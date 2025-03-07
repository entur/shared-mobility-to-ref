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
* 
* Values: POSTPONED_COMMIT,DEPOSIT,PAY_WHEN_FINISHED,REQUIRE_BOOKING_DATA,RETURN_AREA,UPFRONT_PAYMENT
*/
enum class Scenario(@get:JsonValue val value: kotlin.String) {

    POSTPONED_COMMIT("POSTPONED_COMMIT"),
    DEPOSIT("DEPOSIT"),
    PAY_WHEN_FINISHED("PAY_WHEN_FINISHED"),
    REQUIRE_BOOKING_DATA("REQUIRE_BOOKING_DATA"),
    RETURN_AREA("RETURN_AREA"),
    UPFRONT_PAYMENT("UPFRONT_PAYMENT");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): Scenario {
                return values().first{it -> it.value == value}
        }
    }
}

