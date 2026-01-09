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
* status of a leg<br> _NOT_STARTED_ the leg is not started, initial state<br> _PREPARING_ the _PREPARE_ operation has been received<br> _READY_TO_USE_ the leg is ready to use<br> _IN_USE_ the travellers are on their way<br> _PAUSED_ the asset is paused<br> _ENDING_ the end-leg request is received, the offboarding process has is started<br> _ENDED_ the travellers have arrived at their destination, leg is final<br> _ISSUE_REPORTED_ due to an issue, there is (temporarily) no progress to report, when the issue isn't solved, this is a final state<br> _CANCELLED_ the leg has been cancelled, before execution<br> _ABENDED_ the leg is abnormally ended (e.g. due to an issue)
* Values: NOT_STARTED,PREPARING,READY_TO_USE,IN_USE,PAUSED,ENDED,ISSUE_REPORTED,CANCELLED,ABENDED
*/
enum class LegStatus(@get:JsonValue val value: kotlin.String) {

    NOT_STARTED("NOT_STARTED"),
    PREPARING("PREPARING"),
    READY_TO_USE("READY_TO_USE"),
    IN_USE("IN_USE"),
    PAUSED("PAUSED"),
    ENDED("ENDED"),
    ISSUE_REPORTED("ISSUE_REPORTED"),
    CANCELLED("CANCELLED"),
    ABENDED("ABENDED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): LegStatus {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'LegStatus'")
        }
    }
}

