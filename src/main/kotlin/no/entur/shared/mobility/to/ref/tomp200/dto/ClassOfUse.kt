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
* A classification of fare and other service classes by category of user entitled to use them.
* Values: FIRST_CLASS,SECOND_CLASS,THIRD_CLASS,ECONOMY_CLASS,BUSINESS_CLASS,TURISTA,PREFERENTE,PREMIUM_CLASS,ANY,UNKNOWN
*/
enum class ClassOfUse(@get:JsonValue val value: kotlin.String) {

    FIRST_CLASS("FIRST_CLASS"),
    SECOND_CLASS("SECOND_CLASS"),
    THIRD_CLASS("THIRD_CLASS"),
    ECONOMY_CLASS("ECONOMY_CLASS"),
    BUSINESS_CLASS("BUSINESS_CLASS"),
    TURISTA("TURISTA"),
    PREFERENTE("PREFERENTE"),
    PREMIUM_CLASS("PREMIUM_CLASS"),
    ANY("ANY"),
    UNKNOWN("UNKNOWN");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): ClassOfUse {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ClassOfUse'")
        }
    }
}

