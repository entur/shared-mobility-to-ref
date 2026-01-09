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
* Values: SYNC_EXECUTE,ASYNC_EXECUTE,DISMISS
*/
enum class JobControlOptions(@get:JsonValue val value: kotlin.String) {

    SYNC_EXECUTE("sync-execute"),
    ASYNC_EXECUTE("async-execute"),
    DISMISS("dismiss");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): JobControlOptions {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'JobControlOptions'")
        }
    }
}

