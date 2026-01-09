package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param time duration, ISO 8601 compliant
 * @param distanceType 
 * @param distance the travelled distance. Only if applicable.
 */
data class TravellerRequirementsEstimatedUsage(

    @get:Pattern(regexp="/^(-?)P(?=\\d|T\\d)(?:(\\d+)Y)?(?:(\\d+)M)?(?:(\\d+)([DW]))?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+(?:\\.\\d+)?)S)?)?$/")
    @Schema(example = "null", description = "duration, ISO 8601 compliant")
    @get:JsonProperty("time") val time: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("distanceType") val distanceType: TravellerRequirementsEstimatedUsage.DistanceType? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("distance") val distance: kotlin.Float? = null
) {

    /**
    * 
    * Values: KM,MILE
    */
    enum class DistanceType(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        MILE("MILE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): DistanceType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'TravellerRequirementsEstimatedUsage'")
            }
        }
    }

}

