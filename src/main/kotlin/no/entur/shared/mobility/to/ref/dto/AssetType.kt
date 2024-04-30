package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 *
 * @param id Unique identifier of an asset type,
 * @param stationId If stationId is present, the nrAvailable is expected to find the availability at that particular station
 * @param nrAvailable
 * @param assets use this field only in the map-oriented scenario or in the committed bookings. Don't use it in public data
 * (to prevent GDPR issues).
 * @param assetClass
 * @param assetSubClass a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus',
 * 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.
 * @param sharedProperties
 * @param applicablePricings pricing plans that can be applicable for this assetType. Business logic to determine the final pricing
 * plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)
 * @param defaultPricingPlan
 * @param conditions extra information about the asset type, making it possible to f.x.
 * specifying that booking this car requires a driver license.
 */
data class AssetType(
    @Schema(example = "null", required = true, description = "Unique identifier of an asset type,")
    @get:JsonProperty("id", required = true) val id: String,
    @Schema(
        example = "null",
        description = "If stationId is present, the nrAvailable is expected to find the availability at that particular station",
    )
    val stationId: String? = null,
    @Schema(example = "null")
    val nrAvailable: Int? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = """use this field only in the map-oriented scenario or in the committed bookings. Don't use it in public data 
            |(to prevent GDPR issues).""",
    )
    val assets: List<Asset>? = null,
    @field:Valid
    @Schema(example = "null")
    val assetClass: AssetClass? = null,
    @Schema(
        example = "null",
        description = """a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 
            |'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.""",
    )
    val assetSubClass: String? = null,
    @field:Valid
    @Schema(example = "null")
    val sharedProperties: AssetProperties? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = """pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is 
            |not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)""",
    )
    val applicablePricings: List<SystemPricingPlan>? = null,
    @field:Valid
    @Schema(example = "null")
    val defaultPricingPlan: SystemPricingPlan? = null,
    @field:Valid
    @Schema(
        example = "null",
        description = """extra information about the asset type, making it possible to f.x. specifying that booking this car requires a 
            |driver license.""",
    )
    val conditions: List<AssetTypeConditionsInner>? = null,
)
