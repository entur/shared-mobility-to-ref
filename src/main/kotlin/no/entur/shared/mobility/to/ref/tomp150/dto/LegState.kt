package no.entur.shared.mobility.to.ref.tomp150.dto

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
* status of a leg
* Values: NOT_STARTED,PREPARING,IN_USE,PAUSED,FINISHING,FINISHED,ISSUE_REPORTED,CANCELLED
*/
enum class LegState(@get:JsonValue val value: kotlin.String) {

    NOT_STARTED("NOT_STARTED"),
    PREPARING("PREPARING"),
    IN_USE("IN_USE"),
    PAUSED("PAUSED"),
    FINISHING("FINISHING"),
    FINISHED("FINISHED"),
    ISSUE_REPORTED("ISSUE_REPORTED"),
    CANCELLED("CANCELLED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): LegState {
                return values().first{it -> it.value == value}
        }
    }
}

