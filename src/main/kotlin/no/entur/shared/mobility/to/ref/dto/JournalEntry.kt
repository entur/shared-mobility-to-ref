package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size
import java.time.OffsetDateTime

/**
 *
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and
 * omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
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
    @Schema(
        example = "9.95",
        description =
            "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal " +
                "places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. " +
                "This is inclusive VAT",
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
    @field:Valid
    @Schema(example = "null")
    val category: JournalCategory? = null,
    @Schema(example = "null", description = "id of the entry, leg id can be reused")
    val journalId: String? = null,
    @Schema(
        example = "null",
        description = "sequence id of the entry, in combination with journalId unique from TO perspective.",
    )
    val journalSequenceId: String? = null,
    @Schema(example = "null", description = "the number of the invoice. Should be filled in when invoiced.")
    val invoiceId: String? = null,
    @Schema(example = "null")
    val invoiceDate: OffsetDateTime? = null,
    @field:Valid
    @Schema(example = "null")
    val state: JournalState? = null,
    @Schema(example = "null")
    val expirationDate: OffsetDateTime? = null,
    @Schema(example = "null")
    val comment: String? = null,
    @get:DecimalMin("0")
    @Schema(example = "null", description = "the travelled distance. Only if applicable.")
    val distance: Float? = null,
    @Schema(example = "null")
    val distanceType: DistanceType? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the time in seconds that the assed is used. Only if applicable.")
    val usedTime: Int? = null,
    @get:DecimalMin("0")
    @Schema(
        example = "null",
        description = "the mileage at the start of the rental. 'DistanceType' field is also applicable here",
    )
    val rentalStartMileage: Float? = null,
    @Schema(example = "null", description = "VAT identification number.")
    val vatNumber: String? = null,
    @field:Valid
    @Schema(example = "null")
    val bankAccount: BankAccount? = null,
    @field:Valid
    @Schema(example = "null")
    val details: JournalEntryAllOfDetails? = null,
) {
    /**
     *
     * Values: kM,mILE
     */
    enum class DistanceType {
        KM,
        MILE,
    }
}
