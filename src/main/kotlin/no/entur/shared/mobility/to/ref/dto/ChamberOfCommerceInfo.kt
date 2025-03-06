package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * To identify the operator
 * @param number
 * @param place
 */
data class ChamberOfCommerceInfo(
    @Schema(example = "null", description = "")
    @get:JsonProperty("number") val number: kotlin.String? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("place") val place: kotlin.String? = null,
)
