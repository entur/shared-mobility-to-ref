package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.data.place
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingRequest
import no.entur.shared.mobility.to.ref.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingsControllerTest {
    @Autowired
    private lateinit var bookingsController: BookingsController

    @Test
    fun bookingsGet() {
        bookingsController.bookingsGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            state = null,
            minTime = OffsetDateTime.now(),
            maxTime = OffsetDateTime.now(),
            minPrice = null,
            maxPrice = null,
            containsAssetType = "",
        )
    }

    @Test
    fun bookingsIdEventsPost() {
        bookingsController.bookingsIdEventsPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            bookingOperation = null,
        )
    }

    @Test
    fun bookingsIdGet() {
        bookingsController.bookingsIdGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun bookingsIdNotificationsGet() {
        bookingsController.bookingsIdNotificationsGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun bookingsIdNotificationsPost() {
        bookingsController.bookingsIdNotificationsPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            notification = null,
        )
    }

    @Test
    fun bookingsIdPut() {
        bookingsController.bookingsIdPut(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            booking = Booking(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun bookingsIdSubscriptionDelete() {
        bookingsController.bookingsIdSubscriptionDelete(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun bookingsIdSubscriptionPost() {
        bookingsController.bookingsIdSubscriptionPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = "",
        )
    }

    @Test
    fun bookingsOneStopPost() {
        bookingsController.bookingsOneStopPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            oneStopBookingRequest = OneStopBookingRequest(from = place),
        )
    }

    @Test
    fun bookingsPost() {
        bookingsController.bookingsPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            bookingRequest = BookingRequest(),
        )
    }
}
