package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("time", required = true) val time: java.time.OffsetDateTime,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("event", required = true) val event: LegEvent.Event,

    @Schema(example = "null", description = "free text, should match Content-Language")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @Schema(example = "null", description = "urls to support the event e.g. pictures justifying the exit conditions")
    @get:JsonProperty("url") val url: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("userLocation") val userLocation: Place? = null,

    @field:Valid
    @Schema(example = "null", description = "")
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
                return values().first{it -> it.value == value}
            }
        }
    }

}

