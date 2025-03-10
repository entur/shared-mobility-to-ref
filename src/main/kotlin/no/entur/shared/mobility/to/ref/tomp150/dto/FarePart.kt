package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param amountExVat 
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param type type of fare part. If there is only one farepart and this field is missing, it should be assumed it is 'FIXED'. In all other situations this field is mandatory.
 * @param kind is this the default price or is this an additional part (discount, price surge). In case of a DISCOUNT, the amount must always be negative and in case of SURGE it must be positive. This also means, that when you're working with discounts or surges, you have to deliver 2 fareparts, one for the default price and one for the discount/surge. This can be used in combination with as well the fixed price parts as with the flex price parts.
 * @param unitType in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR
 * @param units the number of km, seconds etc. Mandatory when the type is 'FLEX', otherwise not allowed. In case of 0.5 EUR per 15 MINUTES, `units` should contain 15 and `unitType` MINUTES.
 * @param scaleFrom in case of scaling, this is the bottom value (f.x. in the first hour 3 CAD, the `scaleFrom` should contain 0 and the `scaleType` HOUR). When `scaleTo` is used, but this field is missing, it should be assumed it is a 0.
 * @param scaleTo the upper value of the scale (f.x. 3 CAD in the first hour, this field should contain 1, `scaleFrom` 0 and `scaleType` HOUR)
 * @param scaleType 
 * @param name an optional description of this fare part.
 * @param propertyClass class of this fare part. Could be FARE or ANCILLARY
 * @param minimumAmount The minimum price, in the same currency as amount. Place in `amount` the most likely value.
 * @param maximumAmount The minimum price, in the same currency as amount. Place in `amount` the most likely value.
 * @param assetState in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE
 * @param meta 
 */
data class FarePart(

    @get:DecimalMin("0")
    @Schema(example = "9.95", required = true, description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

    @get:DecimalMin("0")
    @Schema(example = "8.95", description = "")
    @get:JsonProperty("amountExVat") val amountExVat: kotlin.Float? = null,

    @get:Size(min=3,max=3)
    @Schema(example = "null", description = "ISO 4217 currency code")
    @get:JsonProperty("currencyCode") val currencyCode: kotlin.String? = null,

    @get:DecimalMin("0")
    @Schema(example = "21.0", description = "value added tax rate (percentage of amount)")
    @get:JsonProperty("vatRate") val vatRate: kotlin.Float? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("vatCountryCode") val vatCountryCode: kotlin.String? = null,

    @Schema(example = "null", description = "type of fare part. If there is only one farepart and this field is missing, it should be assumed it is 'FIXED'. In all other situations this field is mandatory.")
    @get:JsonProperty("type") val type: FarePart.Type? = null,

    @Schema(example = "null", description = "is this the default price or is this an additional part (discount, price surge). In case of a DISCOUNT, the amount must always be negative and in case of SURGE it must be positive. This also means, that when you're working with discounts or surges, you have to deliver 2 fareparts, one for the default price and one for the discount/surge. This can be used in combination with as well the fixed price parts as with the flex price parts.")
    @get:JsonProperty("kind") val kind: FarePart.Kind? = null,

    @Schema(example = "null", description = "in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR")
    @get:JsonProperty("unitType") val unitType: FarePart.UnitType? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the number of km, seconds etc. Mandatory when the type is 'FLEX', otherwise not allowed. In case of 0.5 EUR per 15 MINUTES, `units` should contain 15 and `unitType` MINUTES.")
    @get:JsonProperty("units") val units: kotlin.Float? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "in case of scaling, this is the bottom value (f.x. in the first hour 3 CAD, the `scaleFrom` should contain 0 and the `scaleType` HOUR). When `scaleTo` is used, but this field is missing, it should be assumed it is a 0.")
    @get:JsonProperty("scaleFrom") val scaleFrom: kotlin.Float? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the upper value of the scale (f.x. 3 CAD in the first hour, this field should contain 1, `scaleFrom` 0 and `scaleType` HOUR)")
    @get:JsonProperty("scaleTo") val scaleTo: kotlin.Float? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("scaleType") val scaleType: FarePart.ScaleType? = null,

    @Schema(example = "null", description = "an optional description of this fare part.")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "class of this fare part. Could be FARE or ANCILLARY")
    @get:JsonProperty("class") val propertyClass: FarePart.PropertyClass? = PropertyClass.FARE,

    @get:DecimalMin("0")
    @Schema(example = "9.0", description = "The minimum price, in the same currency as amount. Place in `amount` the most likely value.")
    @get:JsonProperty("minimumAmount") val minimumAmount: kotlin.Float? = null,

    @get:DecimalMin("0")
    @Schema(example = "11.0", description = "The minimum price, in the same currency as amount. Place in `amount` the most likely value.")
    @get:JsonProperty("maximumAmount") val maximumAmount: kotlin.Float? = null,

    @Schema(example = "null", description = "in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE")
    @get:JsonProperty("assetState") val assetState: FarePart.AssetState? = AssetState.IN_USE,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("meta") val meta: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
    ) {

    /**
    * type of fare part. If there is only one farepart and this field is missing, it should be assumed it is 'FIXED'. In all other situations this field is mandatory.
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
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * is this the default price or is this an additional part (discount, price surge). In case of a DISCOUNT, the amount must always be negative and in case of SURGE it must be positive. This also means, that when you're working with discounts or surges, you have to deliver 2 fareparts, one for the default price and one for the discount/surge. This can be used in combination with as well the fixed price parts as with the flex price parts.
    * Values: DEFAULT,DISCOUNT,SURGE
    */
    enum class Kind(@get:JsonValue val value: kotlin.String) {

        DEFAULT("DEFAULT"),
        DISCOUNT("DISCOUNT"),
        SURGE("SURGE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Kind {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR
    * Values: KM,SECOND,MINUTE,HOUR,MILE,PERCENTAGE
    */
    enum class UnitType(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        SECOND("SECOND"),
        MINUTE("MINUTE"),
        HOUR("HOUR"),
        MILE("MILE"),
        PERCENTAGE("PERCENTAGE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): UnitType {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * 
    * Values: KM,MILE,HOUR,MINUTE
    */
    enum class ScaleType(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        MILE("MILE"),
        HOUR("HOUR"),
        MINUTE("MINUTE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ScaleType {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * class of this fare part. Could be FARE or ANCILLARY
    * Values: FARE,ANCILLARY
    */
    enum class PropertyClass(@get:JsonValue val value: kotlin.String) {

        FARE("FARE"),
        ANCILLARY("ANCILLARY");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): PropertyClass {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE
    * Values: IN_USE,PAUSED
    */
    enum class AssetState(@get:JsonValue val value: kotlin.String) {

        IN_USE("IN_USE"),
        PAUSED("PAUSED");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): AssetState {
                return values().first{it -> it.value == value}
            }
        }
    }

}

