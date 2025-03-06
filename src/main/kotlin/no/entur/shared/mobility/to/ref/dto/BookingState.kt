package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
* The life-cycle state of the booking (from NEW to FINISHED)
* Values: NEW,PENDING,REJECTED,RELEASED,EXPIRED,CONDITIONAL_CONFIRMED,CONFIRMED,CANCELLED,STARTED,FINISHED
*/
enum class BookingState(
    @get:JsonValue val value: kotlin.String,
) {
    NEW("NEW"),
    PENDING("PENDING"),
    REJECTED("REJECTED"),
    RELEASED("RELEASED"),
    EXPIRED("EXPIRED"),
    CONDITIONAL_CONFIRMED("CONDITIONAL_CONFIRMED"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    STARTED("STARTED"),
    FINISHED("FINISHED"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): BookingState = values().first { it -> it.value == value }
    }
}
