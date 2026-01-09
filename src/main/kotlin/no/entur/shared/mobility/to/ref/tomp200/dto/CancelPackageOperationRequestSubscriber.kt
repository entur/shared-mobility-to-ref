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
 * 
 * @param successUri 
 * @param inProgressUri 
 * @param failedUri 
 */
data class CancelPackageOperationRequestSubscriber(

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("successUri") val successUri: java.net.URI? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("inProgressUri") val inProgressUri: java.net.URI? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("failedUri") val failedUri: java.net.URI? = null
) {

}

