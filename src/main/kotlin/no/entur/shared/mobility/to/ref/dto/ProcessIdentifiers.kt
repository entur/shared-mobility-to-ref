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
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("operatorInformation", required = true) val operatorInformation: kotlin.collections.List<kotlin.String>,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("planning", required = true) val planning: kotlin.collections.List<kotlin.String>,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("booking", required = true) val booking: kotlin.collections.List<kotlin.String>,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tripExecution", required = true) val tripExecution: kotlin.collections.List<kotlin.String>,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("support", required = true) val support: kotlin.collections.List<kotlin.String>,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("payment", required = true) val payment: kotlin.collections.List<kotlin.String>,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("general", required = true) val general: kotlin.collections.List<kotlin.String>,
)
