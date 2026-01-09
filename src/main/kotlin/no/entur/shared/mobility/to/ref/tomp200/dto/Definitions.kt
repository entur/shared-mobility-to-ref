package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Ancillary
import no.entur.shared.mobility.to.ref.tomp200.dto.Asset
import no.entur.shared.mobility.to.ref.tomp200.dto.Place
import no.entur.shared.mobility.to.ref.tomp200.dto.ProductProperties
import no.entur.shared.mobility.to.ref.tomp200.dto.Traveller
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
 * object containing all necessary collections for a package and a offerCollection Both refer to objects in these collections.
 * @param products 
 * @param places Places that are not specified in an external data source (like a home address)
 * @param ancillaries 
 * @param assets 
 * @param travellers 
 */
data class Definitions(

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("products") val products: kotlin.collections.List<ProductProperties>? = null,

    @field:Valid
    @get:Size(min=0,max=5) 
    @Schema(example = "null", description = "Places that are not specified in an external data source (like a home address)")
    @get:JsonProperty("places") val places: kotlin.collections.List<Place>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("ancillaries") val ancillaries: kotlin.collections.List<Ancillary>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("assets") val assets: kotlin.collections.List<Asset>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("travellers") val travellers: kotlin.collections.List<Traveller>? = null
) {

}

