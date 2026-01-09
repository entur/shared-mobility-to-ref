package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Place
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
 * A user that wishes to purchase a package
 * @param id default string, full names etc (length 0-200)
 * @param initials real short string, codes (length 0-10)
 * @param firstName short string, display names (length 0-75)
 * @param lastName short string, display names (length 0-75)
 * @param middleName real short string, codes (length 0-10)
 * @param prefix real short string, codes (length 0-10)
 * @param postfix real short string, codes (length 0-10)
 * @param phoneNumber default string, full names etc (length 0-200)
 * @param email default string, full names etc (length 0-200)
 * @param dateOfBirth https://www.rfc-editor.org/rfc/rfc3339#section-5.6, full-date (2019-10-12)
 * @param placeOfBirth short string, display names (length 0-75)
 * @param countryOfBirth short string, display names (length 0-75)
 * @param address 
 * @param photo 
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class Customer(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Size(max=10)
    @Schema(example = "null", description = "real short string, codes (length 0-10)")
    @get:JsonProperty("initials") val initials: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("firstName") val firstName: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("lastName") val lastName: kotlin.String? = null,

    @get:Size(max=10)
    @Schema(example = "null", description = "real short string, codes (length 0-10)")
    @get:JsonProperty("middleName") val middleName: kotlin.String? = null,

    @get:Size(max=10)
    @Schema(example = "null", description = "real short string, codes (length 0-10)")
    @get:JsonProperty("prefix") val prefix: kotlin.String? = null,

    @get:Size(max=10)
    @Schema(example = "null", description = "real short string, codes (length 0-10)")
    @get:JsonProperty("postfix") val postfix: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("phoneNumber") val phoneNumber: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("email") val email: kotlin.String? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, full-date (2019-10-12)")
    @get:JsonProperty("dateOfBirth") val dateOfBirth: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("placeOfBirth") val placeOfBirth: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("countryOfBirth") val countryOfBirth: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("address") val address: Place? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "")
    @get:JsonProperty("photo") val photo: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

