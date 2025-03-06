package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Booking

/**
 * A travel planning with bookable options that fulfil the constraints of the planning
 * @param validUntil The time until which the presented options are (likely) available
 * @param options
 */
data class Planning(
    @Schema(example = "null", required = true, description = "The time until which the presented options are (likely) available")
    @get:JsonProperty("validUntil", required = true) val validUntil: java.time.OffsetDateTime,
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("options", required = true) val options: kotlin.collections.List<Booking>,
)
