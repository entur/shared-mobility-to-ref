package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema

/**
 * geoJSON geometry
 * @param type
 * @param coordinates
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes()
interface GeojsonGeometry {
    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    val type: GeojsonGeometry.Type

    @get:Schema(example = "null", description = "")
    val coordinates: GeojsonGeometryCoordinates?

    /**
     *
     * Values: POINT,LINE_STRING,POLYGON,MULTI_POLYGON
     */
    enum class Type(
        @get:JsonValue val value: kotlin.String,
    ) {
        POINT("Point"),
        LINE_STRING("LineString"),
        POLYGON("Polygon"),
        MULTI_POLYGON("MultiPolygon"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type = values().first { it -> it.value == value }
        }
    }
}
