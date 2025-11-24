package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_2
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_3
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.controller.BookingService
import no.entur.shared.mobility.to.ref.tomp150.data.booking
import no.entur.shared.mobility.to.ref.tomp150.data.bookingHigherDepositAmountThanTotalAmount
import no.entur.shared.mobility.to.ref.tomp150.data.bookingWithoutDeposit
import no.entur.shared.mobility.to.ref.tomp150.data.finalFare
import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingOperation
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingRequest
import org.springframework.stereotype.Service

@Service("BookingsServiceTomp150")
class BookingsServiceImpl : BookingService {
    override fun bookingsIdEventsPost(
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
                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(id = id)
    }

    override fun bookingsIdGet(
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
                SCOOTER_OPERATOR -> booking.copy(pricing = finalFare(25.00F))
                SCOOTER_OPERATOR_2 -> booking.copy(pricing = finalFare(5.00F))
                SCOOTER_OPERATOR_3 -> booking.copy(pricing = finalFare(15.00F))
                COLUMBI_BIKE, URBAN_BIKE, ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(id = id)
    }

    override fun bookingsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        bookingRequest: BookingRequest,
        addressedTo: String?,
    ): Booking =
        when (addressedTo) {
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
        }
}
