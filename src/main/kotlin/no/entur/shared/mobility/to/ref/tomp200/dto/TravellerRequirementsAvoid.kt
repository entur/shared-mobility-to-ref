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
 * 
 * @param places 
 * @param zones 
 * @param lines 
 */
data class TravellerRequirementsAvoid(

    @Schema(example = "null", description = "")
    @get:JsonProperty("places") val places: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("zones") val zones: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lines") val lines: kotlin.collections.List<kotlin.String>? = null
) {

}

