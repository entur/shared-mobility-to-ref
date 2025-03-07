package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.AssetClass

/**
 * A generic description of a card, asset class and acceptors is only allowed for DISCOUNT/TRAVEL/OTHER cards
 * @param type The broad category of card
 * @param subType For use in case of OTHER. Can be used in bilateral agreements.
 * @param assetClass
 * @param acceptors references to accepting parties, only if applicable
 */
data class CardType(
    @Schema(example = "null", required = true, description = "The broad category of card")
    @get:JsonProperty("type", required = true) val type: CardType.Type,
    @Schema(example = "null", description = "For use in case of OTHER. Can be used in bilateral agreements.")
    @get:JsonProperty("subType") val subType: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("assetClass") val assetClass: AssetClass? = null,
    @Schema(example = "null", description = "references to accepting parties, only if applicable")
    @get:JsonProperty("acceptors") val acceptors: kotlin.collections.List<kotlin.String>? = null,
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
