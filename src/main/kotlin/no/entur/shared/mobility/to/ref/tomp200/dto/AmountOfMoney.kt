package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * an amount of money, usable in fares, fare calculations or in extra costs.
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param taxPercentageUsed the travelled distance. Only if applicable.
 * @param currencyCode ISO 4217 currency code
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 */
data class AmountOfMoney(

    @Schema(example = "null", required = true, description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

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
    @get:JsonProperty("vatCountryCode") val vatCountryCode: kotlin.String? = null
) {

}

