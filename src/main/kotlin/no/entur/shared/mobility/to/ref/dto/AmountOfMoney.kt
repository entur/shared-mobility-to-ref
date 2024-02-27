package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Size

/**
 *
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places
 * and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param amountExVat
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 */
data class AmountOfMoney(
    @get:DecimalMin("0")
    @Schema(
        example = "9.95",
        description = """This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal 
            |places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT""",
    )
    val amount: Float? = null,
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
)
