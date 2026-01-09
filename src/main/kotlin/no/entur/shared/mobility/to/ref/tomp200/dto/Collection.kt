package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Extent
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
 * @param id identifier of the collection used, for example, in URIs
 * @param links 
 * @param title human readable title of the collection
 * @param description a description of the features in the collection
 * @param extent 
 * @param crs the list of coordinate reference systems supported by the service
 */
data class Collection(

    @Schema(example = "null", required = true, description = "identifier of the collection used, for example, in URIs")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("links", required = true) val links: kotlin.collections.List<Link>,

    @Schema(example = "null", description = "human readable title of the collection")
    @get:JsonProperty("title") val title: kotlin.String? = null,

    @Schema(example = "null", description = "a description of the features in the collection")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("extent") val extent: Extent? = null,

    @Schema(example = "null", description = "the list of coordinate reference systems supported by the service")
    @get:JsonProperty("crs") val crs: kotlin.collections.List<kotlin.String>? = arrayListOf("http://www.opengis.net/def/crs/OGC/1.3/CRS84")
) {

}

