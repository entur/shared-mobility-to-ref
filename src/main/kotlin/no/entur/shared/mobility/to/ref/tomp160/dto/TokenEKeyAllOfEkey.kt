package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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

    @Schema(description = "certificate")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("key")
    @get:JsonProperty("key") val key: kotlin.String? = null,

    @Schema(description = "one time pass key")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("passkey")
    @get:JsonProperty("passkey") val passkey: kotlin.String? = null
) {

}

