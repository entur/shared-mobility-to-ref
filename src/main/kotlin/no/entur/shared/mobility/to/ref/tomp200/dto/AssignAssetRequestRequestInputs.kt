package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * this can be used to assign an asset (/seat) to a leg, by using the field `asset`. If you want to replace an asset, fill the field `replacesAsset` with the asset to replace and `asset` with the new one. If you want to remove an assigned asset from a leg, fill `asset` with 'null' and fill `replacesAsset` with the asset to remove.
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param leg default string, full names etc (length 0-200)
 * @param asset default string, full names etc (length 0-200)
 * @param replacesAsset default string, full names etc (length 0-200)
 */
data class AssignAssetRequestRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package", required = true) val `package`: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("leg", required = true) val leg: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("asset", required = true) val asset: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("replacesAsset") val replacesAsset: kotlin.String? = null
) {

}

