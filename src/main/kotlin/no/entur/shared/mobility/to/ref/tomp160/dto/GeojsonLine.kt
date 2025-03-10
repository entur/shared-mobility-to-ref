package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.GeojsonGeometry
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
 * An array of WGS84 coordinate pairs
 * @param coordinates Geojson Coordinate
 */
data class GeojsonLine(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("type", required = true) override val type: kotlin.String,

    @Schema(example = "[[6.169639,52.253279],[6.05623,52.63473]]", description = "Geojson Coordinate")
    @get:JsonProperty("coordinates") val coordinates: kotlin.collections.List<kotlin.collections.List<kotlin.Float>>? = null
    ) : GeojsonGeometry{

}

