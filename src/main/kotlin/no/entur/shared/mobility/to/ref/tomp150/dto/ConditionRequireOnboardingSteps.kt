package no.entur.shared.mobility.to.ref.tomp150.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.tomp150.dto.Condition
import no.entur.shared.mobility.to.ref.tomp150.dto.OnBoardingStep

/**
 *
 * @param steps
 */
data class ConditionRequireOnboardingSteps(
    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("steps", required = true) val steps: kotlin.collections.List<OnBoardingStep>,
    @Schema(example = "null", required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,
    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @get:JsonProperty("id") override val id: kotlin.String? = null,
) : Condition
