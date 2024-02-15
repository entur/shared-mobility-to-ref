package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.DecimalMin

/**
 * a lon, lat (WGS84, EPSG:4326)
 * @param lng
 * @param lat
 * @param alt altitude, in meters above sea level
 */
data class Coordinates(
    @get:DecimalMin("0")
    @Schema(example = "6.169639", required = true)
    @get:JsonProperty("lng", required = true) val lng: Float,
    @get:DecimalMin("0")
    @Schema(example = "52.253279", required = true)
    @get:JsonProperty("lat", required = true) val lat: Float,
    @get:DecimalMin("0")
    @Schema(example = "null", description = "altitude, in meters above sea level")
    val alt: Float? = null,
)
