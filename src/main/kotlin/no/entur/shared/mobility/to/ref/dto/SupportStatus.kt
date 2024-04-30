package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import java.time.OffsetDateTime

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
    @Schema(example = "PROCESSING")
    val status: Status? = null,
    @Schema(example = "9", description = "time in minutes to expected resolution of support request")
    val timeToResolution: Int? = null,
    @get:Min(0)
    @Schema(example = "null", description = "the sequence number of status of the support issue")
    val order: Int? = null,
    @Schema(example = "null", description = "free text to send to the end user.")
    val comment: String? = null,
    @Schema(example = "null", description = "the booking id")
    val id: String? = null,
    @Schema(example = "null")
    val supportType: SupportType? = null,
    @field:Valid
    @Schema(example = "null")
    val location: Place? = null,
    @Schema(example = "null")
    val time: OffsetDateTime? = null,
    @Schema(example = "null", description = "the priority of the support request.")
    val priority: Priority? = null,
    @Schema(
        example = "null",
        description = "contact information of the end user in case of direct response requests, like phone number",
    )
    val contactInformationEndUser: String? = null,
    @get:DecimalMin("0")
    @Schema(example = "null", description = "time to respond in minutes.")
    val requestedResponseTime: Double? = null,
    @Schema(example = "null", description = "urls to clarify the support request e.g. pictures showing damage")
    val urls: List<String>? = null,
) {
    enum class Status {
        PROCESSING,
        UPDATE_REQUESTED,
        RESOLVED,
        CANCELLED,
    }

    enum class SupportType {
        BROKEN_DOWN,
        NOT_AT_LOCATION,
        MISSING_AFTER_PAUSE,
        NOT_CLEAN,
        NOT_AVAILABLE,
        UNABLE_TO_OPEN,
        UNABLE_TO_CLOSE,
        API_TECHNICAL,
        API_FUNCTIONAL,
        ACCIDENT,
        OTHER,
    }

    /**
     * the priority of the support request.
     */
    enum class Priority {
        ERROR_CANNOT_CONTINUE,
        ERROR_CAN_CONTINUE,
        DISTURBING_ISSUE,
        QUESTION,
        OTHER,
    }
}
