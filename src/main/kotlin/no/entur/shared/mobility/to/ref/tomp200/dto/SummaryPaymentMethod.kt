package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.AmountOfMoney
import no.entur.shared.mobility.to.ref.tomp200.dto.TypeOfPaymentMethod
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
 * @param paymentType 
 * @param deposit 
 */
data class SummaryPaymentMethod(

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("paymentType") val paymentType: TypeOfPaymentMethod? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("deposit") val deposit: AmountOfMoney? = null
) {

}

