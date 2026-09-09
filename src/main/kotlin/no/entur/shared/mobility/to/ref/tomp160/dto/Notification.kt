package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.Asset
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
 * notifies the MaaS operator of issues with a booking. Asset information can be provided when needed.
 * @param type 
 * @param minutes in case of ETA, the number of minutes until arrival at the pickup location
 * @param asset 
 * @param comment free text, should match Content-Language
 * @param legId whenever the booking contains multiple legs, this field is mandatory and contain the id of the leg related to the notification.
 */
data class Notification(

    @Schema(example = "VEHICLE_NOT_AVAILABLE", required = true, description = "")
    @param:JsonProperty("type")
    @get:JsonProperty("type", required = true) val type: Notification.Type,

    @get:Min(value=0)
    @Schema(description = "in case of ETA, the number of minutes until arrival at the pickup location")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("minutes")
    @get:JsonProperty("minutes") val minutes: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("asset")
    @get:JsonProperty("asset") val asset: Asset? = null,

    @Schema(description = "free text, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("comment")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @Schema(description = "whenever the booking contains multiple legs, this field is mandatory and contain the id of the leg related to the notification.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("legId")
    @get:JsonProperty("legId") val legId: kotlin.String? = null
) {

    /**
    * 
    * Values: VEHICLE_NOT_AVAILABLE,USER_NO_SHOW,ETA,MESSAGE_TO_DRIVER,MESSAGE_TO_END_USER,USER_OUT_OF_LIMITS,OTHER
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        VEHICLE_NOT_AVAILABLE("VEHICLE_NOT_AVAILABLE"),
        USER_NO_SHOW("USER_NO_SHOW"),
        ETA("ETA"),
        MESSAGE_TO_DRIVER("MESSAGE_TO_DRIVER"),
        MESSAGE_TO_END_USER("MESSAGE_TO_END_USER"),
        USER_OUT_OF_LIMITS("USER_OUT_OF_LIMITS"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Type'")
            }
        }
    }

}

