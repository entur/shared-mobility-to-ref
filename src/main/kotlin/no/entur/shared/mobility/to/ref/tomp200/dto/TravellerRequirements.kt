package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.ClassOfUse
import no.entur.shared.mobility.to.ref.tomp200.dto.Distribution
import no.entur.shared.mobility.to.ref.tomp200.dto.Mode
import no.entur.shared.mobility.to.ref.tomp200.dto.PrmNeeds
import no.entur.shared.mobility.to.ref.tomp200.dto.TravellerRequirementsAvoid
import no.entur.shared.mobility.to.ref.tomp200.dto.TravellerRequirementsEstimatedUsage
import no.entur.shared.mobility.to.ref.tomp200.dto.TravellerRequirementsPreviousLeg
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
 * @param subMode short string, display names (length 0-75)
 * @param propertyClass 
 * @param operators 
 * @param products 
 * @param assets 
 * @param zones 
 * @param distribution 
 * @param avoid 
 * @param previousLeg 
 * @param estimatedUsage 
 * @param prmNeeds 
 */
data class TravellerRequirements(

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("mode") val mode: Mode? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("subMode") val subMode: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("class") val propertyClass: ClassOfUse? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("operators") val operators: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("products") val products: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("assets") val assets: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("zones") val zones: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("distribution") val distribution: kotlin.collections.List<Distribution>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("avoid") val avoid: TravellerRequirementsAvoid? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("previousLeg") val previousLeg: TravellerRequirementsPreviousLeg? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("estimatedUsage") val estimatedUsage: TravellerRequirementsEstimatedUsage? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("prmNeeds") val prmNeeds: kotlin.collections.List<PrmNeeds>? = null
) {

}

