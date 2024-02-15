package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param bdAddress physical address
 * @param deviceName how it advertises itself
 */
data class TokenEKeyAllOfLock(
    @Schema(example = "null", description = "physical address")
    val bdAddress: String? = null,
    @Schema(example = "null", description = "how it advertises itself")
    val deviceName: String? = null,
)
