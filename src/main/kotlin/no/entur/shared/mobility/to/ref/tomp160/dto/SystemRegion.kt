package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.GeojsonPolygon
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
 * 
 * @param regionId Unique identifier for this region
 * @param name Public name for this region, could match Content-Language
 * @param type the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0, it was only allowed to communicate OPERATING area's.
 * @param typeUnit in case the type needs a value (f.x. speed limit), this is the unit type.
 * @param typeValue the value that belongs to the type (e.g. 8 MPH)
 * @param areaStartTime the start time of this area (mostly applicable in case of limitations)
 * @param areaEndTime the end time of this area (mostly applicable in case of limitations)
 * @param serviceArea 
 */
data class SystemRegion(

    @Schema(example = "BikeRegion", required = true, description = "Unique identifier for this region")
    @get:JsonProperty("regionId", required = true) val regionId: kotlin.String,

    @Schema(example = "BikeTown", required = true, description = "Public name for this region, could match Content-Language")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @Schema(example = "null", description = "the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0, it was only allowed to communicate OPERATING area's.")
    @get:JsonProperty("type") val type: SystemRegion.Type? = Type.OPERATING,

    @Schema(example = "null", description = "in case the type needs a value (f.x. speed limit), this is the unit type.")
    @get:JsonProperty("typeUnit") val typeUnit: SystemRegion.TypeUnit? = null,

    @Schema(example = "null", description = "the value that belongs to the type (e.g. 8 MPH)")
    @get:JsonProperty("typeValue") val typeValue: kotlin.Float? = null,

    @Schema(example = "null", description = "the start time of this area (mostly applicable in case of limitations)")
    @get:JsonProperty("areaStartTime") val areaStartTime: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "the end time of this area (mostly applicable in case of limitations)")
    @get:JsonProperty("areaEndTime") val areaEndTime: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("serviceArea") val serviceArea: GeojsonPolygon? = null
    ) {

    /**
    * the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0, it was only allowed to communicate OPERATING area's.
    * Values: OPERATING,NO_ACCESS,NO_PARKING,PARKING,DISCOUNT,SPEEDLIMIT
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        OPERATING("OPERATING"),
        NO_ACCESS("NO_ACCESS"),
        NO_PARKING("NO_PARKING"),
        PARKING("PARKING"),
        DISCOUNT("DISCOUNT"),
        SPEEDLIMIT("SPEEDLIMIT");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SystemRegion'")
            }
        }
    }

    /**
    * in case the type needs a value (f.x. speed limit), this is the unit type.
    * Values: KMPH,MPH
    */
    enum class TypeUnit(@get:JsonValue val value: kotlin.String) {

        KMPH("KMPH"),
        MPH("MPH");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): TypeUnit {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SystemRegion'")
            }
        }
    }

}

