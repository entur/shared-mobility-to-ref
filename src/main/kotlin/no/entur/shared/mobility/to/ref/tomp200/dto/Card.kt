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
 * Any kind of card that isn't a license, only provide the cards that are required
 * @param type 
 * @param cardType default string, full names etc (length 0-200)
 * @param cardNumber short string, display names (length 0-75)
 * @param description short string, display names (length 0-75)
 * @param additionalNumber short string, display names (length 0-75)
 * @param endValidity https://www.rfc-editor.org/rfc/rfc3339#section-5.6, full-date (2019-10-12)
 */
data class Card(

    @get:Pattern(regexp="^(card)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("cardType", required = true) val cardType: kotlin.String,

    @get:Size(max=75)
    @Schema(example = "null", required = true, description = "short string, display names (length 0-75)")
    @get:JsonProperty("cardNumber", required = true) val cardNumber: kotlin.String,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("additionalNumber") val additionalNumber: kotlin.String? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, full-date (2019-10-12)")
    @get:JsonProperty("endValidity") val endValidity: kotlin.String? = null
) {

}

