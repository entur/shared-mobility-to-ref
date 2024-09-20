package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.data.place
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingRequest
import no.entur.shared.mobility.to.ref.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime
import java.util.UUID

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingsControllerTest {
    @Autowired
    private lateinit var bookingsController: BookingsController

    @Test
    fun bookingsGet() {
        bookingsController.bookingsGet(
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
    fun bookingsIdEventsPost() {
        bookingsController.bookingsIdEventsPost(
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
        bookingsController.bookingsIdGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
        )
    }

    @Test
    fun bookingsIdNotificationsGet() {
        assertThrows<NotImplementedError> {
            bookingsController.bookingsIdNotificationsGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                id = UUID.randomUUID().toString(),
            )
        }
    }

    @Test
    fun bookingsIdNotificationsPost() {
        bookingsController.bookingsIdNotificationsPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
            notification = null,
        )
    }

    @Test
    fun bookingsIdPut() {
        bookingsController.bookingsIdPut(
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
        bookingsController.bookingsIdSubscriptionDelete(
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
        bookingsController.bookingsIdSubscriptionPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = UUID.randomUUID().toString(),
        )
    }

    @Test
    fun bookingsOneStopPost() {
        bookingsController.bookingsOneStopPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            oneStopBookingRequest = OneStopBookingRequest(from = place),
        )
    }

    @Test
    fun bookingsPost() {
        bookingsController.bookingsPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            bookingRequest = BookingRequest(),
        )
    }
}
