package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.Damage
import no.entur.shared.mobility.to.ref.tomp160.dto.Place
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
 * request for support
 * @param id the booking id
 * @param supportType 
 * @param location 
 * @param time 
 * @param priority the priority of the support request.
 * @param contactInformationEndUser contact information of the end user in case of direct response requests, like phone number
 * @param comment 
 * @param requestedResponseTime time to respond in minutes.
 * @param damage 
 * @param urls urls to clarify the support request e.g. pictures showing damage
 * @param assetId the (visual) ID on the asset, to report damage on an asset that hasn't been booked.
 */
data class SupportRequest(

    @Schema(description = "the booking id")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("id")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("supportType")
    @get:JsonProperty("supportType") val supportType: SupportRequest.SupportType? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("location")
    @get:JsonProperty("location") val location: Place? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("time")
    @get:JsonProperty("time") val time: java.time.OffsetDateTime? = null,

    @Schema(description = "the priority of the support request.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("priority")
    @get:JsonProperty("priority") val priority: SupportRequest.Priority? = null,

    @Schema(description = "contact information of the end user in case of direct response requests, like phone number")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("contactInformationEndUser")
    @get:JsonProperty("contactInformationEndUser") val contactInformationEndUser: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("comment")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @get:DecimalMin(value="0")
    @Schema(description = "time to respond in minutes.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("requestedResponseTime")
    @get:JsonProperty("requestedResponseTime") val requestedResponseTime: kotlin.Double? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("damage")
    @get:JsonProperty("damage") val damage: Damage? = null,

    @Schema(description = "urls to clarify the support request e.g. pictures showing damage")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("urls")
    @get:JsonProperty("urls") val urls: kotlin.collections.List<kotlin.String>? = null,

    @Schema(description = "the (visual) ID on the asset, to report damage on an asset that hasn't been booked.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("assetId")
    @get:JsonProperty("assetId") val assetId: kotlin.String? = null
) {

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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportType'")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Priority'")
            }
        }
    }

}

