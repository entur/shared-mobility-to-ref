package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class EventScheduler160(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val bookedQueue: ConcurrentLinkedQueue<String> = ConcurrentLinkedQueue()
    private val inUseQueue: ConcurrentLinkedQueue<String> = ConcurrentLinkedQueue()

    fun addToEventQueue(legId: String) {
        bookedQueue.add(legId)
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 30 * SECONDS)
    fun setInUse() {
        bookedQueue.forEach {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = it,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.SET_IN_USE),
            )
            bookedQueue.remove(it)
            inUseQueue.add(it)
        }
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 300 * SECONDS)
    fun setFinished() {
        inUseQueue.forEach {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = it,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.FINISH),
            )
            inUseQueue.remove(it)
        }
    }

    companion object {
        const val SECONDS = 1000L
    }
}
