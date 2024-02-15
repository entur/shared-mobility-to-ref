package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min

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
 * @param accessMethods access method for trip execution. Data will be delivered in the response of /booking/{id}/events - COMMIT or
 * /leg/{id}/events - PREPARE (preferred) or GET /bookings/{id}.
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
 * @param defaultReserveTime Maximum time in minutes that a vehicle can be reserved before a rental begins. When a vehicle is
 * reserved by a user, the vehicle remains locked until the rental begins. During this time the vehicle is unavailable and cannot
 * be reserved or rented by other users. The vehicle status in free_bike_status.json MUST be set to is_reserved = true.
 * If the value of default_reserve_time elapses without a rental beginning, the vehicle status MUST change to is_reserved = false.
 * If default_reserve_time is set to 0, the vehicle type cannot be reserved.
 * @param other free text to describe asset, should match Content-Language
 * @param meta this object can contain extra information about the type of asset. For instance values from the
 * 'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used in the planning.
 */
data class AssetProperties(
    @Schema(
        example = "null",
        description = "name of asset (type), required in either assetType or asset, should match Content-Language",
    )
    val name: String? = null,
    @field:Valid
    @Schema(example = "null")
    val location: Place? = null,
    @Schema(example = "null", description = "brand of the asset")
    val brand: String? = null,
    @Schema(example = "null")
    val model: String? = null,
    @Schema(example = "null")
    val buildingYear: Int? = null,
    @Schema(example = "null", description = "colour of the asset, should match Content-Language")
    val colour: String? = null,
    @Schema(example = "null", description = "the maximum allowed speed for this asset (in km/h)")
    val maxSpeed: Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the number of wheels")
    val wheelCount: Int? = null,
    @Schema(
        example = "https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg",
        description = "Link to an image of the asset",
    )
    val image: String? = null,
    @Schema(example = "null", description = "Link to an icon of the asset")
    val icon: String? = null,
    @field:Valid
    @Schema(
        example = "null",
        description =
            "access method for trip execution. Data will be delivered in the response of /booking/{id}/events - COMMIT " +
                "or /leg/{id}/events - PREPARE (preferred) or GET /bookings/{id}.",
    )
    val accessMethods: List<AssetAccessMethods>? = null,
    @Schema(example = "null")
    val fuel: Fuel? = null,
    @Schema(example = "null", description = "way in which the asset is powered")
    val propulsion: Propulsion? = null,
    @Schema(example = "null", description = "Energy efficiency")
    val energyLabel: EnergyLabel? = null,
    @field:Valid
    @Schema(example = "null", description = "see https://github.com/MobilityData/gbfs/blob/v2.3/gbfs.md")
    val ecoLabel: List<AssetPropertiesEcoLabelInner>? = null,
    @get:DecimalMin("0")
    @Schema(example = "null")
    @get:JsonProperty("co2PerKm") val co2PerKm: Float? = null,
    @Schema(example = "null", description = "number of gears of the asset")
    val gears: Int? = null,
    @Schema(example = "null", description = "type of gearbox")
    val gearbox: Gearbox? = null,
    @Schema(example = "null", description = "airconditioning available")
    val airConditioning: Boolean? = null,
    @Schema(example = "null", description = "cabrio model")
    val cabrio: Boolean? = null,
    @Schema(example = "null", description = "towing hook available")
    val towingHook: Boolean? = null,
    @Schema(example = "null", description = "winter tires applied")
    val winterTires: Boolean? = null,
    @Schema(example = "null", description = "the number of doors of the vehicle. Return only when applicable")
    val nrOfDoors: Int? = null,
    @Schema(example = "null", description = "the number of available helmets. Return only when applicable")
    val nrOfHelmets: Int? = null,
    @Schema(example = "null", description = "navigation available")
    val navigation: Boolean? = null,
    @Schema(example = "null", description = "cruise control available")
    val cruiseControl: Boolean? = null,
    @get:Min(1)
    @Schema(example = "null", description = "number of persons able to use the asset")
    val persons: Int? = null,
    @Schema(example = "null", description = "true indicates infant seat is supplied")
    val infantSeat: Boolean? = null,
    @Schema(example = "null", description = "true indicates pets are allowed on asset")
    val pets: Boolean? = null,
    @Schema(example = "null", description = "true indicates smoking is allowed on asset")
    val smoking: Boolean? = null,
    @Schema(example = "null", description = "describes if asset is or needs to be easily accessible")
    val easyAccessibility: EasyAccessibility? = null,
    @field:Valid
    @Schema(example = "null")
    val ancillaries: List<Requirement>? = null,
    @Schema(example = "null", description = "the region where this asset or assetType is used.")
    val regionId: String? = null,
    @Schema(example = "null", description = "describes options to carry cargo, should match Content-Language")
    val cargo: String? = null,
    @Schema(example = "null", description = "the volume in liters of the cargo")
    val cargoVolume: Int? = null,
    @Schema(example = "null", description = "the weight in kilograms of the cargo")
    val cargoLoad: Int? = null,
    @Schema(example = "null", description = "true indicates asset is allowed to travel abroad")
    val travelAbroad: Boolean? = null,
    @Schema(example = "null", description = "true indicates underground parking is allowed with asset")
    val undergroundParking: Boolean? = null,
    @Schema(example = "null", description = "is a helmet required to operate this asset")
    val helmetRequired: Boolean? = false,
    @get:Min(0)
    @Schema(
        example = "null",
        description =
            "Maximum time in minutes that a vehicle can be reserved before a rental begins. When a vehicle is reserved by a " +
                "user, the vehicle remains locked until the rental begins. During this time the vehicle is unavailable and cannot be " +
                "reserved or rented by other users. The vehicle status in free_bike_status.json MUST be set to is_reserved = true. " +
                "If the value of default_reserve_time elapses without a rental beginning, the vehicle status MUST change to " +
                "is_reserved = false. If default_reserve_time is set to 0, the vehicle type cannot be reserved.",
    )
    val defaultReserveTime: Int? = null,
    @Schema(example = "null", description = "free text to describe asset, should match Content-Language")
    val other: String? = null,
    @field:Valid
    @Schema(
        example = "null",
        description =
            "this object can contain extra information about the type of asset. For instance values from the " +
                "'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used " +
                "in the planning.",
    )
    val meta: Map<String, Any>? = null,
) {
    /**
     *
     * Values: nONE,gASOLINE,dIESEL,eLECTRIC,hYBRIDGASOLINE,hYBRIDDIESEL,hYBRIDGAS,hYDROGEN,gAS,bIOMASS,kEROSINE,oTHER
     */
    enum class Fuel {
        NONE,
        GASOLINE,
        DIESEL,
        ELECTRIC,
        HYBRID_GASOLINE,
        HYBRID_DIESEL,
        HYBRID_GAS,
        HYDROGEN,
        GAS,
        BIO_MASS,
        KEROSINE,
        OTHER,
    }

    /**
     * way in which the asset is powered
     * Values: mUSCLE,eLECTRIC,gASOLINE,dIESEL,hYBRID,lPG,hYDROGEN
     */
    enum class Propulsion {
        MUSCLE,
        ELECTRIC,
        GASOLINE,
        DIESEL,
        HYBRID,
        LPG,
        HYDROGEN,
    }

    /**
     * Energy efficiency
     * Values: a,b,c,d,e
     */
    enum class EnergyLabel {
        A,
        B,
        C,
        D,
        E,
    }

    /**
     * type of gearbox
     * Values: mANUAL,aUTOMATIC,sEMIAUTOMATIC
     */
    enum class Gearbox {
        MANUAL,
        AUTOMATIC,
        SEMIAUTOMATIC,
    }

    /**
     * describes if asset is or needs to be easily accessible
     * Values: lIFT,eSCALATOR,gROUNDLEVEL,sIGHTIMPAIRMENT,hEARINGIMPAIRMENT,wHEELCHAIR
     */
    enum class EasyAccessibility {
        LIFT,
        ESCALATOR,
        GROUND_LEVEL,
        SIGHTIMPAIRMENT,
        HEARINGIMPAIRMENT,
        WHEELCHAIR,
    }
}
