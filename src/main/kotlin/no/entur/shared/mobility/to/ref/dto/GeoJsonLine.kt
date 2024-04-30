package no.entur.shared.mobility.to.ref.dto

/**
 * An array  of WGS84 coordinate pairs
 */
class GeoJsonLine(list: List<GeoJsonPoint>) : ArrayList<GeoJsonPoint>(list), GeoJsonGeometryCoordinates
