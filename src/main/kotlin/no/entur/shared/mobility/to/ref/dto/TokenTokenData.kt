package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param tokenType
 * @param ekey
 * @param lock
 * @param base64 base 64 QR code
 * @param url the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.
 * @param knownParameters
 * @param version
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tokenType", visible = true)
@JsonSubTypes(
    JsonSubTypes.Type(TokenDefault::class),
    JsonSubTypes.Type(TokenDeeplink::class),
    JsonSubTypes.Type(TokenEKey::class),
    JsonSubTypes.Type(TokenQR::class),
)
interface TokenTokenData {
    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
    val tokenType: String
}
