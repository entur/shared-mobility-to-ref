package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.TokenData
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
 * QR information
 * @param base64 base 64 QR code
 * @param version 
 */
data class TokenQR(

    @Schema(example = "null", required = true, description = "base 64 QR code")
    @get:JsonProperty("base64", required = true) val base64: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("version") val version: kotlin.String? = null
    ) : TokenData{

}

