package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.LicenseType
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
 * @param type 
 * @param licenseType 
 * @param licenseNumber short string, display names (length 0-75)
 * @param endValidity https://www.rfc-editor.org/rfc/rfc3339#section-5.6, full-date (2019-10-12)
 */
data class License(

    @get:Pattern(regexp="^(license)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("licenseType") val licenseType: LicenseType? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("licenseNumber") val licenseNumber: kotlin.String? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, full-date (2019-10-12)")
    @get:JsonProperty("endValidity") val endValidity: kotlin.String? = null
) {

}

