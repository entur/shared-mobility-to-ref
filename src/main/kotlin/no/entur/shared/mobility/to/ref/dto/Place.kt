package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Address
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.StopReference

/**
 * a origin or destination of a leg, 3D. lon/lat in WGS84.
 * @param coordinates
 * @param name Human readable name of the place, could match Content-Language
 * @param stopReference
 * @param stationId reference to /operator/stations
 * @param physicalAddress
 * @param extraInfo
 */
data class Place(
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("coordinates", required = true) val coordinates: Coordinates,
    @Schema(example = "null", description = "Human readable name of the place, could match Content-Language")
    @get:JsonProperty("name") val name: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("stopReference") val stopReference: kotlin.collections.List<StopReference>? = null,
    @Schema(example = "null", description = "reference to /operator/stations")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("physicalAddress") val physicalAddress: Address? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
)
