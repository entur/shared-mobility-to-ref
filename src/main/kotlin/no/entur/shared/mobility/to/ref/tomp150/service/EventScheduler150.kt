package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class EventScheduler150(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val startMessageQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()
    private val tripStartQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    // Fallback auto-finish (som før)

    // NEW: near-station notification workflow
    private val nearStationDropoffQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    // Tracks if we already notified
    private val nearStationNotified: MutableSet<String> = ConcurrentHashMap.newKeySet()

    // Tracks when START_FINISHING was received (to implement "delay before notify")
    private val nearStationCreatedAt: MutableMap<String, OffsetDateTime> = ConcurrentHashMap()

    private val tripEndFinishAt: MutableMap<String, OffsetDateTime> = ConcurrentHashMap()

    /**
     * For operators != *_BIKE: old behavior (auto-finish after some delay).
     * For *_BIKE: we simulate "drop-off next to station" with:
     *  1) notification ("place bike next to station/dock is full")
     *  2) an extended window where an explicit/manual finish is allowed
     *  3) auto-finish when the window expires
     */
    private val tripEndQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    /**
     * Cancel any scheduled auto-finish for this booking/leg/operator.
     * Used when a FINISH event is received from MaaS/app to avoid double FINISH from the scheduler fallback.
     *
     * NOTE: In a real transport operator implementation, bookingId is typically resolved from legId via the operator's
     *  own persistence layer.
     */
    fun cancelScheduledFinish(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        val k = key(bookingId, legId, operatorId)

        tripEndQueue.removeIf { it.first == bookingId && it.second == legId && it.third == operatorId }
        tripEndFinishAt.remove(k)

        nearStationNotified.remove(k)
    }

    fun cancelNearStationDropoff(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        val k = key(bookingId, legId, operatorId)

        nearStationDropoffQueue.removeIf { it.first == bookingId && it.second == legId && it.third == operatorId }
        nearStationCreatedAt.remove(k)
        nearStationNotified.remove(k)
    }

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

            if (triple.third != COLUMBI_BIKE) {
                tripEndQueue.add(triple) // old behavior
            }
        }
    }

    /**
     * Send notification quickly for COLUMBI_BIKE "near station drop-off" tasks.
     * This simulates: "dock is full, place bike next to station".
     */
    @Scheduled(initialDelay = 10_000, fixedDelay = 300 * SECONDS)
    fun notifyNearStationDropoff() {
        val now = OffsetDateTime.now()
        val iterator = nearStationDropoffQueue.iterator()

        while (iterator.hasNext()) {
            val (bookingId, legId, operatorId) = iterator.next()
            val k = key(bookingId, legId, operatorId)

            val createdAt = nearStationCreatedAt[k] ?: now
            val readyToNotify =
                ChronoUnit.SECONDS.between(createdAt, now) >= NEAR_STATION_NOTIFICATION_DELAY_SECONDS

            if (!nearStationNotified.contains(k) && readyToNotify) {
                runCatching {
                    sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                        id = bookingId,
                        maasId = operatorId,
                        addressedTo = "Entur",
                        notification =
                            Notification(
                                legId = legId,
                                type = Notification.Type.MESSAGE_TO_END_USER,
                                comment = "Dock is full. Please place the bike next to the station and end the trip in the app.",
                            ),
                    )
                }

                nearStationNotified.add(k)
                iterator.remove()
                nearStationCreatedAt.remove(k) // cleanup
            }
        }
    }

    /**
     * Auto-finish any scheduled entries whose finishAt has passed (fallback).
     * This covers:
     *  COLUMBI_BIKE near-station dropoff if no FINISH is received from MaaS/app
     */
    @Scheduled(initialDelay = 10_000, fixedDelay = 5 * SECONDS)
    fun setFinished() {
        val now = OffsetDateTime.now()
        val iterator = tripEndQueue.iterator()

        while (iterator.hasNext()) {
            val (bookingId, legId, operatorId) = iterator.next()
            val k = key(bookingId, legId, operatorId)
            val finishAt = tripEndFinishAt[k] ?: now

            if (!finishAt.isAfter(now)) {
                postLeg(Triple(bookingId, legId, operatorId), LegEvent.Event.FINISH)
                iterator.remove()
                tripEndFinishAt.remove(k)

                // cleanup related near-station state too
                nearStationNotified.remove(k)
                nearStationCreatedAt.remove(k)
                nearStationDropoffQueue.removeIf { it.first == bookingId && it.second == legId && it.third == operatorId }
            }
        }
    }

    fun scheduleFallbackFinish(
        bookingId: String,
        legId: String,
        operatorId: String,
        finishAt: OffsetDateTime,
    ) {
        val triple = Triple(bookingId, legId, operatorId)
        tripEndQueue.add(triple)
        tripEndFinishAt[key(bookingId, legId, operatorId)] = finishAt
    }

    /**
     * Schedule the COLUMBI_BIKE "near station drop-off" fallback window.
     *
     * In a real TO, bookingId can be resolved from legId via the operator's own database.
     * In TO-ref (demo), some flows may use bookingId == legId to keep things simple.
     */
    fun scheduleNearStationDropoff(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        val triple = Triple(bookingId, legId, operatorId)
        nearStationDropoffQueue.add(triple)
        nearStationCreatedAt.putIfAbsent(key(bookingId, legId, operatorId), OffsetDateTime.now())
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

        // Old behavior: how long until we auto-finish for non-*_BIKE in this demo
        const val DEFAULT_AUTO_FINISH_SECONDS: Long = 30

        // *_BIKE near-station flow
        const val NEAR_STATION_MANUAL_FINISH_WINDOW_MINUTES: Long = 10

        // *_BIKE near-station flow
        const val NEAR_STATION_NOTIFICATION_DELAY_SECONDS: Long = 3
    }
}
