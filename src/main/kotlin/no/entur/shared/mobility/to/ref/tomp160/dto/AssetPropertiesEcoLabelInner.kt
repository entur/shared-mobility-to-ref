package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("countryCode")
    @get:JsonProperty("countryCode") val countryCode: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("ecoSticker")
    @get:JsonProperty("ecoSticker") val ecoSticker: kotlin.String? = null
) {

}

