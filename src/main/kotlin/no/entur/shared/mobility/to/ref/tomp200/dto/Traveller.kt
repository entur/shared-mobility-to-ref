package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.TravellerCharacteristics
import no.entur.shared.mobility.to.ref.tomp200.dto.TravellerRequirements
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
 * @param type 
 * @param id default string, full names etc (length 0-200)
 * @param characteristics 
 * @param requirements 
 * @param profile default string, full names etc (length 0-200)
 * @param groupSize in case of a travelling party, specify the (sub)group size with equivalent attributes
 */
data class Traveller(

    @get:Pattern(regexp="^(traveller)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("characteristics") val characteristics: TravellerCharacteristics? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("requirements") val requirements: TravellerRequirements? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("profile") val profile: kotlin.String? = null,

    @Schema(example = "null", description = "in case of a travelling party, specify the (sub)group size with equivalent attributes")
    @get:JsonProperty("groupSize") val groupSize: java.math.BigDecimal? = null
) {

}

