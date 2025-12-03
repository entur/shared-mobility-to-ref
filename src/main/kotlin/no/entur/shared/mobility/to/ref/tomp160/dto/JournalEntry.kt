package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.BankAccount
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalCategory
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalEntryAllOfDetails
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalState
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

    @get:DecimalMin("0")
    @Schema(example = "9.95", description = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
    @get:JsonProperty("amount") val amount: kotlin.Float? = null,

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

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("category") val category: JournalCategory? = null,

    @Schema(example = "null", description = "id of the entry, leg id can be reused")
    @get:JsonProperty("journalId") val journalId: kotlin.String? = null,

    @Schema(example = "null", description = "sequence id of the entry, in combination with journalId unique from TO perspective.")
    @get:JsonProperty("journalSequenceId") val journalSequenceId: kotlin.String? = null,

    @Schema(example = "null", description = "the number of the invoice. Should be filled in when invoiced.")
    @get:JsonProperty("invoiceId") val invoiceId: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("invoiceDate") val invoiceDate: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("state") val state: JournalState? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("expirationDate") val expirationDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the travelled distance. Only if applicable.")
    @get:JsonProperty("distance") val distance: kotlin.Float? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("distanceType") val distanceType: JournalEntry.DistanceType? = null,

    @get:Min(0)
    @Schema(example = "null", description = "the time in seconds that the assed is used. Only if applicable.")
    @get:JsonProperty("usedTime") val usedTime: kotlin.Int? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the mileage at the start of the rental. 'DistanceType' field is also applicable here")
    @get:JsonProperty("rentalStartMileage") val rentalStartMileage: kotlin.Float? = null,

    @Schema(example = "null", description = "VAT identification number.")
    @get:JsonProperty("vatNumber") val vatNumber: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("bankAccount") val bankAccount: BankAccount? = null,

    @field:Valid
    @Schema(example = "null", description = "")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'JournalEntry'")
            }
        }
    }

}

