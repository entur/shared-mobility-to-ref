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
 * @param assets 
 * @param customer 
 * @param distribution 
 * @param paymentMethod 
 * @param travellers 
 */
data class UseAssetRequestRequestInputs(

    @get:Size(min=1)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("assets", required = true) val assets: kotlin.collections.List<kotlin.String>,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("customer") val customer: Customer? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("distribution") val distribution: Distribution? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("paymentMethod") val paymentMethod: TypeOfPaymentMethod? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("travellers") val travellers: kotlin.collections.List<Traveller>? = null
) {

}

