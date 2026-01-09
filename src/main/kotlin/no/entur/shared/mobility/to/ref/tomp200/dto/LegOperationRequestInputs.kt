package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.ClassOfUse
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
 * @param leg default string, full names etc (length 0-200)
 * @param timestamp https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param assetLocation this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param userLocation this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param currentCharge percentage of charge available
 * @param time duration, ISO 8601 compliant
 * @param comment free text, should match Content-Language
 * @param evidence 
 * @param propertyClass 
 */
data class LegOperationRequestInputs(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("leg", required = true) val leg: kotlin.String,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("timestamp") val timestamp: java.time.OffsetDateTime? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package") val `package`: kotlin.String? = null,

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("assetLocation") val assetLocation: kotlin.String? = null,

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("userLocation") val userLocation: kotlin.String? = null,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "percentage of charge available")
    @get:JsonProperty("currentCharge") val currentCharge: kotlin.Int? = null,

    @get:Pattern(regexp="/^(-?)P(?=\\d|T\\d)(?:(\\d+)Y)?(?:(\\d+)M)?(?:(\\d+)([DW]))?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+(?:\\.\\d+)?)S)?)?$/")
    @Schema(example = "null", description = "duration, ISO 8601 compliant")
    @get:JsonProperty("time") val time: kotlin.String? = null,

    @Schema(example = "null", description = "free text, should match Content-Language")
    @get:JsonProperty("comment") val comment: kotlin.String? = null,

    @field:Valid
    @get:Size(min=1)
    @Schema(example = "null", description = "")
    @get:JsonProperty("evidence") val evidence: kotlin.collections.List<Link>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("class") val propertyClass: ClassOfUse? = null
) {

}

