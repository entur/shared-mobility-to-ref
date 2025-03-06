package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.controller.BookingOptionalController
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime
import java.util.UUID

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingsOptionalControllerTest {
    @Autowired
    private lateinit var bookingOptionalController: BookingOptionalController

    @Test
    fun bookingsGet() {
        bookingOptionalController.bookingsGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            state = null,
            minTime = OffsetDateTime.now(),
            maxTime = OffsetDateTime.now(),
            minPrice = null,
            maxPrice = null,
            containsAssetType = "AssetType:487",
        )
    }

    @Test
    fun bookingsIdPut() {
        bookingOptionalController.bookingsIdPut(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
            booking = Booking(),
        )
    }

    @Test
    fun bookingsIdSubscriptionDelete() {
        bookingOptionalController.bookingsIdSubscriptionDelete(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
        )
    }

    @Test
    fun bookingsIdSubscriptionPost() {
        bookingOptionalController.bookingsIdSubscriptionPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
        )
    }
}
