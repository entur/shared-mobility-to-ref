package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * this can be used to assign an ancillary to a leg, by using the field `ancillary`. If you want to replace an ancillary, fill the field `replacesAncillary` with the ancillary to replace and `ancillary` with the new one. If you want to remove an assigned ancillary from a leg, fill `ancillary` with 'null' and fill `replacesAncillary` with the ancillary to remove.
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param leg default string, full names etc (length 0-200)
 * @param ancillary default string, full names etc (length 0-200)
 * @param replacesAncillary default string, full names etc (length 0-200)
 */
data class AssignAncillaryRequestRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package", required = true) val `package`: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("leg", required = true) val leg: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("ancillary") val ancillary: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("replacesAncillary") val replacesAncillary: kotlin.String? = null
) {

}

