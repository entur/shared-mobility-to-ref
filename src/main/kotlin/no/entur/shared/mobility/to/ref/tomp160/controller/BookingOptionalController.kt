package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingState
import no.entur.shared.mobility.to.ref.tomp160.service.BookingsOptionalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController("BookingOptionalControllerTomp160")
class BookingOptionalController(
    private val service: BookingsOptionalService,
) : BookingOptionalApi {
    @TompEndpoint
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
