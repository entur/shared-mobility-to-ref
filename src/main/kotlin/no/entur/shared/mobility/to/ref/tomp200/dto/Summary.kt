package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.AmountOfMoney
import no.entur.shared.mobility.to.ref.tomp200.dto.Distribution
import no.entur.shared.mobility.to.ref.tomp200.dto.LegSummary
import no.entur.shared.mobility.to.ref.tomp200.dto.SummaryCancellation
import no.entur.shared.mobility.to.ref.tomp200.dto.SummaryExchanging
import no.entur.shared.mobility.to.ref.tomp200.dto.SummaryPaymentMethod
import no.entur.shared.mobility.to.ref.tomp200.dto.SummaryTransfer
import no.entur.shared.mobility.to.ref.tomp200.dto.TravelSpecification
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
 * @param id default string, full names etc (length 0-200)
 * @param specification 
 * @param price 
 * @param estimatedPrice is this an estimated price; the final price is not known yet. Use the 'fare' link (ref /collections/fares/) in the links section get calculation details.
 * @param products product names
 * @param legs 
 * @param labels 
 * @param distribution 
 * @param cancellation 
 * @param exchangeable 
 * @param exchanging 
 * @param refundable 
 * @param transferrable 
 * @param transfer 
 * @param paymentMethod 
 */
data class Summary(

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("specification") val specification: TravelSpecification? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("price") val price: AmountOfMoney? = null,

    @Schema(example = "null", description = "is this an estimated price; the final price is not known yet. Use the 'fare' link (ref /collections/fares/) in the links section get calculation details.")
    @get:JsonProperty("estimatedPrice") val estimatedPrice: kotlin.Boolean? = null,

    @Schema(example = "null", description = "product names")
    @get:JsonProperty("products") val products: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("legs") val legs: kotlin.collections.List<LegSummary>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("labels") val labels: kotlin.collections.List<Summary.Labels>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("distribution") val distribution: Distribution? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("cancellation") val cancellation: SummaryCancellation? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("exchangeable") val exchangeable: kotlin.Boolean? = true,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("exchanging") val exchanging: SummaryExchanging? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("refundable") val refundable: kotlin.Boolean? = true,

    @Schema(example = "null", description = "")
    @get:JsonProperty("transferrable") val transferrable: kotlin.Boolean? = true,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("transfer") val transfer: SummaryTransfer? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("paymentMethod") val paymentMethod: SummaryPaymentMethod? = null
) {

    /**
    * 
    * Values: MOST_FLEXIBLE,NON_FLEXIBLE,MOST_ECO_FRIENDLY
    */
    enum class Labels(@get:JsonValue val value: kotlin.String) {

        MOST_FLEXIBLE("MOST_FLEXIBLE"),
        NON_FLEXIBLE("NON_FLEXIBLE"),
        MOST_ECO_FRIENDLY("MOST_ECO_FRIENDLY");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Labels {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Summary'")
            }
        }
    }

}

