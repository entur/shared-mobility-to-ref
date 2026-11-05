package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingState
import no.entur.shared.mobility.to.ref.tomp150.service.BookingsOptionalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController("BookingOptionalControllerTomp150")
class BookingOptionalController(
    private val service: BookingsOptionalService,
) : BookingOptionalApi {
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
    ): ResponseEntity<List<Booking>> =
        ResponseEntity.ok(
            service.bookingsGet(
                acceptLanguage,
                api,
                apiVersion,
                maasId,
                addressedTo,
                state,
                minTime,
                maxTime,
                minPrice,
                maxPrice,
                containsAssetType,
            ),
        )
}
