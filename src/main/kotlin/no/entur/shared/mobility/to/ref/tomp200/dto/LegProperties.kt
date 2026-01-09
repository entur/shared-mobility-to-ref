package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Label
import no.entur.shared.mobility.to.ref.tomp200.dto.LegStatus
import no.entur.shared.mobility.to.ref.tomp200.dto.Mode
import no.entur.shared.mobility.to.ref.tomp200.dto.TravelSpecification
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
 * A (planned) consumption of a product within a package
 * @param type 
 * @param id default string, full names etc (length 0-200)
 * @param specification 
 * @param sequenceNumber a bit short integer (0-100)
 * @param mode 
 * @param status 
 * @param travellers 
 * @param products The main product (v1.x 'asset type') used to execute this leg
 * @param ancillaries additional products that can be assigned to this leg
 * @param assets The physical asset(s) used for the execution of the leg
 * @param operatorId default string, full names etc (length 0-200)
 * @param operatorName default string, full names etc (length 0-200)
 * @param labels 
 * @param returnLocations 
 */
data class LegProperties(

    @get:Pattern(regexp="^(leg)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("specification", required = true) val specification: TravelSpecification,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "a bit short integer (0-100)")
    @get:JsonProperty("sequenceNumber") val sequenceNumber: kotlin.Int? = 0,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("mode") val mode: Mode? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("status") val status: LegStatus? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("travellers") val travellers: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "The main product (v1.x 'asset type') used to execute this leg")
    @get:JsonProperty("products") val products: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "additional products that can be assigned to this leg")
    @get:JsonProperty("ancillaries") val ancillaries: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "The physical asset(s) used for the execution of the leg")
    @get:JsonProperty("assets") val assets: kotlin.collections.List<kotlin.String>? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("operatorId") val operatorId: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("operatorName") val operatorName: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("labels") val labels: kotlin.collections.List<Label>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("returnLocations") val returnLocations: kotlin.collections.List<kotlin.String>? = null
) {

}

