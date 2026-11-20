package no.entur.shared.mobility.to.ref.gbfs2.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class GbfsControllerTest {
    private val gbfsController: GbfsController = GbfsController()

    @Test
    fun `gbfs returns valid json`() {
        val json = gbfsController.gbfs()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("systems") shouldNotBe null
    }

    @Test
    fun `eziotrondheimFreeBikeStatus returns valid json`() {
        val json = gbfsController.eziotrondheimFreeBikeStatus()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimGbfs returns valid json`() {
        val json = gbfsController.eziotrondheimGbfs()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimGeofencingZones returns valid json`() {
        val json = gbfsController.eziotrondheimGeofencingZones()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimStationInformation returns valid json`() {
        val json = gbfsController.eziotrondheimStationInformation()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimSystemHours returns valid json`() {
        val json = gbfsController.eziotrondheimSystemHours()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimSystemInformation returns valid json`() {
        val json = gbfsController.eziotrondheimSystemInformation()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimSystemPricingPlans returns valid json`() {
        val json = gbfsController.eziotrondheimSystemPricingPlans()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `eziotrondheimVehicleTypes returns valid json`() {
        val json = gbfsController.eziotrondheimVehicleTypes()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `basimbysykkelGbfs returns valid json`() {
        val json = gbfsController.basimbysykkelGbfs()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `basimbysykkelStationInformation returns valid json`() {
        val json = gbfsController.basimbysykkelStationInformation()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `basimbysykkelStationStatus returns valid json`() {
        val json = gbfsController.basimbysykkelStationStatus()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `basimbysykkelSystemInformation returns valid json`() {
        val json = gbfsController.basimbysykkelSystemInformation()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `basimbysykkelSystemPricingPlans returns valid json`() {
        val json = gbfsController.basimbysykkelSystemPricingPlans()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `basimbysykkelVehicleTypes returns valid json`() {
        val json = gbfsController.basimbysykkelVehicleTypes()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimFreeBikeStatus returns valid json`() {
        val json = gbfsController.evietrondheimFreeBikeStatus()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimGbfs returns valid json`() {
        val json = gbfsController.evietrondheimGbfs()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimGeofencingZones returns valid json`() {
        val json = gbfsController.evietrondheimGeofencingZones()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimSystemAlerts returns valid json`() {
        val json = gbfsController.evietrondheimSystemAlerts()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimSystemInformation returns valid json`() {
        val json = gbfsController.evietrondheimSystemInformation()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimSystemPricingPlans returns valid json`() {
        val json = gbfsController.evietrondheimSystemPricingPlans()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimSystemRegions returns valid json`() {
        val json = gbfsController.evietrondheimSystemRegions()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }

    @Test
    fun `evietrondheimVehicleTypes returns valid json`() {
        val json = gbfsController.evietrondheimVehicleTypes()
        json shouldNotBe null
        val jsonTree = jacksonObjectMapper().readTree(json)
        jsonTree.get("data") shouldNotBe null
    }
}
