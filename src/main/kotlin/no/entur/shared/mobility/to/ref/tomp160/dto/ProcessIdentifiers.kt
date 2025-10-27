package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * Process Identifiers deliberately not included in the specification, since new ones pop up regularly. <br> Known identifiers can be found at https://github.com/TOMP-WG/TOMP-API/wiki/ProcessIdentifiers.<br>
 * @param operatorInformation 
 * @param planning 
 * @param booking 
 * @param tripExecution 
 * @param support 
 * @param payment 
 * @param general 
 */
data class ProcessIdentifiers(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("operatorInformation", required = true) val operatorInformation: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("planning", required = true) val planning: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("booking", required = true) val booking: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tripExecution", required = true) val tripExecution: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("support", required = true) val support: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("payment", required = true) val payment: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("general", required = true) val general: kotlin.collections.List<kotlin.String>
) {

}

