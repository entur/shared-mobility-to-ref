package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegEvent
import no.entur.shared.mobility.to.ref.dto.Place
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime
import java.util.UUID

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LegsControllerTest {
    @Autowired
    private lateinit var legsController: LegsController

    @Test
    fun legsIdAncillariesCategoryNumberDelete() {
        assertThrows<NotImplementedError> {
            legsController.legsIdAncillariesCategoryNumberDelete(
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
            legsController.legsIdAncillariesCategoryNumberPost(
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
            legsController.legsIdAvailableAssetsGet(
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
    fun legsIdConfirmationPost() {
        legsController.legsIdConfirmationPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            id = UUID.randomUUID().toString(),
            confirmationRequest = null,
        )
    }

    @Test
    fun legsIdEventsPost() {
        legsController.legsIdEventsPost(
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
        legsController.legsIdGet(
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
            legsController.legsIdProgressGet(
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

    @Test
    fun legsIdProgressPost() {
        legsController.legsIdProgressPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            id = UUID.randomUUID().toString(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            legProgress = null,
        )
    }

    @Test
    fun legsIdPut() {
        legsController.legsIdPut(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            id = UUID.randomUUID().toString(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            leg = Leg(from = Place(Coordinates(0F, 0F, 0F)), assetType = AssetType(id = "")),
        )
    }
}
