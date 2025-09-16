package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.GeojsonGeometryCoordinates
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
 * @param coordinates 
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
)

interface GeojsonGeometry{
                @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
        val type: GeojsonGeometry.Type

                @get:Schema(example = "null", description = "")
        val coordinates: GeojsonGeometryCoordinates? 


    /**
    * 
    * Values: POINT,LINE_STRING,POLYGON,MULTI_POLYGON
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        POINT("Point"),
        LINE_STRING("LineString"),
        POLYGON("Polygon"),
        MULTI_POLYGON("MultiPolygon");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'GeojsonGeometry'")
            }
        }
    }

}

