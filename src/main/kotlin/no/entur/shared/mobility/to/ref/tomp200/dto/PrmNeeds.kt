package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param encumbranceNeed 
 * @param medicalNeed 
 * @param mobilityNeed 
 * @param psychoSensoryNeed 
 */
data class PrmNeeds(

    @Schema(example = "null", description = "")
    @get:JsonProperty("encumbranceNeed") val encumbranceNeed: PrmNeeds.EncumbranceNeed? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("medicalNeed") val medicalNeed: PrmNeeds.MedicalNeed? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("mobilityNeed") val mobilityNeed: PrmNeeds.MobilityNeed? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("psychoSensoryNeed") val psychoSensoryNeed: PrmNeeds.PsychoSensoryNeed? = null
) {

    /**
    * 
    * Values: PUSHCHAIR,BAGGAGE_TROLLEY,OVERSIZED_BAGGAGE,LUGGAGE_ENCUMBRANCE,GUIDE_DOG,OTHER_ANIMAL,BIKE
    */
    enum class EncumbranceNeed(@get:JsonValue val value: kotlin.String) {

        PUSHCHAIR("pushchair"),
        BAGGAGE_TROLLEY("baggage_trolley"),
        OVERSIZED_BAGGAGE("oversized_baggage"),
        LUGGAGE_ENCUMBRANCE("luggage_encumbrance"),
        GUIDE_DOG("guide_dog"),
        OTHER_ANIMAL("other_animal"),
        BIKE("bike");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EncumbranceNeed {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PrmNeeds'")
            }
        }
    }

    /**
    * 
    * Values: HEART_CONDITION,OTHER
    */
    enum class MedicalNeed(@get:JsonValue val value: kotlin.String) {

        HEART_CONDITION("heart_condition"),
        OTHER("other");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): MedicalNeed {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PrmNeeds'")
            }
        }
    }

    /**
    * 
    * Values: WHEELCHAIR,ASSISTED_WHEELCHAIR,MOTORIZED_WHEELCHAIR,MOBILITY_SCOOTER,ROAD_MOBILITY_SCOOTER,WALKING_FRAME,RESTRICTED_MOBILITY,OTHER
    */
    enum class MobilityNeed(@get:JsonValue val value: kotlin.String) {

        WHEELCHAIR("wheelchair"),
        ASSISTED_WHEELCHAIR("assisted_wheelchair"),
        MOTORIZED_WHEELCHAIR("motorized_wheelchair"),
        MOBILITY_SCOOTER("mobility_scooter"),
        ROAD_MOBILITY_SCOOTER("road_mobility_scooter"),
        WALKING_FRAME("walking_frame"),
        RESTRICTED_MOBILITY("restricted_mobility"),
        OTHER("other");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): MobilityNeed {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PrmNeeds'")
            }
        }
    }

    /**
    * 
    * Values: VISUAL_IMPAIRED,AUDITORY_IMPAIRED,COGNITIVE_IMPAIRED,AVERSE_TO_LIFTS,AVERSE_TO_ESCALATORS,AVERSE_TO_CONFINED_SPACES,AVERSE_TO_CROWDS,OTHER
    */
    enum class PsychoSensoryNeed(@get:JsonValue val value: kotlin.String) {

        VISUAL_IMPAIRED("visual_impaired"),
        AUDITORY_IMPAIRED("auditory_impaired"),
        COGNITIVE_IMPAIRED("cognitive_impaired"),
        AVERSE_TO_LIFTS("averse_to_lifts"),
        AVERSE_TO_ESCALATORS("averse_to_escalators"),
        AVERSE_TO_CONFINED_SPACES("averse_to_confined_spaces"),
        AVERSE_TO_CROWDS("averse_to_crowds"),
        OTHER("other");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): PsychoSensoryNeed {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'PrmNeeds'")
            }
        }
    }

}

