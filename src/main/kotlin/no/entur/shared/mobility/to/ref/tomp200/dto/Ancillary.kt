package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.FareStructure
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
 * @param id default string, full names etc (length 0-200)
 * @param type 
 * @param name short string, display names (length 0-75)
 * @param description long string, memos etc (length 0-10.000)
 * @param product default string, full names etc (length 0-200)
 * @param image valid URL
 * @param fee 
 */
data class Ancillary(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Pattern(regexp="^(ancillary)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("product") val product: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "valid URL")
    @get:JsonProperty("image") val image: java.net.URI? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("fee") val fee: FareStructure? = null
) {

}

