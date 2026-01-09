package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.ClassOfUse
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
 * @param name short string, display names (length 0-75)
 * @param accomodationClass 
 * @param accomodationGender 
 * @param sleeper 
 * @param nuisances 
 */
data class LegSummaryAccomodation(

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("accomodationClass") val accomodationClass: ClassOfUse? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("accomodationGender") val accomodationGender: LegSummaryAccomodation.AccomodationGender? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("sleeper") val sleeper: kotlin.Boolean? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("nuisances") val nuisances: kotlin.collections.List<LegSummaryAccomodation.Nuisances>? = null
) {

    /**
    * 
    * Values: M,F,X,U
    */
    enum class AccomodationGender(@get:JsonValue val value: kotlin.String) {

        M("M"),
        F("F"),
        X("X"),
        U("U");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): AccomodationGender {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'LegSummaryAccomodation'")
            }
        }
    }

    /**
    * 
    * Values: NO_SMOKING,SMOKING,MOBILE_PHONE_USE_ZONE,MOBILE_PHONE_FREE_ZONE,FAMILY_AREA,BREAST_FEEDING_FRIENDLY,CHILD_FREE_AREA,ANIMALS_ALLOWED,NO_ANIMALS
    */
    enum class Nuisances(@get:JsonValue val value: kotlin.String) {

        NO_SMOKING("no_smoking"),
        SMOKING("smoking"),
        MOBILE_PHONE_USE_ZONE("mobile_phone_use_zone"),
        MOBILE_PHONE_FREE_ZONE("mobile_phone_free_zone"),
        FAMILY_AREA("family_area"),
        BREAST_FEEDING_FRIENDLY("breast_feeding_friendly"),
        CHILD_FREE_AREA("child_free_area"),
        ANIMALS_ALLOWED("animals_allowed"),
        NO_ANIMALS("no_animals");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Nuisances {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'LegSummaryAccomodation'")
            }
        }
    }

}

