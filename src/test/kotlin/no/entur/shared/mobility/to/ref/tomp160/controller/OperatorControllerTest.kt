package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import no.entur.shared.mobility.to.ref.tomp160.controller.optional.OperatorInformationController as OptionalOperatorController
import no.entur.shared.mobility.to.ref.tomp160.controller.required.OperatorInformationController as RequiredOperatorController
import no.entur.shared.mobility.to.ref.tomp160.controller.unused.OperatorInformationController as UnusedOperatorController

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OperatorControllerTest {
    @Autowired
    private lateinit var optionalOperatorController: OptionalOperatorController

    @Autowired
    private lateinit var requiredOperatorController: RequiredOperatorController

    @Autowired
    private lateinit var unusedOperatorController: UnusedOperatorController

    @Test
    fun operatorAlertsGet() {
        assertThrows<NotImplementedError> {
            unusedOperatorController.operatorAlertsGet(
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
        optionalOperatorController.operatorAvailableAssetsGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            regionId = "",
            stationId = "",
            limit = 0,
            offset = 2,
            boundingbox = null,
        )
    }

    @Test
    fun operatorInformationGet() {
        optionalOperatorController.operatorInformationGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun operatorMetaGet() {
        requiredOperatorController.operatorMetaGet(
            acceptLanguage = "NOB",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun operatorOperatingCalendarGet() {
        assertThrows<NotImplementedError> {
            unusedOperatorController.operatorOperatingCalendarGet(
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
            unusedOperatorController.operatorOperatingHoursGet(
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
        optionalOperatorController.operatorPingGet(
            acceptLanguage = "",
        )
    }

    @Test
    fun operatorPricingPlansGet() {
        assertThrows<NotImplementedError> {
            unusedOperatorController.operatorPricingPlansGet(
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
            unusedOperatorController.operatorRegionsGet(
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
            unusedOperatorController.operatorStationsGet(
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
