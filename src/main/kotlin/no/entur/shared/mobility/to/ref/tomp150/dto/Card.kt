package no.entur.shared.mobility.to.ref.tomp150.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetClass

/**
 * Any kind of card that isn't a license, only provide the cards that are required
 * @param type The broad category of card
 * @param cardNumber number of the card, like ID number, credit card or bank account number
 * @param validUntil
 * @param subType For use in case of OTHER. Can be used in bilateral agreements.
 * @param assetClass
 * @param acceptors references to accepting parties, only if applicable
 * @param cardDescription description of the card
 * @param cardAdditionalNumber additional number, like CVC code or IBAN code
 * @param country two-letter country codes according to ISO 3166-1
 */
data class Card(
    @Schema(example = "null", required = true, description = "The broad category of card")
    @get:JsonProperty("type", required = true) val type: Card.Type,
    @Schema(example = "null", required = true, description = "number of the card, like ID number, credit card or bank account number")
    @get:JsonProperty("cardNumber", required = true) val cardNumber: kotlin.String,
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("validUntil", required = true) val validUntil: java.time.LocalDate,
    @Schema(example = "null", description = "For use in case of OTHER. Can be used in bilateral agreements.")
    @get:JsonProperty("subType") val subType: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("assetClass") val assetClass: AssetClass? = null,
    @Schema(example = "null", description = "references to accepting parties, only if applicable")
    @get:JsonProperty("acceptors") val acceptors: kotlin.collections.List<kotlin.String>? = null,
    @Schema(example = "null", description = "description of the card")
    @get:JsonProperty("cardDescription") val cardDescription: kotlin.String? = null,
    @Schema(example = "null", description = "additional number, like CVC code or IBAN code")
    @get:JsonProperty("cardAdditionalNumber") val cardAdditionalNumber: kotlin.String? = null,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country") val country: kotlin.String? = null,
) {
    /**
     * The broad category of card
     * Values: ID,DISCOUNT,TRAVEL,BANK,CREDIT,PASSPORT,OTHER
     */
    enum class Type(
        @get:JsonValue val value: kotlin.String,
    ) {
        ID("ID"),
        DISCOUNT("DISCOUNT"),
        TRAVEL("TRAVEL"),
        BANK("BANK"),
        CREDIT("CREDIT"),
        PASSPORT("PASSPORT"),
        OTHER("OTHER"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type = values().first { it -> it.value == value }
        }
    }
}
