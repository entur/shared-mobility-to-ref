package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param key certificate
 * @param passkey one time pass key
 */
data class TokenEKeyAllOfEkey(
    @Schema(example = "null", description = "certificate")
    val key: String? = null,
    @Schema(example = "null", description = "one time pass key")
    val passkey: String? = null,
)
