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
 * The temporal extent of the features in the collection.
 * @param interval One or more time intervals that describe the temporal extent of the dataset. The value `null` is supported and indicates an unbounded interval end. In the Core only a single time interval is supported. Extensions may support multiple intervals. If multiple intervals are provided, the union of the intervals describes the temporal extent.
 * @param trs Coordinate reference system of the coordinates in the temporal extent (property `interval`). The default reference system is the Gregorian calendar. In the Core this is the only supported temporal coordinate reference system. Extensions may support additional temporal coordinate reference systems and add additional enum values.
 */
data class ExtentTemporal(

    @get:Size(min=1)
    @Schema(example = "null", description = "One or more time intervals that describe the temporal extent of the dataset. The value `null` is supported and indicates an unbounded interval end. In the Core only a single time interval is supported. Extensions may support multiple intervals. If multiple intervals are provided, the union of the intervals describes the temporal extent.")
    @get:JsonProperty("interval") val interval: kotlin.collections.List<kotlin.collections.List<java.time.OffsetDateTime>>? = null,

    @Schema(example = "null", description = "Coordinate reference system of the coordinates in the temporal extent (property `interval`). The default reference system is the Gregorian calendar. In the Core this is the only supported temporal coordinate reference system. Extensions may support additional temporal coordinate reference systems and add additional enum values.")
    @get:JsonProperty("trs") val trs: ExtentTemporal.Trs? = Trs.HTTP_COLON_SLASH_SLASH_WWW_PERIOD_OPENGIS_PERIOD_NET_SLASH_DEF_SLASH_UOM_SLASH_ISO_8601_SLASH0_SLASH_GREGORIAN
) {

    /**
    * Coordinate reference system of the coordinates in the temporal extent (property `interval`). The default reference system is the Gregorian calendar. In the Core this is the only supported temporal coordinate reference system. Extensions may support additional temporal coordinate reference systems and add additional enum values.
    * Values: HTTP_COLON_SLASH_SLASH_WWW_PERIOD_OPENGIS_PERIOD_NET_SLASH_DEF_SLASH_UOM_SLASH_ISO_8601_SLASH0_SLASH_GREGORIAN
    */
    enum class Trs(@get:JsonValue val value: kotlin.String) {

        HTTP_COLON_SLASH_SLASH_WWW_PERIOD_OPENGIS_PERIOD_NET_SLASH_DEF_SLASH_UOM_SLASH_ISO_8601_SLASH0_SLASH_GREGORIAN("http://www.opengis.net/def/uom/ISO-8601/0/Gregorian");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Trs {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ExtentTemporal'")
            }
        }
    }

}

