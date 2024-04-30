package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Size

/**
 * this describes a part of the fare (or discount). It contains a for instance the startup costs (fixed) or the flex part (e.g. 1.25 EUR
 * per 2.0 MILES). The amount is tax included. In case of discounts, the values are negative. With 'MAX' you can specify e.g. a maximum of
 * 15 euro per day. Percentage is mainly added for discounts. The `scale` properties create the ability to communicate scales (e.g. the
 * first 4 kilometers you've to pay EUR 0.35 per kilometer, the kilometers 4 until 8 EUR 0.50 and above it EUR 0.80 per kilometer).
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and
 * omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param amountExVat
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param type type of fare part. If there is only one fare part and this field is missing, it should be assumed it is 'FIXED'. In all other
 * situations this field is mandatory.
 * @param kind is this the default price or is this an additional part (discount, price surge). In case of a DISCOUNT, the amount must
 * always be negative and in case of SURGE it must be positive. This also means, that when you're working with discounts or surges, you
 * have to deliver 2 fare parts, one for the default price and one for the discount/surge. This can be used in combination with as well the
 * fixed
 * price parts as with the flex price parts.
 * @param unitType in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR
 * @param units the number of km, seconds etc. Mandatory when the type is 'FLEX', otherwise not allowed. In case of 0.5 EUR per 15 MINUTES,
 * `units` should contain 15 and `unitType` MINUTES.
 * @param scaleFrom in case of scaling, this is the bottom value (f.x. in the first hour 3 CAD, the `scaleFrom` should contain 0 and the
 * `scaleType` HOUR). When `scaleTo` is used, but this field is missing, it should be assumed it is a 0.
 * @param scaleTo the upper value of the scale
 * (f.x. 3 CAD in the first hour, this field should contain 1, `scaleFrom` 0 and `scaleType` HOUR)
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
    @Schema(
        example = "9.95",
        required = true,
        description = """This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal 
            |places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT""",
    )
    @get:JsonProperty("amount", required = true) val amount: Float,
    @get:DecimalMin("0")
    @Schema(example = "8.95")
    val amountExVat: Float? = null,
    @get:Size(min = 3, max = 3)
    @Schema(example = "null", description = "ISO 4217 currency code")
    val currencyCode: String? = null,
    @get:DecimalMin("0")
    @Schema(example = "21.0", description = "value added tax rate (percentage of amount)")
    val vatRate: Float? = null,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    val vatCountryCode: String? = null,
    @Schema(
        example = "null",
        description = """type of fare part. If there is only one fare part and this field is missing, it should be assumed it is 'FIXED'. 
            |In all other situations this field is mandatory.""",
    )
    val type: Type? = null,
    @Schema(
        example = "null",
        description = """is this the default price or is this an additional part (discount, price surge). In case of a DISCOUNT, the 
            |amount must always be negative and in case of SURGE it must be positive. This also means, that when you're working with 
            |discounts or surges, you have to deliver 2 fare parts, one for the default price and one for the discount/surge. This can be 
            |used in combination with as well the fixed price parts as with the flex price parts.""",
    )
    val kind: Kind? = null,
    @Schema(example = "null", description = "in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR")
    val unitType: UnitType? = null,
    @get:DecimalMin("0")
    @Schema(
        example = "null",
        description = """the number of km, seconds etc. Mandatory when the type is 'FLEX', otherwise not allowed. In case of 0.5 EUR per 
            |15 MINUTES, `units` should contain 15 and `unitType` MINUTES.""",
    )
    val units: Float? = null,
    @get:DecimalMin("0")
    @Schema(
        example = "null",
        description = """in case of scaling, this is the bottom value (f.x. in the first hour 3 CAD, the `scaleFrom` should contain 0 and 
            |the `scaleType` HOUR). When `scaleTo` is used, but this field is missing, it should be assumed it is a 0.""",
    )
    val scaleFrom: Float? = null,
    @get:DecimalMin("0")
    @Schema(
        example = "null",
        description = """the upper value of the scale (f.x. 3 CAD in the first hour, this field should contain 1, `scaleFrom` 0 and 
            |`scaleType` HOUR)""",
    )
    val scaleTo: Float? = null,
    @Schema(example = "null")
    val scaleType: ScaleType? = null,
    @Schema(example = "null", description = "an optional description of this fare part.")
    val name: String? = null,
    @Schema(example = "null", description = "class of this fare part. Could be FARE or ANCILLARY")
    @get:JsonProperty("class") val propertyClass: PropertyClass? = PropertyClass.FARE,
    @get:DecimalMin("0")
    @Schema(
        example = "9.0",
        description = "The minimum price, in the same currency as amount. Place in `amount` the most likely value.",
    )
    val minimumAmount: Float? = null,
    @get:DecimalMin("0")
    @Schema(
        example = "11.0",
        description = "The minimum price, in the same currency as amount. Place in `amount` the most likely value.",
    )
    val maximumAmount: Float? = null,
    @Schema(
        example = "null",
        description = "in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE",
    )
    val assetState: AssetState? = AssetState.IN_USE,
    @field:Valid
    @Schema(example = "null")
    val meta: Map<String, Any>? = null,
) {
    /**
     * type of fare part. If there is only one fare part and this field is missing, it should be assumed it is 'FIXED'. In all other
     * situations this field is mandatory.
     */
    enum class Type {
        FIXED,
        FLEX,
        MAX,
    }

    /**
     * is this the default price or is this an additional part (discount, price surge). In case of a DISCOUNT, the amount must always be
     * negative and in case of SURGE it must be positive. This also means, that when you're working with discounts or surges, you have to
     * deliver 2 fare parts, one for the default price and one for the discount/surge. This can be used in combination with as well the
     * fixed
     * price parts as with the flex price parts.
     */
    enum class Kind {
        DEFAULT,
        DISCOUNT,
        SURGE,
    }

    /**
     * in case of 'FLEX' mandatory, otherwise not allowed. E.g. 0.5 EUR per HOUR
     */
    enum class UnitType {
        KM,
        SECOND,
        MINUTE,
        HOUR,
        MILE,
        PERCENTAGE,
    }

    enum class ScaleType {
        KM,
        MILE,
        HOUR,
        MINUTE,
    }

    /**
     * class of this fare part. Could be FARE or ANCILLARY
     */
    enum class PropertyClass {
        FARE,
        ANCILLARY,
    }

    /**
     * in case the fare is dependent on being in use or being paused, this field must be used. Default IN_USE
     */
    enum class AssetState {
        IN_USE,
        PAUSED,
    }
}
