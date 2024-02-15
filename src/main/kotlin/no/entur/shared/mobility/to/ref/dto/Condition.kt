package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param id An identifier for this condition that can be used to refer to this condition
 */
data class Condition(
    @Schema(
        example = "null",
        required = true,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    @get:JsonProperty("conditionType", required = true) val conditionType: String,
    @Schema(
        example = "deposit50eu",
        description = "An identifier for this condition that can be used to refer to this condition",
    )
    val id: String? = null,
)
