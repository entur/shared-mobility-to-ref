package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * Axa EKey information
 * @param tokenType
 * @param ekey
 * @param lock
 */
data class TokenEKey(
    @Schema(example = "null", required = true)
    @get:JsonProperty("tokenType", required = true) override val tokenType: String,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("ekey", required = true) val ekey: TokenEKeyAllOfEkey,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("lock", required = true) val lock: TokenEKeyAllOfLock,
) : TokenTokenData
