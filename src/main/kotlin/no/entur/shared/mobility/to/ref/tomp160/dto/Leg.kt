package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.Asset
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetType
import no.entur.shared.mobility.to.ref.tomp160.dto.Condition
import no.entur.shared.mobility.to.ref.tomp160.dto.Fare
import no.entur.shared.mobility.to.ref.tomp160.dto.GeojsonLine
import no.entur.shared.mobility.to.ref.tomp160.dto.Information
import no.entur.shared.mobility.to.ref.tomp160.dto.LegState
import no.entur.shared.mobility.to.ref.tomp160.dto.Place
import no.entur.shared.mobility.to.ref.tomp160.dto.Suboperator
import no.entur.shared.mobility.to.ref.tomp160.dto.Token
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
 * A planned (segment of) a booked trip using one asset type
 * @param from 
 * @param id The unique identifier (TO) of this leg
 * @param to 
 * @param departureTime The departure time of this leg. Or, in case of a parking, the start of the usage.
 * @param arrivalTime The intended arrival time at the to place. Or, in case of a parking, the end of the usage.
 * @param actualArrivalTime the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the leg has ended. Use this field to ease searching for discrepances between planned and actual arrival times
 * @param actualDepartureTime the 'departureTime' can be used as 'plannedDepartureTime' whenever the leg has started. Use this field to ease searching for discrepances between planned and actual departure times
 * @param travelerReferenceNumbers reference to the travelers field of the request. If missing, it is refering to the first (if any). it is an array to facilitate multiple users on one leg (e.g. using a car). If multiple access informations are needed, please create a leg per used asset.
 * @param assetType 
 * @param legSequenceNumber The order of the leg in the booking. There can be multiple legs with the same sequence (different user or parallel usage (eg. parking lot and a bike)).
 * @param asset 
 * @param pricing 
 * @param suboperator 
 * @param conditions The conditions that apply to this leg, there may be more conditions in a parent booking and planning object (if this is returned as part of those)
 * @param state 
 * @param departureDelay A duration of some time (relative to a time) in milliseconds
 * @param arrivalDelay A duration of some time (relative to a time) in milliseconds
 * @param distance The estimated distance travelled in the leg (in meters)
 * @param progressGeometry 
 * @param ticket 
 * @param assetAccessData 
 * @param allAssetAccessData 
 * @param userCommunication Additional information a TO can send to a customer (instructions, sales info, ...)
 * @param memo 
 */
data class Leg(

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: Place,

    @Schema(description = "The unique identifier (TO) of this leg")
    @param:JsonProperty("id")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("to")
    @get:JsonProperty("to") val to: Place? = null,

    @Schema(description = "The departure time of this leg. Or, in case of a parking, the start of the usage.")
    @param:JsonProperty("departureTime")
    @get:JsonProperty("departureTime") val departureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "The intended arrival time at the to place. Or, in case of a parking, the end of the usage.")
    @param:JsonProperty("arrivalTime")
    @get:JsonProperty("arrivalTime") val arrivalTime: java.time.OffsetDateTime? = null,

    @Schema(description = "the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the leg has ended. Use this field to ease searching for discrepances between planned and actual arrival times")
    @param:JsonProperty("actualArrivalTime")
    @get:JsonProperty("actualArrivalTime") val actualArrivalTime: java.time.OffsetDateTime? = null,

    @Schema(description = "the 'departureTime' can be used as 'plannedDepartureTime' whenever the leg has started. Use this field to ease searching for discrepances between planned and actual departure times")
    @param:JsonProperty("actualDepartureTime")
    @get:JsonProperty("actualDepartureTime") val actualDepartureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "reference to the travelers field of the request. If missing, it is refering to the first (if any). it is an array to facilitate multiple users on one leg (e.g. using a car). If multiple access informations are needed, please create a leg per used asset.")
    @param:JsonProperty("travelerReferenceNumbers")
    @get:JsonProperty("travelerReferenceNumbers") val travelerReferenceNumbers: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("assetType")
    @get:JsonProperty("assetType") val assetType: AssetType? = null,

    @Schema(description = "The order of the leg in the booking. There can be multiple legs with the same sequence (different user or parallel usage (eg. parking lot and a bike)).")
    @param:JsonProperty("legSequenceNumber")
    @get:JsonProperty("legSequenceNumber") val legSequenceNumber: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("asset")
    @get:JsonProperty("asset") val asset: Asset? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("pricing")
    @get:JsonProperty("pricing") val pricing: Fare? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("suboperator")
    @get:JsonProperty("suboperator") val suboperator: Suboperator? = null,

    @field:Valid
    @Schema(description = "The conditions that apply to this leg, there may be more conditions in a parent booking and planning object (if this is returned as part of those)")
    @param:JsonProperty("conditions")
    @get:JsonProperty("conditions") val conditions: kotlin.collections.List<Condition>? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("state")
    @get:JsonProperty("state") val state: LegState? = null,

    @get:Min(value=0)
    @get:Max(value=2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    @param:JsonProperty("departureDelay")
    @get:JsonProperty("departureDelay") val departureDelay: kotlin.Int? = null,

    @get:Min(value=0)
    @get:Max(value=2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    @param:JsonProperty("arrivalDelay")
    @get:JsonProperty("arrivalDelay") val arrivalDelay: kotlin.Int? = null,

    @get:Min(value=0)
    @Schema(example = "7250", description = "The estimated distance travelled in the leg (in meters)")
    @param:JsonProperty("distance")
    @get:JsonProperty("distance") val distance: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("progressGeometry")
    @get:JsonProperty("progressGeometry") val progressGeometry: GeojsonLine? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("ticket")
    @get:JsonProperty("ticket") val ticket: Token? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("assetAccessData")
    @get:JsonProperty("assetAccessData") val assetAccessData: Token? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("allAssetAccessData")
    @get:JsonProperty("allAssetAccessData") val allAssetAccessData: kotlin.collections.List<Token>? = null,

    @field:Valid
    @Schema(description = "Additional information a TO can send to a customer (instructions, sales info, ...)")
    @param:JsonProperty("userCommunication")
    @get:JsonProperty("userCommunication") val userCommunication: kotlin.collections.List<Information>? = null,

    @Schema(description = "")
    @param:JsonProperty("memo")
    @get:JsonProperty("memo") val memo: kotlin.String? = null
) {

}

