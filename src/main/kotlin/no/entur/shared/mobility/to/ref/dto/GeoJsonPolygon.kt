package no.entur.shared.mobility.to.ref.dto

/**
 * geoJSON representation of a polygon. First and last point must be equal. See also https://geojson.org/geojson-spec.html#polygon and
 * example https://geojson.org/geojson-spec.html#id4.
 * The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
 */
class GeoJsonPolygon(
    list: List<GeoJsonLine>,
) : ArrayList<GeoJsonLine>(list),
    GeoJsonGeometryCoordinates
