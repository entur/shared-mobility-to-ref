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
 * @param unitCategory 
 * @param description 
 * @param unit 
 * @param amount the travelled distance. Only if applicable.
 */
data class FinancialDetailAllOfUnits(

    @Schema(example = "null", description = "")
    @get:JsonProperty("unitCategory") val unitCategory: FinancialDetailAllOfUnits.UnitCategory? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("unit") val unit: FinancialDetailAllOfUnits.Unit? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("amount") val amount: kotlin.Float? = null
) {

    /**
    * 
    * Values: DISTANCE,DURATION,USAGE,OTHER
    */
    enum class UnitCategory(@get:JsonValue val value: kotlin.String) {

        DISTANCE("DISTANCE"),
        DURATION("DURATION"),
        USAGE("USAGE"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): UnitCategory {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FinancialDetailAllOfUnits'")
            }
        }
    }

    /**
    * 
    * Values: KM,MILE,HOURS,MINUTES,DAYS,LITER,KILOWATTHOUR,CO2_COMPENSATION,OTHER
    */
    enum class Unit(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        MILE("MILE"),
        HOURS("HOURS"),
        MINUTES("MINUTES"),
        DAYS("DAYS"),
        LITER("LITER"),
        KILOWATTHOUR("KILOWATTHOUR"),
        CO2_COMPENSATION("CO2_COMPENSATION"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Unit {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FinancialDetailAllOfUnits'")
            }
        }
    }

}

