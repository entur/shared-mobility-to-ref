package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.AmountOfMoney
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
 * @param cancellable is it possible to cancel this package?
 * @param fee 
 * @param feePercentage percentage of the offered price you have to pay when you cancel this purchased package
 */
data class SummaryCancellation(

    @Schema(example = "null", description = "is it possible to cancel this package?")
    @get:JsonProperty("cancellable") val cancellable: kotlin.Boolean? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("fee") val fee: AmountOfMoney? = null,

    @get:DecimalMin("0")
    @get:DecimalMax("100")
    @Schema(example = "null", description = "percentage of the offered price you have to pay when you cancel this purchased package")
    @get:JsonProperty("feePercentage") val feePercentage: java.math.BigDecimal? = null
) {

}

