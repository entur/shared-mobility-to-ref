package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
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
 * geoJSON geometry
 * @param type 
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
      JsonSubTypes.Type(value = GeojsonLine::class, name = "LineString"),
      JsonSubTypes.Type(value = GeojsonMultiPolygon::class, name = "MultiPolygon"),
      JsonSubTypes.Type(value = GeojsonPoint::class, name = "Point"),
      JsonSubTypes.Type(value = GeojsonPolygon::class, name = "Polygon")
)

interface GeojsonGeometry{
                @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
        val type: kotlin.String


}

