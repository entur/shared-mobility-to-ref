package no.entur.shared.mobility.to.ref.tomp150.service

import io.kotest.assertions.throwables.shouldThrow
import io.mockk.mockk
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class TripExecutionServiceImplTest {
    private val scheduler: EventScheduler150 = mockk(relaxed = true)
    private val service = TripExecutionServiceImpl(eventScheduler150 = scheduler)

    @Test
    fun `FINISH for COLUMBI_BIKE is rejected`() {
        val now = OffsetDateTime.now()
        val legId = "leg-999"

        shouldThrow<IllegalStateException> {
            service.legsIdEventsPost(
                acceptLanguage = "en",
                apiVersion = "1.5",
                api = "tomp",
                maasId = "maas-1",
                addressedTo = COLUMBI_BIKE,
                id = legId,
                legEvent = LegEvent(time = now, event = LegEvent.Event.FINISH),
            )
        }
    }
}
