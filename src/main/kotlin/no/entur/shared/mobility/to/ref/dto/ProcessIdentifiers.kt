package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param operatorInformation
 * @param planning
 * @param booking
 * @param tripExecution
 * @param support
 * @param payment
 * @param general
 */
data class ProcessIdentifiers(
    @Schema(example = "null", required = true)
    @get:JsonProperty("operatorInformation", required = true) val operatorInformation: List<String> = emptyList(),
    @Schema(example = "null", required = true)
    @get:JsonProperty("planning", required = true) val planning: List<String> = emptyList(),
    @Schema(example = "null", required = true)
    @get:JsonProperty("booking", required = true) val booking: List<String> = emptyList(),
    @Schema(example = "null", required = true)
    @get:JsonProperty("tripExecution", required = true) val tripExecution: List<String> = emptyList(),
    @Schema(example = "null", required = true)
    @get:JsonProperty("support", required = true) val support: List<String> = emptyList(),
    @Schema(example = "null", required = true)
    @get:JsonProperty("payment", required = true) val payment: List<String> = emptyList(),
    @Schema(example = "null", required = true)
    @get:JsonProperty("general", required = true) val general: List<String> = emptyList(),
)
