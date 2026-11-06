package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.config.bikeOperators
import no.entur.shared.mobility.to.ref.config.scooterOperators
import no.entur.shared.mobility.to.ref.tomp150.data.MetaProvider
import no.entur.shared.mobility.to.ref.tomp150.dto.EndpointImplementation
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service("OperatorInformationServiceTomp150")
class OperatorInformationService(
    @Qualifier("tomp150MetaProvider") private val metaProvider: MetaProvider,
) {
    fun operatorMetaGet(
        acceptLanguage: String,
        maasId: String,
        addressedTo: String?,
    ): List<EndpointImplementation> =
        when (addressedTo) {
            in scooterOperators -> metaProvider.scooterOperatorEndpointImplementations()
            in bikeOperators -> metaProvider.bikeOperatorEndpointImplementations()
            ALL_IMPLEMENTING_OPERATOR -> metaProvider.allEndpointImplementations()
            else -> emptyList()
        }
}
