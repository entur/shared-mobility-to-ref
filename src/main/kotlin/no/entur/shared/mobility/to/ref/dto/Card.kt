package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import java.time.LocalDate

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
    @get:JsonProperty("type", required = true) val type: Type,
    @Schema(
        example = "null",
        required = true,
        description = "number of the card, like ID number, credit card or bank account number",
    )
    @get:JsonProperty("cardNumber", required = true) val cardNumber: String,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("validUntil", required = true) val validUntil: LocalDate,
    @Schema(example = "null", description = "For use in case of OTHER. Can be used in bilateral agreements.")
    val subType: String? = null,
    @field:Valid
    @Schema(example = "null")
    val assetClass: AssetClass? = null,
    @Schema(example = "null", description = "references to accepting parties, only if applicable")
    val acceptors: List<String>? = null,
    @Schema(example = "null", description = "description of the card")
    val cardDescription: String? = null,
    @Schema(example = "null", description = "additional number, like CVC code or IBAN code")
    val cardAdditionalNumber: String? = null,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    val country: String? = null,
) {
    /**
     * The broad category of card
     * Values: iD,dISCOUNT,tRAVEL,bANK,cREDIT,pASSPORT,oTHER
     */
    enum class Type {
        ID,
        DISCOUNT,
        TRAVEL,
        BANK,
        CREDIT,
        PASSPORT,
        OTHER,
    }
}
