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
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param guarantee https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param option https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param offer default string, full names etc (length 0-200)
 */
data class RedressOptionRequestRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package", required = true) val `package`: kotlin.String,

    @Schema(example = "null", required = true, description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("guarantee", required = true) val guarantee: kotlin.String,

    @Schema(example = "null", required = true, description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("option", required = true) val option: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("offer") val offer: kotlin.String? = null
) {

}

