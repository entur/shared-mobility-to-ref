package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.Condition
import no.entur.shared.mobility.to.ref.tomp150.dto.Coordinates
import no.entur.shared.mobility.to.ref.tomp150.dto.SystemHours
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
 * a return area. In the condition list there can be multiple return area's.
 * @param stationId station to which the asset should be returned
 * @param returnArea geojson representation of a polygon. First and last point must be equal. See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
 * @param coordinates 
 * @param returnHours the return hours of the facility (if different from operating-hours)
 */
data class ConditionReturnArea(

    @Schema(example = "null", required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,

    @Schema(example = "null", description = "station to which the asset should be returned")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(example = "[[[1.0,1.0],[0.0,1.0],[0.0,0.0],[1.0,0.0],[1.0,1.0]]]", description = "geojson representation of a polygon. First and last point must be equal. See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.")
    @get:JsonProperty("returnArea") val returnArea: kotlin.collections.List<kotlin.collections.List<kotlin.collections.List<kotlin.Float>>>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("coordinates") val coordinates: Coordinates? = null,

    @field:Valid
    @Schema(example = "null", description = "the return hours of the facility (if different from operating-hours)")
    @get:JsonProperty("returnHours") val returnHours: kotlin.collections.List<SystemHours>? = null,

    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @get:JsonProperty("id") override val id: kotlin.String? = null
) : Condition {

}

