package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
*
* Values: POSTPONED_COMMIT,DEPOSIT,PAY_WHEN_FINISHED,REQUIRE_BOOKING_DATA,RETURN_AREA,UPFRONT_PAYMENT
*/
enum class Scenario(
    @get:JsonValue val value: kotlin.String,
) {
    POSTPONED_COMMIT("POSTPONED_COMMIT"),
    DEPOSIT("DEPOSIT"),
    PAY_WHEN_FINISHED("PAY_WHEN_FINISHED"),
    REQUIRE_BOOKING_DATA("REQUIRE_BOOKING_DATA"),
    RETURN_AREA("RETURN_AREA"),
    UPFRONT_PAYMENT("UPFRONT_PAYMENT"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): Scenario = values().first { it -> it.value == value }
    }
}
