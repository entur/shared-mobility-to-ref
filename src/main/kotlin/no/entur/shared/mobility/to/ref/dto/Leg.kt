package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.time.OffsetDateTime

/**
 * A planned (segment of) a booked trip using one asset type
 * @param from
 * @param assetType
 * @param id The unique identifier (TO) of this leg
 * @param to
 * @param departureTime The departure time of this leg. Or, in case of a parking, the start of the usage.
 * @param arrivalTime The intended arrival time at the to place. Or, in case of a parking, the end of the usage.
 * @param actualArrivalTime the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the leg has ended. Use this field to ease
 * searching for discrepancies between planned and actual arrival times
 * @param actualDepartureTime the 'departureTime' can be used as 'plannedDepartureTime' whenever the leg has started. Use this field to
 * ease searching for discrepancies between planned and actual departure times
 * @param travelerReferenceNumbers reference to the travelers field of the request. If missing, it is referring to the first (if any). it is
 * an array to facilitate multiple users on one leg (e.g. using a car). If multiple access information is needed, please create a leg per
 * used asset.
 * @param legSequenceNumber The order of the leg in the booking. There can be multiple legs with the same sequence (different user or
 * parallel usage (e.g. parking lot and a bike)).
 * @param asset
 * @param pricing
 * @param suboperator
 * @param conditions The conditions that apply to this leg, there may be more conditions in a parent booking and planning object (if this
 * is returned as part of those)
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
    @Schema(example = "null", required = true)
    @get:JsonProperty("from", required = true) val from: Place,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("assetType", required = true) val assetType: AssetType,
    @Schema(example = "null", description = "The unique identifier (TO) of this leg")
    val id: String? = null,
    @field:Valid
    @Schema(example = "null")
    val to: Place? = null,
    @Schema(
        example = "null",
        description = "The departure time of this leg. Or, in case of a parking, the start of the usage.",
    )
    val departureTime: OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = "The intended arrival time at the to place. Or, in case of a parking, the end of the usage.",
    )
    val arrivalTime: OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = """the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the leg has ended. Use this field to ease 
            |searching for discrepancies between planned and actual arrival times""",
    )
    val actualArrivalTime: OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = """the 'departureTime' can be used as 'plannedDepartureTime' whenever the leg has started. Use this field to ease 
            |searching for discrepancies between planned and actual departure times""",
    )
    val actualDepartureTime: OffsetDateTime? = null,
    @Schema(
        example = "null",
        description = """reference to the travelers field of the request. If missing, it is referring to the first (if any). it is an 
            |array to facilitate multiple users on one leg (e.g. using a car). If multiple access information is needed, please create 
            |a leg per used asset.""",
    )
    val travelerReferenceNumbers: List<String>? = null,
    @Schema(
        example = "null",
        description = """The order of the leg in the booking. There can be multiple legs with the same sequence (different user or 
            |parallel usage (eg. parking lot and a bike)).""",
    )
    val legSequenceNumber: Int? = null,
    @field:Valid
    @Schema(example = "null")
    val asset: Asset? = null,
    @field:Valid
    @Schema(example = "null")
    val pricing: Fare? = null,
    @field:Valid
    @Schema(example = "null")
    val suboperator: SubOperator? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = """The conditions that apply to this leg, there may be more conditions in a parent booking and planning object 
            |(if this is returned as part of those)""",
    )
    val conditions: List<AssetTypeConditionsInner>? = null,
    @field:Valid
    @Schema(example = "null")
    val state: LegState? = null,
    @get:Min(0)
    @get:Max(2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    val departureDelay: Int? = null,
    @get:Min(0)
    @get:Max(2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    val arrivalDelay: Int? = null,
    @get:Min(0)
    @Schema(example = "7250", description = "The estimated distance travelled in the leg (in meters)")
    val distance: Int? = null,
    @Schema(example = "[[6.169639,52.253279],[6.05623,52.63473]]", description = "An array  of WGS84 coordinate pairs")
    val progressGeometry: GeoJsonLine? = null,
    @field:Valid
    @Schema(example = "null")
    val ticket: Token? = null,
    @field:Valid
    @Schema(example = "null")
    val assetAccessData: Token? = null,
    @field:Valid
    @Schema(example = "null")
    val allAssetAccessData: List<Token>? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = "Additional information a TO can send to a customer (instructions, sales info, ...)",
    )
    val userCommunication: List<Information>? = null,
    @Schema(example = "null")
    val memo: String? = null,
)
