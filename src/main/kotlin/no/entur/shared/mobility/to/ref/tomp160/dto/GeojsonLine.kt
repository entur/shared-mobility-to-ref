package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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
 * @param type 
 * @param coordinates Geojson Coordinate
 */
data class GeojsonLine(

    @Schema(required = true, description = "")
    @param:JsonProperty("type")
    @get:JsonProperty("type", required = true) override val type: kotlin.String,

    @Schema(example = "[[6.169639,52.253279],[6.05623,52.63473]]", description = "Geojson Coordinate")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("coordinates")
    @get:JsonProperty("coordinates") val coordinates: kotlin.collections.List<kotlin.collections.List<kotlin.Float>>? = null
) : GeojsonGeometry {

}

