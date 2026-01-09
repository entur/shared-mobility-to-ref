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
 * @param key long string, memos etc (length 0-10.000)
 * @param passkey long string, memos etc (length 0-10.000)
 */
data class EKeyEkey(

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("key") val key: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("passkey") val passkey: kotlin.String? = null
) {

}

