package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * deeplink info
 * @param tokenType
 * @param url the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.
 * @param knownParameters
 */
data class TokenDeeplink(
    @Schema(example = "null", required = true)
    @get:JsonProperty("tokenType", required = true) override val tokenType: String,
    @Schema(
        example = "mp1.app://something/?auth=sdfkjhrkjsdf003df38=dfsdf",
        description = "the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.",
    )
    val url: String? = null,
    @Schema(example = "[\"return-url\",\"error-url\",\"error-code\",\"error-description\"]")
    val knownParameters: List<String>? = null,
) : TokenTokenData
