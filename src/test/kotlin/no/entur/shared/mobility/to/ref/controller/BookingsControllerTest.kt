package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingRequest
import org.junit.jupiter.api.Assertions.*
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
            addressedTo = "",
            state = null,
            minTime = OffsetDateTime.now(),
            maxTime = OffsetDateTime.now(),
            minPrice = null,
            maxPrice = null,
            containsAssetType = ""
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
            addressedTo = "",
            bookingOperation = null
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
            addressedTo = "",
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
            addressedTo = "",
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
            addressedTo = "",
            notification = null
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
            addressedTo = "",
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
            addressedTo = "",
        )
    }

    @Test
    fun bookingsIdSubscriptionPost() {
        bookingsController.bookingsIdSubscriptionPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = "",
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
            addressedTo = "",
            oneStopBookingRequest = null
        )
    }

    @Test
    fun bookingsPost() {
        bookingsController.bookingsPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = "",
            bookingRequest = BookingRequest()
        )
    }
}