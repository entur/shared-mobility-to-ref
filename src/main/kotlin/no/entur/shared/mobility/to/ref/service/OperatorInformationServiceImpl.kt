package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.controller.OperatorInformationService
import no.entur.shared.mobility.to.ref.data.MetaProvider
import no.entur.shared.mobility.to.ref.data.assetType
import no.entur.shared.mobility.to.ref.data.systemInformation
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.dto.StationInformation
import no.entur.shared.mobility.to.ref.dto.SystemAlert
import no.entur.shared.mobility.to.ref.dto.SystemCalendar
import no.entur.shared.mobility.to.ref.dto.SystemHours
import no.entur.shared.mobility.to.ref.dto.SystemInformation
import no.entur.shared.mobility.to.ref.dto.SystemPricingPlan
import no.entur.shared.mobility.to.ref.dto.SystemRegion
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_2
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_3
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
import org.springframework.stereotype.Service

@Service
class OperatorInformationServiceImpl(
    private val metaProvider: MetaProvider,
) : OperatorInformationService {
    override fun operatorAlertsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
        regionId: String?,
        stationId: String?,
    ): List<SystemAlert> = throw NotImplementedError()

    override fun operatorAvailableAssetsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
        regionId: String?,
        stationId: String?,
    ): List<AssetType> =
        when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(assetType)
            else -> throw NotImplementedError()
        }

    override fun operatorInformationGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
    ): SystemInformation =
        when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> systemInformation
            else -> throw NotImplementedError()
        }

    override fun operatorMetaGet(
        acceptLanguage: String,
        maasId: String,
        addressedTo: String?,
    ): List<EndpointImplementation> =
        when (addressedTo) {
            SCOOTER_OPERATOR_NO_DEPOSIT -> metaProvider.scooterOperatorEndpointImplementations()
            SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> metaProvider.scooterOperatorEndpointImplementations()
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> metaProvider.scooterOperatorEndpointImplementations()
            BIKE_OPERATOR -> metaProvider.bikeOperatorEndpointImplementations()
            ALL_IMPLEMENTING_OPERATOR -> metaProvider.allEndpointImplementations()
            else -> emptyList()
        }

    override fun operatorOperatingCalendarGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        regionId: String?,
        stationId: String?,
    ): List<SystemCalendar> = throw NotImplementedError()

    override fun operatorOperatingHoursGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        regionId: String?,
        stationId: String?,
    ): List<SystemHours> = throw NotImplementedError()

    override fun operatorPingGet(acceptLanguage: String) {
    }

    override fun operatorPricingPlansGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        regionId: String?,
        stationId: String?,
    ): List<SystemPricingPlan> = throw NotImplementedError()

    override fun operatorRegionsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
    ): List<SystemRegion> = throw NotImplementedError()

    override fun operatorStationsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
        regionId: String?,
        lon: Float?,
        lat: Float?,
        radius: Float?,
    ): List<StationInformation> = throw NotImplementedError()
}
