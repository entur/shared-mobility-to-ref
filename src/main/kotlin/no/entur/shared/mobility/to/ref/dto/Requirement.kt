package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size

/**
 * describes an (dis)ability or ancillary.
 * @param category references to the first column of the specification initial values [ HR, AV, HV, AB, AER, K, ZR, RR ]
 * @param number references to the second column of the specification
 * @param source if obsolete, it is referencing the travelers' dictionary
 * (https://github.com/TOMP-WG/TOMP-API/blob/master/documents/CROW%20passenger%20characteristics.xlsx)
 * @param type conditionally extra information, referencing to the 3th column
 * @param memo extra field for detailed information, not standardized
 * @param variableNumber in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)
 * @param applicableDays days of week that are applicable
 */
data class Requirement(
    @Schema(
        example = "null",
        required = true,
        description = "references to the first column of the specification initial values [ HR, AV, HV, AB, AER, K, ZR, RR ]",
    )
    @get:JsonProperty("category", required = true) val category: String,
    @get:Size(min = 2, max = 2)
    @Schema(example = "null", required = true, description = "references to the second column of the specification")
    @get:JsonProperty("number", required = true) val number: String,
    @Schema(
        example = "null",
        description =
            "if obsolete, it is referencing the travelers' dictionary " +
                "(https://github.com/TOMP-WG/TOMP-API/blob/master/documents/CROW%20passenger%20characteristics.xlsx)",
    )
    val source: String? = null,
    @Schema(example = "null", description = "conditionally extra information, referencing to the 3th column")
    val type: String? = null,
    @Schema(example = "null", description = "extra field for detailed information, not standardized")
    val memo: String? = null,
    @get:Min(0)
    @Schema(
        example = "null",
        description = "in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)",
    )
    @get:JsonProperty("variable-number") val variableNumber: Int? = null,
    @Schema(example = "null", description = "days of week that are applicable")
    @get:JsonProperty("applicable-days") val applicableDays: List<ApplicableDays>? = null,
) {
    /**
     * days of week that are applicable
     * Values: mO,tU,wE,tH,fR,sA,sU
     */
    enum class ApplicableDays {
        MO,
        TU,
        WE,
        TH,
        FR,
        SA,
        SU,
    }
}
