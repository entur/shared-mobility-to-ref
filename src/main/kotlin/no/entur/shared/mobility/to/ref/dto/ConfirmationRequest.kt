package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * the TO can ask permission to do something to the MP, as the MP is financially responsible.
 * @param type
 * @param assetTypeId reference to the assetType in /operator/available-assets, this property can be set when replacing an asset
 * (for another type). In case of a successful replacement, the /legs/{id}/events - ASSIGN_ASSET should be sent to the MP to inform a
 * change of asset has been made.
 */
data class ConfirmationRequest(
    @Schema(example = "null")
    val type: Type? = null,
    @Schema(
        example = "null",
        description = """reference to the assetType in /operator/available-assets, this property can be set when replacing an asset 
            |(for another type). In case of a successful replacement, the /legs/{id}/events - ASSIGN_ASSET should be send to the MP to 
            |inform a change of asset has been made.""",
    )
    val assetTypeId: String? = null,
) {
    enum class Type {
        REPLACE_ASSET,
        START_LEG,
    }
}
