package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import java.time.OffsetDateTime

/**
 * A travel planning for which bookable options are requested
 * @param from
 * @param previousLegInfo
 * @param radius Maximum distance in meters a user wants to travel to reach the travel option
 * @param to
 * @param estimatedDistance instead of using the from/to construct, it is also possible to give an indication of the distance to travel.
 * The process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters
 * @param departureTime The intended departure time. If left out and no arrivalTime is set, the current time should be assumed. If only the
 * arrival time is specified, this is an implicit request for a guaranteed arrival at that time.
 * @param arrivalTime The intended arrival time, at the `to place`. If not set, the time the user intends to stop using the asset (implicit
 * request for arrival guarantee).
 * @param nrOfTravelers The number of people that intend to travel, including the customer.
 * @param travelers Extra information about the people that intend to travel if relevant, length must be less than or equal to
 * nrOfTravelers.
 * @param useAssets The specific asset(s) the user wishes to receive leg options for
 * @param userGroups ID(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the public.
 * Ids are agreed upon by TO and MP.
 * @param useAssetTypes The specific asset type(s) the user wishes to receive leg options for
 * @param extraInfo dictionary for extra fields (bilateral agreements)
 */
data class PlanningRequest(
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("from", required = true) val from: Place,
    @field:Valid
    @Schema(example = "null")
    val previousLegInfo: ConnectedLegInfo? = null,
    @get:Min(0)
    @Schema(
        example = "null",
        description = "Maximum distance in meters a user wants to travel to reach the travel option",
    )
    val radius: Int? = null,
    @field:Valid
    @Schema(example = "null")
    val to: Place? = null,
    @get:Min(0)
    @Schema(
        example = "null",
        description = """instead of using the from/to construct, it is also possible to give an indication of the distance to travel. The 
            |process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters""",
    )
    val estimatedDistance: Int? = null,
    @Schema(
        example = "null",
        description = """The intended departure time. If left out and no arrivalTime is set, the current time should be assumed. If only 
            |the arrival time is specified, this is an implicit request for a guaranteed arrival at that time.""",
    )
    val departureTime: OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = """The intended arrival time, at the `to place`. If not set, the time the user intends to stop using the asset 
            |(implicit request for arrival guarantee).""",
    )
    val arrivalTime: OffsetDateTime? = null,
    @get:Min(1)
    @Schema(example = "null", description = "The number of people that intend to travel, including the customer.")
    val nrOfTravelers: Int? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = """Extra information about the people that intend to travel if relevant, length must be less than or equal to 
            |nrOfTravelers.""",
    )
    val travelers: List<Traveler>? = null,
    @Schema(example = "null", description = "The specific asset(s) the user wishes to receive leg options for")
    val useAssets: List<String>? = null,
    @Schema(
        example = "null",
        description = """Id(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the 
            |public. Id's are agreed upon by TO and MP.""",
    )
    val userGroups: List<String>? = null,
    @Schema(example = "null", description = "The specific asset type(s) the user wishes to receive leg options for")
    val useAssetTypes: List<String>? = null,
    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilateral agreements)")
    val extraInfo: Map<String, Any>? = null,
)
