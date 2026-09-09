package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.Address
import no.entur.shared.mobility.to.ref.tomp160.dto.Coordinates
import no.entur.shared.mobility.to.ref.tomp160.dto.StopReference
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
 * a origin or destination of a leg, 3D. lon/lat in WGS84.
 * @param coordinates 
 * @param name Human readable name of the place, could match Content-Language
 * @param stopReference 
 * @param stationId reference to /operator/stations
 * @param physicalAddress 
 * @param extraInfo 
 */
data class Place(

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("coordinates", required = true)
    @get:JsonProperty("coordinates", required = true) val coordinates: Coordinates,

    @Schema(description = "Human readable name of the place, could match Content-Language")
    @param:JsonProperty("name")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("stopReference")
    @get:JsonProperty("stopReference") val stopReference: kotlin.collections.List<StopReference>? = null,

    @Schema(description = "reference to /operator/stations")
    @param:JsonProperty("stationId")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("physicalAddress")
    @get:JsonProperty("physicalAddress") val physicalAddress: Address? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("extraInfo")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

