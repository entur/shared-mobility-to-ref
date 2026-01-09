package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.TravellerCharacteristics
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
 * @param traveller default string, full names etc (length 0-200)
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param age a bit short integer (0-100)
 * @param fullName default string, full names etc (length 0-200)
 * @param characteristics 
 */
data class UpdateTravellerRequestRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("traveller", required = true) val traveller: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package") val `package`: kotlin.String? = null,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "a bit short integer (0-100)")
    @get:JsonProperty("age") val age: kotlin.Int? = 0,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("fullName") val fullName: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("characteristics") val characteristics: TravellerCharacteristics? = null
) {

}

