package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
*
* Values: TO_INVOICE,INVOICED
*/
enum class JournalState(
    @get:JsonValue val value: kotlin.String,
) {
    TO_INVOICE("TO_INVOICE"),
    INVOICED("INVOICED"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): JournalState = values().first { it -> it.value == value }
    }
}
