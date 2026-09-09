package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp150.dto.BankAccount
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalCategory
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalEntryAllOfDetails
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalState
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
 * 
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param amountExVat 
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param category 
 * @param journalId id of the entry, leg id can be reused
 * @param journalSequenceId sequence id of the entry, in combination with journalId unique from TO perspective.
 * @param invoiceId the number of the invoice. Should be filled in when invoiced.
 * @param invoiceDate 
 * @param state 
 * @param expirationDate 
 * @param comment 
 * @param distance the travelled distance. Only if applicable.
 * @param distanceType 
 * @param usedTime the time in seconds that the assed is used. Only if applicable.
 * @param rentalStartMileage the mileage at the start of the rental. 'DistanceType' field is also applicable here
 * @param vatNumber VAT identification number.
 * @param bankAccount 
 * @param details 
 */
data class JournalEntry(

    @get:DecimalMin(value="0")
    @Schema(example = "9.95", description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("amount")
    @get:JsonProperty("amount") val amount: kotlin.Float? = null,

    @get:DecimalMin(value="0")
    @Schema(example = "8.95", description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("amountExVat")
    @get:JsonProperty("amountExVat") val amountExVat: kotlin.Float? = null,

    @get:Size(min=3,max=3)
    @Schema(description = "ISO 4217 currency code")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("currencyCode")
    @get:JsonProperty("currencyCode") val currencyCode: kotlin.String? = null,

    @get:DecimalMin(value="0")
    @Schema(example = "21.0", description = "value added tax rate (percentage of amount)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("vatRate")
    @get:JsonProperty("vatRate") val vatRate: kotlin.Float? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("vatCountryCode")
    @get:JsonProperty("vatCountryCode") val vatCountryCode: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("category")
    @get:JsonProperty("category") val category: JournalCategory? = null,

    @Schema(description = "id of the entry, leg id can be reused")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("journalId")
    @get:JsonProperty("journalId") val journalId: kotlin.String? = null,

    @Schema(description = "sequence id of the entry, in combination with journalId unique from TO perspective.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("journalSequenceId")
    @get:JsonProperty("journalSequenceId") val journalSequenceId: kotlin.String? = null,

    @Schema(description = "the number of the invoice. Should be filled in when invoiced.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("invoiceId")
    @get:JsonProperty("invoiceId") val invoiceId: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("invoiceDate")
    @get:JsonProperty("invoiceDate") val invoiceDate: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("state")
    @get:JsonProperty("state") val state: JournalState? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("expirationDate")
    @get:JsonProperty("expirationDate") val expirationDate: java.time.OffsetDateTime? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("comment")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @get:DecimalMin(value="0")
    @Schema(description = "the travelled distance. Only if applicable.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("distance")
    @get:JsonProperty("distance") val distance: kotlin.Float? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("distanceType")
    @get:JsonProperty("distanceType") val distanceType: JournalEntry.DistanceType? = null,

    @get:Min(value=0)
    @Schema(description = "the time in seconds that the assed is used. Only if applicable.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("usedTime")
    @get:JsonProperty("usedTime") val usedTime: kotlin.Int? = null,

    @get:DecimalMin(value="0")
    @Schema(description = "the mileage at the start of the rental. 'DistanceType' field is also applicable here")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("rentalStartMileage")
    @get:JsonProperty("rentalStartMileage") val rentalStartMileage: kotlin.Float? = null,

    @Schema(description = "VAT identification number.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("vatNumber")
    @get:JsonProperty("vatNumber") val vatNumber: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("bankAccount")
    @get:JsonProperty("bankAccount") val bankAccount: BankAccount? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("details")
    @get:JsonProperty("details") val details: JournalEntryAllOfDetails? = null
) {

    /**
    * 
    * Values: KM,MILE
    */
    enum class DistanceType(@get:JsonValue val value: kotlin.String) {

        KM("KM"),
        MILE("MILE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): DistanceType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'DistanceType'")
            }
        }
    }

}

