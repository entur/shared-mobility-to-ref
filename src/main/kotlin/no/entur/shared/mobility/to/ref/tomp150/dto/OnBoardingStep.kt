package no.entur.shared.mobility.to.ref.tomp150.dto

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
 * @param action The possible steps are described here<br> `SEND_PREPARE` - indicate the leg is going to start <br> `UNLOCK_LOCKER` - user action - optionally triggered by the PREPARE event<br> `DISCONNECT_CHARGER` - requested user action <br> `SHOW_DAMAGES` - show known damages to end user <br> `UNLOCK_ASSET` - requested user action or triggered by SET_IN_USE event <br> `START_ASSET` - requested user action <br> `SEND_OPEN_TRUNK` - request TO to open trunk/helmet case remotely<br> `UNLOCK_TRUNK` - requested user action <br> `TAKE_HELMET` - requested user action <br> `SEND_SET_IN_USE` - request to start leg <br> `SEND_ASSIGN_ASSET` - request to assign the specified asset to the leg <br> `LOCK_LOCKER` - requested user action
 */
data class OnBoardingStep(

    @Schema(example = "null", description = "the type of the information provided")
    @get:JsonProperty("type") val type: OnBoardingStep.Type? = null,

    @Schema(example = "null", description = "the internet location of the information, used in case or type `URL` or `IMAGE`")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "null", description = "the purpose of the information")
    @get:JsonProperty("goal") val goal: OnBoardingStep.Goal? = null,

    @Schema(example = "null", description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`")
    @get:JsonProperty("text") val text: kotlin.String? = null,

    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    @get:JsonProperty("showTime") val showTime: OnBoardingStep.ShowTime? = null,

    @Schema(example = "null", description = "The possible steps are described here<br> `SEND_PREPARE` - indicate the leg is going to start <br> `UNLOCK_LOCKER` - user action - optionally triggered by the PREPARE event<br> `DISCONNECT_CHARGER` - requested user action <br> `SHOW_DAMAGES` - show known damages to end user <br> `UNLOCK_ASSET` - requested user action or triggered by SET_IN_USE event <br> `START_ASSET` - requested user action <br> `SEND_OPEN_TRUNK` - request TO to open trunk/helmet case remotely<br> `UNLOCK_TRUNK` - requested user action <br> `TAKE_HELMET` - requested user action <br> `SEND_SET_IN_USE` - request to start leg <br> `SEND_ASSIGN_ASSET` - request to assign the specified asset to the leg <br> `LOCK_LOCKER` - requested user action")
    @get:JsonProperty("action") val action: OnBoardingStep.Action? = null
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
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'OnBoardingStep'")
            }
        }
    }

    /**
    * the purpose of the information
    * Values: INSTRUCTIONS,SALES
    */
    enum class Goal(@get:JsonValue val value: kotlin.String) {

        INSTRUCTIONS("INSTRUCTIONS"),
        SALES("SALES");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Goal {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'OnBoardingStep'")
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
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'OnBoardingStep'")
            }
        }
    }

    /**
    * The possible steps are described here<br> `SEND_PREPARE` - indicate the leg is going to start <br> `UNLOCK_LOCKER` - user action - optionally triggered by the PREPARE event<br> `DISCONNECT_CHARGER` - requested user action <br> `SHOW_DAMAGES` - show known damages to end user <br> `UNLOCK_ASSET` - requested user action or triggered by SET_IN_USE event <br> `START_ASSET` - requested user action <br> `SEND_OPEN_TRUNK` - request TO to open trunk/helmet case remotely<br> `UNLOCK_TRUNK` - requested user action <br> `TAKE_HELMET` - requested user action <br> `SEND_SET_IN_USE` - request to start leg <br> `SEND_ASSIGN_ASSET` - request to assign the specified asset to the leg <br> `LOCK_LOCKER` - requested user action
    * Values: SEND_PREPARE,UNLOCK_LOCKER,DISCONNECT_CHARGER,SHOW_DAMAGES,UNLOCK_ASSET,START_ASSET,SEND_OPEN_TRUNK,UNLOCK_TRUNK,TAKE_HELMET,SEND_SET_IN_USE,SEND_ASSIGN_ASSET,LOCK_LOCKER
    */
    enum class Action(@get:JsonValue val value: kotlin.String) {

        SEND_PREPARE("SEND_PREPARE"),
        UNLOCK_LOCKER("UNLOCK_LOCKER"),
        DISCONNECT_CHARGER("DISCONNECT_CHARGER"),
        SHOW_DAMAGES("SHOW_DAMAGES"),
        UNLOCK_ASSET("UNLOCK_ASSET"),
        START_ASSET("START_ASSET"),
        SEND_OPEN_TRUNK("SEND_OPEN_TRUNK"),
        UNLOCK_TRUNK("UNLOCK_TRUNK"),
        TAKE_HELMET("TAKE_HELMET"),
        SEND_SET_IN_USE("SEND_SET_IN_USE"),
        SEND_ASSIGN_ASSET("SEND_ASSIGN_ASSET"),
        LOCK_LOCKER("LOCK_LOCKER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Action {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'OnBoardingStep'")
            }
        }
    }

}

