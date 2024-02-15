package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action possible values<br>
 * `UNLOCK_ASSET` - user action, could be triggered by SET_IN_USE event<br>
 * `SEND_OPEN_TRUNK` - request TO to open trunk remotely<br>
 * `UNLOCK_TRUNK` - user action<br>
 * `TAKE_HELMET` - user action<br>
 * `LOCK_TRUNK` - user action<br>
 * `START_ASSET` - user action<br>
 * `SEND_SET_IN_USE` - the TO wants to be informed that the leg is resumed. Optionally triggers the unlock of the vehicle
 */
data class ResumingStep(
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
            "possible values<br> `UNLOCK_ASSET` - user action, could be triggered by SET_IN_USE event<br> " +
                "`SEND_OPEN_TRUNK` - request TO to open trunk remotely<br> " +
                "`UNLOCK_TRUNK` - user action<br> " +
                "`TAKE_HELMET` - user action<br> " +
                "`LOCK_TRUNK` - user action<br> " +
                "`START_ASSET` - user action<br> " +
                "`SEND_SET_IN_USE` - the TO wants to be informed that the leg is resumed. Optionally triggers the unlock of the vehicle",
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
     * possible values<br> `UNLOCK_ASSET` - user action, could be triggered by SET_IN_USE event<br>
     * `SEND_OPEN_TRUNK` - request TO to open trunk remotely<br>
     * `UNLOCK_TRUNK` - user action<br>
     * `TAKE_HELMET` - user action<br>
     * `LOCK_TRUNK` - user action<br>
     * `START_ASSET` - user action<br>
     * `SEND_SET_IN_USE` - the TO wants to be informed that the leg is resumed. Optionally triggers the unlock of the vehicle
     * Values: UNLOCKASSET,SENDOPENTRUNK,UNLOCKTRUNK,TAKEHELMET,LOCKTRUNK,STARTASSET,SENDSETINUSE
     */
    enum class Action {
        UNLOCK_ASSET,
        SEND_OPEN_TRUNK,
        UNLOCK_TRUNK,
        TAKE_HELMET,
        LOCK_TRUNK,
        START_ASSET,
        SEND_SET_IN_USE,
    }
}
