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
* The life-cycle state of the package<br> _OFFERED_ the package is offered (pre-sales) <br> _PENDING_ the purchase of the package is not confirmed (the end user has shown intentions to purchase this offer), must be finalized with the package-confirm operation (purchase)<br> _CONFIRMED_ a purchased package. Both parties agreed to deliver services in return of payment<br> _CANCELLED_ the package is cancelled before it is executed. The agreement will specify whether there is a refund, or under which conditions<br> _ROLLBACK_ the package is purchased, but before the Rollback-Expires timestamp has passed, therefore no financial consequences<br> _EXPIRED_ the MP didn't respond on time, the package offer has been expired<br> _STARTED_ the package is started, the <u>trip execution</u> module is needed now to manage the execution of the package<br> _ENDED_ the package has ended, the trip has been executed<br> _RELEASED_ for internal archiving, the package has not been purchased.<br> _SETTLED_ final exit state, services delivered & financial settlement succeeded.
* Values: OFFERED,PENDING,CONFIRMED,ROLLBACK,RELEASED,EXPIRED,CANCELLED,STARTED,ENDED,SETTLED
*/
enum class PackageStatus(@get:JsonValue val value: kotlin.String) {

    OFFERED("OFFERED"),
    PENDING("PENDING"),
    CONFIRMED("CONFIRMED"),
    ROLLBACK("ROLLBACK"),
    RELEASED("RELEASED"),
    EXPIRED("EXPIRED"),
    CANCELLED("CANCELLED"),
    STARTED("STARTED"),
    ENDED("ENDED"),
    SETTLED("SETTLED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): PackageStatus {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PackageStatus'")
        }
    }
}

