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
 * 
 * @param alertId a unique identifier for this alert
 * @param alertType 
 * @param summary A short summary of this alert to be displayed to the customer, should match Content-Language
 * @param startAndEndTimes Array of hashes with the keys \"start\" and \"end\" indicating when the alert is in effect (e.g. when the system or station is actually closed, or when it is scheduled to be moved). If this array is omitted then the alert should be displayed as long as it is in the feed.
 * @param stationIds Array of strings - If this is an alert that affects one or more stations, include their ids, otherwise omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system
 * @param regionId Array of strings - If this system has regions, and if this alert only affects certain regions, include their ids, otherwise, omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system
 * @param url URL where the customer can learn more information about this alert, if there is one
 * @param description Detailed text description of the alert, should match Content-Language
 * @param lastUpdated 
 */
data class SystemAlert(

    @Schema(example = "null", required = true, description = "a unique identifier for this alert")
    @get:JsonProperty("alertId", required = true) val alertId: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("alertType", required = true) val alertType: SystemAlert.AlertType,

    @Schema(example = "station closed", required = true, description = "A short summary of this alert to be displayed to the customer, should match Content-Language")
    @get:JsonProperty("summary", required = true) val summary: kotlin.String,

    @Schema(example = "null", description = "Array of hashes with the keys \"start\" and \"end\" indicating when the alert is in effect (e.g. when the system or station is actually closed, or when it is scheduled to be moved). If this array is omitted then the alert should be displayed as long as it is in the feed.")
    @get:JsonProperty("startAndEndTimes") val startAndEndTimes: kotlin.collections.List<kotlin.collections.List<java.time.OffsetDateTime>>? = null,

    @Schema(example = "[\"stationID0001\"]", description = "Array of strings - If this is an alert that affects one or more stations, include their ids, otherwise omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system")
    @get:JsonProperty("stationIds") val stationIds: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "[\"regionID0001\"]", description = "Array of strings - If this system has regions, and if this alert only affects certain regions, include their ids, otherwise, omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system")
    @get:JsonProperty("regionId") val regionId: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "http://www.rentmyfreebike.com/alerts", description = "URL where the customer can learn more information about this alert, if there is one")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "station closed indefinitely due to vandalism", description = "Detailed text description of the alert, should match Content-Language")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lastUpdated") val lastUpdated: java.time.OffsetDateTime? = null
    ) {

    /**
    * 
    * Values: SYSTEM_CLOSURE,STATION_CLOSURE,STATION_MOVE,OTHER
    */
    enum class AlertType(@get:JsonValue val value: kotlin.String) {

        SYSTEM_CLOSURE("SYSTEM_CLOSURE"),
        STATION_CLOSURE("STATION_CLOSURE"),
        STATION_MOVE("STATION_MOVE"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): AlertType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SystemAlert'")
            }
        }
    }

}

