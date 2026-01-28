package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class EventScheduler150(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val startMessageQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()
    private val tripStartQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    /**
     * Test hooks (avoid reflection in unit tests).
     * Marked internal so production API surface is unaffected outside the module.
     */
    internal fun startMessageQueueForTest(): ConcurrentLinkedQueue<Triple<String, String, String>> = startMessageQueue

    internal fun tripStartQueueForTest(): ConcurrentLinkedQueue<Triple<String, String, String>> = tripStartQueue

    internal fun tripEndQueueForTest(): ConcurrentLinkedQueue<ScheduledTripEnd> = tripEndQueue

    /**
     * For operators != URBAN_BIKE: old behavior (auto-finish after some delay).
     * For URBAN_BIKE: we simulate "drop-off next to station" with:
     *  1) notification ("place bike next to station/dock is full")
     *  2) an extended window where an explicit/manual finish is allowed
     *  3) auto-finish when the window expires
     */
    private val tripEndQueue: ConcurrentLinkedQueue<ScheduledTripEnd> = ConcurrentLinkedQueue()

    /**
     * Tracks if we've already sent the "near station drop-off" notification for a given booking/leg.
     * This keeps the logic simple without needing a mutable field inside ScheduledTripEnd.
     */
    private val nearStationNotified: MutableSet<String> =
        java.util.concurrent.ConcurrentHashMap
            .newKeySet()

    /**
     * Cancel any scheduled auto-finish for this booking/leg/operator.
     * Used when a FINISH event is received from MaaS/app to avoid double FINISH from the scheduler fallback.
     *
     * NOTE: In a real transport operator implementation, bookingId is typically resolved from legId via the operator's
     *  own persistence layer. TO-ref is a demo and may use bookingId == legId in some flows.
     */
    fun cancelScheduledFinish(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        val iterator = tripEndQueue.iterator()
        while (iterator.hasNext()) {
            val task = iterator.next()
            if (
                task.bookingId == bookingId &&
                task.legId == legId &&
                task.operatorId == operatorId
            ) {
                iterator.remove()
            }
        }

        nearStationNotified.remove(key(bookingId, legId, operatorId))
    }

    data class ScheduledTripEnd(
        val bookingId: String,
        val legId: String,
        val operatorId: String,
        val createdAt: OffsetDateTime = OffsetDateTime.now(),
        val finishAt: OffsetDateTime,
        val nearStationDropoff: Boolean,
    )

    fun addToEventQueue(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        startMessageQueue.add(Triple(bookingId, legId, operatorId))
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 1 * SECONDS)
    fun messageTakeBike() {
        startMessageQueue.forEach {
            runCatching {
                sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                    id = it.first,
                    maasId = it.third,
                    addressedTo = "Entur",
                    notification =
                        Notification(
                            legId = it.second,
                            type = Notification.Type.MESSAGE_TO_END_USER,
                            comment = "You can now take the bike.",
                        ),
                )
            }
            startMessageQueue.remove(it)
            tripStartQueue.add(it)
        }
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 20 * SECONDS)
    fun setInUse() {
        tripStartQueue.forEach { triple ->
            postLeg(triple, LegEvent.Event.SET_IN_USE)
            tripStartQueue.remove(triple)

            // Keep old auto-finish behavior for non-URBAN_BIKE operators only.
            // For URBAN_BIKE, the "near station" workflow is triggered by START_FINISHING in TripExecutionServiceImpl.
            if (triple.third != URBAN_BIKE) {
                tripEndQueue.add(
                    ScheduledTripEnd(
                        bookingId = triple.first,
                        legId = triple.second,
                        operatorId = triple.third,
                        finishAt = OffsetDateTime.now().plusSeconds(DEFAULT_AUTO_FINISH_SECONDS),
                        nearStationDropoff = false,
                    ),
                )
            }
        }
    }

    /**
     * Send notification quickly for URBAN_BIKE "near station drop-off" tasks.
     * This simulates: "dock is full, place bike next to station".
     */
    @Scheduled(initialDelay = 10_000, fixedDelay = 2 * SECONDS)
    fun notifyNearStationDropoff() {
        val now = OffsetDateTime.now()
        tripEndQueue
            .filter { it.nearStationDropoff }
            .forEach { task ->
                val k = key(task.bookingId, task.legId, task.operatorId)

                // Send once, shortly after task creation
                val readyToNotify =
                    ChronoUnit.SECONDS.between(task.createdAt, now) >= NEAR_STATION_NOTIFICATION_DELAY_SECONDS

                if (!nearStationNotified.contains(k) && readyToNotify) {
                    runCatching {
                        sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                            id = task.bookingId,
                            maasId = task.operatorId,
                            addressedTo = "Entur",
                            notification =
                                Notification(
                                    legId = task.legId,
                                    type = Notification.Type.MESSAGE_TO_END_USER,
                                    comment = "Dock is full. Please place the bike next to the station and end the trip in the app.",
                                ),
                        )
                    }
                    nearStationNotified.add(k)
                }
            }
    }

    /**
     * Auto-finish any scheduled entries whose finishAt has passed (fallback).
     * This covers:
     *  URBAN_BIKE near-station dropoff if no FINISH is received from MaaS/app
     */
    @Scheduled(initialDelay = 10_000, fixedDelay = 5 * SECONDS)
    fun setFinished() {
        val now = OffsetDateTime.now()
        val iterator = tripEndQueue.iterator()

        while (iterator.hasNext()) {
            val task = iterator.next()
            if (!task.finishAt.isAfter(now)) {
                postLeg(Triple(task.bookingId, task.legId, task.operatorId), LegEvent.Event.FINISH)
                iterator.remove()
                nearStationNotified.remove(key(task.bookingId, task.legId, task.operatorId))
            }
        }
    }

    /**
     * Schedule the URBAN_BIKE "near station drop-off" fallback window.
     *
     * In a real TO, bookingId can be resolved from legId via the operator's own database.
     * In TO-ref (demo), some flows may use bookingId == legId to keep things simple.
     */
    fun scheduleNearStationDropoff(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        tripEndQueue.add(
            ScheduledTripEnd(
                bookingId = bookingId,
                legId = legId,
                operatorId = operatorId,
                finishAt = OffsetDateTime.now().plusMinutes(NEAR_STATION_MANUAL_FINISH_WINDOW_MINUTES),
                nearStationDropoff = true,
            ),
        )
    }

    private fun postLeg(
        triple: Triple<String, String, String>,
        event: LegEvent.Event,
    ) {
        runCatching {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = triple.second,
                maasId = triple.third,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), event),
            )
        }
    }

    private fun key(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) = "$bookingId|$legId|$operatorId"

    companion object {
        /**
         * NOTE: This constant name is misleading in the original code; it's milliseconds.
         * Keeping it as-is for minimal change footprint.
         */
        const val SECONDS = 1000L

        // Old behavior: how long until we auto-finish for non-URBAN_BIKE in this demo
        const val DEFAULT_AUTO_FINISH_SECONDS: Long = 30

        // URBAN_BIKE near-station flow
        const val NEAR_STATION_NOTIFICATION_DELAY_SECONDS: Long = 3
        const val NEAR_STATION_MANUAL_FINISH_WINDOW_MINUTES: Long = 10
    }
}
