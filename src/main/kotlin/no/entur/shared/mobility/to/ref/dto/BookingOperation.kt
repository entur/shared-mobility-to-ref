package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * operation on the bookingOption
 * @param operation the operation that is requested. When extra time is needed to complete the initial booking, EXTEND_EXPIRY_TIME can
 * be used. In the response there is the 'Expiry' header field to supply the new expiry timestamp.
 * @param extendReason in case `operation` is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.
 * @param origin This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking
 * for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending,
 * this field should contain \"MP\". And in case the TO is sending, \"TO\".
 */
data class BookingOperation(
    @Schema(
        example = "null",
        required = true,
        description =
            "the operation that is requested. When extra time is needed to complete the initial booking, EXTEND_EXPIRY_TIME " +
                "can be used. In the response there is the 'Expiry' header field to supply the new expiry timestamp.",
    )
    @get:JsonProperty("operation", required = true) val operation: Operation,
    @Schema(
        example = "null",
        description = "in case `operation` is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.",
    )
    val extendReason: ExtendReason? = null,
    @Schema(
        example = "null",
        description =
            "This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this " +
                "booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the " +
                "MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".",
    )
    val origin: Origin? = null,
) {
    /**
     * the operation that is requested. When extra time is needed to complete the initial booking, EXTEND_EXPIRY_TIME can be used.
     * In the response there is the 'Expiry' header field to supply the new expiry timestamp.
     * Values: cANCEL,dENY,cOMMIT,eXTENDEXPIRYTIME
     */
    enum class Operation {
        CANCEL,
        DENY,
        COMMIT,
        EXTEND_EXPIRY_TIME,
    }

    /**
     * in case `operation` is EXTEND_EXPIRY_TIME, the reason for extension must be supplied here.
     * Values: bOOKINGPENDING,pAYMENTPENDING,oTHER
     */
    enum class ExtendReason {
        BOOKING_PENDING,
        PAYMENT_PENDING,
        OTHER,
    }

    /**
     * This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me);
     * to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field
     * should contain \"MP\". And in case the TO is sending, \"TO\".
     * Values: tO,mP,eNDUSER,oTHER
     */
    enum class Origin {
        TO,
        MP,
        END_USER,
        OTHER,
    }
}
