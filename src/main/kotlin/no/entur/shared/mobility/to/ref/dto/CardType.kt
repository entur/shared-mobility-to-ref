package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * A generic description of a card, asset class and acceptors is only allowed for DISCOUNT/TRAVEL/OTHER cards
 * @param type The broad category of card
 * @param subType For use in case of OTHER. Can be used in bilateral agreements.
 * @param assetClass
 * @param acceptors references to accepting parties, only if applicable
 */
data class CardType(
    @Schema(example = "null", required = true, description = "The broad category of card")
    @get:JsonProperty("type", required = true) val type: Type,
    @Schema(example = "null", description = "For use in case of OTHER. Can be used in bilateral agreements.")
    val subType: String? = null,
    @field:Valid
    @Schema(example = "null")
    val assetClass: AssetClass? = null,
    @Schema(example = "null", description = "references to accepting parties, only if applicable")
    val acceptors: List<String>? = null,
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
