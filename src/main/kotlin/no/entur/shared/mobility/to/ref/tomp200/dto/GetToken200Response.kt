package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param accessToken The issued access token.
 * @param tokenType The type of the token.
 * @param expiresIn The lifetime of the access token in seconds.
 */
data class GetToken200Response(

    @Schema(example = "null", required = true, description = "The issued access token.")
    @get:JsonProperty("access_token", required = true) val accessToken: kotlin.String,

    @Schema(example = "null", description = "The type of the token.")
    @get:JsonProperty("token_type") val tokenType: kotlin.String? = "Bearer",

    @Schema(example = "null", description = "The lifetime of the access token in seconds.")
    @get:JsonProperty("expires_in") val expiresIn: kotlin.Int? = null
) {

}

