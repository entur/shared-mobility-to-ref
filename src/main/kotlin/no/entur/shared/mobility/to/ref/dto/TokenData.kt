package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param tokenType
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tokenType", visible = true)
@JsonSubTypes(
    JsonSubTypes.Type(value = TokenDeeplink::class, name = "TokenDeeplink"),
    JsonSubTypes.Type(value = TokenDefault::class, name = "TokenDefault"),
    JsonSubTypes.Type(value = TokenEKey::class, name = "TokenEKey"),
    JsonSubTypes.Type(value = TokenQR::class, name = "TokenQR"),
)
interface TokenData {
    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    val tokenType: kotlin.String
}
