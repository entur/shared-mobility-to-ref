package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import java.time.OffsetDateTime

/**
 * A travel planning with bookable options that fulfil the constraints of the planning
 * @param validUntil The time until which the presented options are (likely) available
 * @param options
 */
data class Planning(
    @Schema(
        example = "null",
        required = true,
        description = "The time until which the presented options are (likely) available",
    )
    @get:JsonProperty("validUntil", required = true) val validUntil: OffsetDateTime,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("options", required = true) val options: List<Booking>,
)
