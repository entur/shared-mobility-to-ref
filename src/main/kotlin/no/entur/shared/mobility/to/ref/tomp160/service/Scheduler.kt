package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class Scheduler(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    @Scheduled(initialDelay = 10_000, fixedRate = 60_000)
    fun schedule() {
        sharedMobilityRouterClient.legsIdEventsPost(
            id = "1",
            addressedTo = "Entur",
            legEvent = LegEvent(OffsetDateTime.now(), LegEvent.Event.SET_IN_USE),
        )
    }
}
