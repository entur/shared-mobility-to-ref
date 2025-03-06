package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * The operator of a leg or asset, in case this is not the TO itself but should be shown to the user
 * @param name Name of the operator, could match Content-Language
 * @param maasId the maasId from the operator
 * @param description short description of the operator, should match Content-Language
 * @param contact contact information, should match Content-Language
 */
data class Suboperator(
    @Schema(example = "null", required = true, description = "Name of the operator, could match Content-Language")
    @get:JsonProperty("name", required = true) val name: kotlin.String,
    @Schema(example = "null", description = "the maasId from the operator")
    @get:JsonProperty("maasId") val maasId: kotlin.String? = null,
    @Schema(example = "null", description = "short description of the operator, should match Content-Language")
    @get:JsonProperty("description") val description: kotlin.String? = null,
    @Schema(example = "null", description = "contact information, should match Content-Language")
    @get:JsonProperty("contact") val contact: kotlin.String? = null,
)
