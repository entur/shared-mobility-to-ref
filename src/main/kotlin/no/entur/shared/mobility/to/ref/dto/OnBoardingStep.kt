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
 * `SEND_PREPARE` - indicate the leg is going to start <br>
 * `UNLOCK_LOCKER` - user action - optionally triggered by the PREPARE event<br>
 * `DISCONNECT_CHARGER` - requested user action <br>
 * `SHOW_DAMAGES` - show known damages to end user <br>
 * `UNLOCK_ASSET` - requested user action or triggered by SET_IN_USE event <br>
 * `START_ASSET` - requested user action <br>
 * `SEND_OPEN_TRUNK` - request TO to open trunk/helmet case remotely<br>
 * `UNLOCK_TRUNK` - requested user action <br>
 * `TAKE_HELMET` - requested user action <br>
 * `SEND_SET_IN_USE` - request to start leg <br>
 * `SEND_ASSIGN_ASSET` - request to assign the specified asset to the leg <br>
 * `LOCK_LOCKER` - requested user action
 */
data class OnBoardingStep(
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
                "`SEND_PREPARE` - indicate the leg is going to start <br> " +
                "`UNLOCK_LOCKER` - user action - optionally triggered by the PREPARE event<br> " +
                "`DISCONNECT_CHARGER` - requested user action <br> " +
                "`SHOW_DAMAGES` - show known damages to end user <br> " +
                "`UNLOCK_ASSET` - requested user action or triggered by SET_IN_USE event <br> " +
                "`START_ASSET` - requested user action <br> " +
                "`SEND_OPEN_TRUNK` - request TO to open trunk/helmet case remotely<br> " +
                "`UNLOCK_TRUNK` - requested user action <br> " +
                "`TAKE_HELMET` - requested user action <br> " +
                "`SEND_SET_IN_USE` - request to start leg <br> " +
                "`SEND_ASSIGN_ASSET` - request to assign the specified asset to the leg <br> " +
                "`LOCK_LOCKER` - requested user action",
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
     * The possible steps are described here<br>
     * `SEND_PREPARE` - indicate the leg is going to start <br>
     * `UNLOCK_LOCKER` - user action - optionally triggered by the PREPARE event<br>
     * `DISCONNECT_CHARGER` - requested user action <br>
     * `SHOW_DAMAGES` - show known damages to end user <br>
     * `UNLOCK_ASSET` - requested user action or triggered by SET_IN_USE event <br>
     * `START_ASSET` - requested user action <br>
     * `SEND_OPEN_TRUNK` - request TO to open trunk/helmet case remotely<br>
     * `UNLOCK_TRUNK` - requested user action <br>
     * `TAKE_HELMET` - requested user action <br>
     * `SEND_SET_IN_USE` - request to start leg <br>
     * `SEND_ASSIGN_ASSET` - request to assign the specified asset to the leg <br>
     * `LOCK_LOCKER` - requested user action
     */
    enum class Action {
        SEND_PREPARE,
        UNLOCK_LOCKER,
        DISCONNECT_CHARGER,
        SHOW_DAMAGES,
        UNLOCK_ASSET,
        START_ASSET,
        SEND_OPEN_TRUNK,
        UNLOCK_TRUNK,
        TAKE_HELMET,
        SEND_SET_IN_USE,
        SEND_ASSIGN_ASSET,
        LOCK_LOCKER,
    }
}
