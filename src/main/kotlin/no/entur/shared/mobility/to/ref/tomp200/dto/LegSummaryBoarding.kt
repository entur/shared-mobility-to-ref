package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * 
 * @param onboardStayDuration duration, ISO 8601 compliant
 * @param delayedAlightingAllowed 
 * @param overnightStayAllowed 
 * @param earlyBoardingAllowed 
 */
data class LegSummaryBoarding(

    @get:Pattern(regexp="/^(-?)P(?=\\d|T\\d)(?:(\\d+)Y)?(?:(\\d+)M)?(?:(\\d+)([DW]))?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+(?:\\.\\d+)?)S)?)?$/")
    @Schema(example = "null", description = "duration, ISO 8601 compliant")
    @get:JsonProperty("onboardStayDuration") val onboardStayDuration: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("delayedAlightingAllowed") val delayedAlightingAllowed: kotlin.Boolean? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("overnightStayAllowed") val overnightStayAllowed: kotlin.Boolean? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("earlyBoardingAllowed") val earlyBoardingAllowed: kotlin.Boolean? = null
) {

}

