package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import no.entur.shared.mobility.to.ref.dto.TokenData

/**
 * deeplink info
 * @param url the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.
 * @param knownParameters
 */
data class TokenDeeplink(
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,
    @Schema(
        example = "mp1.app://something/?auth=sdfkjhrkjsdf003df38=dfsdf",
        description = "the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.",
    )
    @get:JsonProperty("url") val url: kotlin.String? = null,
    @Schema(example = "[\"return-url\",\"error-url\",\"error-code\",\"error-description\"]", description = "")
    @get:JsonProperty("knownParameters") val knownParameters: kotlin.collections.List<kotlin.String>? = null,
) : TokenData
