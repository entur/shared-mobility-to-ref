package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp160.dto.Notification
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentHashMap

@Service
class EventScheduler160(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val eventMap = ConcurrentHashMap<String, ScheduledLegAction>()

    @Scheduled(initialDelay = 10_000, fixedDelay = 1000)
    fun handleScheduledLegAction() {
        val now = OffsetDateTime.now()

        // Iterate over a snapshot to avoid surprises if map is modified during handling
        eventMap.entries.toList().forEach { (_, scheduledLegAction) ->
            if (scheduledLegAction.triggerTime.isAfter(now)) return@forEach

            when (scheduledLegAction.type) {
                ScheduledLegActionType.TAKE_MESSAGE -> handleTakeBikeMessage(scheduledLegAction)
                ScheduledLegActionType.SET_IN_USE -> handleSetInUse(scheduledLegAction)
                ScheduledLegActionType.PARKING_WARNING -> handleParkingWarning(scheduledLegAction)
                ScheduledLegActionType.FULL_STATION_MESSAGE -> handleFullStationMessage(scheduledLegAction)
                ScheduledLegActionType.FINISH -> handleFinish(scheduledLegAction)
            }
        }
    }

    fun addTakeBikeMessage(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        eventMap[legId] =
            ScheduledLegAction(
                bookingId = bookingId,
                legId = legId,
                operatorId = operatorId,
                triggerTime = OffsetDateTime.now().plusSeconds(TAKE_MESSAGE_SECONDS),
                type = ScheduledLegActionType.TAKE_MESSAGE,
                legEvent = LegEvent.Event.SET_IN_USE,
            )
    }

    /**
     * Starts the "near station drop-off" flow for this leg:
     * PARKING_WARNING -> FULL_STATION_MESSAGE -> FINISH
     */
    fun startNearStationFlow(legId: String) {
        val scheduledLegAction = eventMap[legId] ?: return

        eventMap[legId] =
            scheduledLegAction.copy(
                triggerTime = OffsetDateTime.now().plusSeconds(PARKING_WARNING_DELAY_SECONDS),
                type = ScheduledLegActionType.PARKING_WARNING,
                // legEvent not used for notifications, but keep as-is
            )
    }

    private fun handleTakeBikeMessage(scheduledLegAction: ScheduledLegAction) {
        postNotification(scheduledLegAction, "You can now take the bike.")

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                type = ScheduledLegActionType.SET_IN_USE,
                legEvent = LegEvent.Event.SET_IN_USE,
                triggerTime = OffsetDateTime.now().plusSeconds(SET_IN_USE_SECONDS),
            )
    }

    private fun handleSetInUse(scheduledLegAction: ScheduledLegAction) {
        postLeg(scheduledLegAction)

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                type = ScheduledLegActionType.FINISH,
                legEvent = LegEvent.Event.FINISH,
                triggerTime = OffsetDateTime.now().plusSeconds(DEFAULT_AUTO_FINISH_SECONDS),
            )
    }

    private fun handleParkingWarning(scheduledLegAction: ScheduledLegAction) {
        postNotification(
            scheduledLegAction,
            "Parking warning: please park the bike correctly and follow local rules.",
        )

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                triggerTime = OffsetDateTime.now().plusSeconds(FULL_STATION_MESSAGE_AFTER_WARNING_DELAY_SECONDS),
                type = ScheduledLegActionType.FULL_STATION_MESSAGE,
                // legEvent not used for notifications
            )
    }

    private fun handleFullStationMessage(scheduledLegAction: ScheduledLegAction) {
        postNotification(scheduledLegAction, "Dock is full. Please place the bike next and lock the bike.")

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                type = ScheduledLegActionType.FINISH,
                legEvent = LegEvent.Event.FINISH,
                triggerTime = OffsetDateTime.now().plusSeconds(LOCK_BIKE_TO_FINISH_DELAY_SECONDS),
            )
    }

    private fun handleFinish(scheduledLegAction: ScheduledLegAction) {
        postLeg(scheduledLegAction)

        eventMap.remove(scheduledLegAction.legId)
    }

    private fun postLeg(scheduledLegAction: ScheduledLegAction) {
        sharedMobilityRouterClient.legsIdEventsPost160(
            id = scheduledLegAction.legId,
            maasId = scheduledLegAction.operatorId,
            addressedTo = "Entur",
            legEvent = LegEvent(OffsetDateTime.now(), scheduledLegAction.legEvent),
        )
    }

    private fun postNotification(
        scheduledLegAction: ScheduledLegAction,
        message: String,
    ) {
        sharedMobilityRouterClient.bookingsIdNotificationsPost160(
            id = scheduledLegAction.bookingId,
            maasId = scheduledLegAction.operatorId,
            addressedTo = "Entur",
            notification =
                Notification(
                    legId = scheduledLegAction.legId,
                    type = Notification.Type.MESSAGE_TO_END_USER,
                    comment = message,
                ),
        )
    }

    companion object {
        const val DEFAULT_AUTO_FINISH_SECONDS: Long = 120

        const val TAKE_MESSAGE_SECONDS = 1L
        const val SET_IN_USE_SECONDS = 5L

        // Near-station flow timing
        const val PARKING_WARNING_DELAY_SECONDS: Long = 3
        const val FULL_STATION_MESSAGE_AFTER_WARNING_DELAY_SECONDS: Long = 5
        const val LOCK_BIKE_TO_FINISH_DELAY_SECONDS: Long = 5L
    }
}

enum class ScheduledLegActionType {
    TAKE_MESSAGE,
    SET_IN_USE,

    // Near-station flow
    PARKING_WARNING,
    FULL_STATION_MESSAGE,

    FINISH,
}

data class ScheduledLegAction(
    val bookingId: String,
    val legId: String,
    val operatorId: String,
    val triggerTime: OffsetDateTime,
    val type: ScheduledLegActionType,
    val legEvent: LegEvent.Event,
)
