package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.FareStructure
import no.entur.shared.mobility.to.ref.tomp200.dto.Guarantee
import no.entur.shared.mobility.to.ref.tomp200.dto.LegProperties
import no.entur.shared.mobility.to.ref.tomp200.dto.PackageStatus
import no.entur.shared.mobility.to.ref.tomp200.dto.Summary
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
 * a purchased package is a registration of an agreement between end user and TO, to execute a package (=set of legs) according a specification, including all conditions (labels)
 * @param type 
 * @param id default string, full names etc (length 0-200)
 * @param status 
 * @param summary 
 * @param price 
 * @param guarantees 
 * @param legs 
 * @param offers contains offered packages, so it is only applicable when the type is package. When a package only contains one offer, this property should be neglected. All references in the offers refer to the products the packageProperties. Optional - the offers can be retrieved using the /collections/offers/items?offerId={reference} endpoint.
 * @param customFields dictionary for extra fields (bilatural agreements)
 */
data class PackageProperties(

    @get:Pattern(regexp="^(offer|package)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("status", required = true) val status: PackageStatus,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("summary") val summary: Summary? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("price") val price: FareStructure? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("guarantees") val guarantees: kotlin.collections.List<Guarantee>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("legs") val legs: kotlin.collections.List<LegProperties>? = null,

    @field:Valid
    @Schema(example = "null", description = "contains offered packages, so it is only applicable when the type is package. When a package only contains one offer, this property should be neglected. All references in the offers refer to the products the packageProperties. Optional - the offers can be retrieved using the /collections/offers/items?offerId={reference} endpoint.")
    @get:JsonProperty("offers") val offers: kotlin.collections.List<Summary>? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

