package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.tomp150.service.OperatorInformationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("OperatorInformationControllerTomp150")
class OperatorInformationController(
    private val service: OperatorInformationService,
) : OperatorInformationApi {
    override fun operatorMetaGet(
        acceptLanguage: String,
        maasId: String,
        addressedTo: String?,
    ): ResponseEntity<List<EndpointImplementation>> = ResponseEntity.ok(service.operatorMetaGet(acceptLanguage, maasId, addressedTo))
}
