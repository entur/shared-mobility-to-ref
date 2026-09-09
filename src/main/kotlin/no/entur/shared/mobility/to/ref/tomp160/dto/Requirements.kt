package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.Requirement
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
 * Requirements from the end user side.
 * @param abilities 
 * @param bringAlong 
 */
data class Requirements(

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("abilities")
    @get:JsonProperty("abilities") val abilities: kotlin.collections.List<Requirement>? = null,

    @field:Valid
    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("bringAlong")
    @get:JsonProperty("bringAlong") val bringAlong: kotlin.collections.List<Requirement>? = null
) {

}

