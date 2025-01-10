package no.entur.shared.mobility.to.ref.dto

/**
 * GeoJSON Coordinate
 */
class GeoJsonPoint(
    list: List<Float>,
) : ArrayList<Float>(list),
    GeoJsonGeometryCoordinates
