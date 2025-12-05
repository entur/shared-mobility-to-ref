package no.entur.shared.mobility.to.ref.tomp150.service

import io.mockk.mockk
import io.mockk.verify
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.config.operators
import no.entur.shared.mobility.to.ref.tomp150.dto.Coordinates
import no.entur.shared.mobility.to.ref.tomp150.dto.Customer
import no.entur.shared.mobility.to.ref.tomp150.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.tomp150.dto.Place
import org.junit.jupiter.api.Test

class PlanningServiceImplTest {
    private val eventScheduler150: EventScheduler150 = mockk(relaxed = true)

    private val planningServiceImpl = PlanningServiceImpl(eventScheduler150)

    @Test
    fun `bookingsOneStopPost should call eventScheduler if the call comes from a bike operator`() {
        planningServiceImpl.bookingsOneStopPost(
            "",
            "",
            "",
            "",
            COLUMBI_BIKE,
            OneStopBookingRequest(
                customer = Customer(""),
                from = Place(coordinates = Coordinates(0.0F, 0.0F)),
                useAssets = listOf("asset"),
            ),
        )

        verify(exactly = 1) { eventScheduler150.addToEventQueue(any(), any(), COLUMBI_BIKE) }
    }

    @Test
    fun `bookingsOneStopPost should not call eventScheduler if the call doesn't come from a bike operator`() {
        operators.filter { it !in setOf(COLUMBI_BIKE, URBAN_BIKE) }.forEach {
            planningServiceImpl.bookingsOneStopPost(
                "",
                "",
                "",
                "",
                it,
                OneStopBookingRequest(
                    customer = Customer(""),
                    from = Place(coordinates = Coordinates(0.0F, 0.0F)),
                    useAssets = listOf("asset"),
                ),
            )
        }

        verify(exactly = 0) { eventScheduler150.addToEventQueue(any(), any(), any()) }
    }
}
