package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetClass
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
 * A generic description of a card, asset class and acceptors is only allowed for DISCOUNT/TRAVEL/OTHER cards
 * @param type The broad category of card
 * @param subType For use in case of OTHER. Can be used in bilateral agreements.
 * @param assetClass 
 * @param acceptors references to accepting parties, only if applicable
 */
data class CardType(

    @Schema(required = true, description = "The broad category of card")
    @param:JsonProperty("type")
    @get:JsonProperty("type", required = true) val type: CardType.Type,

    @Schema(description = "For use in case of OTHER. Can be used in bilateral agreements.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("subType")
    @get:JsonProperty("subType") val subType: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("assetClass")
    @get:JsonProperty("assetClass") val assetClass: AssetClass? = null,

    @Schema(description = "references to accepting parties, only if applicable")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("acceptors")
    @get:JsonProperty("acceptors") val acceptors: kotlin.collections.List<kotlin.String>? = null
) {

    /**
    * The broad category of card
    * Values: ID,DISCOUNT,TRAVEL,BANK,CREDIT,PASSPORT,OTHER
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        ID("ID"),
        DISCOUNT("DISCOUNT"),
        TRAVEL("TRAVEL"),
        BANK("BANK"),
        CREDIT("CREDIT"),
        PASSPORT("PASSPORT"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Type'")
            }
        }
    }

}

