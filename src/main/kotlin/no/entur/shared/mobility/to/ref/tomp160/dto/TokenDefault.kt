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
 * Arbitrary data the TO may pass along the ticket to the client
 * @param tokenType 
 * @param url download url for html/pdf
 */
data class TokenDefault(

    @Schema(required = true, description = "")
    @param:JsonProperty("tokenType", required = true)
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,

    @Schema(description = "download url for html/pdf")
    @param:JsonProperty("url")
    @get:JsonProperty("url") val url: kotlin.String? = null
) : TokenData {

}

