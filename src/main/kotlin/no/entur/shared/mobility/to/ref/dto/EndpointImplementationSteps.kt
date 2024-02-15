package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * The steps can be specified here, when they are uniform over all assets. If some assets should be handled differently, it can be
 * specified as a condition in the booking for that specific asset(type).
 * @param planning
 * @param booking
 * @param onboarding this array should be considered as a sequence!
 * @param offboarding this array should be considered as a sequence!
 * @param pausing this array should be considered as a sequence!
 * @param resuming this array should be considered as a sequence!
 */
data class EndpointImplementationSteps(
    @field:Valid
    @Schema(example = "null")
    val planning: List<PlanningStep>? = null,
    @field:Valid
    @Schema(example = "null")
    val booking: List<BookingStep>? = null,
    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    val onboarding: List<OnBoardingStep>? = null,
    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    val offboarding: List<OffBoardingStep>? = null,
    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    val pausing: List<PausingStep>? = null,
    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    val resuming: List<ResumingStep>? = null,
)
