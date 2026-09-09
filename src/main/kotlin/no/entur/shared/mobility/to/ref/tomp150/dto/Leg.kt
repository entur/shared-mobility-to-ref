package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp150.dto.Asset
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetType
import no.entur.shared.mobility.to.ref.tomp150.dto.Condition
import no.entur.shared.mobility.to.ref.tomp150.dto.Fare
import no.entur.shared.mobility.to.ref.tomp150.dto.Information
import no.entur.shared.mobility.to.ref.tomp150.dto.LegState
import no.entur.shared.mobility.to.ref.tomp150.dto.Place
import no.entur.shared.mobility.to.ref.tomp150.dto.Suboperator
import no.entur.shared.mobility.to.ref.tomp150.dto.Token
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
 * @param progressGeometry An array  of WGS84 coordinate pairs
 * @param ticket 
 * @param assetAccessData 
 * @param allAssetAccessData 
 * @param userCommunication Additional information a TO can send to a customer (instructions, sales info, ...)
 * @param memo 
 */
data class Leg(

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("from")
    @get:JsonProperty("from", required = true) val from: Place,

    @Schema(description = "The unique identifier (TO) of this leg")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("id")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("to")
    @get:JsonProperty("to") val to: Place? = null,

    @Schema(description = "The departure time of this leg. Or, in case of a parking, the start of the usage.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("departureTime")
    @get:JsonProperty("departureTime") val departureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "The intended arrival time at the to place. Or, in case of a parking, the end of the usage.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("arrivalTime")
    @get:JsonProperty("arrivalTime") val arrivalTime: java.time.OffsetDateTime? = null,

    @Schema(description = "the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the leg has ended. Use this field to ease searching for discrepances between planned and actual arrival times")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("actualArrivalTime")
    @get:JsonProperty("actualArrivalTime") val actualArrivalTime: java.time.OffsetDateTime? = null,

    @Schema(description = "the 'departureTime' can be used as 'plannedDepartureTime' whenever the leg has started. Use this field to ease searching for discrepances between planned and actual departure times")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("actualDepartureTime")
    @get:JsonProperty("actualDepartureTime") val actualDepartureTime: java.time.OffsetDateTime? = null,

    @Schema(description = "reference to the travelers field of the request. If missing, it is refering to the first (if any). it is an array to facilitate multiple users on one leg (e.g. using a car). If multiple access informations are needed, please create a leg per used asset.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("travelerReferenceNumbers")
    @get:JsonProperty("travelerReferenceNumbers") val travelerReferenceNumbers: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("assetType")
    @get:JsonProperty("assetType") val assetType: AssetType? = null,

    @Schema(description = "The order of the leg in the booking. There can be multiple legs with the same sequence (different user or parallel usage (eg. parking lot and a bike)).")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("legSequenceNumber")
    @get:JsonProperty("legSequenceNumber") val legSequenceNumber: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("asset")
    @get:JsonProperty("asset") val asset: Asset? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("pricing")
    @get:JsonProperty("pricing") val pricing: Fare? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("suboperator")
    @get:JsonProperty("suboperator") val suboperator: Suboperator? = null,

    @field:Valid
    @Schema(description = "The conditions that apply to this leg, there may be more conditions in a parent booking and planning object (if this is returned as part of those)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("conditions")
    @get:JsonProperty("conditions") val conditions: kotlin.collections.List<Condition>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("state")
    @get:JsonProperty("state") val state: LegState? = null,

    @get:Min(value=0)
    @get:Max(value=2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("departureDelay")
    @get:JsonProperty("departureDelay") val departureDelay: kotlin.Int? = null,

    @get:Min(value=0)
    @get:Max(value=2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("arrivalDelay")
    @get:JsonProperty("arrivalDelay") val arrivalDelay: kotlin.Int? = null,

    @get:Min(value=0)
    @Schema(example = "7250", description = "The estimated distance travelled in the leg (in meters)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("distance")
    @get:JsonProperty("distance") val distance: kotlin.Int? = null,

    @Schema(example = "[[6.169639,52.253279],[6.05623,52.63473]]", description = "An array  of WGS84 coordinate pairs")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("progressGeometry")
    @get:JsonProperty("progressGeometry") val progressGeometry: kotlin.collections.List<kotlin.collections.List<kotlin.Float>>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("ticket")
    @get:JsonProperty("ticket") val ticket: Token? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("assetAccessData")
    @get:JsonProperty("assetAccessData") val assetAccessData: Token? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("allAssetAccessData")
    @get:JsonProperty("allAssetAccessData") val allAssetAccessData: kotlin.collections.List<Token>? = null,

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
    @get:JsonProperty("memo") val memo: kotlin.String? = null
) {

}

