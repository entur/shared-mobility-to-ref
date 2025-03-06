package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import no.entur.shared.mobility.to.ref.dto.AssetClass

/**
 * A category of license to use a certain asset class
 * @param assetClass
 * @param issuingCountry two-letter country codes according to ISO 3166-1
 */
data class LicenseType(
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("assetClass", required = true) val assetClass: AssetClass,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("issuingCountry") val issuingCountry: kotlin.String? = null,
)
