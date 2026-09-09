package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.BankAccount
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalCategory
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
 * Costs that the TO is charging the MP; credits are negative. Other amounts should be positive
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param category 
 * @param description free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language
 * @param amountExVat 
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param number e.g. number of litres, number of kilowatthour, etc
 * @param numberType 
 * @param account 
 * @param meta Arbitrary metadata that a TO can add, like voucher codes
 */
data class ExtraCosts(

    @get:DecimalMin(value="0")
    @Schema(example = "9.95", required = true, description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @param:JsonProperty("amount", required = true)
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("category", required = true)
    @get:JsonProperty("category", required = true) val category: JournalCategory,

    @Schema(required = true, description = "free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language")
    @param:JsonProperty("description", required = true)
    @get:JsonProperty("description", required = true) val description: kotlin.String,

    @get:DecimalMin(value="0")
    @Schema(example = "8.95", description = "")
    @param:JsonProperty("amountExVat")
    @get:JsonProperty("amountExVat") val amountExVat: kotlin.Float? = null,

    @get:Size(min=3,max=3)
    @Schema(description = "ISO 4217 currency code")
    @param:JsonProperty("currencyCode")
    @get:JsonProperty("currencyCode") val currencyCode: kotlin.String? = null,

    @get:DecimalMin(value="0")
    @Schema(example = "21.0", description = "value added tax rate (percentage of amount)")
    @param:JsonProperty("vatRate")
    @get:JsonProperty("vatRate") val vatRate: kotlin.Float? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @param:JsonProperty("vatCountryCode")
    @get:JsonProperty("vatCountryCode") val vatCountryCode: kotlin.String? = null,

    @get:DecimalMin(value="0")
    @Schema(description = "e.g. number of litres, number of kilowatthour, etc")
    @param:JsonProperty("number")
    @get:JsonProperty("number") val number: kotlin.Float? = null,

    @Schema(description = "")
    @param:JsonProperty("numberType")
    @get:JsonProperty("numberType") val numberType: ExtraCosts.NumberType? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("account")
    @get:JsonProperty("account") val account: BankAccount? = null,

    @field:Valid
    @Schema(description = "Arbitrary metadata that a TO can add, like voucher codes")
    @param:JsonProperty("meta")
    @get:JsonProperty("meta") val meta: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) : JournalEntryAllOfDetails {

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
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'NumberType'")
            }
        }
    }

}

