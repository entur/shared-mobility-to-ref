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
* _ISSUE_REQUESTED_ the ticket is new, to be processed by the TO<br> _ISSUE_OPEN_ the ticket is open, we're on our way<br> _ISSUE_UPDATE_REQUESTED_ we're waiting on a response of the traveller(s)<br> _ISSUE_RESOLVED_ Issue succesfully closed<br> _ISSUE_REVOKED_ Issue revoked<br>
* Values: ISSUE_REQUESTED,ISSUE_OPEN,ISSUE_UPDATE_REQUESTED,ISSUE_RESOLVED,ISSUE_REVOKED
*/
enum class SupportTicketStatus(@get:JsonValue val value: kotlin.String) {

    ISSUE_REQUESTED("ISSUE_REQUESTED"),
    ISSUE_OPEN("ISSUE_OPEN"),
    ISSUE_UPDATE_REQUESTED("ISSUE_UPDATE_REQUESTED"),
    ISSUE_RESOLVED("ISSUE_RESOLVED"),
    ISSUE_REVOKED("ISSUE_REVOKED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): SupportTicketStatus {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SupportTicketStatus'")
        }
    }
}

