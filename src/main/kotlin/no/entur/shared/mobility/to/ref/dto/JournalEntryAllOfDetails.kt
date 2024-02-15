package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Size

/**
 * the specification of the amount; how is it composed.
 * @param estimated is this fare an estimation?
 * @param description free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language
 * @param parts
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and
 * omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param category
 * @param propertyClass in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.
 * @param amountExVat
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param number e.g. number of litres, number of kilowatthour, etc
 * @param numberType
 * @param account
 * @param meta Arbitrary metadata that a TO can add, like voucher codes
 */
data class JournalEntryAllOfDetails(
    @Schema(example = "null", required = true, description = "is this fare an estimation?")
    @get:JsonProperty("estimated", required = true) val estimated: Boolean,
    @Schema(
        example = "null",
        required = true,
        description = "free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language",
    )
    @get:JsonProperty("description", required = true) val description: String,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("parts", required = true) val parts: List<FarePart>,
    @get:DecimalMin("0")
    @Schema(
        example = "9.95",
        required = true,
        description =
            "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal " +
                "places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. " +
                "This is inclusive VAT",
    )
    @get:JsonProperty("amount", required = true) val amount: Float,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("category", required = true) val category: JournalCategory,
    @Schema(
        example = "null",
        description = "in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.",
    )
    @get:JsonProperty("class") val propertyClass: String? = null,
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
    @get:DecimalMin("0")
    @Schema(example = "null", description = "e.g. number of litres, number of kilowatthour, etc")
    val number: Float? = null,
    @Schema(example = "null")
    val numberType: NumberType? = null,
    @field:Valid
    @Schema(example = "null")
    val account: BankAccount? = null,
    @field:Valid
    @Schema(example = "null", description = "Arbitrary metadata that a TO can add, like voucher codes")
    val meta: Map<String, Any>? = null,
) {
    /**
     *
     * Values: lITER,kILOWATTHOUR,cO2COMPENSATION,oTHER
     */
    enum class NumberType {
        LITER,
        KILOWATTHOUR,
        CO2_COMPENSATION,
        OTHER,
    }
}
