package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
import no.entur.shared.mobility.to.ref.tomp200.dto.OfferCollectionProperties
import no.entur.shared.mobility.to.ref.tomp200.dto.OfferFeature
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
 * @param features 
 * @param properties 
 * @param numberMatched 
 * @param numberReturned 
 * @param links actions that can be performed on this package, but also alternative (rel=alternative+1, alternative+2) offers or references to other resources In case it is an alternative, specify clearly in the description what the financial consequences are.
 */
data class OfferCollection(

    @get:Pattern(regexp="^(FeatureCollection)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("features") val features: kotlin.collections.List<OfferFeature>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("properties") val properties: OfferCollectionProperties? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("numberMatched") val numberMatched: java.math.BigDecimal? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("numberReturned") val numberReturned: java.math.BigDecimal? = null,

    @field:Valid
    @Schema(example = "null", description = "actions that can be performed on this package, but also alternative (rel=alternative+1, alternative+2) offers or references to other resources In case it is an alternative, specify clearly in the description what the financial consequences are.")
    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

