package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.time.OffsetDateTime

/**
 *
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param ultimateResponseTime
 * @param id An identifier for this condition that can be used to refer to this condition
 */
data class ConditionPostponedCommit(
    @Schema(
        example = "null",
        required = true,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    @get:JsonProperty("conditionType", required = true) override val conditionType: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty("ultimateResponseTime", required = true) val ultimateResponseTime: OffsetDateTime,
    @Schema(
        example = "deposit50eu",
        description = "An identifier for this condition that can be used to refer to this condition",
    )
    val id: String? = null,
): AssetTypeConditionsInner
