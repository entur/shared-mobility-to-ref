package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OperatorControllerTest {
    @Autowired
    private lateinit var operatorController: OperatorController

    @Test
    fun operatorAlertsGet() {
        operatorController.operatorAlertsGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            regionId = "",
            stationId = "",
            limit = 0,
            offset = 2,
        )
    }

    @Test
    fun operatorAvailableAssetsGet() {
        operatorController.operatorAvailableAssetsGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            regionId = "",
            stationId = "",
            limit = 0,
            offset = 2,
        )
    }

    @Test
    fun operatorInformationGet() {
        operatorController.operatorInformationGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun operatorMetaGet() {
        operatorController.operatorMetaGet(
            acceptLanguage = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun operatorOperatingCalendarGet() {
        operatorController.operatorOperatingCalendarGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            regionId = "",
            stationId = "",
        )
    }

    @Test
    fun operatorOperatingHoursGet() {
        operatorController.operatorOperatingHoursGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            regionId = "",
            stationId = "",
        )
    }

    @Test
    fun operatorPingGet() {
        operatorController.operatorPingGet(
            acceptLanguage = "",
        )
    }

    @Test
    fun operatorPricingPlansGet() {
        operatorController.operatorPricingPlansGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            regionId = "",
            stationId = "",
        )
    }

    @Test
    fun operatorRegionsGet() {
        operatorController.operatorRegionsGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            offset = 0,
            limit = 0,
        )
    }

    @Test
    fun operatorStationsGet() {
        val operatorStationsGet =
            operatorController.operatorStationsGet(
                acceptLanguage = "",
                api = "",
                apiVersion = "",
                maasId = "",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                offset = 0,
                limit = 0,
                regionId = null,
                lon = 5F,
                lat = 4F,
                radius = 3F,
            )
        println(operatorStationsGet)
    }
}
