package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.Planning
import no.entur.shared.mobility.to.ref.tomp160.dto.PlanningRequest
import no.entur.shared.mobility.to.ref.tomp160.service.PlanningService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("PlanningControllerTomp160")
class PlanningController(
    private val service: PlanningService,
) : PlanningApi {
    @TompEndpoint
    override fun planningOffersPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        planningRequest: PlanningRequest?,
    ): ResponseEntity<Planning> =
        ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.planningOffersPost(acceptLanguage, api, apiVersion, maasId, addressedTo, planningRequest))

    @TompEndpoint
    override fun bookingsOneStopPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        oneStopBookingRequest: OneStopBookingRequest?,
    ): ResponseEntity<Booking> =
        ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.bookingsOneStopPost(acceptLanguage, api, apiVersion, maasId, addressedTo, oneStopBookingRequest))
}
