package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * this action allows to publish advertisements together with the proposed leg.
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action the `RESULT_SHOWN` action requires the MP to display some information to the customer when it is viewing the proposed
 * legs.
 */
data class PlanningStep(
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
            "the `RESULT_SHOWN` action requires the MP to display some information to the customer when it is viewing" +
                " the proposed legs.",
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
     * the `RESULT_SHOWN` action requires the MP to display some information to the customer when it is viewing the proposed legs.
     * Values: rESULTSHOWN
     */
    enum class Action {
        RESULT_SHOWN,
    }
}
