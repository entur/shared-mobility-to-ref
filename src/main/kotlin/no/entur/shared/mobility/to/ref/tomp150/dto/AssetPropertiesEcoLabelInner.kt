package no.entur.shared.mobility.to.ref.tomp150.dto

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
 * @param countryCode two-letter country codes according to ISO 3166-1
 * @param ecoSticker 
 */
data class AssetPropertiesEcoLabelInner(

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("countryCode") val countryCode: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("ecoSticker") val ecoSticker: kotlin.String? = null
    ) {

}

