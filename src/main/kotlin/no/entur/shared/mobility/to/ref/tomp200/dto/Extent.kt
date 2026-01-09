package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.ExtentSpatial
import no.entur.shared.mobility.to.ref.tomp200.dto.ExtentTemporal
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
 * The extent of the features in the collection. In the Core only spatial and temporal extents are specified. Extensions may add additional members to represent other extents, for example, thermal or pressure ranges.
 * @param spatial 
 * @param temporal 
 */
data class Extent(

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("spatial") val spatial: ExtentSpatial? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("temporal") val temporal: ExtentTemporal? = null
) {

}

