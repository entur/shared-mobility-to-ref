package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.service.BookingsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

// Routes, headers and validation come from the generated BookingApi.
// Endpoints not overridden here return 501 Not Implemented.
@RestController("BookingControllerTomp150")
class BookingController(
    private val service: BookingsService,
) : BookingApi {
    override fun bookingsIdGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): ResponseEntity<Booking> = ResponseEntity.ok(service.bookingsIdGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo))
}
