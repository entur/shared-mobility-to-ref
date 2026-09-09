package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetAccessMethods
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetPropertiesEcoLabelInner
import no.entur.shared.mobility.to.ref.tomp150.dto.Place
import no.entur.shared.mobility.to.ref.tomp150.dto.Requirement
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

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

    @Schema(description = "name of asset (type), required in either assetType or asset, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("name")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("location")
    @get:JsonProperty("location") val location: Place? = null,

    @Schema(description = "brand of the asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("brand")
    @get:JsonProperty("brand") val brand: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("model")
    @get:JsonProperty("model") val model: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("buildingYear")
    @get:JsonProperty("buildingYear") val buildingYear: kotlin.Int? = null,

    @Schema(description = "colour of the asset, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("colour")
    @get:JsonProperty("colour") val colour: kotlin.String? = null,

    @Schema(description = "the maximum allowed speed for this asset (in km/h)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("maxSpeed")
    @get:JsonProperty("maxSpeed") val maxSpeed: kotlin.Int? = null,

    @get:Min(value=0)
    @Schema(description = "the number of wheels")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("wheelCount")
    @get:JsonProperty("wheelCount") val wheelCount: kotlin.Int? = null,

    @Schema(example = "https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg", description = "Link to an image of the asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("image")
    @get:JsonProperty("image") val image: kotlin.String? = null,

    @Schema(description = "Link to an icon of the asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("icon")
    @get:JsonProperty("icon") val icon: kotlin.String? = null,

    @field:Valid
    @Schema(description = "access method for trip execution. Data will be delivered in the response of /booking/{id}/events - COMMIT or /leg/{id}/events - PREPARE (preferred) or GET /bookings/{id}.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("accessMethods")
    @get:JsonProperty("accessMethods") val accessMethods: kotlin.collections.List<AssetAccessMethods>? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("fuel")
    @get:JsonProperty("fuel") val fuel: AssetProperties.Fuel? = null,

    @Schema(description = "way in which the asset is powered")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("propulsion")
    @get:JsonProperty("propulsion") val propulsion: AssetProperties.Propulsion? = null,

    @Schema(description = "Energy efficiency")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("energyLabel")
    @get:JsonProperty("energyLabel") val energyLabel: AssetProperties.EnergyLabel? = null,

    @field:Valid
    @Schema(description = "see https://github.com/MobilityData/gbfs/blob/v2.3/gbfs.md")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("ecoLabel")
    @get:JsonProperty("ecoLabel") val ecoLabel: kotlin.collections.List<AssetPropertiesEcoLabelInner>? = null,

    @get:DecimalMin(value="0")
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("co2PerKm")
    @get:JsonProperty("co2PerKm") val co2PerKm: kotlin.Float? = null,

    @Schema(description = "number of gears of the asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("gears")
    @get:JsonProperty("gears") val gears: kotlin.Int? = null,

    @Schema(description = "type of gearbox")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("gearbox")
    @get:JsonProperty("gearbox") val gearbox: AssetProperties.Gearbox? = null,

    @Schema(description = "airconditioning available")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("airConditioning")
    @get:JsonProperty("airConditioning") val airConditioning: kotlin.Boolean? = null,

    @Schema(description = "cabrio model")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("cabrio")
    @get:JsonProperty("cabrio") val cabrio: kotlin.Boolean? = null,

    @Schema(description = "towing hook available")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("towingHook")
    @get:JsonProperty("towingHook") val towingHook: kotlin.Boolean? = null,

    @Schema(description = "winter tires applied")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("winterTires")
    @get:JsonProperty("winterTires") val winterTires: kotlin.Boolean? = null,

    @Schema(description = "the number of doors of the vehicle. Return only when applicable")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("nrOfDoors")
    @get:JsonProperty("nrOfDoors") val nrOfDoors: kotlin.Int? = null,

    @Schema(description = "the number of available helmets. Return only when applicable")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("nrOfHelmets")
    @get:JsonProperty("nrOfHelmets") val nrOfHelmets: kotlin.Int? = null,

    @Schema(description = "navigation available")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("navigation")
    @get:JsonProperty("navigation") val navigation: kotlin.Boolean? = null,

    @Schema(description = "cruise control available")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("cruiseControl")
    @get:JsonProperty("cruiseControl") val cruiseControl: kotlin.Boolean? = null,

    @get:Min(value=1)
    @Schema(description = "number of persons able to use the asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("persons")
    @get:JsonProperty("persons") val persons: kotlin.Int? = null,

    @Schema(description = "true indicates infant seat is supplied")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("infantSeat")
    @get:JsonProperty("infantSeat") val infantSeat: kotlin.Boolean? = null,

    @Schema(description = "true indicates pets are allowed on asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("pets")
    @get:JsonProperty("pets") val pets: kotlin.Boolean? = null,

    @Schema(description = "true indicates smoking is allowed on asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("smoking")
    @get:JsonProperty("smoking") val smoking: kotlin.Boolean? = null,

    @Schema(description = "describes if asset is or needs to be easily accessible")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("easyAccessibility")
    @get:JsonProperty("easyAccessibility") val easyAccessibility: AssetProperties.EasyAccessibility? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("ancillaries")
    @get:JsonProperty("ancillaries") val ancillaries: kotlin.collections.List<Requirement>? = null,

    @Schema(description = "the region where this asset or assetType is used.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("regionId")
    @get:JsonProperty("regionId") val regionId: kotlin.String? = null,

    @Schema(description = "describes options to carry cargo, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("cargo")
    @get:JsonProperty("cargo") val cargo: kotlin.String? = null,

    @Schema(description = "the volume in liters of the cargo")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("cargoVolume")
    @get:JsonProperty("cargoVolume") val cargoVolume: kotlin.Int? = null,

    @Schema(description = "the weight in kilograms of the cargo")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("cargoLoad")
    @get:JsonProperty("cargoLoad") val cargoLoad: kotlin.Int? = null,

    @Schema(description = "true indicates asset is allowed to travel abroad")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("travelAbroad")
    @get:JsonProperty("travelAbroad") val travelAbroad: kotlin.Boolean? = null,

    @Schema(description = "true indicates underground parking is allowed with asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("undergroundParking")
    @get:JsonProperty("undergroundParking") val undergroundParking: kotlin.Boolean? = null,

    @Schema(description = "is a helmet required to operate this asset")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("helmetRequired")
    @get:JsonProperty("helmetRequired") val helmetRequired: kotlin.Boolean? = false,

    @get:Min(value=0)
    @Schema(description = "Maximum time in minutes that a vehicle can be reserved before a rental begins. When a vehicle is reserved by a user, the vehicle remains locked until the rental begins. During this time the vehicle is unavailable and cannot be reserved or rented by other users. The vehicle status in free_bike_status.json MUST be set to is_reserved = true. If the value of default_reserve_time elapses without a rental beginning, the vehicle status MUST change to is_reserved = false. If default_reserve_time is set to 0, the vehicle type cannot be reserved.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("defaultReserveTime")
    @get:JsonProperty("defaultReserveTime") val defaultReserveTime: kotlin.Int? = null,

    @Schema(description = "free text to describe asset, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("other")
    @get:JsonProperty("other") val other: kotlin.String? = null,

    @field:Valid
    @Schema(description = "this object can contain extra information about the type of asset. For instance values from the 'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used in the planning.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("meta")
    @get:JsonProperty("meta") val meta: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

    /**
    * 
    * Values: NONE,GASOLINE,DIESEL,ELECTRIC,HYBRID_GASOLINE,HYBRID_DIESEL,HYBRID_GAS,HYDROGEN,GAS,BIO_MASS,KEROSINE,OTHER
    */
    enum class Fuel(@get:JsonValue val value: kotlin.String) {

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
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Fuel {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Fuel'")
            }
        }
    }

    /**
    * way in which the asset is powered
    * Values: MUSCLE,ELECTRIC,GASOLINE,DIESEL,HYBRID,LPG,HYDROGEN
    */
    enum class Propulsion(@get:JsonValue val value: kotlin.String) {

        MUSCLE("MUSCLE"),
        ELECTRIC("ELECTRIC"),
        GASOLINE("GASOLINE"),
        DIESEL("DIESEL"),
        HYBRID("HYBRID"),
        LPG("LPG"),
        HYDROGEN("HYDROGEN");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Propulsion {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Propulsion'")
            }
        }
    }

    /**
    * Energy efficiency
    * Values: A,B,C,D,E
    */
    enum class EnergyLabel(@get:JsonValue val value: kotlin.String) {

        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EnergyLabel {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'EnergyLabel'")
            }
        }
    }

    /**
    * type of gearbox
    * Values: MANUAL,AUTOMATIC,SEMIAUTOMATIC
    */
    enum class Gearbox(@get:JsonValue val value: kotlin.String) {

        MANUAL("MANUAL"),
        AUTOMATIC("AUTOMATIC"),
        SEMIAUTOMATIC("SEMIAUTOMATIC");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Gearbox {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Gearbox'")
            }
        }
    }

    /**
    * describes if asset is or needs to be easily accessible
    * Values: LIFT,ESCALATOR,GROUND_LEVEL,SIGHTIMPAIRMENT,HEARINGIMPAIRMENT,WHEELCHAIR
    */
    enum class EasyAccessibility(@get:JsonValue val value: kotlin.String) {

        LIFT("LIFT"),
        ESCALATOR("ESCALATOR"),
        GROUND_LEVEL("GROUND_LEVEL"),
        SIGHTIMPAIRMENT("SIGHTIMPAIRMENT"),
        HEARINGIMPAIRMENT("HEARINGIMPAIRMENT"),
        WHEELCHAIR("WHEELCHAIR");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EasyAccessibility {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'EasyAccessibility'")
            }
        }
    }

}

