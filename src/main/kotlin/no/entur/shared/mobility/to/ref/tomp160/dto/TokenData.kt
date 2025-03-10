package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
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
 * @param tokenType 
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tokenType", visible = true)
@JsonSubTypes(
      JsonSubTypes.Type(value = TokenDeeplink::class, name = "TokenDeeplink"),
      JsonSubTypes.Type(value = TokenDefault::class, name = "TokenDefault"),
      JsonSubTypes.Type(value = TokenEKey::class, name = "TokenEKey"),
      JsonSubTypes.Type(value = TokenQR::class, name = "TokenQR")
)

interface TokenData{
                @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
        val tokenType: kotlin.String


}

