package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Size

/**
 *
 * @param countryCode two-letter country codes according to ISO 3166-1
 * @param ecoSticker
 */
data class AssetPropertiesEcoLabelInner(
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("countryCode") val countryCode: kotlin.String? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("ecoSticker") val ecoSticker: kotlin.String? = null,
)
