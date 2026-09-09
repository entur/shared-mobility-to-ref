package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetType
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingAllOfExtraData
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingState
import no.entur.shared.mobility.to.ref.tomp150.dto.Customer
import no.entur.shared.mobility.to.ref.tomp150.dto.Fare
import no.entur.shared.mobility.to.ref.tomp150.dto.Information
import no.entur.shared.mobility.to.ref.tomp150.dto.Leg
import no.entur.shared.mobility.to.ref.tomp150.dto.Place
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
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("state")
    @get:JsonProperty("state") val state: BookingState? = null,

    @field:Valid
    @Schema(description = "The legs of this booking, generally just one for simple legs, in order of how they will be travelled. If this part is not present, it means that there is only one leg. This leg can be constructed * leg[0].id = booking.id * leg[0].departureTime = booking.departureTime * leg[0].arrivalTime = booking.arrivalTime * leg[0].assetType = booking.mainAssetType * leg[0].pricing = booking.pricing This approach is not allowed in the trip execution part")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("legs")
    @get:JsonProperty("legs") val legs: kotlin.collections.List<Leg>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("pricing")
    @get:JsonProperty("pricing") val pricing: Fare? = null,

    @Schema(description = "The initial departure time (over all legs)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("departureTime")
    @get:JsonProperty("departureTime") val departureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "The intended arrival time at the destination of the booking (over all legs)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("arrivalTime")
    @get:JsonProperty("arrivalTime") val arrivalTime: java.time.OffsetDateTime? = null,

    @Schema(description = "the 'departureTime' can be used as 'plannedDepartureTime' whenever the trip has started. Use this field to ease searching for discrepances between planned and actual departure times")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("actualDepartureTime")
    @get:JsonProperty("actualDepartureTime") val actualDepartureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the trip has ended. Use this field to ease searching for discrepances between planned and actual arrival times")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("actualArrivalTime")
    @get:JsonProperty("actualArrivalTime") val actualArrivalTime: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("mainAssetType")
    @get:JsonProperty("mainAssetType") val mainAssetType: AssetType? = null,

    @field:Valid
    @Schema(description = "Additional information a TO can send to a customer (instructions, sales info, ...)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("userCommunication")
    @get:JsonProperty("userCommunication") val userCommunication: kotlin.collections.List<Information>? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("memo")
    @get:JsonProperty("memo") val memo: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("extraData")
    @get:JsonProperty("extraData") val extraData: BookingAllOfExtraData? = null
) {

}

