package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import no.entur.shared.mobility.to.ref.dto.TokenData

/**
 * Arbitrary data the TO may pass along the ticket to the client
 * @param url download url for html/pdf
 */
data class TokenDefault(
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,
    @Schema(example = "null", description = "download url for html/pdf")
    @get:JsonProperty("url") val url: kotlin.String? = null,
) : TokenData
