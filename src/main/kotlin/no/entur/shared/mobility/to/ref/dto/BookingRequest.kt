package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Customer
import no.entur.shared.mobility.to.ref.dto.Place

/**
 * A booking requested by the MP
 * @param id A unique identifier for the TO to know this booking by
 * @param from
 * @param callbackUrl The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.
 * @param to
 * @param customer
 * @param extraInfo dictionary for extra fields (bilatural agreements)
 */
data class BookingRequest(
    @Schema(example = "null", description = "A unique identifier for the TO to know this booking by")
    @get:JsonProperty("id") val id: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("from") val from: Place? = null,
    @Schema(
        example = "null",
        description = "The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.",
    )
    @get:JsonProperty("callbackUrl") val callbackUrl: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("to") val to: Place? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("customer") val customer: Customer? = null,
    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
)
