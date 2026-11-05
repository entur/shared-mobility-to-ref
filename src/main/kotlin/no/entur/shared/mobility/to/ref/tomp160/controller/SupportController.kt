package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.SupportRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.SupportStatus
import no.entur.shared.mobility.to.ref.tomp160.service.SupportService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("SupportControllerTomp160")
class SupportController(
    private val service: SupportService,
) : SupportApi {
    @TompEndpoint
    override fun supportPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        supportRequest: SupportRequest?,
    ): ResponseEntity<SupportStatus> =
        ResponseEntity.ok(service.supportPost(acceptLanguage, api, apiVersion, maasId, addressedTo, supportRequest))

    @TompEndpoint(optional = true)
    override fun supportIdStatusGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): ResponseEntity<List<SupportStatus>> =
        ResponseEntity.ok(service.supportIdStatusGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo))
}
