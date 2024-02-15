package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * a complete endpoint description, containing all endpoints, their status, but also the served scenarios and implemented process flows.
 * The identifiers for the process flows can be found at https://github.com/TOMP-WG/TOMP-API/wiki/ProcessIdentifiers<br>
 * @param version
 * @param baseUrl
 * @param endpoints
 * @param scenarios
 * @param processIdentifiers
 * @param steps
 */
data class EndpointImplementation(
    @Schema(example = "null", required = true)
    @get:JsonProperty("version", required = true) val version: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty("baseUrl", required = true) val baseUrl: String,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("endpoints", required = true) val endpoints: List<Endpoint>,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("scenarios", required = true) val scenarios: List<Scenario>,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("processIdentifiers", required = true) val processIdentifiers: ProcessIdentifiers,
    @field:Valid
    @Schema(example = "null")
    val steps: EndpointImplementationSteps? = null,
)
