package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingStep
import no.entur.shared.mobility.to.ref.tomp160.dto.OffBoardingStep
import no.entur.shared.mobility.to.ref.tomp160.dto.OnBoardingStep
import no.entur.shared.mobility.to.ref.tomp160.dto.PausingStep
import no.entur.shared.mobility.to.ref.tomp160.dto.PlanningStep
import no.entur.shared.mobility.to.ref.tomp160.dto.ResumingStep
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
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("planning")
    @get:JsonProperty("planning") val planning: kotlin.collections.List<PlanningStep>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("booking")
    @get:JsonProperty("booking") val booking: kotlin.collections.List<BookingStep>? = null,

    @field:Valid
    @Schema(description = "this array should be considered as a sequence!")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("onboarding")
    @get:JsonProperty("onboarding") val onboarding: kotlin.collections.List<OnBoardingStep>? = null,

    @field:Valid
    @Schema(description = "this array should be considered as a sequence!")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("offboarding")
    @get:JsonProperty("offboarding") val offboarding: kotlin.collections.List<OffBoardingStep>? = null,

    @field:Valid
    @Schema(description = "this array should be considered as a sequence!")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("pausing")
    @get:JsonProperty("pausing") val pausing: kotlin.collections.List<PausingStep>? = null,

    @field:Valid
    @Schema(description = "this array should be considered as a sequence!")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("resuming")
    @get:JsonProperty("resuming") val resuming: kotlin.collections.List<ResumingStep>? = null
) {

}

