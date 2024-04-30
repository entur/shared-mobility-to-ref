package no.entur.shared.mobility.to.ref.dto

/**
 * geoJSON representation of a multi polygon. See also https://geojson.org/geojson-spec.html#multipolygon
 */
class GeoJsonMultiPolygon(list: List<GeoJsonPolygon>) : ArrayList<GeoJsonPolygon>(list), GeoJsonGeometryCoordinates
