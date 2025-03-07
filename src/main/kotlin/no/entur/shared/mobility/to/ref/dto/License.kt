package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import no.entur.shared.mobility.to.ref.dto.AssetClass

/**
 * driver or usage license for a specific user. Contains the number and the assetType you're allowed to operate (e.g. driver license for CAR)
 * @param assetClass
 * @param issuingCountry two-letter country codes according to ISO 3166-1
 * @param number
 * @param licenseCode in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the assetType too generic.
 * @param validUntil
 */
data class License(
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("assetClass", required = true) val assetClass: AssetClass,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("issuingCountry") val issuingCountry: kotlin.String? = null,
    @Schema(example = "1287948792", description = "")
    @get:JsonProperty("number") val number: kotlin.String? = null,
    @Schema(
        example = "D4",
        description = "in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the assetType too generic.",
    )
    @get:JsonProperty("licenseCode") val licenseCode: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("validUntil") val validUntil: java.time.LocalDate? = null,
)
