package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.Fare
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
 * @param planId a unique identifier for this plan in the system
 * @param name name of this pricing scheme, could match Content-Language
 * @param fare 
 * @param isTaxable false indicates that no additional tax will be added (either because tax is not charged, or because it is included) true indicates that tax will be added to the base price
 * @param description Text field describing the particular pricing plan in human readable terms. This should include the duration, price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used for automatic calculations, should match Content-Language
 * @param url a fully qualified URL where the customer can learn more about this particular scheme
 * @param stationId pricing plan for a specific station
 * @param regionId pricing plan for a specific region
 * @param surgePricing Is there currently an increase in price in response to increased demand in this pricing plan? If this field is empty, it means there is no surge pricing in effect.
 */
data class SystemPricingPlan(

    @Schema(example = "freeplan1", required = true, description = "a unique identifier for this plan in the system")
    @get:JsonProperty("planId", required = true) val planId: kotlin.String,

    @Schema(example = "Free Plan", required = true, description = "name of this pricing scheme, could match Content-Language")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("fare", required = true) val fare: Fare,

    @Schema(example = "null", required = true, description = "false indicates that no additional tax will be added (either because tax is not charged, or because it is included) true indicates that tax will be added to the base price")
    @get:JsonProperty("isTaxable", required = true) val isTaxable: kotlin.Boolean,

    @Schema(example = "Unlimited plan for free bikes, as long as you don't break them!", required = true, description = "Text field describing the particular pricing plan in human readable terms. This should include the duration, price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used for automatic calculations, should match Content-Language")
    @get:JsonProperty("description", required = true) val description: kotlin.String,

    @Schema(example = "https://www.rentmyfreebike.com/freeplan", description = "a fully qualified URL where the customer can learn more about this particular scheme")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "null", description = "pricing plan for a specific station")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(example = "null", description = "pricing plan for a specific region")
    @get:JsonProperty("regionId") val regionId: kotlin.String? = null,

    @Schema(example = "null", description = "Is there currently an increase in price in response to increased demand in this pricing plan? If this field is empty, it means there is no surge pricing in effect.")
    @get:JsonProperty("surgePricing") val surgePricing: kotlin.Boolean? = null
    ) {

}

