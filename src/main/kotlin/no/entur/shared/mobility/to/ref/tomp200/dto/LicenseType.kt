package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Mode
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
 * A category of license to use a certain asset class.
 * @param modes 
 * @param type required when delivered in /collections/license-types/items.
 * @param licenseCategory 
 * @param licenseCode short string, display names (length 0-75)
 * @param issuingCountry two-letter country codes according to ISO 3166-1
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class LicenseType(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("modes", required = true) val modes: kotlin.collections.List<Mode>,

    @get:Pattern(regexp="^(licenseType)$")
    @Schema(example = "null", description = "required when delivered in /collections/license-types/items.")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("licenseCategory") val licenseCategory: LicenseType.LicenseCategory? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("licenseCode") val licenseCode: kotlin.String? = null,

    @get:Pattern(regexp="[A-Z]{2}")
    @get:Size(min=2,max=2)
    @Schema(example = "null", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("issuingCountry") val issuingCountry: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

    /**
    * 
    * Values: DRIVER_LICENSE,OPERATOR_LICENSE,OTHER
    */
    enum class LicenseCategory(@get:JsonValue val value: kotlin.String) {

        DRIVER_LICENSE("DRIVER_LICENSE"),
        OPERATOR_LICENSE("OPERATOR_LICENSE"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): LicenseCategory {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'LicenseType'")
            }
        }
    }

}

