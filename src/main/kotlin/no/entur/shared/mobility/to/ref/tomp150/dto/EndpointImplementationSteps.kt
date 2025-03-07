package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingStep
import no.entur.shared.mobility.to.ref.tomp150.dto.OffBoardingStep
import no.entur.shared.mobility.to.ref.tomp150.dto.OnBoardingStep
import no.entur.shared.mobility.to.ref.tomp150.dto.PausingStep
import no.entur.shared.mobility.to.ref.tomp150.dto.PlanningStep
import no.entur.shared.mobility.to.ref.tomp150.dto.ResumingStep
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
 * The steps can be specified here, when they are uniform over all assets. If some assets should be handled differently, it can be specified as a condition in the booking for that specific asset(type).
 * @param planning 
 * @param booking 
 * @param onboarding this array should be considered as a sequence!
 * @param offboarding this array should be considered as a sequence!
 * @param pausing this array should be considered as a sequence!
 * @param resuming this array should be considered as a sequence!
 */
data class EndpointImplementationSteps(

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("planning") val planning: kotlin.collections.List<PlanningStep>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("booking") val booking: kotlin.collections.List<BookingStep>? = null,

    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    @get:JsonProperty("onboarding") val onboarding: kotlin.collections.List<OnBoardingStep>? = null,

    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    @get:JsonProperty("offboarding") val offboarding: kotlin.collections.List<OffBoardingStep>? = null,

    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    @get:JsonProperty("pausing") val pausing: kotlin.collections.List<PausingStep>? = null,

    @field:Valid
    @Schema(example = "null", description = "this array should be considered as a sequence!")
    @get:JsonProperty("resuming") val resuming: kotlin.collections.List<ResumingStep>? = null
    ) {

}

