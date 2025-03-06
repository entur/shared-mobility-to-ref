package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.TokenData

/**
 * The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to show their right to travel, or use to access an asset
 * @param validFrom
 * @param validUntil
 * @param tokenType The type of data held in this token, will later be an enum
 * @param tokenData
 */
data class Token(
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("validFrom", required = true) val validFrom: java.time.OffsetDateTime,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("validUntil", required = true) val validUntil: java.time.OffsetDateTime,
    @Schema(example = "null", required = true, description = "The type of data held in this token, will later be an enum")
    @get:JsonProperty("tokenType", required = true) val tokenType: Token.TokenType,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("tokenData") val tokenData: TokenData? = null,
) {
    /**
     * The type of data held in this token, will later be an enum
     * Values: TOKEN_DEFAULT,TOKEN_DEEPLINK,TOKEN_E_KEY,TOKEN_QR
     */
    enum class TokenType(
        @get:JsonValue val value: kotlin.String,
    ) {
        TOKEN_DEFAULT("tokenDefault"),
        TOKEN_DEEPLINK("tokenDeeplink"),
        TOKEN_E_KEY("tokenEKey"),
        TOKEN_QR("tokenQR"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): TokenType = values().first { it -> it.value == value }
        }
    }
}
