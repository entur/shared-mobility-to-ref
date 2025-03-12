package no.entur.shared.mobility.to.ref.tomp160.dto

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
* The life-cycle state of the booking (from NEW to FINISHED)
* Values: NEW,PENDING,REJECTED,RELEASED,EXPIRED,CONDITIONAL_CONFIRMED,CONFIRMED,CANCELLED,STARTED,FINISHED
*/
enum class BookingState(@get:JsonValue val value: kotlin.String) {

    NEW("NEW"),
    PENDING("PENDING"),
    REJECTED("REJECTED"),
    RELEASED("RELEASED"),
    EXPIRED("EXPIRED"),
    CONDITIONAL_CONFIRMED("CONDITIONAL_CONFIRMED"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    STARTED("STARTED"),
    FINISHED("FINISHED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): BookingState {
                return values().first{it -> it.value == value}
        }
    }
}

