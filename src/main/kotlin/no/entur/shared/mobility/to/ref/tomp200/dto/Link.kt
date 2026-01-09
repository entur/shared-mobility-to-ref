package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param rel the action that can be performed OR part of the URI allowed values include the 'processId's, prefixes for the referenced data sources, prefixes for deeplinks ('apple' and 'android'), OGC compliant ones (alternative, next, etc)
 * @param href valid URL
 * @param type short string, display names (length 0-75)
 * @param method to indicate the http method.
 * @param description the description of the external data source
 * @param body the (prefilled) body for the request
 * @param headers 
 * @param mandatory is this link informative, or must it be used?
 * @param hash to validate that the content of the link hasn`t been changed.
 * @param expires https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param availableFrom https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 */
data class Link(

    @Schema(example = "null", required = true, description = "the action that can be performed OR part of the URI allowed values include the 'processId's, prefixes for the referenced data sources, prefixes for deeplinks ('apple' and 'android'), OGC compliant ones (alternative, next, etc)")
    @get:JsonProperty("rel", required = true) val rel: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "valid URL")
    @get:JsonProperty("href", required = true) val href: java.net.URI,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @Schema(example = "null", description = "to indicate the http method.")
    @get:JsonProperty("method") val method: Link.Method? = Method.GET,

    @Schema(example = "null", description = "the description of the external data source")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "the (prefilled) body for the request")
    @get:JsonProperty("body") val body: kotlin.Any? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("headers") val headers: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    @Schema(example = "null", description = "is this link informative, or must it be used?")
    @get:JsonProperty("mandatory") val mandatory: kotlin.Boolean? = null,

    @Schema(example = "null", description = "to validate that the content of the link hasn`t been changed.")
    @get:JsonProperty("hash") val hash: kotlin.String? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("expires") val expires: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("availableFrom") val availableFrom: java.time.OffsetDateTime? = null
) {

    /**
    * to indicate the http method.
    * Values: POST,GET,DELETE,PATCH
    */
    enum class Method(@get:JsonValue val value: kotlin.String) {

        POST("POST"),
        GET("GET"),
        DELETE("DELETE"),
        PATCH("PATCH");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Method {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Link'")
            }
        }
    }

}

