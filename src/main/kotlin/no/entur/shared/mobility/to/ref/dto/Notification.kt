package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Min

/**
 * notifies the MaaS operator of issues with a booking. Asset information can be provided when needed.
 * @param type
 * @param minutes in case of ETA, the number of minutes until arrival at the pickup location
 * @param asset
 * @param comment free text, should match Content-Language
 * @param legId whenever the booking contains multiple legs, this field is mandatory and contain the id of the leg related to the
 * notification.
 */
data class Notification(
    @Schema(example = "VEHICLE_NOT_AVAILABLE", required = true)
    @get:JsonProperty("type", required = true) val type: Type,
    @get:Min(0)
    @Schema(
        example = "null",
        description = "in case of ETA, the number of minutes until arrival at the pickup location",
    )
    val minutes: Int? = null,
    @field:Valid
    @Schema(example = "null")
    val asset: Asset? = null,
    @Schema(example = "null", description = "free text, should match Content-Language")
    val comment: String? = null,
    @Schema(
        example = "null",
        description = """whenever the booking contains multiple legs, this field is mandatory and contain the id of the leg related to the 
            |notification.""",
    )
    val legId: String? = null,
) {
    enum class Type {
        VEHICLE_NOT_AVAILABLE,
        USER_NO_SHOW,
        ETA,
        MESSAGE_TO_DRIVER,
        MESSAGE_TO_END_USER,
        USER_OUT_OF_LIMITS,
        OTHER,
    }
}
