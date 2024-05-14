package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema

/**
 * @property conditionType The specific subclass of condition, should match the schema name exactly
 */

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "conditionType",
    visible = true,
)
@JsonSubTypes(
    JsonSubTypes.Type(ConditionDeposit::class),
    JsonSubTypes.Type(ConditionPayWhenFinished::class),
    JsonSubTypes.Type(ConditionPostponedCommit::class),
    JsonSubTypes.Type(ConditionRequireBookingData::class),
    JsonSubTypes.Type(ConditionReturnArea::class),
    JsonSubTypes.Type(ConditionUpfrontPayment::class),
    JsonSubTypes.Type(ConditionRequireEvidence::class),
    JsonSubTypes.Type(ConditionRequireOnboardingSteps::class),
    JsonSubTypes.Type(ConditionRequireOffboardingSteps::class),
    JsonSubTypes.Type(ConditionRequirePausingSteps::class),
    JsonSubTypes.Type(ConditionRequireResumingSteps::class),
)
interface AssetTypeConditionsInner {
    @get:Schema(
        example = "null",
        requiredMode = Schema.RequiredMode.REQUIRED,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    val conditionType: String
}
