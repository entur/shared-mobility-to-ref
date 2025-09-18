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
    private val queue: ConcurrentLinkedQueue<String> = ConcurrentLinkedQueue()

    fun addToEventQueue(legId: String) {
        queue.add(legId)
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 30_000)
    fun schedule() {
        queue.forEach {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = it,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.SET_IN_USE),
            )
            queue.remove(it)
        }
    }
}
