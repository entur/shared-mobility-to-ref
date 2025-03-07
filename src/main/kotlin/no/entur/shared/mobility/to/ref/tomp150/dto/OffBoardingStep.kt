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
 * @param action these actions are available<br> `SEND_START_FINISHING` - the TO needs to be informed the leg is about to finish<br> `PARK_ASSIST` - user action to park (stop) using the asset<br> `UNLOCK_LOCKER` - user action, could be triggered by the START_FINISH event<br> `CONNECT_CHARGER` - user action<br> `LOCK_ASSET` - user action, could be triggered by the FINISH event<br> `SEND_OPEN_TRUNK` - the TO opens the trunk remotely <br> `UNLOCK_TRUNK` - user action <br> `STOW_HELMET` - user action <br> `LOCK_TRUNK` - user action <br> `LOCK_LOCKER` - user action <br> `SEND_FINISH` - the TO wants to be informed about the end of the leg<br> `SEND_EVIDENCE_PARKED` - the TO requires parking evidence<br> `SEND_EVIDENCE_HELMET` - the TO requires evidence of storing the helmet<br> `SEND_EVIDENCE_CHARGER` - the TO requires evidence of correct usage of the charger
 */
data class OffBoardingStep(

    @Schema(example = "null", description = "the type of the information provided")
    @get:JsonProperty("type") val type: OffBoardingStep.Type? = null,

    @Schema(example = "null", description = "the internet location of the information, used in case or type `URL` or `IMAGE`")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "null", description = "the purpose of the information")
    @get:JsonProperty("goal") val goal: OffBoardingStep.Goal? = null,

    @Schema(example = "null", description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`")
    @get:JsonProperty("text") val text: kotlin.String? = null,

    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    @get:JsonProperty("showTime") val showTime: OffBoardingStep.ShowTime? = null,

    @Schema(example = "null", description = "these actions are available<br> `SEND_START_FINISHING` - the TO needs to be informed the leg is about to finish<br> `PARK_ASSIST` - user action to park (stop) using the asset<br> `UNLOCK_LOCKER` - user action, could be triggered by the START_FINISH event<br> `CONNECT_CHARGER` - user action<br> `LOCK_ASSET` - user action, could be triggered by the FINISH event<br> `SEND_OPEN_TRUNK` - the TO opens the trunk remotely <br> `UNLOCK_TRUNK` - user action <br> `STOW_HELMET` - user action <br> `LOCK_TRUNK` - user action <br> `LOCK_LOCKER` - user action <br> `SEND_FINISH` - the TO wants to be informed about the end of the leg<br> `SEND_EVIDENCE_PARKED` - the TO requires parking evidence<br> `SEND_EVIDENCE_HELMET` - the TO requires evidence of storing the helmet<br> `SEND_EVIDENCE_CHARGER` - the TO requires evidence of correct usage of the charger")
    @get:JsonProperty("action") val action: OffBoardingStep.Action? = null
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
    * Values: INSTRUCTIONS,SALES
    */
    enum class Goal(@get:JsonValue val value: kotlin.String) {

        INSTRUCTIONS("INSTRUCTIONS"),
        SALES("SALES");

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
    * these actions are available<br> `SEND_START_FINISHING` - the TO needs to be informed the leg is about to finish<br> `PARK_ASSIST` - user action to park (stop) using the asset<br> `UNLOCK_LOCKER` - user action, could be triggered by the START_FINISH event<br> `CONNECT_CHARGER` - user action<br> `LOCK_ASSET` - user action, could be triggered by the FINISH event<br> `SEND_OPEN_TRUNK` - the TO opens the trunk remotely <br> `UNLOCK_TRUNK` - user action <br> `STOW_HELMET` - user action <br> `LOCK_TRUNK` - user action <br> `LOCK_LOCKER` - user action <br> `SEND_FINISH` - the TO wants to be informed about the end of the leg<br> `SEND_EVIDENCE_PARKED` - the TO requires parking evidence<br> `SEND_EVIDENCE_HELMET` - the TO requires evidence of storing the helmet<br> `SEND_EVIDENCE_CHARGER` - the TO requires evidence of correct usage of the charger
    * Values: SEND_START_FINISHING,PARK_ASSIST,UNLOCK_LOCKER,CONNECT_CHARGER,LOCK_ASSET,SEND_OPEN_TRUNK,UNLOCK_TRUNK,STOW_HELMET,LOCK_TRUNK,LOCK_LOCKER,SEND_FINISH,SEND_EVIDENCE_PARKED,SEND_EVIDENCE_HELMET,SEND_EVIDENCE_CHARGER
    */
    enum class Action(@get:JsonValue val value: kotlin.String) {

        SEND_START_FINISHING("SEND_START_FINISHING"),
        PARK_ASSIST("PARK_ASSIST"),
        UNLOCK_LOCKER("UNLOCK_LOCKER"),
        CONNECT_CHARGER("CONNECT_CHARGER"),
        LOCK_ASSET("LOCK_ASSET"),
        SEND_OPEN_TRUNK("SEND_OPEN_TRUNK"),
        UNLOCK_TRUNK("UNLOCK_TRUNK"),
        STOW_HELMET("STOW_HELMET"),
        LOCK_TRUNK("LOCK_TRUNK"),
        LOCK_LOCKER("LOCK_LOCKER"),
        SEND_FINISH("SEND_FINISH"),
        SEND_EVIDENCE_PARKED("SEND_EVIDENCE_PARKED"),
        SEND_EVIDENCE_HELMET("SEND_EVIDENCE_HELMET"),
        SEND_EVIDENCE_CHARGER("SEND_EVIDENCE_CHARGER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Action {
                return values().first{it -> it.value == value}
            }
        }
    }

}

