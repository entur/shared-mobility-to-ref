package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 *
 * @param startTime
 * @param endTime
 * @param days An array of abbreviations (first 3 letters) of English names of the days of the week that this hour object applies to
 * (i.e. [\"mon\", \"tue\"]). Each day can only appear once within all of the hours objects in this feed.
 * @param userType This indicates that this set of rental hours applies to either members or non-members only.
 * @param stationId If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours of the
 * station. (GET /operator/stations)
 * @param regionId If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours for the
 * region. (GET /operator/regions)
 */
data class SystemHours(
    @Schema(example = "null", required = true)
    @get:JsonProperty("startTime", required = true) val startTime: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty("endTime", required = true) val endTime: String,
    @field:Valid
    @Schema(
        example = "null",
        required = true,
        description = """An array of abbreviations (first 3 letters) of English names of the days of the week that this hour object 
            |applies to (i.e. ["mon", "tue"]). Each day can only appear once within all of the hours objects in this feed.""",
    )
    @get:JsonProperty("days", required = true) val days: List<Day>,
    @Schema(
        example = "MEMBER",
        description = "This indicates that this set of rental hours applies to either members or non-members only.",
    )
    val userType: UserType? = null,
    @Schema(
        example = "null",
        description = """If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours of 
            |the station. (GET /operator/stations)""",
    )
    val stationId: String? = null,
    @Schema(
        example = "null",
        description = """If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours for 
            |the region. (GET /operator/regions)""",
    )
    val regionId: String? = null,
) {
    /**
     * This indicates that this set of rental hours applies to either members or non-members only.
     */
    enum class UserType {
        MEMBER,
        NON_MEMBERS,
    }
}
