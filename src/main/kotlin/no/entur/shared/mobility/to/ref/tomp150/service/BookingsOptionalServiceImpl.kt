package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.tomp150.controller.BookingOptionalService
import no.entur.shared.mobility.to.ref.tomp150.data.booking
import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingState
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service("BookingsOptionalServiceTomp150")
class BookingsOptionalServiceImpl : BookingOptionalService {
    override fun bookingsGet(
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
            ALL_IMPLEMENTING_OPERATOR -> listOf(booking)
            else -> throw NotImplementedError()
        }

    override fun bookingsIdSubscriptionDelete(
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

    override fun bookingsIdSubscriptionPost(
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

    override fun bookingsIdPut(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        booking: Booking,
        addressedTo: String?,
    ): Booking =
        when (addressedTo) {
            ALL_IMPLEMENTING_OPERATOR -> booking
            else -> throw NotImplementedError()
        }
}
