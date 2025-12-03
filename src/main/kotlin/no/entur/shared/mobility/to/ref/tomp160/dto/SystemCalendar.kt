package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * @param startMonth Starting month for the system operations (1-12)
 * @param startDay Starting day for the system operations (1-31)
 * @param endMonth Ending month for the system operations (1-12)
 * @param endDay Ending day for the system operations (1-31)
 * @param stationId If this parameter is present, it means that start and end prameters correspond to the opening and closing days of the station. (GET /operator/stations)
 * @param regionId If this parameter is present, it means that start and end prameters correspond to the opening and closing days for the region. (GET /operator/regions)
 * @param startYear Starting year for the system operations
 * @param endYear Ending year for the system operations
 */
data class SystemCalendar(

    @get:Min(1)
    @get:Max(12)
    @Schema(example = "1", required = true, description = "Starting month for the system operations (1-12)")
    @get:JsonProperty("startMonth", required = true) val startMonth: kotlin.Int,

    @get:Min(1)
    @get:Max(31)
    @Schema(example = "1", required = true, description = "Starting day for the system operations (1-31)")
    @get:JsonProperty("startDay", required = true) val startDay: kotlin.Int,

    @get:Min(1)
    @get:Max(12)
    @Schema(example = "12", required = true, description = "Ending month for the system operations (1-12)")
    @get:JsonProperty("endMonth", required = true) val endMonth: kotlin.Int,

    @get:Min(1)
    @get:Max(31)
    @Schema(example = "31", required = true, description = "Ending day for the system operations (1-31)")
    @get:JsonProperty("endDay", required = true) val endDay: kotlin.Int,

    @Schema(example = "null", description = "If this parameter is present, it means that start and end prameters correspond to the opening and closing days of the station. (GET /operator/stations)")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(example = "null", description = "If this parameter is present, it means that start and end prameters correspond to the opening and closing days for the region. (GET /operator/regions)")
    @get:JsonProperty("regionId") val regionId: kotlin.String? = null,

    @Schema(example = "2019", description = "Starting year for the system operations")
    @get:JsonProperty("startYear") val startYear: kotlin.Int? = null,

    @Schema(example = "2099", description = "Ending year for the system operations")
    @get:JsonProperty("endYear") val endYear: kotlin.Int? = null
) {

}

