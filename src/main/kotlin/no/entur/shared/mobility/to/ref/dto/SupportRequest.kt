package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import java.time.OffsetDateTime

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
 * @param urls urls to clarify the support request e.g. pictures showing damage
 */
data class SupportRequest(
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
    @Schema(example = "null")
    val comment: String? = null,
    @get:DecimalMin("0")
    @Schema(example = "null", description = "time to respond in minutes.")
    val requestedResponseTime: Double? = null,
    @Schema(example = "null", description = "urls to clarify the support request e.g. pictures showing damage")
    val urls: List<String>? = null,
) {
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
     * Values: eRRORCANNOTCONTINUE,eRRORCANCONTINUE,dISTURBINGISSUE,qUESTION,oTHER
     */
    enum class Priority {
        ERROR_CANNOT_CONTINUE,
        ERROR_CAN_CONTINUE,
        DISTURBING_ISSUE,
        QUESTION,
        OTHER,
    }
}
