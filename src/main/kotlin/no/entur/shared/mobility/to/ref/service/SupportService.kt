package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.supportStatus
import no.entur.shared.mobility.to.ref.dto.SupportRequest
import no.entur.shared.mobility.to.ref.dto.SupportStatus
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
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
    ): List<SupportStatus> {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(supportStatus)
            else -> throw NotImplementedError()
        }
    }

    fun supportPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        supportRequest: SupportRequest?,
    ): SupportStatus {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> supportStatus
            else -> throw NotImplementedError()
        }
    }
}
