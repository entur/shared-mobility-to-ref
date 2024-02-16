package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Arbitrary data the TO may pass along the ticket to the client
 * @param tokenType
 * @param url download url for html/pdf
 */
data class TokenDefault(
    @Schema(example = "null", required = true)
    @get:JsonProperty("tokenType", required = true) override val tokenType: String,
    @Schema(example = "null", description = "download url for html/pdf")
    val url: String? = null,
) : TokenTokenData
