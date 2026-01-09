package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Ancillary
import no.entur.shared.mobility.to.ref.tomp200.dto.GeojsonGeometry
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
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
 * @param properties 
 * @param id short string, display names (length 0-75)
 * @param geometry 
 * @param links 
 */
data class AncillaryCollectionFeaturesInner(

    @get:Pattern(regexp="^(Feature)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("properties", required = true) val properties: Ancillary,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("geometry") val geometry: GeojsonGeometry? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

