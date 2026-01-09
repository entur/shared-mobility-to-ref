package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Mode
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
 * A generic description of a CARD
 * @param id default string, full names etc (length 0-200)
 * @param type 
 * @param cardCategory The broad category of card<br> DISCOUNT - discount card, can be applied in the purchase process to get rebate<br> TRAVEL - (external) travel card, possibly paid for in other context, but also monthly, weekly or day-cards<br> BANK - bank card<br> CREDIT - credit card<br> ID - identification card, like an ID card<br> PASSPORT - passport to identify yourself<br> OTHER - unspecified
 * @param subType short string, display names (length 0-75)
 * @param modes modes for which this card can be used, when empty, all modes are allowed
 * @param relatedProduct default string, full names etc (length 0-200)
 * @param transportOrganisations references to accepting parties, only if applicable
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class CardType(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Pattern(regexp="^(cardType)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @Schema(example = "null", description = "The broad category of card<br> DISCOUNT - discount card, can be applied in the purchase process to get rebate<br> TRAVEL - (external) travel card, possibly paid for in other context, but also monthly, weekly or day-cards<br> BANK - bank card<br> CREDIT - credit card<br> ID - identification card, like an ID card<br> PASSPORT - passport to identify yourself<br> OTHER - unspecified")
    @get:JsonProperty("cardCategory") val cardCategory: CardType.CardCategory? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("subType") val subType: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "modes for which this card can be used, when empty, all modes are allowed")
    @get:JsonProperty("modes") val modes: kotlin.collections.List<Mode>? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("relatedProduct") val relatedProduct: kotlin.String? = null,

    @get:Size(max=15)
    @Schema(example = "null", description = "references to accepting parties, only if applicable")
    @get:JsonProperty("transportOrganisations") val transportOrganisations: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

    /**
    * The broad category of card<br> DISCOUNT - discount card, can be applied in the purchase process to get rebate<br> TRAVEL - (external) travel card, possibly paid for in other context, but also monthly, weekly or day-cards<br> BANK - bank card<br> CREDIT - credit card<br> ID - identification card, like an ID card<br> PASSPORT - passport to identify yourself<br> OTHER - unspecified
    * Values: DISCOUNT,TRAVEL,BANK,CREDIT,ID,PASSPORT,OTHER
    */
    enum class CardCategory(@get:JsonValue val value: kotlin.String) {

        DISCOUNT("DISCOUNT"),
        TRAVEL("TRAVEL"),
        BANK("BANK"),
        CREDIT("CREDIT"),
        ID("ID"),
        PASSPORT("PASSPORT"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): CardCategory {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'CardType'")
            }
        }
    }

}

