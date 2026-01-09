package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Customer
import no.entur.shared.mobility.to.ref.tomp200.dto.Distribution
import no.entur.shared.mobility.to.ref.tomp200.dto.Traveller
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
 * @param products 
 * @param customer 
 * @param location this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.
 * @param distribution 
 * @param traveller 
 */
data class PurchaseProductRequestRequestInputs(

    @get:Size(min=1)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("products", required = true) val products: kotlin.collections.List<kotlin.String>,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("customer") val customer: Customer? = null,

    @get:Pattern(regexp="^(GPS|gps|{datasource-prefix}|P):[a-zA-Z0-9\\-_.]+$")
    @get:Size(max=200)
    @Schema(example = "null", description = "this string references to information that can be found in the `data sources`. Enlist all prefixes (=rel) from the /collections/datasources/items that apply to a place/location. Default it matches already with 'GPS' (no entry required in the datasources). In case of a custom place (like home address), you can use the 'P:' prefix and add the address to the **places** list of the request/offer/package.")
    @get:JsonProperty("location") val location: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("distribution") val distribution: Distribution? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("traveller") val traveller: kotlin.collections.List<Traveller>? = null
) {

}

