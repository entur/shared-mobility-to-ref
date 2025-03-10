package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.GeojsonGeometry
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
 * geojson representation of a polygon. First and last point must be equal. See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
 * @param coordinates 
 */
data class GeojsonPolygon(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) override val type: kotlin.String,

    @Schema(example = "[[[1.0,1.0],[0.0,1.0],[0.0,0.0],[1.0,0.0],[1.0,1.0]]]", description = "")
    @get:JsonProperty("coordinates") val coordinates: kotlin.collections.List<kotlin.collections.List<kotlin.collections.List<kotlin.Float>>>? = null
    ) : GeojsonGeometry{

}

