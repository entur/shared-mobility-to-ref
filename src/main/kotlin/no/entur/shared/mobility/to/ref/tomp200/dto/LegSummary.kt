package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.LegSummaryAccomodation
import no.entur.shared.mobility.to.ref.tomp200.dto.LegSummaryBoarding
import no.entur.shared.mobility.to.ref.tomp200.dto.Mode
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
 * @param mode 
 * @param name 
 * @param icon valid URL
 * @param destination default string, full names etc (length 0-200)
 * @param travellers 
 * @param equipment 
 * @param boarding 
 * @param accomodation 
 */
data class LegSummary(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("mode", required = true) val mode: Mode,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @field:Valid
    @Schema(example = "null", description = "valid URL")
    @get:JsonProperty("icon") val icon: java.net.URI? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("destination") val destination: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("travellers") val travellers: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("equipment") val equipment: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("boarding") val boarding: LegSummaryBoarding? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("accomodation") val accomodation: LegSummaryAccomodation? = null
) {

}

