package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp150.dto.TokenData
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
 * @param tokenType 
 * @param version 
 */
data class TokenQR(

    @Schema(required = true, description = "base 64 QR code")
    @param:JsonProperty("base64")
    @get:JsonProperty("base64", required = true) val base64: kotlin.String,

    @Schema(required = true, description = "")
    @param:JsonProperty("tokenType")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("version")
    @get:JsonProperty("version") val version: kotlin.String? = null
) : TokenData {

}

