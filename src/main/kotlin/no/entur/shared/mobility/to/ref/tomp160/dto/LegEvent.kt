package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.Asset
import no.entur.shared.mobility.to.ref.tomp160.dto.Place
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
 * event for the execution
 * @param time 
 * @param event 
 * @param comment free text, should match Content-Language
 * @param url urls to support the event e.g. pictures justifying the exit conditions
 * @param userLocation 
 * @param asset 
 */
data class LegEvent(

    @Schema(required = true, description = "")
    @param:JsonProperty("time")
    @get:JsonProperty("time", required = true) val time: java.time.OffsetDateTime,

    @Schema(required = true, description = "")
    @param:JsonProperty("event")
    @get:JsonProperty("event", required = true) val event: LegEvent.Event,

    @Schema(description = "free text, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("comment")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @Schema(description = "urls to support the event e.g. pictures justifying the exit conditions")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("url")
    @get:JsonProperty("url") val url: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("userLocation")
    @get:JsonProperty("userLocation") val userLocation: Place? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("asset")
    @get:JsonProperty("asset") val asset: Asset? = null
) {

    /**
    * 
    * Values: PREPARE,ASSIGN_ASSET,SET_IN_USE,PAUSE,OPEN_TRUNK,START_FINISHING,FINISH,TIME_EXTEND,TIME_POSTPONE,CANCEL
    */
    enum class Event(@get:JsonValue val value: kotlin.String) {

        PREPARE("PREPARE"),
        ASSIGN_ASSET("ASSIGN_ASSET"),
        SET_IN_USE("SET_IN_USE"),
        PAUSE("PAUSE"),
        OPEN_TRUNK("OPEN_TRUNK"),
        START_FINISHING("START_FINISHING"),
        FINISH("FINISH"),
        TIME_EXTEND("TIME_EXTEND"),
        TIME_POSTPONE("TIME_POSTPONE"),
        CANCEL("CANCEL");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Event {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Event'")
            }
        }
    }

}

