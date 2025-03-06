package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import no.entur.shared.mobility.to.ref.dto.TokenData

/**
 * QR information
 * @param base64 base 64 QR code
 * @param version
 */
data class TokenQR(
    @Schema(example = "null", required = true, description = "base 64 QR code")
    @get:JsonProperty("base64", required = true) val base64: kotlin.String,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,
    @Schema(example = "null", description = "")
    @get:JsonProperty("version") val version: kotlin.String? = null,
) : TokenData
