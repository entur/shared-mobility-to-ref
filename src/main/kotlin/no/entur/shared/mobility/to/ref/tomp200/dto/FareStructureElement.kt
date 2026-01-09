package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Interval
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
 * this describes a part of the fare (or discount). It contains a for instance the startup costs (fixed) or the flex part (e.g. 1.25 EUR per 2.0 MILES). The amount is tax included. In case of discounts, the values are negative. With 'MAX' you can specify e.g. a maximum of 15 euro per day. Percentage is mainly added for discounts. The `scale` properties create the ability to communicate scales (e.g. the first 4 kilometers you've to pay EUR 0.35 per kilometer, the kilometers 4 until 8 EUR 0.50 and above it EUR 0.80 per kilometer).
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param type type of fare structure element. If there is only one fare structure elements and this field is missing, it should be assumed it is 'FIXED'. In all other situations this field is mandatory.<br> _FIXED_ fixed element, independend on the duration or distance traveled. _FLEX_ flex element, dependend on the duration or distance of the package. Can be tiered. _MAX_ capping mechanism. Calculate the price using the sum of the FIXED and FLEX elements, cap it using this rule. Max 1 per fare structure.
 * @param taxPercentageUsed the travelled distance. Only if applicable.
 * @param currencyCode ISO 4217 currency code
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param priceCondition is this the default price or is this an additional part (discount, price surge). <br> _DEFAULT_ the default price for this price part<br> _DISCOUNT_ the amount must always be negative <br> _SURGE_ the amount must always be positive <br> This also means, that when you're working with discounts or surges, you have to deliver 2 fare structure elements, one for the default price and one for the discount/surge. This can be used in combination with as well the fixed price parts as with the flex price parts.
 * @param units in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR
 * @param amountOfUnits the travelled distance. Only if applicable.
 * @param scale 
 * @param priceInterval 
 * @param name default string, full names etc (length 0-200)
 * @param appliesTo class of this fare structure element. Could be FARE or ANCILLARY<br> _FARE_ this fare structure element is related to the distance or time of usage.<br> _ANCILLARY_ this fare structure element is related to the rental of one or more ancillaries.
 * @param assetCondition in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class FareStructureElement(

    @Schema(example = "null", required = true, description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

    @Schema(example = "null", required = true, description = "type of fare structure element. If there is only one fare structure elements and this field is missing, it should be assumed it is 'FIXED'. In all other situations this field is mandatory.<br> _FIXED_ fixed element, independend on the duration or distance traveled. _FLEX_ flex element, dependend on the duration or distance of the package. Can be tiered. _MAX_ capping mechanism. Calculate the price using the sum of the FIXED and FLEX elements, cap it using this rule. Max 1 per fare structure.")
    @get:JsonProperty("type", required = true) val type: FareStructureElement.Type,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("taxPercentageUsed") val taxPercentageUsed: kotlin.Float? = null,

    @get:Pattern(regexp="[a-zA-Z]{3}")
    @get:Size(min=3,max=3)
    @Schema(example = "null", description = "ISO 4217 currency code")
    @get:JsonProperty("currencyCode") val currencyCode: kotlin.String? = null,

    @get:Pattern(regexp="[A-Z]{2}")
    @get:Size(min=2,max=2)
    @Schema(example = "null", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("vatCountryCode") val vatCountryCode: kotlin.String? = null,

    @Schema(example = "null", description = "is this the default price or is this an additional part (discount, price surge). <br> _DEFAULT_ the default price for this price part<br> _DISCOUNT_ the amount must always be negative <br> _SURGE_ the amount must always be positive <br> This also means, that when you're working with discounts or surges, you have to deliver 2 fare structure elements, one for the default price and one for the discount/surge. This can be used in combination with as well the fixed price parts as with the flex price parts.")
    @get:JsonProperty("priceCondition") val priceCondition: FareStructureElement.PriceCondition? = null,

    @Schema(example = "null", description = "in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR")
    @get:JsonProperty("units") val units: FareStructureElement.Units? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("amountOfUnits") val amountOfUnits: kotlin.Float? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("scale") val scale: Interval? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("priceInterval") val priceInterval: Interval? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "class of this fare structure element. Could be FARE or ANCILLARY<br> _FARE_ this fare structure element is related to the distance or time of usage.<br> _ANCILLARY_ this fare structure element is related to the rental of one or more ancillaries.")
    @get:JsonProperty("appliesTo") val appliesTo: FareStructureElement.AppliesTo? = AppliesTo.FARE,

    @Schema(example = "null", description = "in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE")
    @get:JsonProperty("assetCondition") val assetCondition: FareStructureElement.AssetCondition? = AssetCondition.IN_USE,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

    /**
    * type of fare structure element. If there is only one fare structure elements and this field is missing, it should be assumed it is 'FIXED'. In all other situations this field is mandatory.<br> _FIXED_ fixed element, independend on the duration or distance traveled. _FLEX_ flex element, dependend on the duration or distance of the package. Can be tiered. _MAX_ capping mechanism. Calculate the price using the sum of the FIXED and FLEX elements, cap it using this rule. Max 1 per fare structure.
    * Values: FIXED,FLEX,MAX
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        FIXED("FIXED"),
        FLEX("FLEX"),
        MAX("MAX");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FareStructureElement'")
            }
        }
    }

    /**
    * is this the default price or is this an additional part (discount, price surge). <br> _DEFAULT_ the default price for this price part<br> _DISCOUNT_ the amount must always be negative <br> _SURGE_ the amount must always be positive <br> This also means, that when you're working with discounts or surges, you have to deliver 2 fare structure elements, one for the default price and one for the discount/surge. This can be used in combination with as well the fixed price parts as with the flex price parts.
    * Values: DEFAULT,DISCOUNT,SURGE
    */
    enum class PriceCondition(@get:JsonValue val value: kotlin.String) {

        DEFAULT("DEFAULT"),
        DISCOUNT("DISCOUNT"),
        SURGE("SURGE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): PriceCondition {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FareStructureElement'")
            }
        }
    }

    /**
    * in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR
    * Values: KM,SECOND,MINUTE,HOUR,MILE,PERCENTAGE,ZONE
    */
    enum class Units(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        SECOND("SECOND"),
        MINUTE("MINUTE"),
        HOUR("HOUR"),
        MILE("MILE"),
        PERCENTAGE("PERCENTAGE"),
        ZONE("ZONE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Units {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FareStructureElement'")
            }
        }
    }

    /**
    * class of this fare structure element. Could be FARE or ANCILLARY<br> _FARE_ this fare structure element is related to the distance or time of usage.<br> _ANCILLARY_ this fare structure element is related to the rental of one or more ancillaries.
    * Values: FARE,ANCILLARY
    */
    enum class AppliesTo(@get:JsonValue val value: kotlin.String) {

        FARE("FARE"),
        ANCILLARY("ANCILLARY");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): AppliesTo {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FareStructureElement'")
            }
        }
    }

    /**
    * in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE
    * Values: IN_USE,PAUSED
    */
    enum class AssetCondition(@get:JsonValue val value: kotlin.String) {

        IN_USE("IN_USE"),
        PAUSED("PAUSED");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): AssetCondition {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'FareStructureElement'")
            }
        }
    }

}

