package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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
 * this object describes the previous leg. It can contain f.x. a flight number, a used parking to get a discount, etc.
 * @param provider the provider of the previous leg (usually a Transport Operator reference)
 * @param assetReference the identification of the previous asset, like a flight number. This field (in case of a specific asset) or assetTypeReference must be filled.
 * @param assetTypeReference the identification of the previous asset type, like a discount combi. This field (in case of a specific asset type) or asset reference must be filled.
 */
data class ConnectedLegInfo(

    @Schema(description = "the provider of the previous leg (usually a Transport Operator reference)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("provider")
    @get:JsonProperty("provider") val provider: kotlin.String? = null,

    @Schema(description = "the identification of the previous asset, like a flight number. This field (in case of a specific asset) or assetTypeReference must be filled.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("assetReference")
    @get:JsonProperty("assetReference") val assetReference: kotlin.String? = null,

    @Schema(description = "the identification of the previous asset type, like a discount combi. This field (in case of a specific asset type) or asset reference must be filled.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("assetTypeReference")
    @get:JsonProperty("assetTypeReference") val assetTypeReference: kotlin.String? = null
) {

}

