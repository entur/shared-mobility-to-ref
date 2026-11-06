package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.Leg
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp160.service.TripExecutionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("TripExecutionControllerTomp160")
class TripExecutionController(
    private val service: TripExecutionService,
) : TripExecutionApi {
    @TompEndpoint
    override fun legsIdEventsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        legEvent: LegEvent?,
    ): ResponseEntity<Leg> = ResponseEntity.ok(service.legsIdEventsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, legEvent))

    @TompEndpoint
    override fun legsIdGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): ResponseEntity<Leg> = ResponseEntity.ok(service.legsIdGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo))
}
