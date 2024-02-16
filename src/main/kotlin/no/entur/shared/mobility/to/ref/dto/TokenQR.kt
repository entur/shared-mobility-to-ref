package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * QR information
 * @param tokenType
 * @param base64 base 64 QR code
 * @param version
 */
data class TokenQR(
    @Schema(example = "null", required = true)
    @get:JsonProperty("tokenType", required = true) override val tokenType: String,
    @Schema(example = "null", required = true, description = "base 64 QR code")
    @get:JsonProperty("base64", required = true) val base64: String,
    @Schema(example = "null")
    val version: String? = null,
) : TokenTokenData
