package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetClass
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

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("issuingCountry") val issuingCountry: kotlin.String? = null,

    @Schema(example = "1287948792", description = "")
    @get:JsonProperty("number") val number: kotlin.String? = null,

    @Schema(example = "D4", description = "in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the assetType too generic.")
    @get:JsonProperty("licenseCode") val licenseCode: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("validUntil") val validUntil: java.time.LocalDate? = null
    ) {

}

