package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.BookingAllOfExtraData
import no.entur.shared.mobility.to.ref.dto.BookingState
import no.entur.shared.mobility.to.ref.dto.Customer
import no.entur.shared.mobility.to.ref.dto.Fare
import no.entur.shared.mobility.to.ref.dto.Information
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.Place

/**
 * The booking information describing the state and details of an agreed upon trip
 * @param id A unique identifier for the TO to know this booking by
 * @param from
 * @param callbackUrl The callback URL of the Maas Provider, to use as base url for callback, f.x. the POST legs/{id}/events and POST /bookings/{id}/events. Only to be provided when this deviates from standard or agreed URL.
 * @param to
 * @param customer
 * @param extraInfo dictionary for extra fields (bilatural agreements)
 * @param state
 * @param legs The legs of this booking, generally just one for simple legs, in order of how they will be travelled. If this part is not present, it means that there is only one leg. This leg can be constructed * leg[0].id = booking.id * leg[0].departureTime = booking.departureTime * leg[0].arrivalTime = booking.arrivalTime * leg[0].assetType = booking.mainAssetType * leg[0].pricing = booking.pricing This approach is not allowed in the trip execution part
 * @param pricing
 * @param departureTime The initial departure time (over all legs)
 * @param arrivalTime The intended arrival time at the destination of the booking (over all legs)
 * @param actualDepartureTime the 'departureTime' can be used as 'plannedDepartureTime' whenever the trip has started. Use this field to ease searching for discrepances between planned and actual departure times
 * @param actualArrivalTime the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the trip has ended. Use this field to ease searching for discrepances between planned and actual arrival times
 * @param mainAssetType
 * @param userCommunication Additional information a TO can send to a customer (instructions, sales info, ...)
 * @param memo
 * @param extraData
 */
data class Booking(
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
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("state") val state: BookingState? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = "The legs of this booking, generally just one for simple legs, in order of how they will be travelled. If this part is not present, it means that there is only one leg. This leg can be constructed * leg[0].id = booking.id * leg[0].departureTime = booking.departureTime * leg[0].arrivalTime = booking.arrivalTime * leg[0].assetType = booking.mainAssetType * leg[0].pricing = booking.pricing This approach is not allowed in the trip execution part",
    )
    @get:JsonProperty("legs") val legs: kotlin.collections.List<Leg>? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("pricing") val pricing: Fare? = null,
    @Schema(example = "null", description = "The initial departure time (over all legs)")
    @get:JsonProperty("departureTime") val departureTime: java.time.OffsetDateTime? = null,
    @Schema(example = "null", description = "The intended arrival time at the destination of the booking (over all legs)")
    @get:JsonProperty("arrivalTime") val arrivalTime: java.time.OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = "the 'departureTime' can be used as 'plannedDepartureTime' whenever the trip has started. Use this field to ease searching for discrepances between planned and actual departure times",
    )
    @get:JsonProperty("actualDepartureTime") val actualDepartureTime: java.time.OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = "the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the trip has ended. Use this field to ease searching for discrepances between planned and actual arrival times",
    )
    @get:JsonProperty("actualArrivalTime") val actualArrivalTime: java.time.OffsetDateTime? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("mainAssetType") val mainAssetType: AssetType? = null,
    @field:Valid
    @Schema(example = "null", description = "Additional information a TO can send to a customer (instructions, sales info, ...)")
    @get:JsonProperty("userCommunication") val userCommunication: kotlin.collections.List<Information>? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("memo") val memo: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("extraData") val extraData: BookingAllOfExtraData? = null,
)
