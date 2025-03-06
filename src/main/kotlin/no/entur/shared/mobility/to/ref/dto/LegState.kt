package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
* status of a leg
* Values: NOT_STARTED,PREPARING,IN_USE,PAUSED,FINISHING,FINISHED,ISSUE_REPORTED,CANCELLED
*/
enum class LegState(
    @get:JsonValue val value: kotlin.String,
) {
    NOT_STARTED("NOT_STARTED"),
    PREPARING("PREPARING"),
    IN_USE("IN_USE"),
    PAUSED("PAUSED"),
    FINISHING("FINISHING"),
    FINISHED("FINISHED"),
    ISSUE_REPORTED("ISSUE_REPORTED"),
    CANCELLED("CANCELLED"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): LegState = values().first { it -> it.value == value }
    }
}
