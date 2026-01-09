package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicket
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
 * @param id https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param properties 
 */
data class GetSupportTickets200ResponseFeaturesInner(

    @get:Pattern(regexp="^(Feature)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @Schema(example = "null", description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("properties") val properties: SupportTicket? = null
) {

}

