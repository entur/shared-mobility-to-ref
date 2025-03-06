package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param key certificate
 * @param passkey one time pass key
 */
data class TokenEKeyAllOfEkey(
    @Schema(example = "null", description = "certificate")
    @get:JsonProperty("key") val key: kotlin.String? = null,
    @Schema(example = "null", description = "one time pass key")
    @get:JsonProperty("passkey") val passkey: kotlin.String? = null,
)
