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
 * @param from the travelled distance. Only if applicable.
 * @param to the travelled distance. Only if applicable.
 * @param units the units is normally the same as the **interval.units**, but it doesn't have to be. For instance, you could pay 1 EUR per kilometer for the first hour.
 */
data class Interval(

    @get:DecimalMin("0")
    @Schema(example = "null", required = true, description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("from", required = true) val from: kotlin.Float,

    @get:DecimalMin("0")
    @Schema(example = "null", required = true, description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("to", required = true) val to: kotlin.Float,

    @Schema(example = "null", required = true, description = "the units is normally the same as the **interval.units**, but it doesn't have to be. For instance, you could pay 1 EUR per kilometer for the first hour.")
    @get:JsonProperty("units", required = true) val units: Interval.Units
) {

    /**
    * the units is normally the same as the **interval.units**, but it doesn't have to be. For instance, you could pay 1 EUR per kilometer for the first hour.
    * Values: KM,MILE,HOUR,MINUTE,ZONE,CURRENCY
    */
    enum class Units(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        MILE("MILE"),
        HOUR("HOUR"),
        MINUTE("MINUTE"),
        ZONE("ZONE"),
        CURRENCY("CURRENCY");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Units {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Interval'")
            }
        }
    }

}

