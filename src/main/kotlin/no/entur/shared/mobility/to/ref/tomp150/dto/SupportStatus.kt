package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.Place
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
 * the current status of support
 * @param status 
 * @param timeToResolution time in minutes to expected resolution of support request
 * @param order the sequence number of status of the support issue
 * @param comment free text to send to the end user.
 * @param id the booking id
 * @param supportType 
 * @param location 
 * @param time 
 * @param priority the priority of the support request.
 * @param contactInformationEndUser contact information of the end user in case of direct response requests, like phone number
 * @param requestedResponseTime time to respond in minutes.
 * @param urls urls to clarify the support request e.g. pictures showing damage
 */
data class SupportStatus(

    @Schema(example = "PROCESSING", description = "")
    @get:JsonProperty("status") val status: SupportStatus.Status? = null,

    @Schema(example = "9", description = "time in minutes to expected resolution of support request")
    @get:JsonProperty("timeToResolution") val timeToResolution: kotlin.Int? = null,

    @get:Min(0)
    @Schema(example = "null", description = "the sequence number of status of the support issue")
    @get:JsonProperty("order") val order: kotlin.Int? = null,

    @Schema(example = "null", description = "free text to send to the end user.")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @Schema(example = "null", description = "the booking id")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("supportType") val supportType: SupportStatus.SupportType? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("location") val location: Place? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("time") val time: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "the priority of the support request.")
    @get:JsonProperty("priority") val priority: SupportStatus.Priority? = null,

    @Schema(example = "null", description = "contact information of the end user in case of direct response requests, like phone number")
    @get:JsonProperty("contactInformationEndUser") val contactInformationEndUser: kotlin.String? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "time to respond in minutes.")
    @get:JsonProperty("requestedResponseTime") val requestedResponseTime: kotlin.Double? = null,

    @Schema(example = "null", description = "urls to clarify the support request e.g. pictures showing damage")
    @get:JsonProperty("urls") val urls: kotlin.collections.List<kotlin.String>? = null
) {

    /**
    * 
    * Values: PROCESSING,UPDATE_REQUESTED,RESOLVED,CANCELLED
    */
    enum class Status(@get:JsonValue val value: kotlin.String) {

        PROCESSING("PROCESSING"),
        UPDATE_REQUESTED("UPDATE_REQUESTED"),
        RESOLVED("RESOLVED"),
        CANCELLED("CANCELLED");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Status {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportStatus'")
            }
        }
    }

    /**
    * 
    * Values: BROKEN_DOWN,NOT_AT_LOCATION,MISSING_AFTER_PAUSE,NOT_CLEAN,NOT_AVAILABLE,UNABLE_TO_OPEN,UNABLE_TO_CLOSE,API_TECHNICAL,API_FUNCTIONAL,ACCIDENT,OTHER
    */
    enum class SupportType(@get:JsonValue val value: kotlin.String) {

        BROKEN_DOWN("BROKEN_DOWN"),
        NOT_AT_LOCATION("NOT_AT_LOCATION"),
        MISSING_AFTER_PAUSE("MISSING_AFTER_PAUSE"),
        NOT_CLEAN("NOT_CLEAN"),
        NOT_AVAILABLE("NOT_AVAILABLE"),
        UNABLE_TO_OPEN("UNABLE_TO_OPEN"),
        UNABLE_TO_CLOSE("UNABLE_TO_CLOSE"),
        API_TECHNICAL("API_TECHNICAL"),
        API_FUNCTIONAL("API_FUNCTIONAL"),
        ACCIDENT("ACCIDENT"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): SupportType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportStatus'")
            }
        }
    }

    /**
    * the priority of the support request.
    * Values: ERROR_CANNOT_CONTINUE,ERROR_CAN_CONTINUE,DISTURBING_ISSUE,QUESTION,OTHER
    */
    enum class Priority(@get:JsonValue val value: kotlin.String) {

        ERROR_CANNOT_CONTINUE("ERROR_CANNOT_CONTINUE"),
        ERROR_CAN_CONTINUE("ERROR_CAN_CONTINUE"),
        DISTURBING_ISSUE("DISTURBING_ISSUE"),
        QUESTION("QUESTION"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Priority {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportStatus'")
            }
        }
    }

}

