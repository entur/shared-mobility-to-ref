package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import java.time.OffsetDateTime

/**
 * The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to show their right to travel, or use to
 * access an asset
 * @param validFrom
 * @param validUntil
 * @param tokenType The type of data held in this token, will later be an enum
 * @param tokenData
 */
data class Token(
    @Schema(example = "null", required = true)
    @get:JsonProperty("validFrom", required = true) val validFrom: OffsetDateTime,
    @Schema(example = "null", required = true)
    @get:JsonProperty("validUntil", required = true) val validUntil: OffsetDateTime,
    @Schema(
        example = "null",
        required = true,
        description = "The type of data held in this token, will later be an enum",
    )
    @get:JsonProperty("tokenType", required = true) val tokenType: TokenType,
    @field:Valid
    @Schema(example = "null")
    val tokenData: TokenTokenData? = null,
) {
    /**
     * The type of data held in this token, will later be an enum
     * Values: tokenDefault,tokenDeeplink,tokenEKey,tokenQR
     */
    @Suppress("EnumEntryName")
    enum class TokenType {
        tokenDefault,
        tokenDeeplink,
        tokenEKey,
        tokenQR,
    }
}
