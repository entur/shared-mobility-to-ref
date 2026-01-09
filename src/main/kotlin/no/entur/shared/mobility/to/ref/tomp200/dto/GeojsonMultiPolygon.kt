package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * geojson representation of a multi polygon. See also https://geojson.org/geojson-spec.html#multipolygon
 * @param coordinates 
 */
data class GeojsonMultiPolygon(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("coordinates", required = true) val coordinates: kotlin.collections.List<kotlin.collections.List<kotlin.collections.List<kotlin.collections.List<kotlin.Float>>>>
) {

}

