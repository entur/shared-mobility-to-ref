package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime
import java.util.UUID
import no.entur.shared.mobility.to.ref.tomp150.controller.required.TripExecutionController as RequiredTripExecutionController
import no.entur.shared.mobility.to.ref.tomp150.controller.unused.TripExecutionController as UnusedTripExecutionController

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TripExecutionControllerTest {
    @Autowired
    private lateinit var requiredLegsController: RequiredTripExecutionController

    @Autowired
    private lateinit var unusedLegsController: UnusedTripExecutionController

    @Test
    fun legsIdAncillariesCategoryNumberDelete() {
        assertThrows<NotImplementedError> {
            unusedLegsController.legsIdAncillariesCategoryNumberDelete(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                id = "",
                category = "",
                number = "",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            )
        }
    }

    @Test
    fun legsIdAncillariesCategoryNumberPost() {
        assertThrows<NotImplementedError> {
            unusedLegsController.legsIdAncillariesCategoryNumberPost(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                id = UUID.randomUUID().toString(),
                category = "",
                number = "",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            )
        }
    }

    @Test
    fun legsIdAvailableAssetsGet() {
        assertThrows<NotImplementedError> {
            unusedLegsController.legsIdAvailableAssetsGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                id = UUID.randomUUID().toString(),
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                limit = 1,
                offset = 1,
            )
        }
    }

    @Test
    fun legsIdEventsPost() {
        requiredLegsController.legsIdEventsPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            id = UUID.randomUUID().toString(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            legEvent = LegEvent(event = LegEvent.Event.SET_IN_USE, time = OffsetDateTime.now()),
        )
    }

    @Test
    fun legsIdGet() {
        requiredLegsController.legsIdGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            id = UUID.randomUUID().toString(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }

    @Test
    fun legsIdProgressGet() {
        assertThrows<NotImplementedError> {
            unusedLegsController.legsIdProgressGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                id = UUID.randomUUID().toString(),
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                locationOnly = true,
            )
        }
    }
}
