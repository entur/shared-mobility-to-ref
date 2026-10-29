package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID
import no.entur.shared.mobility.to.ref.tomp160.controller.required.BookingController as RequiredBookingController
import no.entur.shared.mobility.to.ref.tomp160.controller.unused.BookingController as UnusedBookingController

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingsControllerTest {
    @Autowired
    private lateinit var unusedBookingsController: UnusedBookingController

    @Autowired
    private lateinit var requiredBookingsController: RequiredBookingController

    @Test
    fun bookingsIdEventsPost() {
        unusedBookingsController.bookingsIdEventsPost(
            id = UUID.randomUUID().toString(),
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            bookingOperation = null,
        )
    }

    @Test
    fun bookingsIdGet() {
        requiredBookingsController.bookingsIdGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
        )
    }

    @Test
    fun bookingsPost() {
        unusedBookingsController.bookingsPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            bookingRequest = BookingRequest(),
        )
    }
}
