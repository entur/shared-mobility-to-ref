package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * a return area. In the condition list there can be multiple return area's.
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param id An identifier for this condition that can be used to refer to this condition
 * @param stationId station to which the asset should be returned
 * @param returnArea geoJson representation of a polygon. First and last point must be equal. See also
 * https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be
 * lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
 * @param coordinates
 * @param returnHours the return hours of the facility (if different from operating-hours)
 */
data class ConditionReturnArea(
    @Schema(
        example = "null",
        required = true,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    @get:JsonProperty("conditionType", required = true) override val conditionType: String,
    @Schema(
        example = "deposit50eu",
        description = "An identifier for this condition that can be used to refer to this condition",
    )
    val id: String? = null,
    @Schema(example = "null", description = "station to which the asset should be returned")
    val stationId: String? = null,
    @Schema(
        example = "[[[1.0,1.0],[0.0,1.0],[0.0,0.0],[1.0,0.0],[1.0,1.0]]]",
        description = """geoJson representation of a polygon. First and last point must be equal. See also 
            |https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be 
            |lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.""",
    )
    val returnArea: GeoJsonPolygon? = null,
    @field:Valid
    @Schema(example = "null")
    val coordinates: Coordinates? = null,
    @field:Valid
    @Schema(example = "null", description = "the return hours of the facility (if different from operating-hours)")
    val returnHours: List<SystemHours>? = null,
) : AssetTypeConditionsInner
