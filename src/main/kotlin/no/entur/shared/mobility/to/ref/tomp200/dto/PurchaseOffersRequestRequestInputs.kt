package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Customer
import no.entur.shared.mobility.to.ref.tomp200.dto.Distribution
import no.entur.shared.mobility.to.ref.tomp200.dto.Traveller
import no.entur.shared.mobility.to.ref.tomp200.dto.TypeOfPaymentMethod
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
 * @param offer default string, full names etc (length 0-200)
 * @param customer 
 * @param paymentMethod 
 * @param distribution 
 * @param travellers 
 */
data class PurchaseOffersRequestRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("offer", required = true) val offer: kotlin.String,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("customer") val customer: Customer? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("paymentMethod") val paymentMethod: TypeOfPaymentMethod? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("distribution") val distribution: Distribution? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("travellers") val travellers: kotlin.collections.List<Traveller>? = null
) {

}

