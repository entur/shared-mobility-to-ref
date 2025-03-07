package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import no.entur.shared.mobility.to.ref.dto.AssetAccessMethods
import no.entur.shared.mobility.to.ref.dto.AssetPropertiesEcoLabelInner
import no.entur.shared.mobility.to.ref.dto.Place
import no.entur.shared.mobility.to.ref.dto.Requirement

/**
 * Aspects of an asset or assetType. Most aspects are optional and should only be used when applicable.
 * @param name name of asset (type), required in either assetType or asset, should match Content-Language
 * @param location
 * @param brand brand of the asset
 * @param model
 * @param buildingYear
 * @param colour colour of the asset, should match Content-Language
 * @param maxSpeed the maximum allowed speed for this asset (in km/h)
 * @param wheelCount the number of wheels
 * @param image Link to an image of the asset
 * @param icon Link to an icon of the asset
 * @param accessMethods access method for trip execution. Data will be delivered in the response of /booking/{id}/events - COMMIT or /leg/{id}/events - PREPARE (preferred) or GET /bookings/{id}.
 * @param fuel
 * @param propulsion way in which the asset is powered
 * @param energyLabel Energy efficiency
 * @param ecoLabel see https://github.com/MobilityData/gbfs/blob/v2.3/gbfs.md
 * @param co2PerKm
 * @param gears number of gears of the asset
 * @param gearbox type of gearbox
 * @param airConditioning airconditioning available
 * @param cabrio cabrio model
 * @param towingHook towing hook available
 * @param winterTires winter tires applied
 * @param nrOfDoors the number of doors of the vehicle. Return only when applicable
 * @param nrOfHelmets the number of available helmets. Return only when applicable
 * @param navigation navigation available
 * @param cruiseControl cruise control available
 * @param persons number of persons able to use the asset
 * @param infantSeat true indicates infant seat is supplied
 * @param pets true indicates pets are allowed on asset
 * @param smoking true indicates smoking is allowed on asset
 * @param easyAccessibility describes if asset is or needs to be easily accessible
 * @param ancillaries
 * @param regionId the region where this asset or assetType is used.
 * @param cargo describes options to carry cargo, should match Content-Language
 * @param cargoVolume the volume in liters of the cargo
 * @param cargoLoad the weight in kilograms of the cargo
 * @param travelAbroad true indicates asset is allowed to travel abroad
 * @param undergroundParking true indicates underground parking is allowed with asset
 * @param helmetRequired is a helmet required to operate this asset
 * @param defaultReserveTime Maximum time in minutes that a vehicle can be reserved before a rental begins. When a vehicle is reserved by a user, the vehicle remains locked until the rental begins. During this time the vehicle is unavailable and cannot be reserved or rented by other users. The vehicle status in free_bike_status.json MUST be set to is_reserved = true. If the value of default_reserve_time elapses without a rental beginning, the vehicle status MUST change to is_reserved = false. If default_reserve_time is set to 0, the vehicle type cannot be reserved.
 * @param other free text to describe asset, should match Content-Language
 * @param meta this object can contain extra information about the type of asset. For instance values from the 'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used in the planning.
 */
data class AssetProperties(
    @Schema(example = "null", description = "name of asset (type), required in either assetType or asset, should match Content-Language")
    @get:JsonProperty("name") val name: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("location") val location: Place? = null,
    @Schema(example = "null", description = "brand of the asset")
    @get:JsonProperty("brand") val brand: kotlin.String? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("model") val model: kotlin.String? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("buildingYear") val buildingYear: kotlin.Int? = null,
    @Schema(example = "null", description = "colour of the asset, should match Content-Language")
    @get:JsonProperty("colour") val colour: kotlin.String? = null,
    @Schema(example = "null", description = "the maximum allowed speed for this asset (in km/h)")
    @get:JsonProperty("maxSpeed") val maxSpeed: kotlin.Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the number of wheels")
    @get:JsonProperty("wheelCount") val wheelCount: kotlin.Int? = null,
    @Schema(
        example = "https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg",
        description = "Link to an image of the asset",
    )
    @get:JsonProperty("image") val image: kotlin.String? = null,
    @Schema(example = "null", description = "Link to an icon of the asset")
    @get:JsonProperty("icon") val icon: kotlin.String? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = "access method for trip execution. Data will be delivered in the response of /booking/{id}/events - COMMIT or /leg/{id}/events - PREPARE (preferred) or GET /bookings/{id}.",
    )
    @get:JsonProperty("accessMethods") val accessMethods: kotlin.collections.List<AssetAccessMethods>? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("fuel") val fuel: AssetProperties.Fuel? = null,
    @Schema(example = "null", description = "way in which the asset is powered")
    @get:JsonProperty("propulsion") val propulsion: AssetProperties.Propulsion? = null,
    @Schema(example = "null", description = "Energy efficiency")
    @get:JsonProperty("energyLabel") val energyLabel: AssetProperties.EnergyLabel? = null,
    @field:Valid
    @Schema(example = "null", description = "see https://github.com/MobilityData/gbfs/blob/v2.3/gbfs.md")
    @get:JsonProperty("ecoLabel") val ecoLabel: kotlin.collections.List<AssetPropertiesEcoLabelInner>? = null,
    @get:DecimalMin("0")
    @Schema(example = "null", description = "")
    @get:JsonProperty("co2PerKm") val co2PerKm: kotlin.Float? = null,
    @Schema(example = "null", description = "number of gears of the asset")
    @get:JsonProperty("gears") val gears: kotlin.Int? = null,
    @Schema(example = "null", description = "type of gearbox")
    @get:JsonProperty("gearbox") val gearbox: AssetProperties.Gearbox? = null,
    @Schema(example = "null", description = "airconditioning available")
    @get:JsonProperty("airConditioning") val airConditioning: kotlin.Boolean? = null,
    @Schema(example = "null", description = "cabrio model")
    @get:JsonProperty("cabrio") val cabrio: kotlin.Boolean? = null,
    @Schema(example = "null", description = "towing hook available")
    @get:JsonProperty("towingHook") val towingHook: kotlin.Boolean? = null,
    @Schema(example = "null", description = "winter tires applied")
    @get:JsonProperty("winterTires") val winterTires: kotlin.Boolean? = null,
    @Schema(example = "null", description = "the number of doors of the vehicle. Return only when applicable")
    @get:JsonProperty("nrOfDoors") val nrOfDoors: kotlin.Int? = null,
    @Schema(example = "null", description = "the number of available helmets. Return only when applicable")
    @get:JsonProperty("nrOfHelmets") val nrOfHelmets: kotlin.Int? = null,
    @Schema(example = "null", description = "navigation available")
    @get:JsonProperty("navigation") val navigation: kotlin.Boolean? = null,
    @Schema(example = "null", description = "cruise control available")
    @get:JsonProperty("cruiseControl") val cruiseControl: kotlin.Boolean? = null,
    @get:Min(1)
    @Schema(example = "null", description = "number of persons able to use the asset")
    @get:JsonProperty("persons") val persons: kotlin.Int? = null,
    @Schema(example = "null", description = "true indicates infant seat is supplied")
    @get:JsonProperty("infantSeat") val infantSeat: kotlin.Boolean? = null,
    @Schema(example = "null", description = "true indicates pets are allowed on asset")
    @get:JsonProperty("pets") val pets: kotlin.Boolean? = null,
    @Schema(example = "null", description = "true indicates smoking is allowed on asset")
    @get:JsonProperty("smoking") val smoking: kotlin.Boolean? = null,
    @Schema(example = "null", description = "describes if asset is or needs to be easily accessible")
    @get:JsonProperty("easyAccessibility") val easyAccessibility: AssetProperties.EasyAccessibility? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("ancillaries") val ancillaries: kotlin.collections.List<Requirement>? = null,
    @Schema(example = "null", description = "the region where this asset or assetType is used.")
    @get:JsonProperty("regionId") val regionId: kotlin.String? = null,
    @Schema(example = "null", description = "describes options to carry cargo, should match Content-Language")
    @get:JsonProperty("cargo") val cargo: kotlin.String? = null,
    @Schema(example = "null", description = "the volume in liters of the cargo")
    @get:JsonProperty("cargoVolume") val cargoVolume: kotlin.Int? = null,
    @Schema(example = "null", description = "the weight in kilograms of the cargo")
    @get:JsonProperty("cargoLoad") val cargoLoad: kotlin.Int? = null,
    @Schema(example = "null", description = "true indicates asset is allowed to travel abroad")
    @get:JsonProperty("travelAbroad") val travelAbroad: kotlin.Boolean? = null,
    @Schema(example = "null", description = "true indicates underground parking is allowed with asset")
    @get:JsonProperty("undergroundParking") val undergroundParking: kotlin.Boolean? = null,
    @Schema(example = "null", description = "is a helmet required to operate this asset")
    @get:JsonProperty("helmetRequired") val helmetRequired: kotlin.Boolean? = false,
    @get:Min(0)
    @Schema(
        example = "null",
        description = "Maximum time in minutes that a vehicle can be reserved before a rental begins. When a vehicle is reserved by a user, the vehicle remains locked until the rental begins. During this time the vehicle is unavailable and cannot be reserved or rented by other users. The vehicle status in free_bike_status.json MUST be set to is_reserved = true. If the value of default_reserve_time elapses without a rental beginning, the vehicle status MUST change to is_reserved = false. If default_reserve_time is set to 0, the vehicle type cannot be reserved.",
    )
    @get:JsonProperty("defaultReserveTime") val defaultReserveTime: kotlin.Int? = null,
    @Schema(example = "null", description = "free text to describe asset, should match Content-Language")
    @get:JsonProperty("other") val other: kotlin.String? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = "this object can contain extra information about the type of asset. For instance values from the 'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used in the planning.",
    )
    @get:JsonProperty("meta") val meta: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
) {
    /**
     *
     * Values: NONE,GASOLINE,DIESEL,ELECTRIC,HYBRID_GASOLINE,HYBRID_DIESEL,HYBRID_GAS,HYDROGEN,GAS,BIO_MASS,KEROSINE,OTHER
     */
    enum class Fuel(
        @get:JsonValue val value: kotlin.String,
    ) {
        NONE("NONE"),
        GASOLINE("GASOLINE"),
        DIESEL("DIESEL"),
        ELECTRIC("ELECTRIC"),
        HYBRID_GASOLINE("HYBRID_GASOLINE"),
        HYBRID_DIESEL("HYBRID_DIESEL"),
        HYBRID_GAS("HYBRID_GAS"),
        HYDROGEN("HYDROGEN"),
        GAS("GAS"),
        BIO_MASS("BIO_MASS"),
        KEROSINE("KEROSINE"),
        OTHER("OTHER"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Fuel = values().first { it -> it.value == value }
        }
    }

    /**
     * way in which the asset is powered
     * Values: MUSCLE,ELECTRIC,GASOLINE,DIESEL,HYBRID,LPG,HYDROGEN
     */
    enum class Propulsion(
        @get:JsonValue val value: kotlin.String,
    ) {
        MUSCLE("MUSCLE"),
        ELECTRIC("ELECTRIC"),
        GASOLINE("GASOLINE"),
        DIESEL("DIESEL"),
        HYBRID("HYBRID"),
        LPG("LPG"),
        HYDROGEN("HYDROGEN"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Propulsion = values().first { it -> it.value == value }
        }
    }

    /**
     * Energy efficiency
     * Values: A,B,C,D,E
     */
    enum class EnergyLabel(
        @get:JsonValue val value: kotlin.String,
    ) {
        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EnergyLabel = values().first { it -> it.value == value }
        }
    }

    /**
     * type of gearbox
     * Values: MANUAL,AUTOMATIC,SEMIAUTOMATIC
     */
    enum class Gearbox(
        @get:JsonValue val value: kotlin.String,
    ) {
        MANUAL("MANUAL"),
        AUTOMATIC("AUTOMATIC"),
        SEMIAUTOMATIC("SEMIAUTOMATIC"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Gearbox = values().first { it -> it.value == value }
        }
    }

    /**
     * describes if asset is or needs to be easily accessible
     * Values: LIFT,ESCALATOR,GROUND_LEVEL,SIGHTIMPAIRMENT,HEARINGIMPAIRMENT,WHEELCHAIR
     */
    enum class EasyAccessibility(
        @get:JsonValue val value: kotlin.String,
    ) {
        LIFT("LIFT"),
        ESCALATOR("ESCALATOR"),
        GROUND_LEVEL("GROUND_LEVEL"),
        SIGHTIMPAIRMENT("SIGHTIMPAIRMENT"),
        HEARINGIMPAIRMENT("HEARINGIMPAIRMENT"),
        WHEELCHAIR("WHEELCHAIR"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EasyAccessibility = values().first { it -> it.value == value }
        }
    }
}
