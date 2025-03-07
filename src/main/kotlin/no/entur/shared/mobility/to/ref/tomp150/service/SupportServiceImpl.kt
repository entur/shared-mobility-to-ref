package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.tomp150.controller.SupportService
import no.entur.shared.mobility.to.ref.tomp150.dto.SupportRequest
import no.entur.shared.mobility.to.ref.tomp150.dto.SupportStatus
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class SupportServiceImpl : SupportService {
    override fun supportIdStatusGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): List<SupportStatus> = throw NotImplementedError()

    override fun supportPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        supportRequest: SupportRequest?,
    ): SupportStatus =
        SupportStatus(
            id = supportRequest?.id,
            status = SupportStatus.Status.PROCESSING,
            comment = "comment",
            time = OffsetDateTime.now(),
            priority = SupportStatus.Priority.QUESTION,
            contactInformationEndUser = "test.testesen@entur.org",
        )
}
