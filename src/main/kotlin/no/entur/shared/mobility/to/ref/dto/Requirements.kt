package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Requirement

/**
 * Requirements from the end user side.
 * @param abilities
 * @param bringAlong
 */
data class Requirements(
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("abilities") val abilities: kotlin.collections.List<Requirement>? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("bringAlong") val bringAlong: kotlin.collections.List<Requirement>? = null,
)
