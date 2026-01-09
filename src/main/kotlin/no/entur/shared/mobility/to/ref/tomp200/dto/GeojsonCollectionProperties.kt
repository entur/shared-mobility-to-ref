package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Definitions
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
 * @param type 
 * @param id short string, display names (length 0-75)
 * @param definitions 
 */
data class GeojsonCollectionProperties(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=75)
    @Schema(example = "null", required = true, description = "short string, display names (length 0-75)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("definitions") val definitions: Definitions? = null
) : kotlin.collections.HashMap<String, kotlin.Any>() {

}

