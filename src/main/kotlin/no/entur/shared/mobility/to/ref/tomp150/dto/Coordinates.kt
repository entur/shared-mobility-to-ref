package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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
 * a lon, lat (WGS84, EPSG:4326)
 * @param lng 
 * @param lat 
 * @param alt altitude, in meters above sea level
 */
data class Coordinates(

    @get:DecimalMin(value="0")
    @Schema(example = "6.169639", required = true, description = "")
    @param:JsonProperty("lng")
    @get:JsonProperty("lng", required = true) val lng: kotlin.Float,

    @get:DecimalMin(value="0")
    @Schema(example = "52.253279", required = true, description = "")
    @param:JsonProperty("lat")
    @get:JsonProperty("lat", required = true) val lat: kotlin.Float,

    @get:DecimalMin(value="0")
    @Schema(description = "altitude, in meters above sea level")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("alt")
    @get:JsonProperty("alt") val alt: kotlin.Float? = null
) {

}

