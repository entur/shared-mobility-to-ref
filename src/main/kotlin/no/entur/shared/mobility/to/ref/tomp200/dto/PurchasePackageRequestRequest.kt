package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseOffersRequestRequestSubscriber
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchasePackageRequestRequestInputs
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
 * @param inputs 
 * @param subscriber 
 */
data class PurchasePackageRequestRequest(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("inputs", required = true) val inputs: PurchasePackageRequestRequestInputs,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("subscriber") val subscriber: PurchaseOffersRequestRequestSubscriber? = null
) {

}

