package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.Coordinates

/**
 * provides current asset location & duration and distance of the current leg
 * @param coordinates
 * @param duration A duration of some time (relative to a time) in milliseconds
 * @param distance The estimated distance travelled in the leg (in meters)
 * @param asset
 */
data class LegProgress(
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("coordinates", required = true) val coordinates: Coordinates,
    @get:Min(0)
    @get:Max(2147483647)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    @get:JsonProperty("duration") val duration: kotlin.Int? = null,
    @get:Min(0)
    @Schema(example = "7250", description = "The estimated distance travelled in the leg (in meters)")
    @get:JsonProperty("distance") val distance: kotlin.Int? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("asset") val asset: Asset? = null,
)
