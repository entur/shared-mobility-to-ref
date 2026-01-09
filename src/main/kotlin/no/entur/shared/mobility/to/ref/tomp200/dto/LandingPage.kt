package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
import no.entur.shared.mobility.to.ref.tomp200.dto.ProcessIdentifier
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
 * a complete endpoint description, containing all endpoints, their status, but also the served scenarios and implemented process flows. The identifiers for the process flows can be found at https://github.com/TOMP-WG/TOMP-API/wiki/ProcessIdentifiers<br>
 * @param title 
 * @param description 
 * @param links 
 * @param processIdentifiers an array with 'care labels', indiacting how this implementation wants to be treated.
 */
data class LandingPage(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("title", required = true) val title: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("description", required = true) val description: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("links", required = true) val links: kotlin.collections.List<Link>,

    @field:Valid
    @get:Size(max=10)
    @Schema(example = "null", description = "an array with 'care labels', indiacting how this implementation wants to be treated.")
    @get:JsonProperty("processIdentifiers") val processIdentifiers: kotlin.collections.List<ProcessIdentifier>? = null
) {

}

