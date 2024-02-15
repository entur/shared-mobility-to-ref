package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min

/**
 * Arbitrary information that a TO can add
 * @param safeWaitTime the predicted time before the asset will arrive, in minutes
 * @param maxWaitTime the maximum time before the asset will arrive, in minutes
 * @param safeTravelTime the predicted time the legs will take, in minutes
 * @param maxTravelTime the maximum time the legs will take, in minutes
 */
data class BookingAllOfExtraData(
    @get:Min(0)
    @Schema(example = "null", description = "the predicted time before the asset will arrive, in minutes")
    val safeWaitTime: Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the maximum time before the asset will arrive, in minutes")
    val maxWaitTime: Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the predicted time the legs will take, in minutes")
    val safeTravelTime: Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the maximum time the legs will take, in minutes")
    val maxTravelTime: Int? = null,
) : HashMap<String, Any>()
