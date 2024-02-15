package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * the total fare is the sum of all parts, except for the 'MAX' farePart. This one descripes the maximum price for the complete leg.
 * @param estimated is this fare an estimation?
 * @param parts
 * @param description user friendly description of the fare (e.g. 'full fare'), should match Content-Language
 * @param propertyClass in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.
 */
data class Fare(
    @Schema(example = "null", required = true, description = "is this fare an estimation?")
    @get:JsonProperty("estimated", required = true) val estimated: Boolean,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("parts", required = true) val parts: List<FarePart>,
    @Schema(
        example = "null",
        description = "user friendly description of the fare (e.g. 'full fare'), should match Content-Language",
    )
    val description: String? = null,
    @Schema(
        example = "null",
        description = "in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.",
    )
    @get:JsonProperty("class") val propertyClass: String? = null,
)
