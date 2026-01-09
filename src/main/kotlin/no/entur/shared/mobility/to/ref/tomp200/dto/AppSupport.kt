package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.TypeOfTravelDocument
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
 * attributes to display/use in an external app.
 * @param displayName short string, display names (length 0-75)
 * @param description long string, memos etc (length 0-10.000)
 * @param image valid URL
 * @param icon valid URL
 * @param accessMethods how this asset can be opened
 */
data class AppSupport(

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("displayName") val displayName: kotlin.String? = null,

    @get:Size(max=10000)
    @Schema(example = "null", description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "valid URL")
    @get:JsonProperty("image") val image: java.net.URI? = null,

    @field:Valid
    @Schema(example = "null", description = "valid URL")
    @get:JsonProperty("icon") val icon: java.net.URI? = null,

    @field:Valid
    @Schema(example = "null", description = "how this asset can be opened")
    @get:JsonProperty("accessMethods") val accessMethods: kotlin.collections.List<TypeOfTravelDocument>? = null
) {

}

