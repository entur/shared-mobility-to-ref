package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema

/**
 * operation on the bookingOption
 * @param operation the operation that is requested. When extra time is needed to complete the initial booking, EXTEND_EXPIRY_TIME can be used. In the response there is the 'Expiry' header field to supply the new expiry timestamp.
 * @param extendReason in case `operation` is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.
 * @param origin This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".
 */
data class BookingOperation(
    @Schema(
        example = "null",
        required = true,
        description = "the operation that is requested. When extra time is needed to complete the initial booking, EXTEND_EXPIRY_TIME can be used. In the response there is the 'Expiry' header field to supply the new expiry timestamp.",
    )
    @get:JsonProperty("operation", required = true) val operation: BookingOperation.Operation,
    @Schema(example = "null", description = "in case `operation` is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.")
    @get:JsonProperty("extendReason") val extendReason: BookingOperation.ExtendReason? = null,
    @Schema(
        example = "null",
        description = "This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".",
    )
    @get:JsonProperty("origin") val origin: BookingOperation.Origin? = null,
) {
    /**
     * the operation that is requested. When extra time is needed to complete the initial booking, EXTEND_EXPIRY_TIME can be used. In the response there is the 'Expiry' header field to supply the new expiry timestamp.
     * Values: CANCEL,DENY,COMMIT,EXTEND_EXPIRY_TIME
     */
    enum class Operation(
        @get:JsonValue val value: kotlin.String,
    ) {
        CANCEL("CANCEL"),
        DENY("DENY"),
        COMMIT("COMMIT"),
        EXTEND_EXPIRY_TIME("EXTEND_EXPIRY_TIME"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Operation = values().first { it -> it.value == value }
        }
    }

    /**
     * in case `operation` is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.
     * Values: BOOKING_PENDING,PAYMENT_PENDING,OTHER
     */
    enum class ExtendReason(
        @get:JsonValue val value: kotlin.String,
    ) {
        BOOKING_PENDING("BOOKING_PENDING"),
        PAYMENT_PENDING("PAYMENT_PENDING"),
        OTHER("OTHER"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ExtendReason = values().first { it -> it.value == value }
        }
    }

    /**
     * This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".
     * Values: TO,MP,END_USER,OTHER
     */
    enum class Origin(
        @get:JsonValue val value: kotlin.String,
    ) {
        TO("TO"),
        MP("MP"),
        END_USER("END_USER"),
        OTHER("OTHER"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Origin = values().first { it -> it.value == value }
        }
    }
}
