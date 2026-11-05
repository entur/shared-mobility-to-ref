package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.tomp160.data.booking
import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingState
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service("BookingsOptionalServiceTomp160")
class BookingsOptionalService {
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
            ALL_IMPLEMENTING_OPERATOR -> listOf(booking)
            else -> throw NotImplementedError()
        }
}
