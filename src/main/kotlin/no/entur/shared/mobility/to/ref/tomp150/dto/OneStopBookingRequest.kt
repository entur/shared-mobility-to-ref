package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.ConnectedLegInfo
import no.entur.shared.mobility.to.ref.tomp150.dto.Customer
import no.entur.shared.mobility.to.ref.tomp150.dto.Place
import no.entur.shared.mobility.to.ref.tomp150.dto.Traveler
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
 * @param customer 
 * @param callbackUrl The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.
 */
data class OneStopBookingRequest(

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: Place,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("previousLegInfo")
    @get:JsonProperty("previousLegInfo") val previousLegInfo: ConnectedLegInfo? = null,

    @get:Min(value=0)
    @Schema(description = "Maximum distance in meters a user wants to travel to reach the travel option")
    @param:JsonProperty("radius")
    @get:JsonProperty("radius") val radius: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("to")
    @get:JsonProperty("to") val to: Place? = null,

    @get:Min(value=0)
    @Schema(description = "instead of using the from/to construct, it is also possible to give an indication of the distance to travel. The process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters")
    @param:JsonProperty("estimatedDistance")
    @get:JsonProperty("estimatedDistance") val estimatedDistance: kotlin.Int? = null,

    @Schema(description = "The intended departure time. If left out and no arrivalTime is set, the current time should be assumed. If only the arrival time is specified, this is an implicit request for a guaranteed arrival at that time.")
    @param:JsonProperty("departureTime")
    @get:JsonProperty("departureTime") val departureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "The intended arrival time, at the `to place`. If not set, the time the user intends to stop using the asset (implicit request for arrival guarantee).")
    @param:JsonProperty("arrivalTime")
    @get:JsonProperty("arrivalTime") val arrivalTime: java.time.OffsetDateTime? = null,

    @get:Min(value=1)
    @Schema(description = "The number of people that intend to travel, including the customer.")
    @param:JsonProperty("nrOfTravelers")
    @get:JsonProperty("nrOfTravelers") val nrOfTravelers: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "Extra information about the people that intend to travel if relevant, length must be less than or equal to nrOftravelers.")
    @param:JsonProperty("travelers")
    @get:JsonProperty("travelers") val travelers: kotlin.collections.List<Traveler>? = null,

    @Schema(description = "The specific asset(s) the user wishes to receive leg options for")
    @param:JsonProperty("useAssets")
    @get:JsonProperty("useAssets") val useAssets: kotlin.collections.List<kotlin.String>? = null,

    @Schema(description = "Id(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the public. Id's are agreed upon by TO and MP.")
    @param:JsonProperty("userGroups")
    @get:JsonProperty("userGroups") val userGroups: kotlin.collections.List<kotlin.String>? = null,

    @Schema(description = "The specific asset type(s) the user wishes to receive leg options for")
    @param:JsonProperty("useAssetTypes")
    @get:JsonProperty("useAssetTypes") val useAssetTypes: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(description = "dictionary for extra fields (bilatural agreements)")
    @param:JsonProperty("extraInfo")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("customer")
    @get:JsonProperty("customer") val customer: Customer? = null,

    @Schema(description = "The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.")
    @param:JsonProperty("callbackUrl")
    @get:JsonProperty("callbackUrl") val callbackUrl: kotlin.String? = null
) {

}

