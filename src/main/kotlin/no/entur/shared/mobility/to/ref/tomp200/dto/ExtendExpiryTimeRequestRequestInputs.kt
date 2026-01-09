package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
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
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param reason in case operation is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.<br> _PURCHASE_PENDING_ - The internal purchase process on the MP side is not yet finished<br> _PAYMENT_PENDING_ - The customer is in the payment process<br> _OTHER_ - unspecified
 * @param origin This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".
 */
data class ExtendExpiryTimeRequestRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package") val `package`: kotlin.String? = null,

    @Schema(example = "null", description = "in case operation is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.<br> _PURCHASE_PENDING_ - The internal purchase process on the MP side is not yet finished<br> _PAYMENT_PENDING_ - The customer is in the payment process<br> _OTHER_ - unspecified")
    @get:JsonProperty("reason") val reason: ExtendExpiryTimeRequestRequestInputs.Reason? = null,

    @Schema(example = "null", description = "This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".")
    @get:JsonProperty("origin") val origin: ExtendExpiryTimeRequestRequestInputs.Origin? = null
) {

    /**
    * in case operation is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.<br> _PURCHASE_PENDING_ - The internal purchase process on the MP side is not yet finished<br> _PAYMENT_PENDING_ - The customer is in the payment process<br> _OTHER_ - unspecified
    * Values: PURCHASE_PENDING,PAYMENT_PENDING,OTHER
    */
    enum class Reason(@get:JsonValue val value: kotlin.String) {

        PURCHASE_PENDING("PURCHASE_PENDING"),
        PAYMENT_PENDING("PAYMENT_PENDING"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Reason {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ExtendExpiryTimeRequestRequestInputs'")
            }
        }
    }

    /**
    * This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".
    * Values: TO,MP,END_USER,OTHER
    */
    enum class Origin(@get:JsonValue val value: kotlin.String) {

        TO("TO"),
        MP("MP"),
        END_USER("END_USER"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Origin {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ExtendExpiryTimeRequestRequestInputs'")
            }
        }
    }

}

