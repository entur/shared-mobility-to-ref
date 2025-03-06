package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import no.entur.shared.mobility.to.ref.dto.Condition

/**
 *
 * @param ultimateResponseTime
 */
data class ConditionPostponedCommit(
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ultimateResponseTime", required = true) val ultimateResponseTime: java.time.OffsetDateTime,
    @Schema(example = "null", required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,
    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @get:JsonProperty("id") override val id: kotlin.String? = null,
) : Condition
