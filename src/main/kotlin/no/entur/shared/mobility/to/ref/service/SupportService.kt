package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.dto.SupportRequest
import no.entur.shared.mobility.to.ref.dto.SupportStatus
import org.springframework.stereotype.Service

@Service
class SupportService {
    fun supportIdStatusGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): List<SupportStatus> = throw NotImplementedError()

    fun supportPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        supportRequest: SupportRequest?,
    ): SupportStatus = throw NotImplementedError()
}
