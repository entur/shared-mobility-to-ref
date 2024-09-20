package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OperatorControllerTest {
    @Autowired
    private lateinit var operatorController: OperatorController

    @Test
    fun operatorAlertsGet() {
        assertThrows<NotImplementedError> {
            operatorController.operatorAlertsGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                regionId = "",
                stationId = "",
                limit = 0,
                offset = 2,
            )
        }
    }

    @Test
    fun operatorAvailableAssetsGet() {
        operatorController.operatorAvailableAssetsGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
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
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun operatorMetaGet() {
        operatorController.operatorMetaGet(
            acceptLanguage = "NOB",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun operatorOperatingCalendarGet() {
        assertThrows<NotImplementedError> {
            operatorController.operatorOperatingCalendarGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                regionId = "",
                stationId = "",
            )
        }
    }

    @Test
    fun operatorOperatingHoursGet() {
        assertThrows<NotImplementedError> {
            operatorController.operatorOperatingHoursGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                regionId = "",
                stationId = "",
            )
        }
    }

    @Test
    fun operatorPingGet() {
        operatorController.operatorPingGet(
            acceptLanguage = "",
        )
    }

    @Test
    fun operatorPricingPlansGet() {
        assertThrows<NotImplementedError> {
            operatorController.operatorPricingPlansGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                regionId = "",
                stationId = "",
            )
        }
    }

    @Test
    fun operatorRegionsGet() {
        assertThrows<NotImplementedError> {
            operatorController.operatorRegionsGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                offset = 0,
                limit = 0,
            )
        }
    }

    @Test
    fun operatorStationsGet() {
        assertThrows<NotImplementedError> {
            operatorController.operatorStationsGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                offset = 0,
                limit = 0,
                regionId = null,
                lon = 5F,
                lat = 4F,
                radius = 3F,
            )
        }
    }
}
