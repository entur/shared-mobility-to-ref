package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * describes an (dis)ability or ancillary.
 * @param category references to the first column of the specification initial values [ HR, AV, HV, AB, AER, K, ZR, RR ]
 * @param number references to the second column of the specification
 * @param source if obsolete, it is referencing the travelers' dictionary (https://github.com/TOMP-WG/TOMP-API/blob/master/documents/CROW%20passenger%20characteristics.xlsx)
 * @param type conditionally extra information, referencing to the 3th column
 * @param memo extra field for detailed information, not standardized
 * @param variableNumber in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)
 * @param applicableDays days of week that are applicable
 */
data class Requirement(

    @Schema(example = "null", required = true, description = "references to the first column of the specification initial values [ HR, AV, HV, AB, AER, K, ZR, RR ]")
    @get:JsonProperty("category", required = true) val category: kotlin.String,

    @get:Size(min=2,max=2)
    @Schema(example = "null", required = true, description = "references to the second column of the specification")
    @get:JsonProperty("number", required = true) val number: kotlin.String,

    @Schema(example = "null", description = "if obsolete, it is referencing the travelers' dictionary (https://github.com/TOMP-WG/TOMP-API/blob/master/documents/CROW%20passenger%20characteristics.xlsx)")
    @get:JsonProperty("source") val source: kotlin.String? = null,

    @Schema(example = "null", description = "conditionally extra information, referencing to the 3th column")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @Schema(example = "null", description = "extra field for detailed information, not standardized")
    @get:JsonProperty("memo") val memo: kotlin.String? = null,

    @get:Min(0)
    @Schema(example = "null", description = "in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)")
    @get:JsonProperty("variable-number") val variableNumber: kotlin.Int? = null,

    @Schema(example = "null", description = "days of week that are applicable")
    @get:JsonProperty("applicable-days") val applicableDays: kotlin.collections.List<Requirement.ApplicableDays>? = null
    ) {

    /**
    * days of week that are applicable
    * Values: MO,TU,WE,TH,FR,SA,SU
    */
    enum class ApplicableDays(@get:JsonValue val value: kotlin.String) {

        MO("MO"),
        TU("TU"),
        WE("WE"),
        TH("TH"),
        FR("FR"),
        SA("SA"),
        SU("SU");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ApplicableDays {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Requirement'")
            }
        }
    }

}

