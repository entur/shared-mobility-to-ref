package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Size

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
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country") val country: kotlin.String? = null,
    @Schema(example = "null", description = "bank identification, like BIC code")
    @get:JsonProperty("bankIdentification") val bankIdentification: kotlin.String? = null,
)
