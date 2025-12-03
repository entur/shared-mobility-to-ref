package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class EventScheduler150(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val bookedStartMessageQueue: ConcurrentLinkedQueue<String> = ConcurrentLinkedQueue()
    private val bookedStartQueue: ConcurrentLinkedQueue<String> = ConcurrentLinkedQueue()
    private val tripEndQueue: ConcurrentLinkedQueue<String> = ConcurrentLinkedQueue()

    fun addToEventQueue(legId: String) {
        bookedStartMessageQueue.add(legId)
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 1 * SECONDS)
    fun messageTakeBike() {
        bookedStartMessageQueue.forEach {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = it,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.SET_IN_USE),
            )
            bookedStartMessageQueue.remove(it)
            bookedStartQueue.add(it)
        }
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 20 * SECONDS)
    fun setInUse() {
        bookedStartQueue.forEach {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = it,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.SET_IN_USE),
            )
            bookedStartQueue.remove(it)
            if (!it.startsWith(URBAN_BIKE)) {
                tripEndQueue.add(it)
            }
        }
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 300 * SECONDS)
    fun setFinished() {
        tripEndQueue.forEach {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = it,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.FINISH),
            )
            tripEndQueue.remove(it)
        }
    }

    companion object {
        const val SECONDS = 1000L
    }
}
