package no.entur.shared.mobility.to.ref.tomp150.dto

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
 * reference to a stop (can be nation specific). This can help to specific pinpoint a (bus) stop. Extra information about the stop is not supplied; you should find it elsewhere.
 * @param type type of external reference (GTFS, CHB).
 * @param id this field should contain the complete ID. E.g. NL:S:13121110 or BE:S:79640040
 * @param country two-letter country codes according to ISO 3166-1
 */
data class StopReference(

    @Schema(example = "null", required = true, description = "type of external reference (GTFS, CHB).")
    @get:JsonProperty("type", required = true) val type: StopReference.Type,

    @Schema(example = "null", required = true, description = "this field should contain the complete ID. E.g. NL:S:13121110 or BE:S:79640040")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", required = true, description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country", required = true) val country: kotlin.String
    ) {

    /**
    * type of external reference (GTFS, CHB).
    * Values: GTFS_STOP_ID,GTFS_STOP_CODE,GTFS_AREA_ID,CHB_STOP_PLACE_CODE,CHB_QUAY_CODE,NS_CODE
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        GTFS_STOP_ID("GTFS_STOP_ID"),
        GTFS_STOP_CODE("GTFS_STOP_CODE"),
        GTFS_AREA_ID("GTFS_AREA_ID"),
        CHB_STOP_PLACE_CODE("CHB_STOP_PLACE_CODE"),
        CHB_QUAY_CODE("CHB_QUAY_CODE"),
        NS_CODE("NS_CODE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().first{it -> it.value == value}
            }
        }
    }

}

