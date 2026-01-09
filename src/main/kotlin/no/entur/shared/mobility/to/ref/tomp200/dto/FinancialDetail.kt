package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.BankAccount
import no.entur.shared.mobility.to.ref.tomp200.dto.FinancialDetailAllOfUnits
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentCategory
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentState
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
 * @param taxPercentageUsed the travelled distance. Only if applicable.
 * @param currencyCode ISO 4217 currency code
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param id https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param category 
 * @param state 
 * @param expirationDate https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param sequenceId for really small numbers (0-10)
 * @param invoiceId short string, display names (length 0-75)
 * @param invoiceDate https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param comment long string, memos etc (length 0-10.000)
 * @param units 
 * @param vatNumber short string, display names (length 0-75)
 * @param bankAccount 
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class FinancialDetail(

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
    @get:JsonProperty("vatCountryCode") val vatCountryCode: kotlin.String? = null,

    @Schema(example = "null", description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("category") val category: PaymentCategory? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("state") val state: PaymentState? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("expirationDate") val expirationDate: java.time.OffsetDateTime? = null,

    @get:Min(0)
    @get:Max(10)
    @Schema(example = "null", description = "for really small numbers (0-10)")
    @get:JsonProperty("sequenceId") val sequenceId: kotlin.Int? = 0,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("invoiceId") val invoiceId: kotlin.String? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("invoiceDate") val invoiceDate: java.time.OffsetDateTime? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("units") val units: kotlin.collections.List<FinancialDetailAllOfUnits>? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("vatNumber") val vatNumber: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("bankAccount") val bankAccount: BankAccount? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

