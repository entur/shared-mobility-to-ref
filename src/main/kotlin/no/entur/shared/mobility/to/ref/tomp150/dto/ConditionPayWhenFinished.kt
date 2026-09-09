package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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
 * in case the TO demands a direct payment after usage.
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param id An identifier for this condition that can be used to refer to this condition
 */
class ConditionPayWhenFinished(

    @Schema(required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @param:JsonProperty("conditionType")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,

    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("id")
    @get:JsonProperty("id") override val id: kotlin.String? = null
) : Condition {

}

