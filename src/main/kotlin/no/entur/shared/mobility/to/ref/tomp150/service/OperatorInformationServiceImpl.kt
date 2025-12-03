package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_2
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_3
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.controller.OperatorInformationService
import no.entur.shared.mobility.to.ref.tomp150.data.MetaProvider
import no.entur.shared.mobility.to.ref.tomp150.data.assetType
import no.entur.shared.mobility.to.ref.tomp150.data.systemInformation
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetType
import no.entur.shared.mobility.to.ref.tomp150.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.tomp150.dto.StationInformation
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemAlert
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemCalendar
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemHours
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemInformation
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemPricingPlan
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemRegion
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service("OperatorInformationServiceTomp150")
class OperatorInformationServiceImpl(
    @Qualifier("tomp150MetaProvider") private val metaProvider: MetaProvider,
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
            ALL_IMPLEMENTING_OPERATOR -> systemInformation
            else -> throw NotImplementedError()
        }

    override fun operatorMetaGet(
        acceptLanguage: String,
        maasId: String,
        addressedTo: String?,
    ): List<EndpointImplementation> =
        when (addressedTo) {
            SCOOTER_OPERATOR_NO_DEPOSIT,
            SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
            SCOOTER_OPERATOR,
            SCOOTER_OPERATOR_2,
            SCOOTER_OPERATOR_3,
            -> metaProvider.scooterOperatorEndpointImplementations()
            COLUMBI_BIKE, URBAN_BIKE -> metaProvider.bikeOperatorEndpointImplementations()
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
