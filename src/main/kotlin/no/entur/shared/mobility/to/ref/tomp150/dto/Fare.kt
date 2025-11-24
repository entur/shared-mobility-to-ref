package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.FarePart
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
 * the total fare is the sum of all parts, except for the 'MAX' farePart. This one descripes the maximum price for the complete leg.
 * @param estimated is this fare an estimation?
 * @param parts 
 * @param description user friendly description of the fare (e.g. 'full fare'), should match Content-Language
 * @param propertyClass in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.
 */
data class Fare(

    @Schema(example = "null", required = true, description = "is this fare an estimation?")
    @get:JsonProperty("estimated", required = true) val estimated: kotlin.Boolean,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("parts", required = true) val parts: kotlin.collections.List<FarePart>,

    @Schema(example = "null", description = "user friendly description of the fare (e.g. 'full fare'), should match Content-Language")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.")
    @get:JsonProperty("class") val propertyClass: kotlin.String? = null
) {

}

