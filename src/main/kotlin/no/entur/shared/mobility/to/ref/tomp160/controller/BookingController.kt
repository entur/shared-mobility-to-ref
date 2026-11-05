package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.service.BookingsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

// Routes, headers and validation come from the generated BookingApi.
// Endpoints not overridden here return 501 Not Implemented.
@RestController("BookingControllerTomp160")
class BookingController(
    private val service: BookingsService,
) : BookingApi {
    @TompEndpoint
    override fun bookingsIdGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): ResponseEntity<Booking> = ResponseEntity.ok(service.bookingsIdGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo))
}
