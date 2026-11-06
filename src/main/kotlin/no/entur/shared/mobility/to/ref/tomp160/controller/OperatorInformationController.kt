package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.tomp160.service.OperatorInformationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("OperatorInformationControllerTomp160")
class OperatorInformationController(
    private val service: OperatorInformationService,
) : OperatorInformationApi {
    @TompEndpoint
    override fun operatorMetaGet(
        acceptLanguage: String,
        maasId: String,
        addressedTo: String?,
    ): ResponseEntity<List<EndpointImplementation>> = ResponseEntity.ok(service.operatorMetaGet(acceptLanguage, maasId, addressedTo))
}
