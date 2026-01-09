package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.AdditionalParameter
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
 * @param title 
 * @param role 
 * @param href 
 * @param parameters 
 */
data class DescriptionTypeAdditionalParameters(

    @Schema(example = "null", description = "")
    @get:JsonProperty("title") val title: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("role") val role: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("href") val href: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("parameters") val parameters: kotlin.collections.List<AdditionalParameter>? = null
) {

}

