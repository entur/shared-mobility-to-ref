package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Damage
import no.entur.shared.mobility.to.ref.tomp200.dto.Links
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicketContext
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicketStatus
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
 * @param type 
 * @param supportType these are the currently enlisted support requests<br> _BROKEN_DOWN_ The asset doesn't work anymore<br> _NOT_AT_LOCATION_ The asset isn't available at the specified time/location<br> _MISSING_AFTER_PAUSE_ The asset is missing (stolen?)<br> _NOT_CLEAN_ The asset is not clean<br> _NOT_AVAILABLE_ The asset is at the location, but unreachable<br> _UNABLE_TO_OPEN_ The asset cannot be unlocked (malfunctioning)<br> _UNABLE_TO_CLOSE_ The asset cannot be closed (malfunctioning)<br> _ACCIDENT_ Accident occurred<br> _OTHER_ unspecified<br> _REPORT_DAMAGE_ Oeps. Photo sent with slight damage<br> _REQUEST_ASSISTANCE_ request personal assistance, e.g. to get into the train<br> _EVIDENCE_ Send evidence to the TO for redress functions<br>
 * @param location this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param timestamp https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param id https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param status 
 * @param context 
 * @param priority the priority of the support request.
 * @param contactInformationEndUser default string, full names etc (length 0-200)
 * @param comment long string, memos etc (length 0-10.000)
 * @param urls urls to clarify the support request e.g. pictures showing damage or digital scans with evidence documents
 * @param requestedResponseTime a bit short integer (0-100)
 * @param timeToResolution a bit short integer (0-100)
 * @param damage 
 * @param sequence for really small numbers (0-10)
 * @param links 
 */
data class SupportTicket(

    @get:Pattern(regexp="^(supportTicket)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @Schema(example = "null", required = true, description = "these are the currently enlisted support requests<br> _BROKEN_DOWN_ The asset doesn't work anymore<br> _NOT_AT_LOCATION_ The asset isn't available at the specified time/location<br> _MISSING_AFTER_PAUSE_ The asset is missing (stolen?)<br> _NOT_CLEAN_ The asset is not clean<br> _NOT_AVAILABLE_ The asset is at the location, but unreachable<br> _UNABLE_TO_OPEN_ The asset cannot be unlocked (malfunctioning)<br> _UNABLE_TO_CLOSE_ The asset cannot be closed (malfunctioning)<br> _ACCIDENT_ Accident occurred<br> _OTHER_ unspecified<br> _REPORT_DAMAGE_ Oeps. Photo sent with slight damage<br> _REQUEST_ASSISTANCE_ request personal assistance, e.g. to get into the train<br> _EVIDENCE_ Send evidence to the TO for redress functions<br>")
    @get:JsonProperty("supportType", required = true) val supportType: SupportTicket.SupportType,

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("location", required = true) val location: kotlin.String,

    @Schema(example = "null", required = true, description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("timestamp", required = true) val timestamp: java.time.OffsetDateTime,

    @Schema(example = "null", description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("status") val status: SupportTicketStatus? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("context") val context: SupportTicketContext? = null,

    @Schema(example = "null", description = "the priority of the support request.")
    @get:JsonProperty("priority") val priority: SupportTicket.Priority? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("contactInformationEndUser") val contactInformationEndUser: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @field:Valid
    @get:Size(max=10)
    @Schema(example = "null", description = "urls to clarify the support request e.g. pictures showing damage or digital scans with evidence documents")
    @get:JsonProperty("urls") val urls: kotlin.collections.List<java.net.URI>? = null,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "a bit short integer (0-100)")
    @get:JsonProperty("requestedResponseTime") val requestedResponseTime: kotlin.Int? = 0,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "a bit short integer (0-100)")
    @get:JsonProperty("timeToResolution") val timeToResolution: kotlin.Int? = 0,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("damage") val damage: Damage? = null,

    @get:Min(0)
    @get:Max(10)
    @Schema(example = "null", description = "for really small numbers (0-10)")
    @get:JsonProperty("sequence") val sequence: kotlin.Int? = 0,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("links") val links: Links? = null
) {

    /**
    * these are the currently enlisted support requests<br> _BROKEN_DOWN_ The asset doesn't work anymore<br> _NOT_AT_LOCATION_ The asset isn't available at the specified time/location<br> _MISSING_AFTER_PAUSE_ The asset is missing (stolen?)<br> _NOT_CLEAN_ The asset is not clean<br> _NOT_AVAILABLE_ The asset is at the location, but unreachable<br> _UNABLE_TO_OPEN_ The asset cannot be unlocked (malfunctioning)<br> _UNABLE_TO_CLOSE_ The asset cannot be closed (malfunctioning)<br> _ACCIDENT_ Accident occurred<br> _OTHER_ unspecified<br> _REPORT_DAMAGE_ Oeps. Photo sent with slight damage<br> _REQUEST_ASSISTANCE_ request personal assistance, e.g. to get into the train<br> _EVIDENCE_ Send evidence to the TO for redress functions<br>
    * Values: BROKEN_DOWN,NOT_AT_LOCATION,MISSING_AFTER_PAUSE,NOT_CLEAN,NOT_AVAILABLE,UNABLE_TO_OPEN,UNABLE_TO_CLOSE,ACCIDENT,OTHER,REPORT_DAMAGE,REQUEST_ASSISTANCE,EVIDENCE
    */
    enum class SupportType(@get:JsonValue val value: kotlin.String) {

        BROKEN_DOWN("BROKEN_DOWN"),
        NOT_AT_LOCATION("NOT_AT_LOCATION"),
        MISSING_AFTER_PAUSE("MISSING_AFTER_PAUSE"),
        NOT_CLEAN("NOT_CLEAN"),
        NOT_AVAILABLE("NOT_AVAILABLE"),
        UNABLE_TO_OPEN("UNABLE_TO_OPEN"),
        UNABLE_TO_CLOSE("UNABLE_TO_CLOSE"),
        ACCIDENT("ACCIDENT"),
        OTHER("OTHER"),
        REPORT_DAMAGE("REPORT_DAMAGE"),
        REQUEST_ASSISTANCE("REQUEST_ASSISTANCE"),
        EVIDENCE("EVIDENCE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): SupportType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportTicket'")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportTicket'")
            }
        }
    }

}

