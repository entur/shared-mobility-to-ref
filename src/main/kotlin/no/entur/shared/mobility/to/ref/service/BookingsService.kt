package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.asset
import no.entur.shared.mobility.to.ref.data.booking
import no.entur.shared.mobility.to.ref.data.leg
import no.entur.shared.mobility.to.ref.data.notification
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingOperation
import no.entur.shared.mobility.to.ref.dto.BookingRequest
import no.entur.shared.mobility.to.ref.dto.BookingState
import no.entur.shared.mobility.to.ref.dto.Notification
import no.entur.shared.mobility.to.ref.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.UUID

@Service
class BookingsService {
    fun bookingsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        state: BookingState?,
        minTime: OffsetDateTime?,
        maxTime: OffsetDateTime?,
        minPrice: Float?,
        maxPrice: Float?,
        containsAssetType: String?,
    ): List<Booking> {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(booking)
            else -> throw NotImplementedError()
        }
    }

    fun bookingsIdEventsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        bookingOperation: BookingOperation?,
    ): Booking {
        val booking: Booking =
            when (addressedTo) {
                SCOOTER_OPERATOR -> throw NotImplementedError()
                BIKE_OPERATOR -> throw NotImplementedError()
                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(id = id)
    }

    fun bookingsIdGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): Booking {
        val booking: Booking =
            when (addressedTo) {
                SCOOTER_OPERATOR -> booking
                BIKE_OPERATOR -> booking
                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(id = id)
    }

    fun bookingsIdNotificationsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): List<Notification> {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(notification)
            else -> throw NotImplementedError()
        }
    }

    fun bookingsIdNotificationsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        notification: Notification?,
    ) {
        if (addressedTo != ALL_IMPLEMENTING_OPERATOR) {
            throw NotImplementedError()
        }
    }

    fun bookingsIdPut(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        booking: Booking,
        addressedTo: String?,
    ): Booking {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
        }
    }

    fun bookingsIdSubscriptionDelete(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ) {
        if (addressedTo != ALL_IMPLEMENTING_OPERATOR) {
            throw NotImplementedError()
        }
    }

    fun bookingsIdSubscriptionPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ) {
        if (addressedTo != ALL_IMPLEMENTING_OPERATOR) {
            throw NotImplementedError()
        }
    }

    fun bookingsOneStopPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        oneStopBookingRequest: OneStopBookingRequest,
    ): Booking {
        val booking =
            booking.copy(
                customer = oneStopBookingRequest.customer,
                from = oneStopBookingRequest.from,
                legs =
                    listOf(
                        leg.copy(
                            from = oneStopBookingRequest.from,
                            asset = asset.copy(id = oneStopBookingRequest.useAssets?.first() ?: UUID.randomUUID().toString()),
                        ),
                    ),
            )

        return when (addressedTo) {
            SCOOTER_OPERATOR -> booking
            BIKE_OPERATOR -> booking
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
        }
    }

    fun bookingsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        bookingRequest: BookingRequest,
    ): Booking {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
        }
    }
}
