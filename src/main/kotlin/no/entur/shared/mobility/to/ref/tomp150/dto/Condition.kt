package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
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
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param id An identifier for this condition that can be used to refer to this condition
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "conditionType", visible = true)
@JsonSubTypes(
      JsonSubTypes.Type(value = ConditionDeposit::class, name = "ConditionDeposit"),
      JsonSubTypes.Type(value = ConditionPayWhenFinished::class, name = "ConditionPayWhenFinished"),
      JsonSubTypes.Type(value = ConditionPostponedCommit::class, name = "ConditionPostponedCommit"),
      JsonSubTypes.Type(value = ConditionRequireBookingData::class, name = "ConditionRequireBookingData"),
      JsonSubTypes.Type(value = ConditionRequireEvidence::class, name = "ConditionRequireEvidence"),
      JsonSubTypes.Type(value = ConditionRequireOffboardingSteps::class, name = "ConditionRequireOffboardingSteps"),
      JsonSubTypes.Type(value = ConditionRequireOnboardingSteps::class, name = "ConditionRequireOnboardingSteps"),
      JsonSubTypes.Type(value = ConditionRequirePausingSteps::class, name = "ConditionRequirePausingSteps"),
      JsonSubTypes.Type(value = ConditionRequireResumingSteps::class, name = "ConditionRequireResumingSteps"),
      JsonSubTypes.Type(value = ConditionReturnArea::class, name = "ConditionReturnArea"),
      JsonSubTypes.Type(value = ConditionUpfrontPayment::class, name = "ConditionUpfrontPayment")
)

interface Condition{
                @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED, description = "The specific subclass of condition, should match the schema name exactly")
        val conditionType: kotlin.String

                @get:Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
        val id: kotlin.String? 


}

