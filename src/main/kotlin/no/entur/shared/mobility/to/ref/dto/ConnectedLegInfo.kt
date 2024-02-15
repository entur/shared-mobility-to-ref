package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * this object describes the previous leg. It can contain f.x. a flight number, a used parking to get a discount, etc.
 * @param provider the provider of the previous leg (usually a Transport Operator reference)
 * @param assetReference the identification of the previous asset, like a flight number. This field (in case of a specific asset) or
 * assetTypeReference must be filled.
 * @param assetTypeReference the identification of the previous asset type, like a discount combi. This field
 * (in case of a specific asset type) or asset reference must be filled.
 */
data class ConnectedLegInfo(
    @Schema(example = "null", description = "the provider of the previous leg (usually a Transport Operator reference)")
    val provider: String? = null,
    @Schema(
        example = "null",
        description =
            "the identification of the previous asset, like a flight number. This field (in case of a specific asset) " +
                "or assetTypeReference must be filled.",
    )
    val assetReference: String? = null,
    @Schema(
        example = "null",
        description =
            "the identification of the previous asset type, like a discount combi. " +
                "This field (in case of a specific asset type) or asset reference must be filled.",
    )
    val assetTypeReference: String? = null,
)
