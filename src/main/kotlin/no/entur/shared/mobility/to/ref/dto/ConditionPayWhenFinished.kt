package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * in case the TO demands a direct payment after usage.
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param id An identifier for this condition that can be used to refer to this condition
 */
data class ConditionPayWhenFinished(
    @Schema(
        example = "null",
        required = true,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    @get:JsonProperty("conditionType", required = true) override val conditionType: String,
    @Schema(
        example = "deposit50eu",
        description = "An identifier for this condition that can be used to refer to this condition",
    )
    val id: String? = null,
) : AssetTypeConditionsInner
