package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.planning
import no.entur.shared.mobility.to.ref.dto.Planning
import no.entur.shared.mobility.to.ref.dto.PlanningRequest
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import org.springframework.stereotype.Service

@Service
class PlanningsService {
    fun planningsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        bookingIntent: Boolean,
        planningRequest: PlanningRequest?,
    ): Planning {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> planning
            else -> throw NotImplementedError()
        }
    }
}
