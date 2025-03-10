package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
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
 * A travel planning with bookable options that fulfil the constraints of the planning
 * @param validUntil The time until which the presented options are (likely) available
 * @param options 
 */
data class Planning(

    @Schema(example = "null", required = true, description = "The time until which the presented options are (likely) available")
    @get:JsonProperty("validUntil", required = true) val validUntil: java.time.OffsetDateTime,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("options", required = true) val options: kotlin.collections.List<Booking>
    ) {

}

