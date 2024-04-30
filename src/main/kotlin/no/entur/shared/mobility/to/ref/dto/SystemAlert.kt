package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.time.OffsetDateTime

/**
 *
 * @param alertId a unique identifier for this alert
 * @param alertType
 * @param summary A short summary of this alert to be displayed to the customer, should match Content-Language
 * @param startAndEndTimes Array of hashes with the keys \"start\" and \"end\" indicating when the alert is in effect (e.g. when the system
 * or station is actually closed, or when it is scheduled to be moved). If this array is omitted then the alert should be displayed as long
 * as it is in the feed.
 * @param stationIds Array of strings - If this is an alert that affects one or more stations, include their ids, otherwise omit this
 * field.
 * If both stationIDs and regionIDs are omitted, assume this alert affects the entire system
 * @param regionId Array of strings - If this system has regions, and if this alert only affects certain regions, include their ids,
 * otherwise, omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system
 * @param url URL where the customer can learn more information about this alert, if there is one
 * @param description Detailed text description of the alert, should match Content-Language
 * @param lastUpdated
 */
data class SystemAlert(
    @Schema(example = "null", required = true, description = "a unique identifier for this alert")
    @get:JsonProperty("alertId", required = true) val alertId: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty("alertType", required = true) val alertType: AlertType,
    @Schema(
        example = "station closed",
        required = true,
        description = "A short summary of this alert to be displayed to the customer, should match Content-Language",
    )
    @get:JsonProperty("summary", required = true) val summary: String,
    @Schema(
        example = "null",
        description = """Array of hashes with the keys "start" and "end" indicating when the alert is in effect (e.g. when the system or 
            |station is actually closed, or when it is scheduled to be moved). If this array is omitted then the alert should be displayed 
            |as long as it is in the feed.""",
    )
    val startAndEndTimes: List<List<OffsetDateTime>>? = null,
    @Schema(
        example = "[\"stationID0001\"]",
        description = """Array of strings - If this is an alert that affects one or more stations, include their ids, otherwise omit this 
            |field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system""",
    )
    val stationIds: List<String>? = null,
    @Schema(
        example = "[\"regionID0001\"]",
        description = """Array of strings - If this system has regions, and if this alert only affects certain regions, include their ids, 
            |otherwise, omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system""",
    )
    val regionId: List<String>? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/alerts",
        description = "URL where the customer can learn more information about this alert, if there is one",
    )
    val url: String? = null,
    @Schema(
        example = "station closed indefinitely due to vandalism",
        description = "Detailed text description of the alert, should match Content-Language",
    )
    val description: String? = null,
    @Schema(example = "null")
    val lastUpdated: OffsetDateTime? = null,
) {
    enum class AlertType {
        SYSTEM_CLOSURE,
        STATION_CLOSURE,
        STATION_MOVE,
        OTHER,
    }
}
