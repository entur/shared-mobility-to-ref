package no.entur.shared.mobility.to.ref.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.FileNotFoundException

@RestController
@RequestMapping("mobility/v2/gbfs")
class GbfsController {
    @Value("\${baseUrl}")
    val baseUrl: String = "https://api.dev.entur.io/shared-mobility-to-ref/v1"

    @GetMapping(produces = ["application/json"])
    fun gbfs(): String = getFile("gbfs.json").replace("BASE_URL", baseUrl)

    @GetMapping("/v2/kenwaybysykkel/gbfs", produces = ["application/json"])
    fun kenwaybysykkelGbfs(): String = getFile("kenwaybysykkel-gbfs.json").replace("BASE_URL", baseUrl)

    @GetMapping("/v2/kenwaybysykkel/station_information", produces = ["application/json"])
    fun kenwaybysykkelStationInformation(): String = getFile("kenwaybysykkel-station_information.json")

    @GetMapping("/v2/kenwaybysykkel/station_status", produces = ["application/json"])
    fun kenwaybysykkelStationStatus(): String = getFile("kenwaybysykkel-station_status.json")

    @GetMapping("/v2/kenwaybysykkel/system_information", produces = ["application/json"])
    fun kenwaybysykkelSystemInformation(): String = getFile("kenwaybysykkel-system_information.json")

    @GetMapping("/v2/kenwaybysykkel/system_pricing_plans", produces = ["application/json"])
    fun kenwaybysykkelSystemPricingPlans(): String = getFile("kenwaybysykkel-system_pricing_plans.json")

    @GetMapping("/v2/kenwaybysykkel/vehicle_types", produces = ["application/json"])
    fun kenwaybysykkelVehicleTypes(): String = getFile("kenwaybysykkel-vehicle_types.json")

    @GetMapping("/v2/eziotrondheim/free_bike_status", produces = ["application/json"])
    fun eziotrondheimFreeBikeStatus(): String = getFile("eziotrondheim-free_bike_status.json")

    @GetMapping("/v2/eziotrondheim/gbfs", produces = ["application/json"])
    fun eziotrondheimGbfs(): String = getFile("eziotrondheim-gbfs.json").replace("BASE_URL", baseUrl)

    @GetMapping("/v2/eziotrondheim/geofencing_zones", produces = ["application/json"])
    fun eziotrondheimGeofencingZones(): String = getFile("eziotrondheim-geofencing_zones.json")

    @GetMapping("/v2/eziotrondheim/station_information", produces = ["application/json"])
    fun eziotrondheimStationInformation(): String = getFile("eziotrondheim-station_information.json")

    @GetMapping("/v2/eziotrondheim/system_hours", produces = ["application/json"])
    fun eziotrondheimSystemHours(): String = getFile("eziotrondheim-system_hours.json")

    @GetMapping("/v2/eziotrondheim/system_information", produces = ["application/json"])
    fun eziotrondheimSystemInformation(): String = getFile("eziotrondheim-system_information.json")

    @GetMapping("/v2/eziotrondheim/system_pricing_plans", produces = ["application/json"])
    fun eziotrondheimSystemPricingPlans(): String = getFile("eziotrondheim-system_pricing_plans.json")

    @GetMapping("/v2/eziotrondheim/vehicle_types", produces = ["application/json"])
    fun eziotrondheimVehicleTypes(): String = getFile("eziotrondheim-vehicle_types.json")

    @GetMapping("/v2/altairtrondheim/free_bike_status", produces = ["application/json"])
    fun altairtrondheimFreeBikeStatus(): String = getFile("altairtrondheim-free_bike_status.json")

    @GetMapping("/v2/altairtrondheim/gbfs", produces = ["application/json"])
    fun altairtrondheimGbfs(): String = getFile("altairtrondheim-gbfs.json").replace("BASE_URL", baseUrl)

    @GetMapping("/v2/altairtrondheim/geofencing_zones", produces = ["application/json"])
    fun altairtrondheimGeofencingZones(): String = getFile("altairtrondheim-geofencing_zones.json")

    @GetMapping("/v2/altairtrondheim/system_information", produces = ["application/json"])
    fun altairtrondheimSystemInformation(): String = getFile("altairtrondheim-system_information.json")

    @GetMapping("/v2/altairtrondheim/system_pricing_plans", produces = ["application/json"])
    fun altairtrondheimSystemPricingPlans(): String = getFile("altairtrondheim-system_pricing_plans.json")

    @GetMapping("/v2/altairtrondheim/vehicle_types", produces = ["application/json"])
    fun altairtrondheimVehicleTypes(): String = getFile("altairtrondheim-vehicle_types.json")

    @GetMapping("/v2/basimbysykkel/gbfs", produces = ["application/json"])
    fun basimbysykkelGbfs(): String = getFile("basimbysykkel-gbfs.json").replace("BASE_URL", baseUrl)

    @GetMapping("/v2/basimbysykkel/station_information", produces = ["application/json"])
    fun basimbysykkelStationInformation(): String = getFile("basimbysykkel-station_information.json")

    @GetMapping("/v2/basimbysykkel/station_status", produces = ["application/json"])
    fun basimbysykkelStationStatus(): String = getFile("basimbysykkel-station_status.json")

    @GetMapping("/v2/basimbysykkel/system_information", produces = ["application/json"])
    fun basimbysykkelSystemInformation(): String = getFile("basimbysykkel-system_information.json")

    @GetMapping("/v2/basimbysykkel/system_pricing_plans", produces = ["application/json"])
    fun basimbysykkelSystemPricingPlans(): String = getFile("basimbysykkel-system_pricing_plans.json")

    @GetMapping("/v2/basimbysykkel/vehicle_types", produces = ["application/json"])
    fun basimbysykkelVehicleTypes(): String = getFile("basimbysykkel-vehicle_types.json")

    @GetMapping("/v2/evietrondheim/free_bike_status", produces = ["application/json"])
    fun evietrondheimFreeBikeStatus(): String = getFile("evietrondheim-free_bike_status.json")

    @GetMapping("/v2/evietrondheim/gbfs", produces = ["application/json"])
    fun evietrondheimGbfs(): String = getFile("evietrondheim-gbfs.json").replace("BASE_URL", baseUrl)

    @GetMapping("/v2/evietrondheim/geofencing_zones", produces = ["application/json"])
    fun evietrondheimGeofencingZones(): String = getFile("evietrondheim-geofencing_zones.json")

    @GetMapping("/v2/evietrondheim/system_alerts", produces = ["application/json"])
    fun evietrondheimSystemAlerts(): String = getFile("evietrondheim-system_alerts.json")

    @GetMapping("/v2/evietrondheim/system_information", produces = ["application/json"])
    fun evietrondheimSystemInformation(): String = getFile("evietrondheim-system_information.json")

    @GetMapping("/v2/evietrondheim/system_pricing_plans", produces = ["application/json"])
    fun evietrondheimSystemPricingPlans(): String = getFile("evietrondheim-system_pricing_plans.json")

    @GetMapping("/v2/evietrondheim/system_regions", produces = ["application/json"])
    fun evietrondheimSystemRegions(): String = getFile("evietrondheim-system_regions.json")

    @GetMapping("/v2/evietrondheim/vehicle_types", produces = ["application/json"])
    fun evietrondheimVehicleTypes(): String = getFile("evietrondheim-vehicle_types.json")

    private fun getFile(fileName: String): String =
        this::class.java.getResource("/gbfs/$fileName")?.readText() ?: throw FileNotFoundException()
}
