package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
* They are there for filtering purposes in the journal entry endpoint.
* Values: ALL,DAMAGE,LOSS,STOLEN,EXTRA_USAGE,REFUND,FINE,OTHER_ASSET_USED,CREDIT,VOUCHER,DEPOSIT,OTHER,FARE
*/
enum class JournalCategory(
    @get:JsonValue val value: kotlin.String,
) {
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
    FARE("FARE"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): JournalCategory = values().first { it -> it.value == value }
    }
}
