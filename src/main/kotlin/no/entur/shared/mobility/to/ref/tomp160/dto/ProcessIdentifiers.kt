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

    @Schema(required = true, description = "")
    @param:JsonProperty("operatorInformation", required = true)
    @get:JsonProperty("operatorInformation", required = true) val operatorInformation: kotlin.collections.List<kotlin.String>,

    @Schema(required = true, description = "")
    @param:JsonProperty("planning", required = true)
    @get:JsonProperty("planning", required = true) val planning: kotlin.collections.List<kotlin.String>,

    @Schema(required = true, description = "")
    @param:JsonProperty("booking", required = true)
    @get:JsonProperty("booking", required = true) val booking: kotlin.collections.List<kotlin.String>,

    @Schema(required = true, description = "")
    @param:JsonProperty("tripExecution", required = true)
    @get:JsonProperty("tripExecution", required = true) val tripExecution: kotlin.collections.List<kotlin.String>,

    @Schema(required = true, description = "")
    @param:JsonProperty("support", required = true)
    @get:JsonProperty("support", required = true) val support: kotlin.collections.List<kotlin.String>,

    @Schema(required = true, description = "")
    @param:JsonProperty("payment", required = true)
    @get:JsonProperty("payment", required = true) val payment: kotlin.collections.List<kotlin.String>,

    @Schema(required = true, description = "")
    @param:JsonProperty("general", required = true)
    @get:JsonProperty("general", required = true) val general: kotlin.collections.List<kotlin.String>
) {

}

