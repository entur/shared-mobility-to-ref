package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.BankAccount
import no.entur.shared.mobility.to.ref.tomp150.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.tomp150.dto.Fare
import no.entur.shared.mobility.to.ref.tomp150.dto.FarePart
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalCategory
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
 * the specification of the amount; how is it composed.
 * @param estimated is this fare an estimation?
 * @param description free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language
 * @param parts 
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
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
    @get:JsonProperty("estimated", required = true) val estimated: kotlin.Boolean,

    @Schema(example = "null", required = true, description = "free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language")
    @get:JsonProperty("description", required = true) val description: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("parts", required = true) val parts: kotlin.collections.List<FarePart>,

    @get:DecimalMin("0")
    @Schema(example = "9.95", required = true, description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("category", required = true) val category: JournalCategory,

    @Schema(example = "null", description = "in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.")
    @get:JsonProperty("class") val propertyClass: kotlin.String? = null,

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

    @get:DecimalMin("0")
    @Schema(example = "null", description = "e.g. number of litres, number of kilowatthour, etc")
    @get:JsonProperty("number") val number: kotlin.Float? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("numberType") val numberType: JournalEntryAllOfDetails.NumberType? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("account") val account: BankAccount? = null,

    @field:Valid
    @Schema(example = "null", description = "Arbitrary metadata that a TO can add, like voucher codes")
    @get:JsonProperty("meta") val meta: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
    ) {

    /**
    * 
    * Values: LITER,KILOWATTHOUR,CO2_COMPENSATION,OTHER
    */
    enum class NumberType(@get:JsonValue val value: kotlin.String) {

        LITER("LITER"),
        KILOWATTHOUR("KILOWATTHOUR"),
        CO2_COMPENSATION("CO2_COMPENSATION"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): NumberType {
                return values().first{it -> it.value == value}
            }
        }
    }

}

