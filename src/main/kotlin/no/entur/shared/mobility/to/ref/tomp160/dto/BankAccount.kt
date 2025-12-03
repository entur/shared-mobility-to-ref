package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * 
 * @param name account name
 * @param number account number
 * @param country two-letter country codes according to ISO 3166-1
 * @param bankIdentification bank identification, like BIC code
 */
data class BankAccount(

    @Schema(example = "null", description = "account name")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "account number")
    @get:JsonProperty("number") val number: kotlin.String? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country") val country: kotlin.String? = null,

    @Schema(example = "null", description = "bank identification, like BIC code")
    @get:JsonProperty("bankIdentification") val bankIdentification: kotlin.String? = null
) {

}

