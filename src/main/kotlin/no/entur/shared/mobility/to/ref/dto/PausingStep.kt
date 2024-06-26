package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action allowed actions<br> `SEND_PAUSE` - send leg event PAUSE to inform the TO<br>
 * `PARK_ASSIST` - user action, the end user can be informed how and where to park<br>
 * `LOCK_ASSET` - user action, can be triggered by the PAUSE event<br>
 * `SEND_OPEN_TRUNK` - request TO to open the trunk remotely<br>
 * `UNLOCK_TRUNK` - user action<br>
 * `STOW_HELMET` - user action<br>
 * `LOCK_TRUNK` - user action
 */
data class PausingStep(
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
        description = """allowed actions<br> `SEND_PAUSE` - send leg event PAUSE to inform the TO<br> 
            |`PARK_ASSIST` - user action, the end user can be informed how and where to park<br> 
            |`LOCK_ASSET` - user action, can be triggered by the PAUSE event<br> 
            |`SEND_OPEN_TRUNK` - request TO to open the trunk remotely<br> 
            |`UNLOCK_TRUNK` - user action<br> 
            |`STOW_HELMET` - user action<br> 
            |`LOCK_TRUNK` - user action""",
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

    /**
     * the moment when the information must be displayed
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
     * allowed actions<br> `SEND_PAUSE` - send leg event PAUSE to inform the TO<br>
     * `PARK_ASSIST` - user action, the end user can be informed how and where to park<br>
     * `LOCK_ASSET` - user action, can be triggered by the PAUSE event<br>
     * `SEND_OPEN_TRUNK` - request TO to open the trunk remotely<br>
     * `UNLOCK_TRUNK` - user action<br> `STOW_HELMET` - user action<br>
     * `LOCK_TRUNK` - user action
     */
    enum class Action {
        SEND_PAUSE,
        PARK_ASSIST,
        LOCK_ASSET,
        SEND_OPEN_TRUNK,
        UNLOCK_TRUNK,
        STOW_HELMET,
        LOCK_TRUNK,
    }
}
