package no.entur.shared.mobility.to.ref.tomp150.dto

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
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action The possible steps are described here<br> `PENDING` - to show whenever the booking is in PENDING state (not confirmed)<br> `WAITING` - to indicate that the TO is processing the booking, optionally after an extension of the expiry time<br> `WAITING_FOR_PAYMENT` - to indicate that the payment hasn't been settled, after an extension of the expiry time with reason payment<br> `CONFIRMED` - to show whenever the booking is in a COMMITTED state (confirmed)<br> `CANCELLED` - to show whenever the booking is cancelled<br> `CONDITIONAL_CONFIRMED` - to show whenever the booking is conditionally confirmed (see process identifiers)<br> `EXPIRED` - to show whenever the booking is expired (the expiry time has passed)<br>
 */
data class BookingStep(

    @Schema(example = "null", description = "the type of the information provided")
    @get:JsonProperty("type") val type: BookingStep.Type? = null,

    @Schema(example = "null", description = "the internet location of the information, used in case or type `URL` or `IMAGE`")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "null", description = "the purpose of the information")
    @get:JsonProperty("goal") val goal: BookingStep.Goal? = null,

    @Schema(example = "null", description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`")
    @get:JsonProperty("text") val text: kotlin.String? = null,

    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    @get:JsonProperty("showTime") val showTime: BookingStep.ShowTime? = null,

    @Schema(example = "null", description = "The possible steps are described here<br> `PENDING` - to show whenever the booking is in PENDING state (not confirmed)<br> `WAITING` - to indicate that the TO is processing the booking, optionally after an extension of the expiry time<br> `WAITING_FOR_PAYMENT` - to indicate that the payment hasn't been settled, after an extension of the expiry time with reason payment<br> `CONFIRMED` - to show whenever the booking is in a COMMITTED state (confirmed)<br> `CANCELLED` - to show whenever the booking is cancelled<br> `CONDITIONAL_CONFIRMED` - to show whenever the booking is conditionally confirmed (see process identifiers)<br> `EXPIRED` - to show whenever the booking is expired (the expiry time has passed)<br>")
    @get:JsonProperty("action") val action: BookingStep.Action? = null
) {

    /**
    * the type of the information provided
    * Values: URL,IMAGE,PLAIN_TEXT,HTML
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        URL("URL"),
        IMAGE("IMAGE"),
        PLAIN_TEXT("PLAIN_TEXT"),
        HTML("HTML");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'BookingStep'")
            }
        }
    }

    /**
    * the purpose of the information
    * Values: INSTRUCTIONS,SALES
    */
    enum class Goal(@get:JsonValue val value: kotlin.String) {

        INSTRUCTIONS("INSTRUCTIONS"),
        SALES("SALES");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Goal {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'BookingStep'")
            }
        }
    }

    /**
    * the moment when the information must be displayed
    * Values: PLANNING,COMMITTED_BOOKING,PREPARE,SET_IN_USE,PAUSE,OPEN_TRUNK,START_FINISHING,FINISH
    */
    enum class ShowTime(@get:JsonValue val value: kotlin.String) {

        PLANNING("PLANNING"),
        COMMITTED_BOOKING("COMMITTED_BOOKING"),
        PREPARE("PREPARE"),
        SET_IN_USE("SET_IN_USE"),
        PAUSE("PAUSE"),
        OPEN_TRUNK("OPEN_TRUNK"),
        START_FINISHING("START_FINISHING"),
        FINISH("FINISH");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ShowTime {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'BookingStep'")
            }
        }
    }

    /**
    * The possible steps are described here<br> `PENDING` - to show whenever the booking is in PENDING state (not confirmed)<br> `WAITING` - to indicate that the TO is processing the booking, optionally after an extension of the expiry time<br> `WAITING_FOR_PAYMENT` - to indicate that the payment hasn't been settled, after an extension of the expiry time with reason payment<br> `CONFIRMED` - to show whenever the booking is in a COMMITTED state (confirmed)<br> `CANCELLED` - to show whenever the booking is cancelled<br> `CONDITIONAL_CONFIRMED` - to show whenever the booking is conditionally confirmed (see process identifiers)<br> `EXPIRED` - to show whenever the booking is expired (the expiry time has passed)<br>
    * Values: PENDING,WAITING_FOR_PAYMENT,CONFIRMED,CONDITIONAL_CONFIRMED,CANCELLED,EXPIRED
    */
    enum class Action(@get:JsonValue val value: kotlin.String) {

        PENDING("PENDING"),
        WAITING_FOR_PAYMENT("WAITING_FOR_PAYMENT"),
        CONFIRMED("CONFIRMED"),
        CONDITIONAL_CONFIRMED("CONDITIONAL_CONFIRMED"),
        CANCELLED("CANCELLED"),
        EXPIRED("EXPIRED");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Action {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'BookingStep'")
            }
        }
    }

}

