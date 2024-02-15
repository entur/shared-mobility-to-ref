package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param tokenType
 */
data class TokenData(
    @Schema(example = "null", required = true)
    @get:JsonProperty("tokenType", required = true) val tokenType: String,
) : HashMap<String, Any>()
