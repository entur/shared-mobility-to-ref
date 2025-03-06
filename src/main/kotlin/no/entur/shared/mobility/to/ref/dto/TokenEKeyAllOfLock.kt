package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param bdAddress physical address
 * @param deviceName how it advertises itself
 */
data class TokenEKeyAllOfLock(
    @Schema(example = "null", description = "physical address")
    @get:JsonProperty("bdAddress") val bdAddress: kotlin.String? = null,
    @Schema(example = "null", description = "how it advertises itself")
    @get:JsonProperty("deviceName") val deviceName: kotlin.String? = null,
)
