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
 * applicable properties to specify cargo space/loads
 * @param description long string, memos etc (length 0-10.000)
 * @param volume default length for an integer (0-1000)
 * @param weight default length for an integer (0-1000)
 */
data class CargoLimits(

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @get:Min(0)
    @get:Max(1000)
    @Schema(example = "null", description = "default length for an integer (0-1000)")
    @get:JsonProperty("volume") val volume: kotlin.Int? = 0,

    @get:Min(0)
    @get:Max(1000)
    @Schema(example = "null", description = "default length for an integer (0-1000)")
    @get:JsonProperty("weight") val weight: kotlin.Int? = 0
) {

}

