package no.entur.shared.mobility.to.ref.tomp150.service

import io.mockk.mockk
import io.mockk.verify
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class TripExecutionServiceImplTest {
    private val scheduler: EventScheduler150 = mockk(relaxed = true)
    private val service = TripExecutionServiceImpl(eventScheduler150 = scheduler)

    @Test
    fun `START_FINISHING for COLUMBI_BIKE schedules near-station dropoff and fallback finish`() {
        val now = OffsetDateTime.now()
        val legId = "leg-123"
        val operatorId = COLUMBI_BIKE

        service.legsIdEventsPost(
            acceptLanguage = "en",
            apiVersion = "1.5",
            api = "tomp",
            maasId = "maas-1",
            addressedTo = operatorId,
            id = legId,
            legEvent =
                LegEvent(
                    time = now,
                    event = LegEvent.Event.START_FINISHING,
                ),
        )

        val expectedBookingId = "bookingId"

        verify(exactly = 1) {
            scheduler.scheduleNearStationDropoff(
                bookingId = expectedBookingId,
                legId = legId,
                operatorId = operatorId,
            )
        }

        verify(exactly = 1) {
            scheduler.scheduleFallbackFinish(
                bookingId = expectedBookingId,
                legId = legId,
                operatorId = operatorId,
                finishAt = any(),
            )
        }
    }

    @Test
    fun `FINISH for COLUMBI_BIKE cancels scheduled finish and pending near-station dropoff`() {
        val now = OffsetDateTime.now()
        val legId = "leg-999"
        val operatorId = COLUMBI_BIKE

        service.legsIdEventsPost(
            acceptLanguage = "en",
            apiVersion = "1.5",
            api = "tomp",
            maasId = "maas-1",
            addressedTo = operatorId,
            id = legId,
            legEvent =
                LegEvent(
                    time = now,
                    event = LegEvent.Event.FINISH,
                ),
        )

        val expectedBookingId = "bookingId"

        verify(exactly = 1) {
            scheduler.cancelScheduledFinish(
                bookingId = expectedBookingId,
                legId = legId,
                operatorId = operatorId,
            )
        }

        verify(exactly = 1) {
            scheduler.cancelNearStationDropoff(
                bookingId = expectedBookingId,
                legId = legId,
                operatorId = operatorId,
            )
        }
    }
}
