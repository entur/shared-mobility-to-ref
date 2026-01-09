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
 * @param type 
 * @param from this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param via use an ID contained in the **places** field, or from an external source, when using coordinates, please use the prefix 'gps:'
 * @param to this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param startTime https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param endTime https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 */
data class TravelSpecification(

    @get:Pattern(regexp="^(travelSpecification)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("from") val from: kotlin.String? = null,

    @get:Size(min=0,max=3) 
    @Schema(example = "null", description = "use an ID contained in the **places** field, or from an external source, when using coordinates, please use the prefix 'gps:'")
    @get:JsonProperty("via") val via: kotlin.collections.List<kotlin.String>? = null,

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("to") val to: kotlin.String? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("startTime") val startTime: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("endTime") val endTime: java.time.OffsetDateTime? = null
) {

}

