package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Place
import no.entur.shared.mobility.to.ref.tomp200.dto.SearchOfferRequestSpecification
import no.entur.shared.mobility.to.ref.tomp200.dto.Traveller
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
 * A package planning request, resulting in offers
 * @param type 
 * @param specification 
 * @param requirements 
 * @param travellers 
 * @param places Places that are not specified in an external data source (like a home address)
 * @param packageToExchange default string, full names etc (length 0-200)
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class SearchOfferRequest(

    @get:Pattern(regexp="^(searchOffer)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("specification", required = true) val specification: SearchOfferRequestSpecification,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("requirements") val requirements: TravellerRequirements? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("travellers") val travellers: kotlin.collections.List<Traveller>? = null,

    @field:Valid
    @get:Size(min=0,max=5) 
    @Schema(example = "null", description = "Places that are not specified in an external data source (like a home address)")
    @get:JsonProperty("places") val places: kotlin.collections.List<Place>? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("packageToExchange") val packageToExchange: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

