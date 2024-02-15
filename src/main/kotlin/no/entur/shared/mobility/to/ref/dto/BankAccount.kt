package no.entur.shared.mobility.to.ref.dto

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
    val name: String? = null,
    @Schema(example = "null", description = "account number")
    val number: String? = null,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    val country: String? = null,
    @Schema(example = "null", description = "bank identification, like BIC code")
    val bankIdentification: String? = null,
)
