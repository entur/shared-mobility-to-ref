package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.asset
import no.entur.shared.mobility.to.ref.data.booking
import no.entur.shared.mobility.to.ref.data.bookingHigherDepositAmountThanTotalAmount
import no.entur.shared.mobility.to.ref.data.bookingWithoutDeposit
import no.entur.shared.mobility.to.ref.data.finalFare
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingOperation
import no.entur.shared.mobility.to.ref.dto.BookingRequest
import no.entur.shared.mobility.to.ref.dto.BookingState
import no.entur.shared.mobility.to.ref.dto.Notification
import no.entur.shared.mobility.to.ref.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_2
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_3
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
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
    ): List<Booking> =
        when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            SCOOTER_OPERATOR_NO_DEPOSIT -> throw NotImplementedError()
            SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(booking)
            else -> throw NotImplementedError()
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
                SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
                SCOOTER_OPERATOR_NO_DEPOSIT -> throw NotImplementedError()
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> throw NotImplementedError()
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
                SCOOTER_OPERATOR_NO_DEPOSIT -> bookingWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                SCOOTER_OPERATOR -> booking.copy(pricing = finalFare(50.00F))
                SCOOTER_OPERATOR_2 -> booking.copy(pricing = finalFare(5.00F))
                SCOOTER_OPERATOR_3 -> booking.copy(pricing = finalFare(15.00F))
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
    ): List<Notification> = throw NotImplementedError()

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
    ): Booking =
        when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
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
            when (addressedTo) {
                SCOOTER_OPERATOR_NO_DEPOSIT -> bookingWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                SCOOTER_OPERATOR -> booking.copy(pricing = finalFare(50.00F))
                SCOOTER_OPERATOR_2 -> booking.copy(pricing = finalFare(5.00F))
                SCOOTER_OPERATOR_3 -> booking.copy(pricing = finalFare(15.00F))
                BIKE_OPERATOR -> booking
                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(
            customer = oneStopBookingRequest.customer,
            from = oneStopBookingRequest.from,
            legs =
                booking.legs?.map { leg ->
                    leg.copy(
                        from = oneStopBookingRequest.from,
                        asset = asset.copy(id = oneStopBookingRequest.useAssets?.first() ?: UUID.randomUUID().toString()),
                    )
                },
        )
    }

    fun bookingsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        bookingRequest: BookingRequest,
    ): Booking =
        when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
        }
}
