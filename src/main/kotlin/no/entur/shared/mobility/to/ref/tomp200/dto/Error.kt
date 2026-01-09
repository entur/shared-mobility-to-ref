package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
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
 * An error that the service may send, e.g. in case of invalId input, missing authorization or internal service error. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. JSON schema for exceptions based on RFC 7807
 * @param errorcode for really small numbers (0-10)
 * @param title short string, display names (length 0-75)
 * @param type real short string, codes (length 0-10)
 * @param status for really small numbers (0-10)
 * @param detail long string, memos etc (length 0-10.000)
 * @param instance valid URL
 * @param links 
 */
data class Error(

    @get:Min(0)
    @get:Max(10)
    @Schema(example = "null", required = true, description = "for really small numbers (0-10)")
    @get:JsonProperty("errorcode", required = true) val errorcode: kotlin.Int = 0,

    @get:Size(max=75)
    @Schema(example = "null", required = true, description = "short string, display names (length 0-75)")
    @get:JsonProperty("title", required = true) val title: kotlin.String,

    @get:Size(max=10)
    @Schema(example = "null", description = "real short string, codes (length 0-10)")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @get:Min(0)
    @get:Max(10)
    @Schema(example = "null", description = "for really small numbers (0-10)")
    @get:JsonProperty("status") val status: kotlin.Int? = 0,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("detail") val detail: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "valid URL")
    @get:JsonProperty("instance") val instance: java.net.URI? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

