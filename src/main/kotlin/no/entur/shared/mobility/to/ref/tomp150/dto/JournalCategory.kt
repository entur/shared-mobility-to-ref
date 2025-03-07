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
* They are there for filtering purposes in the journal entry endpoint.
* Values: ALL,DAMAGE,LOSS,STOLEN,EXTRA_USAGE,REFUND,FINE,OTHER_ASSET_USED,CREDIT,VOUCHER,DEPOSIT,OTHER,FARE
*/
enum class JournalCategory(@get:JsonValue val value: kotlin.String) {

    ALL("ALL"),
    DAMAGE("DAMAGE"),
    LOSS("LOSS"),
    STOLEN("STOLEN"),
    EXTRA_USAGE("EXTRA_USAGE"),
    REFUND("REFUND"),
    FINE("FINE"),
    OTHER_ASSET_USED("OTHER_ASSET_USED"),
    CREDIT("CREDIT"),
    VOUCHER("VOUCHER"),
    DEPOSIT("DEPOSIT"),
    OTHER("OTHER"),
    FARE("FARE");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): JournalCategory {
                return values().first{it -> it.value == value}
        }
    }
}

