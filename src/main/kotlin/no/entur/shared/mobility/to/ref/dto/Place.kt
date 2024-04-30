package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * an origin or destination of a leg, 3D. lon/lat in WGS84.
 * @param coordinates
 * @param name Human-readable name of the place, could match Content-Language
 * @param stopReference
 * @param stationId reference to /operator/stations
 * @param physicalAddress
 * @param extraInfo
 */
data class Place(
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("coordinates", required = true) val coordinates: Coordinates,
    @Schema(example = "null", description = "Human readable name of the place, could match Content-Language")
    val name: String? = null,
    @field:Valid
    @Schema(example = "null")
    val stopReference: List<StopReference>? = null,
    @Schema(example = "null", description = "reference to /operator/stations")
    val stationId: String? = null,
    @field:Valid
    @Schema(example = "null")
    val physicalAddress: Address? = null,
    @field:Valid
    @Schema(example = "null")
    val extraInfo: Map<String, Any>? = null,
)
