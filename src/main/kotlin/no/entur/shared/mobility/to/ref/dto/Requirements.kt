package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * Requirements from the end user side.
 * @param abilities
 * @param bringAlong
 */
data class Requirements(
    @field:Valid
    @Schema(example = "null")
    val abilities: List<Requirement>? = null,
    @field:Valid
    @Schema(example = "null")
    val bringAlong: List<Requirement>? = null,
) : HashMap<String, Any>()
