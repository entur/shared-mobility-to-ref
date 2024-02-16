package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.Place
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LegsControllerTest {
    @Autowired
    private lateinit var legsController: LegsController

    @Test
    fun legsIdAncillariesCategoryNumberDelete() {
        legsController.legsIdAncillariesCategoryNumberDelete(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            category = "",
            number = "",
            addressedTo = "",
        )
    }

    @Test
    fun legsIdAncillariesCategoryNumberPost() {
        legsController.legsIdAncillariesCategoryNumberPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            category = "",
            number = "",
            addressedTo = "",
        )
    }

    @Test
    fun legsIdAvailableAssetsGet() {
        legsController.legsIdAvailableAssetsGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = "",
            limit = 1,
            offset = 1,
        )
    }

    @Test
    fun legsIdConfirmationPost() {
        legsController.legsIdConfirmationPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            id = "",
            confirmationRequest = null,
        )
    }

    @Test
    fun legsIdEventsPost() {
        legsController.legsIdEventsPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = "",
            legEvent = null,
        )
    }

    @Test
    fun legsIdGet() {
        legsController.legsIdGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = "",
        )
    }

    @Test
    fun legsIdProgressGet() {
        legsController.legsIdProgressGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = "",
            locationOnly = true,
        )
    }

    @Test
    fun legsIdProgressPost() {
        legsController.legsIdProgressPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = "",
            legProgress = null,
        )
    }

    @Test
    fun legsIdPut() {
        legsController.legsIdPut(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            id = "",
            addressedTo = "",
            leg = Leg(from = Place(Coordinates(0F, 0F, 0F)), assetType = AssetType(id = "")),
        )
    }
}
