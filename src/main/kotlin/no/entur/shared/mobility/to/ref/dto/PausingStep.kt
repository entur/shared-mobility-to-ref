package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action allowed actions<br> `SEND_PAUSE` - send leg event PAUSE to inform the TO<br> `PARK_ASSIST` - user action, the end user can be informed how and where to park<br> `LOCK_ASSET` - user action, can be triggered by the PAUSE event<br> `SEND_OPEN_TRUNK` - request TO to open the trunk remotely<br> `UNLOCK_TRUNK` - user action<br> `STOW_HELMET` - user action<br> `LOCK_TRUNK` - user action
 */
data class PausingStep(
    @Schema(example = "null", description = "the type of the information provided")
    @get:JsonProperty("type") val type: PausingStep.Type? = null,
    @Schema(example = "null", description = "the internet location of the information, used in case or type `URL` or `IMAGE`")
    @get:JsonProperty("url") val url: kotlin.String? = null,
    @Schema(example = "null", description = "the purpose of the information")
    @get:JsonProperty("goal") val goal: PausingStep.Goal? = null,
    @Schema(
        example = "null",
        description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`",
    )
    @get:JsonProperty("text") val text: kotlin.String? = null,
    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    @get:JsonProperty("showTime") val showTime: PausingStep.ShowTime? = null,
    @Schema(
        example = "null",
        description = "allowed actions<br> `SEND_PAUSE` - send leg event PAUSE to inform the TO<br> `PARK_ASSIST` - user action, the end user can be informed how and where to park<br> `LOCK_ASSET` - user action, can be triggered by the PAUSE event<br> `SEND_OPEN_TRUNK` - request TO to open the trunk remotely<br> `UNLOCK_TRUNK` - user action<br> `STOW_HELMET` - user action<br> `LOCK_TRUNK` - user action",
    )
    @get:JsonProperty("action") val action: PausingStep.Action? = null,
) {
    /**
     * the type of the information provided
     * Values: URL,IMAGE,PLAIN_TEXT,HTML
     */
    enum class Type(
        @get:JsonValue val value: kotlin.String,
    ) {
        URL("URL"),
        IMAGE("IMAGE"),
        PLAIN_TEXT("PLAIN_TEXT"),
        HTML("HTML"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type = values().first { it -> it.value == value }
        }
    }

    /**
     * the purpose of the information
     * Values: INSTRUCTIONS,SALES
     */
    enum class Goal(
        @get:JsonValue val value: kotlin.String,
    ) {
        INSTRUCTIONS("INSTRUCTIONS"),
        SALES("SALES"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Goal = values().first { it -> it.value == value }
        }
    }

    /**
     * the moment when the information must be displayed
     * Values: PLANNING,COMMITTED_BOOKING,PREPARE,SET_IN_USE,PAUSE,OPEN_TRUNK,START_FINISHING,FINISH
     */
    enum class ShowTime(
        @get:JsonValue val value: kotlin.String,
    ) {
        PLANNING("PLANNING"),
        COMMITTED_BOOKING("COMMITTED_BOOKING"),
        PREPARE("PREPARE"),
        SET_IN_USE("SET_IN_USE"),
        PAUSE("PAUSE"),
        OPEN_TRUNK("OPEN_TRUNK"),
        START_FINISHING("START_FINISHING"),
        FINISH("FINISH"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ShowTime = values().first { it -> it.value == value }
        }
    }

    /**
     * allowed actions<br> `SEND_PAUSE` - send leg event PAUSE to inform the TO<br> `PARK_ASSIST` - user action, the end user can be informed how and where to park<br> `LOCK_ASSET` - user action, can be triggered by the PAUSE event<br> `SEND_OPEN_TRUNK` - request TO to open the trunk remotely<br> `UNLOCK_TRUNK` - user action<br> `STOW_HELMET` - user action<br> `LOCK_TRUNK` - user action
     * Values: SEND_PAUSE,PARK_ASSIST,LOCK_ASSET,SEND_OPEN_TRUNK,UNLOCK_TRUNK,STOW_HELMET,LOCK_TRUNK
     */
    enum class Action(
        @get:JsonValue val value: kotlin.String,
    ) {
        SEND_PAUSE("SEND_PAUSE"),
        PARK_ASSIST("PARK_ASSIST"),
        LOCK_ASSET("LOCK_ASSET"),
        SEND_OPEN_TRUNK("SEND_OPEN_TRUNK"),
        UNLOCK_TRUNK("UNLOCK_TRUNK"),
        STOW_HELMET("STOW_HELMET"),
        LOCK_TRUNK("LOCK_TRUNK"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Action = values().first { it -> it.value == value }
        }
    }
}
