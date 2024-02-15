package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * To identify the operator
 * @param number
 * @param place
 */
data class ChamberOfCommerceInfo(
    @Schema(example = "null")
    val number: String? = null,
    @Schema(example = "null")
    val place: String? = null,
)
