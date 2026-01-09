package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.FinancialDetail
import no.entur.shared.mobility.to.ref.tomp200.dto.Guarantee
import no.entur.shared.mobility.to.ref.tomp200.dto.PackageProperties
import no.entur.shared.mobility.to.ref.tomp200.dto.PackageStatus
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
 * @param type 
 * @param id https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param packageState 
 * @param redressType 
 * @param reason 
 * @param compensations 
 * @param replacements 
 */
data class RedressOption(

    @get:Pattern(regexp="^(RedressOption)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @Schema(example = "null", description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("packageState") val packageState: PackageStatus? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("redressType") val redressType: RedressOption.RedressType? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("reason") val reason: Guarantee? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("compensations") val compensations: kotlin.collections.List<FinancialDetail>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("replacements") val replacements: kotlin.collections.List<PackageProperties>? = null
) {

    /**
    * 
    * Values: PACKAGE_REFUND,OFFER_REFUND,LEG_REFUND,ANCILLARY_REFUND,REPLACEMENT
    */
    enum class RedressType(@get:JsonValue val value: kotlin.String) {

        PACKAGE_REFUND("PACKAGE_REFUND"),
        OFFER_REFUND("OFFER_REFUND"),
        LEG_REFUND("LEG_REFUND"),
        ANCILLARY_REFUND("ANCILLARY_REFUND"),
        REPLACEMENT("REPLACEMENT");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): RedressType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'RedressOption'")
            }
        }
    }

}

