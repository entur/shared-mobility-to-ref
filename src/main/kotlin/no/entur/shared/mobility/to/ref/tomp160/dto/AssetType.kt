package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.Asset
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetClass
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetProperties
import no.entur.shared.mobility.to.ref.tomp160.dto.Condition
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemPricingPlan
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
 * @param id Unique identifier of an asset type,
 * @param stationId If stationId is present, the nrAvailable is expected to find the availability at that particular station
 * @param nrAvailable 
 * @param assets use this field only in the map-oriented scenario or in the committed bookings. Don't use it in public data (to prevent GDPR issues).
 * @param assetClass 
 * @param assetSubClass a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.
 * @param sharedProperties 
 * @param applicablePricings pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)
 * @param defaultPricingPlan 
 * @param conditions extra information about the asset type, making it possible to f.x. specifying that booking this car requires a driver license.
 */
data class AssetType(

    @Schema(example = "null", required = true, description = "Unique identifier of an asset type,")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @Schema(example = "null", description = "If stationId is present, the nrAvailable is expected to find the availability at that particular station")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("nrAvailable") val nrAvailable: kotlin.Int? = null,

    @field:Valid
    @Schema(example = "null", description = "use this field only in the map-oriented scenario or in the committed bookings. Don't use it in public data (to prevent GDPR issues).")
    @get:JsonProperty("assets") val assets: kotlin.collections.List<Asset>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("assetClass") val assetClass: AssetClass? = null,

    @Schema(example = "null", description = "a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.")
    @get:JsonProperty("assetSubClass") val assetSubClass: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("sharedProperties") val sharedProperties: AssetProperties? = null,

    @field:Valid
    @Schema(example = "null", description = "pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)")
    @get:JsonProperty("applicablePricings") val applicablePricings: kotlin.collections.List<SystemPricingPlan>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("defaultPricingPlan") val defaultPricingPlan: SystemPricingPlan? = null,

    @field:Valid
    @Schema(example = "null", description = "extra information about the asset type, making it possible to f.x. specifying that booking this car requires a driver license.")
    @get:JsonProperty("conditions") val conditions: kotlin.collections.List<Condition>? = null
    ) {

}

