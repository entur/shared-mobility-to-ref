package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.Leg
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.service.TripExecutionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("TripExecutionControllerTomp150")
class TripExecutionController(
    private val service: TripExecutionService,
) : TripExecutionApi {
    override fun legsIdEventsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        legEvent: LegEvent?,
    ): ResponseEntity<Leg> = ResponseEntity.ok(service.legsIdEventsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, legEvent))

    override fun legsIdGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): ResponseEntity<Leg> = ResponseEntity.ok(service.legsIdGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo))
}
