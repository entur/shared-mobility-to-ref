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
 * Binary information, like a image or certificate
 * @param contentType the media type (IANA)
 * @param base64 long string, memos etc (length 0-10.000)
 */
data class BinaryTicket(

    @Schema(example = "null", required = true, description = "the media type (IANA)")
    @get:JsonProperty("contentType", required = true) val contentType: kotlin.String,

    @get:Size(max=10000)
    @Schema(example = "null", required = true, description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("base64", required = true) val base64: kotlin.String
) {

}

