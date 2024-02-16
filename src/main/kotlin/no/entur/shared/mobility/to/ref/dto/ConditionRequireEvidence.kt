package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * use this condition to specify the evidence you require as TO in the off-boarding process. It can be used in addition with the static
 * process identifier 'OFF_BOARDING_REQUIRED'. The evidence should be delivered in the /legs/{id}/events object (legEvent), in the `url`
 * array This construct is deprecated since v1.5. Please migrate it to conditionRequireOffboardingSteps
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param evidenceTypes
 * @param id An identifier for this condition that can be used to refer to this condition
 */
data class ConditionRequireEvidence(
    @Schema(
        example = "null",
        required = true,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    @get:JsonProperty("conditionType", required = true) override val conditionType: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty(
        "evidenceTypes",
        required = true,
    ) val evidenceTypes: List<EvidenceTypes>,
    @Schema(
        example = "deposit50eu",
        description = "An identifier for this condition that can be used to refer to this condition",
    )
    val id: String? = null,
) : AssetTypeConditionsInner {
    enum class EvidenceTypes {
        PARKED,
        HELMET_IN_BASKET,
        CHARGING,
    }
}
