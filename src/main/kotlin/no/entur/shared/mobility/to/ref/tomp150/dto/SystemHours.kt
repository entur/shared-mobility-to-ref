package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.Day
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
 * @param startTime 
 * @param endTime 
 * @param days An array of abbreviations (first 3 letters) of English names of the days of the week that this hour object applies to (i.e. [\"mon\", \"tue\"]). Each day can only appear once within all of the hours objects in this feed.
 * @param userType This indicates that this set of rental hours applies to either members or non-members only.
 * @param stationId If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours of the station. (GET /operator/stations)
 * @param regionId If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours for the region. (GET /operator/regions)
 */
data class SystemHours(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("startTime", required = true) val startTime: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("endTime", required = true) val endTime: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "An array of abbreviations (first 3 letters) of English names of the days of the week that this hour object applies to (i.e. [\"mon\", \"tue\"]). Each day can only appear once within all of the hours objects in this feed.")
    @get:JsonProperty("days", required = true) val days: kotlin.collections.List<Day>,

    @Schema(example = "MEMBER", description = "This indicates that this set of rental hours applies to either members or non-members only.")
    @get:JsonProperty("userType") val userType: SystemHours.UserType? = null,

    @Schema(example = "null", description = "If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours of the station. (GET /operator/stations)")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(example = "null", description = "If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours for the region. (GET /operator/regions)")
    @get:JsonProperty("regionId") val regionId: kotlin.String? = null
) {

    /**
    * This indicates that this set of rental hours applies to either members or non-members only.
    * Values: MEMBER,NON_MEMBERS
    */
    enum class UserType(@get:JsonValue val value: kotlin.String) {

        MEMBER("MEMBER"),
        NON_MEMBERS("NON_MEMBERS");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): UserType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'SystemHours'")
            }
        }
    }

}

