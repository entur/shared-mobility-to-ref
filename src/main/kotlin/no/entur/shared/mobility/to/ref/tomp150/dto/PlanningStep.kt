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
 * this action allows to publish advertisements together with the proposed leg.
 * @param type the type of the information provided
 * @param url the internet location of the information, used in case or type `URL` or `IMAGE`
 * @param goal the purpose of the information
 * @param text free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`
 * @param showTime the moment when the information must be displayed
 * @param action the `RESULT_SHOWN` action requires the MP to display some information to the customer when it is viewing the proposed legs.
 */
data class PlanningStep(

    @Schema(example = "null", description = "the type of the information provided")
    @get:JsonProperty("type") val type: PlanningStep.Type? = null,

    @Schema(example = "null", description = "the internet location of the information, used in case or type `URL` or `IMAGE`")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "null", description = "the purpose of the information")
    @get:JsonProperty("goal") val goal: PlanningStep.Goal? = null,

    @Schema(example = "null", description = "free format text or HTML, depending on the type. Not to use in combination with `URL` or `IMAGE`")
    @get:JsonProperty("text") val text: kotlin.String? = null,

    @Schema(example = "null", description = "the moment when the information must be displayed")
    @Deprecated(message = "")
    @get:JsonProperty("showTime") val showTime: PlanningStep.ShowTime? = null,

    @Schema(example = "null", description = "the `RESULT_SHOWN` action requires the MP to display some information to the customer when it is viewing the proposed legs.")
    @get:JsonProperty("action") val action: PlanningStep.Action? = null
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PlanningStep'")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PlanningStep'")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PlanningStep'")
            }
        }
    }

    /**
    * the `RESULT_SHOWN` action requires the MP to display some information to the customer when it is viewing the proposed legs.
    * Values: RESULT_SHOWN
    */
    enum class Action(@get:JsonValue val value: kotlin.String) {

        RESULT_SHOWN("RESULT_SHOWN");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Action {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PlanningStep'")
            }
        }
    }

}

