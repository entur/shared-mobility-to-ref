package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * geoJSON geometry
 * @param type
 * @param coordinates
 */

class GeoJsonGeometry(
    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
    val type: Type,
    coordinates: List<Any>,
) {
    @get:Schema(example = "null")
    val coordinates: GeoJsonGeometryCoordinates

    init {
        @Suppress("UNCHECKED_CAST")
        this.coordinates =
            when (type) {
                Type.Point -> GeoJsonPoint(coordinates as List<Float>)
                Type.LineString -> GeoJsonLine(coordinates as List<GeoJsonPoint>)
                Type.Polygon -> GeoJsonPolygon(coordinates as List<GeoJsonLine>)
                Type.MultiPolygon -> GeoJsonMultiPolygon(coordinates as List<GeoJsonPolygon>)
            }
    }

    enum class Type {
        Point,
        LineString,
        Polygon,
        MultiPolygon,
    }
}
