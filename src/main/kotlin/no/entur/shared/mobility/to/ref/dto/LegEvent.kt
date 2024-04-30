package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import java.time.OffsetDateTime

/**
 * event for the execution
 * @param time
 * @param event
 * @param comment free text, should match Content-Language
 * @param url urls to support the event e.g. pictures justifying the exit conditions
 * @param asset
 */
data class LegEvent(
    @Schema(example = "null", required = true)
    @get:JsonProperty("time", required = true) val time: OffsetDateTime,
    @Schema(example = "null", required = true)
    @get:JsonProperty("event", required = true) val event: Event,
    @Schema(example = "null", description = "free text, should match Content-Language")
    val comment: String? = null,
    @Schema(example = "null", description = "urls to support the event e.g. pictures justifying the exit conditions")
    val url: List<String>? = null,
    @field:Valid
    @Schema(example = "null")
    val asset: Asset? = null,
) {
    enum class Event {
        PREPARE,
        ASSIGN_ASSET,
        SET_IN_USE,
        PAUSE,
        OPEN_TRUNK,
        START_FINISHING,
        FINISH,
        TIME_EXTEND,
        TIME_POSTPONE,
        CANCEL,
    }
}
