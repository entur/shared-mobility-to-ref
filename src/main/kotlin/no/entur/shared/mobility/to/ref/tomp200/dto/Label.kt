package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
* Values: REFUNDABLE,EXCHANGABLE,CANCELLABLE,TRANSFERABLE,DEPOSIT_REQUIRED,ANCILLARIES_INCLUDED,ANCILLARIES_REQUIRED,PAY_WHEN_FINISHED,PURCHASE_TO_BE_CONFIRMED,REQUIRES_PERSONAL_DATA,MANDATORY_ENTRY_INSTRUCTIONS,MANDATORY_EXIT_INSTRUCTIONS,MANDATORY_PAUSING_INSTRUCTIONS,ROUND_TRIP,UPFRONT_PAYMENT
*/
enum class Label(@get:JsonValue val value: kotlin.String) {

    REFUNDABLE("REFUNDABLE"),
    EXCHANGABLE("EXCHANGABLE"),
    CANCELLABLE("CANCELLABLE"),
    TRANSFERABLE("TRANSFERABLE"),
    DEPOSIT_REQUIRED("DEPOSIT_REQUIRED"),
    ANCILLARIES_INCLUDED("ANCILLARIES_INCLUDED"),
    ANCILLARIES_REQUIRED("ANCILLARIES_REQUIRED"),
    PAY_WHEN_FINISHED("PAY_WHEN_FINISHED"),
    PURCHASE_TO_BE_CONFIRMED("PURCHASE_TO_BE_CONFIRMED"),
    REQUIRES_PERSONAL_DATA("REQUIRES_PERSONAL_DATA"),
    MANDATORY_ENTRY_INSTRUCTIONS("MANDATORY_ENTRY_INSTRUCTIONS"),
    MANDATORY_EXIT_INSTRUCTIONS("MANDATORY_EXIT_INSTRUCTIONS"),
    MANDATORY_PAUSING_INSTRUCTIONS("MANDATORY_PAUSING_INSTRUCTIONS"),
    ROUND_TRIP("ROUND_TRIP"),
    UPFRONT_PAYMENT("UPFRONT_PAYMENT");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): Label {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Label'")
        }
    }
}

