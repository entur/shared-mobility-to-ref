package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Min

/**
 * provides current asset location & duration and distance of the current leg
 * @param coordinates
 * @param duration A duration of some time (relative to a time) in milliseconds
 * @param distance The estimated distance travelled in the leg (in meters)
 * @param asset
 */
data class LegProgress(
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("coordinates", required = true) val coordinates: Coordinates,
    @get:Min(0)
    @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
    val duration: Int? = null,
    @get:Min(0)
    @Schema(example = "7250", description = "The estimated distance travelled in the leg (in meters)")
    val distance: Int? = null,
    @field:Valid
    @Schema(example = "null")
    val asset: Asset? = null,
)
