package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Collection
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
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
 * @param links 
 * @param collections 
 */
data class Collections(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("links", required = true) val links: kotlin.collections.List<Link>,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("collections", required = true) val collections: kotlin.collections.List<Collection>
) {

}

