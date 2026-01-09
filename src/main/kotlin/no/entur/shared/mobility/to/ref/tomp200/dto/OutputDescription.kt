package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.DescriptionTypeAdditionalParameters
import no.entur.shared.mobility.to.ref.tomp200.dto.Metadata
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
 * @param schema 
 * @param title 
 * @param description 
 * @param keywords 
 * @param metadata 
 * @param additionalParameters 
 */
data class OutputDescription(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("schema", required = true) val schema: kotlin.Any,

    @Schema(example = "null", description = "")
    @get:JsonProperty("title") val title: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("keywords") val keywords: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("metadata") val metadata: kotlin.collections.List<Metadata>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("additionalParameters") val additionalParameters: DescriptionTypeAdditionalParameters? = null
) {

}

