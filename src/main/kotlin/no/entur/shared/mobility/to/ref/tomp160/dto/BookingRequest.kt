package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.Customer
import no.entur.shared.mobility.to.ref.tomp160.dto.Place
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
 * A booking requested by the MP
 * @param id A unique identifier for the TO to know this booking by
 * @param from 
 * @param callbackUrl The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.
 * @param to 
 * @param customer 
 * @param extraInfo dictionary for extra fields (bilatural agreements)
 */
data class BookingRequest(

    @Schema(description = "A unique identifier for the TO to know this booking by")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("id")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("from")
    @get:JsonProperty("from") val from: Place? = null,

    @Schema(description = "The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("callbackUrl")
    @get:JsonProperty("callbackUrl") val callbackUrl: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("to")
    @get:JsonProperty("to") val to: Place? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("customer")
    @get:JsonProperty("customer") val customer: Customer? = null,

    @field:Valid
    @Schema(description = "dictionary for extra fields (bilatural agreements)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("extraInfo")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

