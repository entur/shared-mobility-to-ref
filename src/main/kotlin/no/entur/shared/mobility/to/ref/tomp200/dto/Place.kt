package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
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
 * address parts, where addressLine1 and 2 should contain the complete address, matches Content-Language
 * @param id this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param addressLine1 long string, memos etc (length 0-10.000)
 * @param type 
 * @param addressLine2 long string, memos etc (length 0-10.000)
 * @param street default string, full names etc (length 0-200)
 * @param houseNumber default length for an integer (0-1000)
 * @param houseNumberAddition real short string, codes (length 0-10)
 * @param postalCode short string, display names (length 0-75)
 * @param city short string, display names (length 0-75)
 * @param province short string, display names (length 0-75)
 * @param state short string, display names (length 0-75)
 * @param country two-letter country codes according to ISO 3166-1
 * @param additionalInfo long string, memos etc (length 0-10.000)
 */
data class Place(

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Size(max=10000)
    @Schema(example = "null", required = true, description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("addressLine1", required = true) val addressLine1: kotlin.String,

    @get:Pattern(regexp="^(place)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("addressLine2") val addressLine2: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("street") val street: kotlin.String? = null,

    @get:Min(0)
    @get:Max(1000)
    @Schema(example = "null", description = "default length for an integer (0-1000)")
    @get:JsonProperty("houseNumber") val houseNumber: kotlin.Int? = 0,

    @get:Size(max=10)
    @Schema(example = "null", description = "real short string, codes (length 0-10)")
    @get:JsonProperty("houseNumberAddition") val houseNumberAddition: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("postalCode") val postalCode: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("city") val city: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("province") val province: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("state") val state: kotlin.String? = null,

    @get:Pattern(regexp="[A-Z]{2}")
    @get:Size(min=2,max=2)
    @Schema(example = "null", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country") val country: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("additionalInfo") val additionalInfo: kotlin.String? = null
) {

}

