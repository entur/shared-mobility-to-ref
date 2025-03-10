package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * To identify the operator
 * @param number 
 * @param place 
 */
data class ChamberOfCommerceInfo(

    @Schema(example = "null", description = "")
    @get:JsonProperty("number") val number: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("place") val place: kotlin.String? = null
    ) {

}

