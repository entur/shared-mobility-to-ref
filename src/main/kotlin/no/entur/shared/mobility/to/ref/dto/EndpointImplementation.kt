package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Endpoint
import no.entur.shared.mobility.to.ref.dto.EndpointImplementationSteps
import no.entur.shared.mobility.to.ref.dto.ProcessIdentifiers
import no.entur.shared.mobility.to.ref.dto.Scenario

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
    @get:JsonProperty("steps") val steps: EndpointImplementationSteps? = null,
)
