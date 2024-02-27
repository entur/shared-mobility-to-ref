package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.time.OffsetDateTime

/**
 *
 * @param regionId Unique identifier for this region
 * @param name Public name for this region, could match Content-Language
 * @param type the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0,
 * it was only allowed to communicate OPERATING area's.
 * @param typeUnit in case the type needs a value (f.x. speed limit), this is the unit type.
 * @param typeValue the value that belongs to the type (e.g. 8 MPH)
 * @param areaStartTime the start time of this area (mostly applicable in case of limitations)
 * @param areaEndTime the end time of this area (mostly applicable in case of limitations)
 * @param serviceArea geoJSON representation of a polygon. First and last point must be equal.
 * See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4.
 * The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
 */
data class SystemRegion(
    @Schema(example = "BikeRegion", required = true, description = "Unique identifier for this region")
    @get:JsonProperty("regionId", required = true) val regionId: String,
    @Schema(
        example = "BikeTown",
        required = true,
        description = "Public name for this region, could match Content-Language",
    )
    @get:JsonProperty("name", required = true) val name: String,
    @Schema(
        example = "null",
        description = """the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). 
            |Before 1.3.0, it was only allowed to communicate OPERATING area's.""",
    )
    val type: Type? = Type.OPERATING,
    @Schema(example = "null", description = "in case the type needs a value (f.x. speed limit), this is the unit type.")
    val typeUnit: TypeUnit? = null,
    @Schema(example = "null", description = "the value that belongs to the type (e.g. 8 MPH)")
    val typeValue: Float? = null,
    @Schema(example = "null", description = "the start time of this area (mostly applicable in case of limitations)")
    val areaStartTime: OffsetDateTime? = null,
    @Schema(example = "null", description = "the end time of this area (mostly applicable in case of limitations)")
    val areaEndTime: OffsetDateTime? = null,
    @Schema(
        example = "[[[1.0,1.0],[0.0,1.0],[0.0,0.0],[1.0,0.0],[1.0,1.0]]]",
        description = """geoJSON representation of a polygon. First and last point must be equal. See also 
            |https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be 
            |lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.""",
    )
    val serviceArea: GeoJsonPolygon? = null,
) {
    /**
     * the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0,
     * it was only allowed to communicate OPERATING area's.
     */
    enum class Type {
        OPERATING,
        NO_ACCESS,
        NO_PARKING,
        PARKING,
        DISCOUNT,
        SPEEDLIMIT,
    }

    /**
     * in case the type needs a value (f.x. speed limit), this is the unit type.
     */
    enum class TypeUnit {
        KMPH,
        MPH,
    }
}
