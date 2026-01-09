package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * The spatial extent of the features in the collection.
 * @param bbox One or more bounding boxes that describe the spatial extent of the dataset. In the Core only a single bounding box is supported. Extensions may support additional areas. If multiple areas are provided, the union of the bounding boxes describes the spatial extent.
 * @param crs Coordinate reference system of the coordinates in the spatial extent (property `bbox`). The default reference system is WGS 84 longitude/latitude. In the Core this is the only supported coordinate reference system. Extensions may support additional coordinate reference systems and add additional enum values.
 */
data class ExtentSpatial(

    @get:Size(min=1)
    @Schema(example = "null", description = "One or more bounding boxes that describe the spatial extent of the dataset. In the Core only a single bounding box is supported. Extensions may support additional areas. If multiple areas are provided, the union of the bounding boxes describes the spatial extent.")
    @get:JsonProperty("bbox") val bbox: kotlin.collections.List<kotlin.collections.List<java.math.BigDecimal>>? = null,

    @Schema(example = "null", description = "Coordinate reference system of the coordinates in the spatial extent (property `bbox`). The default reference system is WGS 84 longitude/latitude. In the Core this is the only supported coordinate reference system. Extensions may support additional coordinate reference systems and add additional enum values.")
    @get:JsonProperty("crs") val crs: ExtentSpatial.Crs? = Crs.HTTP_COLON_SLASH_SLASH_WWW_PERIOD_OPENGIS_PERIOD_NET_SLASH_DEF_SLASH_CRS_SLASH_OGC_SLASH1_PERIOD3_SLASH_CRS84
) {

    /**
    * Coordinate reference system of the coordinates in the spatial extent (property `bbox`). The default reference system is WGS 84 longitude/latitude. In the Core this is the only supported coordinate reference system. Extensions may support additional coordinate reference systems and add additional enum values.
    * Values: HTTP_COLON_SLASH_SLASH_WWW_PERIOD_OPENGIS_PERIOD_NET_SLASH_DEF_SLASH_CRS_SLASH_OGC_SLASH1_PERIOD3_SLASH_CRS84
    */
    enum class Crs(@get:JsonValue val value: kotlin.String) {

        HTTP_COLON_SLASH_SLASH_WWW_PERIOD_OPENGIS_PERIOD_NET_SLASH_DEF_SLASH_CRS_SLASH_OGC_SLASH1_PERIOD3_SLASH_CRS84("http://www.opengis.net/def/crs/OGC/1.3/CRS84");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Crs {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ExtentSpatial'")
            }
        }
    }

}

