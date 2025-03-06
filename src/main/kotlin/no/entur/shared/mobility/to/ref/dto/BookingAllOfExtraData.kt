package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
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
    @get:JsonProperty("safeWaitTime") val safeWaitTime: kotlin.Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the maximum time before the asset will arrive, in minutes")
    @get:JsonProperty("maxWaitTime") val maxWaitTime: kotlin.Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the predicted time the legs will take, in minutes")
    @get:JsonProperty("safeTravelTime") val safeTravelTime: kotlin.Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the maximum time the legs will take, in minutes")
    @get:JsonProperty("maxTravelTime") val maxTravelTime: kotlin.Int? = null,
)
