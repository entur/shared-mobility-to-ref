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
 * @param id default string, full names etc (length 0-200)
 * @param type 
 * @param description default string, full names etc (length 0-200)
 */
data class EntitlementGiven(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Pattern(regexp="^(entitlement|commercialProfile)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("description", required = true) val description: kotlin.String
) {

}

