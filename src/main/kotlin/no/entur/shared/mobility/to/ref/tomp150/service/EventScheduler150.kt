package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentHashMap

@Service
class EventScheduler150(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val eventMap = ConcurrentHashMap<String, AutomatedBehaviour>()

    @Scheduled(initialDelay = 10_000, fixedDelay = 1000)
    fun handleAutomatedBehaviour() {

        eventMap.keys.forEach {
            val automatedBehaviour = eventMap[it]!!
            if (automatedBehaviour.triggerTime > OffsetDateTime.now()) {
                return@forEach
            }
            when (automatedBehaviour.type) {
                "TAKE_MESSAGE" -> handleTakeBikeMessage(automatedBehaviour)
                "SET_IN_USE" -> handleSetInUse(automatedBehaviour)
                "FULL_STATION_MESSAGE" -> handleFullStationMessage(automatedBehaviour)
                "FINISH" -> handleFinish(automatedBehaviour)
            }
        }
    }

    fun addTakeBikeMessage(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        eventMap[legId] = AutomatedBehaviour(
            bookingId,
            legId,
            operatorId,
            OffsetDateTime.now().plusSeconds(TAKE_MESSAGE_SECONDS),
            "TAKE_MESSAGE",
            LegEvent.Event.SET_IN_USE
        )
    }

    fun addFullStationMessage(legId: String) {
        val automatedBehaviour = eventMap[legId]!!

        eventMap[automatedBehaviour.legId] = automatedBehaviour.copy(
            triggerTime = OffsetDateTime.now().plusSeconds(FULL_STATION_MESSAGE_DELAY_SECONDS),
            type = "FULL_STATION_MESSAGE",
            legEvent = LegEvent.Event.FINISH
        )
    }


    private fun handleTakeBikeMessage(automatedBehaviour: AutomatedBehaviour) {
        postNotification(automatedBehaviour, "You can now take the bike.")
        eventMap[automatedBehaviour.legId] = automatedBehaviour.copy(
            type = "SET_IN_USE",
            legEvent = LegEvent.Event.SET_IN_USE,
            triggerTime = OffsetDateTime.now().plusSeconds(SET_IN_USE_SECONDS)
        )
    }

    private fun handleSetInUse(automatedBehaviour: AutomatedBehaviour) {
        postLeg(automatedBehaviour)
        eventMap[automatedBehaviour.legId] = automatedBehaviour.copy(
            type = "FINISH",
            legEvent = LegEvent.Event.FINISH,
            triggerTime = OffsetDateTime.now().plusSeconds(DEFAULT_AUTO_FINISH_SECONDS)
        )
    }

    private fun handleFullStationMessage(automatedBehaviour: AutomatedBehaviour) {
        postNotification(automatedBehaviour, "Dock is full. Please place the bike next and lock the bike.")
        eventMap[automatedBehaviour.legId] = automatedBehaviour.copy(
            type = "FINISH",
            legEvent = LegEvent.Event.FINISH,
            triggerTime = OffsetDateTime.now().plusSeconds(LOCK_BIKE_TO_FINISH_DELAY_SECONDS)
        )
    }

    private fun handleFinish(automatedBehaviour: AutomatedBehaviour) {
        postLeg(automatedBehaviour)
        eventMap.remove(automatedBehaviour.legId)
    }

    private fun postLeg(
        automatedBehaviour: AutomatedBehaviour,
    ) {
        runCatching {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = automatedBehaviour.legId,
                maasId = automatedBehaviour.operatorId,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), automatedBehaviour.legEvent),
            )
        }
    }

    private fun postNotification(
        automatedBehaviour: AutomatedBehaviour,
        message: String,
    ) {
        sharedMobilityRouterClient.bookingsIdNotificationsPost150(
            id = automatedBehaviour.legId,
            maasId = automatedBehaviour.operatorId,
            addressedTo = "Entur",
            notification =
                Notification(
                    legId = automatedBehaviour.bookingId,
                    type = Notification.Type.MESSAGE_TO_END_USER,
                    comment = message,
                ),
        )
    }

    companion object {
        const val DEFAULT_AUTO_FINISH_SECONDS: Long = 120
        const val TAKE_MESSAGE_SECONDS = 1L
        const val SET_IN_USE_SECONDS = 5L
        const val LOCK_BIKE_TO_FINISH_DELAY_SECONDS = 5L
        const val FULL_STATION_MESSAGE_DELAY_SECONDS: Long = 1
    }
}

data class AutomatedBehaviour(
    val bookingId: String,
    val legId: String,
    val operatorId: String,
    val triggerTime: OffsetDateTime,
    val type: String,
    val legEvent: LegEvent.Event,
)
