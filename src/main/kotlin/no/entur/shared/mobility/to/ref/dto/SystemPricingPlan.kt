package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 *
 * @param planId a unique identifier for this plan in the system
 * @param name name of this pricing scheme, could match Content-Language
 * @param fare
 * @param isTaxable false indicates that no additional tax will be added (either because tax is not charged, or because it is included)
 * true indicates that tax will be added to the base price
 * @param description Text field describing the particular pricing plan in human-readable terms. This should include the duration, price,
 * conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used
 * for automatic calculations, should match Content-Language
 * @param url a fully qualified URL where the customer can learn more about this particular scheme
 * @param stationId pricing plan for a specific station
 * @param regionId pricing plan for a specific region
 * @param surgePricing Is there currently an increase in price in response to increased demand in this pricing plan? If this field is
 * empty, it means there is no surge pricing in effect.
 */
data class SystemPricingPlan(
    @Schema(example = "freePlan1", required = true, description = "a unique identifier for this plan in the system")
    @get:JsonProperty("planId", required = true) val planId: String,
    @Schema(
        example = "Free Plan",
        required = true,
        description = "name of this pricing scheme, could match Content-Language",
    )
    @get:JsonProperty("name", required = true) val name: String,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("fare", required = true) val fare: Fare,
    @Schema(
        example = "null",
        required = true,
        description = """false indicates that no additional tax will be added (either because tax is not charged, or because it is 
            |included) true indicates that tax will be added to the base price""",
    )
    @get:JsonProperty("isTaxable", required = true) val isTaxable: Boolean,
    @Schema(
        example = "Unlimited plan for free bikes, as long as you don't break them!",
        required = true,
        description = """Text field describing the particular pricing plan in human readable terms. This should include the duration, 
            |price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and 
            |should not be used for automatic calculations, should match Content-Language""",
    )
    @get:JsonProperty("description", required = true) val description: String,
    @Schema(
        example = "https://www.rentmyfreebike.com/freeplan",
        description = "a fully qualified URL where the customer can learn more about this particular scheme",
    )
    val url: String? = null,
    @Schema(example = "null", description = "pricing plan for a specific station")
    val stationId: String? = null,
    @Schema(example = "null", description = "pricing plan for a specific region")
    val regionId: String? = null,
    @Schema(
        example = "null",
        description = """Is there currently an increase in price in response to increased demand in this pricing plan? If this field is 
            |empty, it means there is no surge pricing in effect.""",
    )
    val surgePricing: Boolean? = null,
)
