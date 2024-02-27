package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action these actions are available<br> `SEND_START_FINISHING` - the TO needs to be informed the leg is about to finish<br>
 * `PARK_ASSIST` - user action to park (stop) using the asset<br>
 * `UNLOCK_LOCKER` - user action, could be triggered by the START_FINISH event<br>
 * `CONNECT_CHARGER` - user action<br>
 * `LOCK_ASSET` - user action, could be triggered by the FINISH event<br>
 * `SEND_OPEN_TRUNK` - the TO opens the trunk remotely <br>
 * `UNLOCK_TRUNK` - user action <br>
 * `STOW_HELMET` - user action <br>
 * `LOCK_TRUNK` - user action <br>
 * `LOCK_LOCKER` - user action <br>
 * `SEND_FINISH` - the TO wants to be informed about the end of the leg<br>
 * `SEND_EVIDENCE_PARKED` - the TO requires parking evidence<br>
 * `SEND_EVIDENCE_HELMET` - the TO requires evidence of storing the helmet<br>
 * `SEND_EVIDENCE_CHARGER` - the TO requires evidence of correct usage of the charger
 */
data class OffBoardingStep(
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
        description = """these actions are available<br> 
            |`SEND_START_FINISHING` - the TO needs to be informed the leg is about to finish<br> 
            |`PARK_ASSIST` - user action to park (stop) using the asset<br> 
            |`UNLOCK_LOCKER` - user action, could be triggered by the START_FINISH event<br> 
            |`CONNECT_CHARGER` - user action<br> 
            |`LOCK_ASSET` - user action, could be triggered by the FINISH event<br> 
            |`SEND_OPEN_TRUNK` - the TO opens the trunk remotely <br> 
            |`UNLOCK_TRUNK` - user action <br> 
            |`STOW_HELMET` - user action <br> 
            |`LOCK_TRUNK` - user action <br> 
            |`LOCK_LOCKER` - user action <br> 
            |`SEND_FINISH` - the TO wants to be informed about the end of the leg<br> 
            |`SEND_EVIDENCE_PARKED` - the TO requires parking evidence<br> 
            |`SEND_EVIDENCE_HELMET` - the TO requires evidence of storing the helmet<br> 
            |`SEND_EVIDENCE_CHARGER` - the TO requires evidence of correct usage of the charger""",
    )
    val action: Action? = null,
) {
    /**
     * the type of the information provided
     */
    enum class Type {
        URL,
        IMAGE,
        PLAIN_TEXT,
        HTML,
    }

    /**
     * the purpose of the information
     */
    enum class Goal {
        INSTRUCTIONS,
        SALES,
    }

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
     * these actions are available<br>
     * `SEND_START_FINISHING` - the TO needs to be informed the leg is about to finish<br>
     * `PARK_ASSIST` - user action to park (stop) using the asset<br>
     * `UNLOCK_LOCKER` - user action, could be triggered by the START_FINISH event<br>
     * `CONNECT_CHARGER` - user action<br>
     * `LOCK_ASSET` - user action, could be triggered by the FINISH event<br>
     * `SEND_OPEN_TRUNK` - the TO opens the trunk remotely <br>
     * `UNLOCK_TRUNK` - user action <br>
     * `STOW_HELMET` - user action <br>
     * `LOCK_TRUNK` - user action <br>
     * `LOCK_LOCKER` - user action <br>
     * `SEND_FINISH` - the TO wants to be informed about the end of the leg<br>
     * `SEND_EVIDENCE_PARKED` - the TO requires parking evidence<br>
     * `SEND_EVIDENCE_HELMET` - the TO requires evidence of storing the helmet<br>
     * `SEND_EVIDENCE_CHARGER` - the TO requires evidence of correct usage of the charger
     */
    enum class Action {
        SEND_START_FINISHING,
        PARK_ASSIST,
        UNLOCK_LOCKER,
        CONNECT_CHARGER,
        LOCK_ASSET,
        SEND_OPEN_TRUNK,
        UNLOCK_TRUNK,
        STOW_HELMET,
        LOCK_TRUNK,
        LOCK_LOCKER,
        SEND_FINISH,
        SEND_EVIDENCE_PARKED,
        SEND_EVIDENCE_HELMET,
        SEND_EVIDENCE_CHARGER,
    }
}
