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
 * bank account
 * @param name short string, display names (length 0-75)
 * @param number short string, display names (length 0-75)
 * @param country two-letter country codes according to ISO 3166-1
 * @param bankIdentification short string, display names (length 0-75)
 */
data class BankAccount(

    @get:Size(max=75)
    @Schema(example = "null", required = true, description = "short string, display names (length 0-75)")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:Size(max=75)
    @Schema(example = "null", required = true, description = "short string, display names (length 0-75)")
    @get:JsonProperty("number", required = true) val number: kotlin.String,

    @get:Pattern(regexp="[A-Z]{2}")
    @get:Size(min=2,max=2)
    @Schema(example = "null", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country") val country: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("bankIdentification") val bankIdentification: kotlin.String? = null
) {

}

