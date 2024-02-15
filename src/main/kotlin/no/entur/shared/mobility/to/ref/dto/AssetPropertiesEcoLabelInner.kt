package no.entur.shared.mobility.to.ref.dto

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
    val countryCode: String? = null,
    @Schema(example = "null")
    val ecoSticker: String? = null,
)
