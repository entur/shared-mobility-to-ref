package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action The possible steps are described here<br>
 * `PENDING` - to show whenever the booking is in PENDING state (not confirmed)<br>
 * `WAITING` - to indicate that the TO is processing the booking, optionally after an extension of the expiry time<br>
 * `WAITING_FOR_PAYMENT` - to indicate that the payment hasn't been settled, after an extension of the expiry time with reason payment<br>
 * `CONFIRMED` - to show whenever the booking is in a COMMITTED state (confirmed)<br>
 * `CANCELLED` - to show whenever the booking is cancelled<br>
 * `CONDITIONAL_CONFIRMED` - to show whenever the booking is conditionally confirmed (see process identifiers)<br>
 * `EXPIRED` - to show whenever the booking is expired (the expiry time has passed)<br>
 */
data class BookingStep(
    @Schema(example = "null", description = "the type of the information provided")
    val type: Type? = null,
    @Schema(
        example = "null",
        description = "the internet location of the information, used in case or type `URL` or `IMAGE`",
    )
    val url: String? = null,
    @Schema(example = "null", description = "the purpose of the information")
    val goal: Goal? = null,
    @Schema(
        example = "null",
        description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`",
    )
    val text: String? = null,
    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    val showTime: ShowTime? = null,
    @Schema(
        example = "null",
        description =
            "The possible steps are described here<br> " +
                "`PENDING` - to show whenever the booking is in PENDING state (not confirmed)<br> " +
                "`WAITING` - to indicate that the TO is processing the booking, optionally after an extension of the expiry time<br> " +
                "`WAITING_FOR_PAYMENT` - to indicate that the payment hasn't been settled, after an extension of the expiry time with " +
                "reason payment<br> " +
                "`CONFIRMED` - to show whenever the booking is in a COMMITTED state (confirmed)<br> " +
                "`CANCELLED` - to show whenever the booking is cancelled<br> " +
                "`CONDITIONAL_CONFIRMED` - to show whenever the booking is conditionally confirmed (see process identifiers)<br> " +
                "`EXPIRED` - to show whenever the booking is expired (the expiry time has passed)<br>",
    )
    val action: Action? = null,
) {
    /**
     * the type of the information provided
     * Values: uRL,iMAGE,pLAINTEXT,hTML
     */
    enum class Type {
        URL,
        IMAGE,
        PLAIN_TEXT,
        HTML,
    }

    /**
     * the purpose of the information
     * Values: iNSTRUCTIONS,sALES
     */
    enum class Goal {
        INSTRUCTIONS,
        SALES,
    }

    /**
     * the moment when the information must be displayed
     * Values: pLANNING,cOMMITTEDBOOKING,pREPARE,sETINUSE,pAUSE,oPENTRUNK,sTARTFINISHING,fINISH
     */
    enum class ShowTime {
        PLANNING,
        COMMITTED_BOOKING,
        PREPARE,
        SET_IN_USE,
        PAUSE,
        OPEN_TRUNK,
        START_FINISHING,
        FINISH,
    }

    /**
     * The possible steps are described here<br> `PENDING` - to show whenever the booking is in PENDING state (not confirmed)<br>
     * `WAITING` - to indicate that the TO is processing the booking, optionally after an extension of the expiry time<br>
     * `WAITING_FOR_PAYMENT` - to indicate that the payment hasn't been settled, after an extension of the expiry time with
     * reason payment<br>
     * `CONFIRMED` - to show whenever the booking is in a COMMITTED state (confirmed)<br>
     * `CANCELLED` - to show whenever the booking is cancelled<br>
     * `CONDITIONAL_CONFIRMED` - to show whenever the booking is conditionally confirmed (see process identifiers)<br>
     * `EXPIRED` - to show whenever the booking is expired (the expiry time has passed)<br>
     * Values: pENDING,wAITINGFORPAYMENT,cONFIRMED,cONDITIONALCONFIRMED,cANCELLED,eXPIRED
     */
    enum class Action {
        PENDING,
        WAITING_FOR_PAYMENT,
        CONFIRMED,
        CONDITIONAL_CONFIRMED,
        CANCELLED,
        EXPIRED,
    }
}
