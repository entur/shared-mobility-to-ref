package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.FareStructure
import no.entur.shared.mobility.to.ref.tomp200.dto.Guarantee
import no.entur.shared.mobility.to.ref.tomp200.dto.Label
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
 * a product within a package
 * @param type 
 * @param id default string, full names etc (length 0-200)
 * @param name default string, full names etc (length 0-200)
 * @param description long string, memos etc (length 0-10.000)
 * @param parts to be used for composed products.
 * @param fare 
 * @param conditions 
 * @param guarantees 
 */
data class ProductProperties(

    @get:Pattern(regexp="^(product)$")
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "to be used for composed products.")
    @get:JsonProperty("parts") val parts: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("fare") val fare: FareStructure? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("conditions") val conditions: kotlin.collections.List<Label>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("guarantees") val guarantees: kotlin.collections.List<Guarantee>? = null
) {

}

