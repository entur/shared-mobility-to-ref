package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.TokenData
import no.entur.shared.mobility.to.ref.dto.TokenEKeyAllOfEkey
import no.entur.shared.mobility.to.ref.dto.TokenEKeyAllOfLock

/**
 * Axa EKey information
 * @param ekey
 * @param lock
 */
data class TokenEKey(
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ekey", required = true) val ekey: TokenEKeyAllOfEkey,
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("lock", required = true) val lock: TokenEKeyAllOfLock,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,
) : TokenData
