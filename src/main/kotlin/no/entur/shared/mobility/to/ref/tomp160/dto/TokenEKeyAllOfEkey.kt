package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * @param key certificate
 * @param passkey one time pass key
 */
data class TokenEKeyAllOfEkey(

    @Schema(example = "null", description = "certificate")
    @get:JsonProperty("key") val key: kotlin.String? = null,

    @Schema(example = "null", description = "one time pass key")
    @get:JsonProperty("passkey") val passkey: kotlin.String? = null
) {

}

