package no.entur.shared.mobility.to.ref.tomp160.dto

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
* status of a CUSTOMER ACCOUNT<br> _CREATED_ the customer account has been created but is not ready to create a purchase yet<br> _TO_PENDING_VALIDATION_ the customer account is pending a verification of identity and properties by the TO. No purchases can be made in this step<br> _OTP_REQUIRED_ the TO has sent an OTP to the customer's phone or email address and is expecting it to activate the account. No purchases can be made in this step<br> _ACTIVE_ the customer account is active and can continue to purchase offers<br> _BLOCKED_ the customer account has been blocked by the TO and can no longer use this TO<br>
* Values: CREATED,TO_PENDING_VALIDATION,ACTIVE,BLOCKED
*/
enum class CustomerAccountStatus(@get:JsonValue val value: kotlin.String) {

    CREATED("CREATED"),
    TO_PENDING_VALIDATION("TO_PENDING_VALIDATION"),
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): CustomerAccountStatus {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'CustomerAccountStatus'")
        }
    }
}

