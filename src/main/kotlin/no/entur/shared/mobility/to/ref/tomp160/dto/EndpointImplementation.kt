package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.Endpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.EndpointImplementationSteps
import no.entur.shared.mobility.to.ref.tomp160.dto.ProcessIdentifiers
import no.entur.shared.mobility.to.ref.tomp160.dto.Scenario
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
 * @param version 
 * @param baseUrl 
 * @param endpoints 
 * @param scenarios 
 * @param processIdentifiers 
 * @param steps 
 */
data class EndpointImplementation(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("version", required = true) val version: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("baseUrl", required = true) val baseUrl: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("endpoints", required = true) val endpoints: kotlin.collections.List<Endpoint>,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("scenarios", required = true) val scenarios: kotlin.collections.List<Scenario>,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("processIdentifiers", required = true) val processIdentifiers: ProcessIdentifiers,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("steps") val steps: EndpointImplementationSteps? = null
    ) {

}

