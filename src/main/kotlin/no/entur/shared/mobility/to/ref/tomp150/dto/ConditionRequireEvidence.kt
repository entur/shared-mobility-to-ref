package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.Condition
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
 * use this condition to specify the evidence you require as TO in the off-boarding process. It can be used in addition with the static process identifier 'OFF_BOARDING_REQUIRED'. The evidence should be delivered in the /legs/{id}/events object (legEvent), in the `url` array This construct is deprecated since v1.5. Please migrate it to conditionRequireOffboardingSteps
 * @param evidenceTypes 
 */
data class ConditionRequireEvidence(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("evidenceTypes", required = true) val evidenceTypes: kotlin.collections.List<ConditionRequireEvidence.EvidenceTypes>,

    @Schema(example = "null", required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,

    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @get:JsonProperty("id") override val id: kotlin.String? = null
) : Condition {

    /**
    * 
    * Values: PARKED,HELMET_IN_BASKET,CHARGING
    */
    enum class EvidenceTypes(@get:JsonValue val value: kotlin.String) {

        PARKED("PARKED"),
        HELMET_IN_BASKET("HELMET_IN_BASKET"),
        CHARGING("CHARGING");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EvidenceTypes {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ConditionRequireEvidence'")
            }
        }
    }

}

