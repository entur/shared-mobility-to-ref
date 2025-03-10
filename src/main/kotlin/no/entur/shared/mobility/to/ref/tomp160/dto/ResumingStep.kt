package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action possible values<br> `UNLOCK_ASSET` - user action, could be triggered by SET_IN_USE event<br> `SEND_OPEN_TRUNK` - request TO to open trunk remotely<br> `UNLOCK_TRUNK` - user action<br> `TAKE_HELMET` - user action<br> `LOCK_TRUNK` - user action<br> `START_ASSET` - user action<br> `SEND_SET_IN_USE` - the TO wants to be informed that the leg is resumed. Optionally triggers the unlock of the vehicle
 */
data class ResumingStep(

    @Schema(example = "null", description = "the type of the information provided")
    @get:JsonProperty("type") val type: ResumingStep.Type? = null,

    @Schema(example = "null", description = "the internet location of the information, used in case or type `URL` or `IMAGE`")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "null", description = "the purpose of the information")
    @get:JsonProperty("goal") val goal: ResumingStep.Goal? = null,

    @Schema(example = "null", description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`")
    @get:JsonProperty("text") val text: kotlin.String? = null,

    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    @get:JsonProperty("showTime") val showTime: ResumingStep.ShowTime? = null,

    @Schema(example = "null", description = "possible values<br> `UNLOCK_ASSET` - user action, could be triggered by SET_IN_USE event<br> `SEND_OPEN_TRUNK` - request TO to open trunk remotely<br> `UNLOCK_TRUNK` - user action<br> `TAKE_HELMET` - user action<br> `LOCK_TRUNK` - user action<br> `START_ASSET` - user action<br> `SEND_SET_IN_USE` - the TO wants to be informed that the leg is resumed. Optionally triggers the unlock of the vehicle")
    @get:JsonProperty("action") val action: ResumingStep.Action? = null
    ) {

    /**
    * the type of the information provided
    * Values: URL,IMAGE,PLAIN_TEXT,HTML
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        URL("URL"),
        IMAGE("IMAGE"),
        PLAIN_TEXT("PLAIN_TEXT"),
        HTML("HTML");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * the purpose of the information
    * Values: INSTRUCTIONS,SALES,TERMS_CONDITIONS
    */
    enum class Goal(@get:JsonValue val value: kotlin.String) {

        INSTRUCTIONS("INSTRUCTIONS"),
        SALES("SALES"),
        TERMS_CONDITIONS("TERMS_CONDITIONS");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Goal {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * the moment when the information must be displayed
    * Values: PLANNING,COMMITTED_BOOKING,PREPARE,SET_IN_USE,PAUSE,OPEN_TRUNK,START_FINISHING,FINISH
    */
    enum class ShowTime(@get:JsonValue val value: kotlin.String) {

        PLANNING("PLANNING"),
        COMMITTED_BOOKING("COMMITTED_BOOKING"),
        PREPARE("PREPARE"),
        SET_IN_USE("SET_IN_USE"),
        PAUSE("PAUSE"),
        OPEN_TRUNK("OPEN_TRUNK"),
        START_FINISHING("START_FINISHING"),
        FINISH("FINISH");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ShowTime {
                return values().first{it -> it.value == value}
            }
        }
    }

    /**
    * possible values<br> `UNLOCK_ASSET` - user action, could be triggered by SET_IN_USE event<br> `SEND_OPEN_TRUNK` - request TO to open trunk remotely<br> `UNLOCK_TRUNK` - user action<br> `TAKE_HELMET` - user action<br> `LOCK_TRUNK` - user action<br> `START_ASSET` - user action<br> `SEND_SET_IN_USE` - the TO wants to be informed that the leg is resumed. Optionally triggers the unlock of the vehicle
    * Values: UNLOCK_ASSET,SEND_OPEN_TRUNK,UNLOCK_TRUNK,TAKE_HELMET,LOCK_TRUNK,START_ASSET,SEND_SET_IN_USE
    */
    enum class Action(@get:JsonValue val value: kotlin.String) {

        UNLOCK_ASSET("UNLOCK_ASSET"),
        SEND_OPEN_TRUNK("SEND_OPEN_TRUNK"),
        UNLOCK_TRUNK("UNLOCK_TRUNK"),
        TAKE_HELMET("TAKE_HELMET"),
        LOCK_TRUNK("LOCK_TRUNK"),
        START_ASSET("START_ASSET"),
        SEND_SET_IN_USE("SEND_SET_IN_USE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Action {
                return values().first{it -> it.value == value}
            }
        }
    }

}

