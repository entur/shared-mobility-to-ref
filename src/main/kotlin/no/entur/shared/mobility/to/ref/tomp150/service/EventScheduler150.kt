package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class EventScheduler150(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val startMessageQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()
    private val tripStartQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    private val nearStationDropoffQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    private val tripEndFinishAt: MutableMap<String, OffsetDateTime> = ConcurrentHashMap()

    private val bookingIdByLegKey: MutableMap<String, String> = ConcurrentHashMap()

    /**
     * For operators != *_BIKE: old behavior (auto-finish after some delay).
     * For *_BIKE: we simulate "drop-off next to station" with:
     *  1) notification ("place bike next to station/dock is full")
     *  2) an extended window where an explicit/manual finish is allowed
     *  3) auto-finish when the window expires
     */
    private val tripEndQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    private val log = LoggerFactory.getLogger(EventScheduler150::class.java)

    /**
     * Cancel any scheduled auto-finish for this booking/leg/operator.
     * Used when a FINISH event is received from MaaS/app to avoid double FINISH from the scheduler fallback.
     *
     * NOTE: In a real transport operator implementation, bookingId is typically resolved from legId via the operator's
     *  own persistence layer.
     */
    fun cancelScheduledFinish(
        legId: String,
        operatorId: String,
    ) {
        val k = key(legId, operatorId)

        tripEndQueue.removeIf { it.second == legId && it.third == operatorId }
        tripEndFinishAt.remove(k)

        bookingIdByLegKey.remove(k)
    }

    fun cancelNearStationDropoff(
        legId: String,
        operatorId: String,
    ) {
        val k = key(legId, operatorId)

        nearStationDropoffQueue.removeIf { it.second == legId && it.third == operatorId }

        bookingIdByLegKey.remove(k)
    }

    fun addToEventQueue(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        val k = key(legId, operatorId)
        bookingIdByLegKey.putIfAbsent(k, bookingId)

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
        val iterator = nearStationDropoffQueue.iterator()

        while (iterator.hasNext()) {
            val (bookingId, legId, operatorId) = iterator.next()

            val ok =
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
                }.isSuccess

            if (ok) {
                iterator.remove()
            } else {
                // Keep entry in queue for retry on next scheduler run.
                log.warn("Failed to send near-station notification for legId={} operatorId={}", legId, operatorId)
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
            val k = key(legId, operatorId)
            val finishAt = tripEndFinishAt[k] ?: now

            if (!finishAt.isAfter(now)) {
                postLeg(Triple(bookingId, legId, operatorId), LegEvent.Event.FINISH)

                iterator.remove()
                tripEndFinishAt.remove(k)

                // cleanup near-station too (legId/operatorId identity)
                nearStationDropoffQueue.removeIf { it.second == legId && it.third == operatorId }

                bookingIdByLegKey.remove(k)
            }
        }
    }

    fun scheduleFallbackFinish(
        legId: String,
        operatorId: String,
        finishAt: OffsetDateTime,
    ) {
        val k = key(legId, operatorId)

        val bookingId = findBookingId(legId, operatorId)
        if (bookingId == null) {
            log.warn(
                "Cannot schedule fallback finish: missing bookingId",
            )
            return
        }

        bookingIdByLegKey.putIfAbsent(k, bookingId)

        tripEndQueue.add(Triple(bookingId, legId, operatorId))
        tripEndFinishAt[k] = finishAt
    }

    /**
     * Schedule the COLUMBI_BIKE "near station drop-off" fallback window.
     *
     * In a real TO, bookingId can be resolved from legId via the operator's own database.
     * In TO-ref (demo), some flows may use bookingId == legId to keep things simple.
     */
    fun scheduleNearStationDropoff(
        legId: String,
        operatorId: String,
    ) {
        val k = key(legId, operatorId)

        val bookingId = findBookingId(legId, operatorId)
        if (bookingId == null) {
            log.warn(
                "Cannot schedule near-station dropoff: missing bookingId. " +
                    "Expected bookingIdByLegKey to be populated or present in an existing queue entry.",
            )
            return
        }

        // Keep mapping warm for later steps (fallback finish, notifications, etc.)
        bookingIdByLegKey.putIfAbsent(k, bookingId)

        nearStationDropoffQueue.add(Triple(bookingId, legId, operatorId))
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

    private fun findBookingId(
        legId: String,
        operatorId: String,
    ): String? {
        // Prefer explicit mapping if present
        val k = key(legId, operatorId)
        bookingIdByLegKey[k]?.let { return it }

        // Fall back to whatever we already have queued (Triple(bookingId, legId, operatorId))
        fun ConcurrentLinkedQueue<Triple<String, String, String>>.find(): String? =
            this.firstOrNull { it.second == legId && it.third == operatorId }?.first

        return nearStationDropoffQueue.find()
            ?: tripEndQueue.find()
            ?: startMessageQueue.find()
            ?: tripStartQueue.find()
    }

    private fun key(
        legId: String,
        operatorId: String,
    ) = "$legId|$operatorId"

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
    }
}
