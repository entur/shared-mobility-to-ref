package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.ConnectedLegInfo
import no.entur.shared.mobility.to.ref.tomp160.dto.Place
import no.entur.shared.mobility.to.ref.tomp160.dto.Traveler
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
 * A travel planning for which bookable options are requested
 * @param from 
 * @param previousLegInfo 
 * @param radius Maximum distance in meters a user wants to travel to reach the travel option
 * @param to 
 * @param estimatedDistance instead of using the from/to construct, it is also possible to give an indication of the distance to travel. The process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters
 * @param departureTime The intended departure time. If left out and no arrivalTime is set, the current time should be assumed. If only the arrival time is specified, this is an implicit request for a guaranteed arrival at that time.
 * @param arrivalTime The intended arrival time, at the `to place`. If not set, the time the user intends to stop using the asset (implicit request for arrival guarantee).
 * @param nrOfTravelers The number of people that intend to travel, including the customer.
 * @param travelers Extra information about the people that intend to travel if relevant, length must be less than or equal to nrOftravelers.
 * @param useAssets The specific asset(s) the user wishes to receive leg options for
 * @param userGroups Id(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the public. Id's are agreed upon by TO and MP.
 * @param useAssetTypes The specific asset type(s) the user wishes to receive leg options for
 * @param extraInfo dictionary for extra fields (bilatural agreements)
 */
data class PlanningRequest(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("from", required = true) val from: Place,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("previousLegInfo") val previousLegInfo: ConnectedLegInfo? = null,

    @get:Min(0)
    @Schema(example = "null", description = "Maximum distance in meters a user wants to travel to reach the travel option")
    @get:JsonProperty("radius") val radius: kotlin.Int? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("to") val to: Place? = null,

    @get:Min(0)
    @Schema(example = "null", description = "instead of using the from/to construct, it is also possible to give an indication of the distance to travel. The process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters")
    @get:JsonProperty("estimatedDistance") val estimatedDistance: kotlin.Int? = null,

    @Schema(example = "null", description = "The intended departure time. If left out and no arrivalTime is set, the current time should be assumed. If only the arrival time is specified, this is an implicit request for a guaranteed arrival at that time.")
    @get:JsonProperty("departureTime") val departureTime: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "The intended arrival time, at the `to place`. If not set, the time the user intends to stop using the asset (implicit request for arrival guarantee).")
    @get:JsonProperty("arrivalTime") val arrivalTime: java.time.OffsetDateTime? = null,

    @get:Min(1)
    @Schema(example = "null", description = "The number of people that intend to travel, including the customer.")
    @get:JsonProperty("nrOfTravelers") val nrOfTravelers: kotlin.Int? = null,

    @field:Valid
    @Schema(example = "null", description = "Extra information about the people that intend to travel if relevant, length must be less than or equal to nrOftravelers.")
    @get:JsonProperty("travelers") val travelers: kotlin.collections.List<Traveler>? = null,

    @Schema(example = "null", description = "The specific asset(s) the user wishes to receive leg options for")
    @get:JsonProperty("useAssets") val useAssets: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "Id(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the public. Id's are agreed upon by TO and MP.")
    @get:JsonProperty("userGroups") val userGroups: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "The specific asset type(s) the user wishes to receive leg options for")
    @get:JsonProperty("useAssetTypes") val useAssetTypes: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
    ) {

}

