package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema

/**
 * geoJSON geometry
 * @param type
 * @param coordinates
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes()
interface GeojsonGeometry {
    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
    val type: Type

    @get:Schema(example = "null")
    val coordinates: GeojsonGeometryCoordinates?

    /**
     *
     * Values: point,lineString,polygon,multiPolygon
     */
    enum class Type {
        Point,
        LineString,
        Polygon,
        MultiPolygon,
    }
}
