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

    fun addFullStationMessage(legId: String) {
        val scheduledLegAction = eventMap[legId] ?: return

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                triggerTime = OffsetDateTime.now().plusSeconds(FULL_STATION_MESSAGE_DELAY_SECONDS),
                type = ScheduledLegActionType.FULL_STATION_MESSAGE,
                legEvent = LegEvent.Event.FINISH,
            )
    }

    private fun handleTakeBikeMessage(scheduledLegAction: ScheduledLegAction) {
        val ok = postNotification(scheduledLegAction, "You can now take the bike.")
        if (!ok) return // keep TAKE_MESSAGE for retry

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                type = ScheduledLegActionType.SET_IN_USE,
                legEvent = LegEvent.Event.SET_IN_USE,
                triggerTime = OffsetDateTime.now().plusSeconds(SET_IN_USE_SECONDS),
            )
    }

    private fun handleSetInUse(scheduledLegAction: ScheduledLegAction) {
        val ok = postLeg(scheduledLegAction)
        if (!ok) return // keep SET_IN_USE for retry

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                type = ScheduledLegActionType.FINISH,
                legEvent = LegEvent.Event.FINISH,
                triggerTime = OffsetDateTime.now().plusSeconds(DEFAULT_AUTO_FINISH_SECONDS),
            )
    }

    private fun handleFullStationMessage(scheduledLegAction: ScheduledLegAction) {
        val ok = postNotification(scheduledLegAction, "Dock is full. Please place the bike next and lock the bike.")
        if (!ok) return // keep FULL_STATION_MESSAGE for retry

        eventMap[scheduledLegAction.legId] =
            scheduledLegAction.copy(
                type = ScheduledLegActionType.FINISH,
                legEvent = LegEvent.Event.FINISH,
                triggerTime = OffsetDateTime.now().plusSeconds(LOCK_BIKE_TO_FINISH_DELAY_SECONDS),
            )
    }

    private fun handleFinish(scheduledLegAction: ScheduledLegAction) {
        val ok = postLeg(scheduledLegAction)
        if (!ok) return // keep FINISH for retry

        eventMap.remove(scheduledLegAction.legId)
    }

    private fun postLeg(scheduledLegAction: ScheduledLegAction): Boolean =
        runCatching {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = scheduledLegAction.legId,
                maasId = scheduledLegAction.operatorId,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), scheduledLegAction.legEvent),
            )
        }.isSuccess

    private fun postNotification(
        scheduledLegAction: ScheduledLegAction,
        message: String,
    ): Boolean =
        runCatching {
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
        }.isSuccess

    companion object {
        const val DEFAULT_AUTO_FINISH_SECONDS: Long = 120
        const val TAKE_MESSAGE_SECONDS = 1L
        const val SET_IN_USE_SECONDS = 5L
        const val LOCK_BIKE_TO_FINISH_DELAY_SECONDS = 5L
        const val FULL_STATION_MESSAGE_DELAY_SECONDS: Long = 1
    }
}

enum class ScheduledLegActionType {
    TAKE_MESSAGE,
    SET_IN_USE,
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
