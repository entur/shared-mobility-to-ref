package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.allEndpointImplementations
import no.entur.shared.mobility.to.ref.data.assetType
import no.entur.shared.mobility.to.ref.data.bikeOperatorEndpointImplementations
import no.entur.shared.mobility.to.ref.data.scooterOperatorEndpointImplementations
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
class OperatorService {
    fun operatorAlertsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
        regionId: String?,
        stationId: String?,
    ): List<SystemAlert> {
        throw NotImplementedError()
    }

    fun operatorAvailableAssetsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
        regionId: String?,
        stationId: String?,
    ): List<AssetType> {
        return when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(assetType)
            else -> throw NotImplementedError()
        }
    }

    fun operatorInformationGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
    ): SystemInformation {
        return when (addressedTo) {
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> systemInformation
            else -> throw NotImplementedError()
        }
    }

    fun operatorMetaGet(
        acceptLanguage: String,
        maasId: String,
        addressedTo: String?,
    ): List<EndpointImplementation> {
        return when (addressedTo) {
            SCOOTER_OPERATOR_NO_DEPOSIT -> scooterOperatorEndpointImplementations
            SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> scooterOperatorEndpointImplementations
            SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> scooterOperatorEndpointImplementations
            BIKE_OPERATOR -> bikeOperatorEndpointImplementations
            ALL_IMPLEMENTING_OPERATOR -> allEndpointImplementations
            else -> emptyList()
        }
    }

    fun operatorOperatingCalendarGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        regionId: String?,
        stationId: String?,
    ): List<SystemCalendar> {
        throw NotImplementedError()
    }

    fun operatorOperatingHoursGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        regionId: String?,
        stationId: String?,
    ): List<SystemHours> {
        throw NotImplementedError()
    }

    fun operatorPingGet(acceptLanguage: String) {
    }

    fun operatorPricingPlansGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        regionId: String?,
        stationId: String?,
    ): List<SystemPricingPlan> {
        throw NotImplementedError()
    }

    fun operatorRegionsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
    ): List<SystemRegion> {
        throw NotImplementedError()
    }

    fun operatorStationsGet(
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
    ): List<StationInformation> {
        throw NotImplementedError()
    }
}
