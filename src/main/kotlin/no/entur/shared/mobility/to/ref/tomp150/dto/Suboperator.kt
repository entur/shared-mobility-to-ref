package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
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
 * The operator of a leg or asset, in case this is not the TO itself but should be shown to the user
 * @param name Name of the operator, could match Content-Language
 * @param maasId the maasId from the operator
 * @param description short description of the operator, should match Content-Language
 * @param contact contact information, should match Content-Language
 */
data class Suboperator(

    @Schema(required = true, description = "Name of the operator, could match Content-Language")
    @param:JsonProperty("name")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @Schema(description = "the maasId from the operator")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("maasId")
    @get:JsonProperty("maasId") val maasId: kotlin.String? = null,

    @Schema(description = "short description of the operator, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("description")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(description = "contact information, should match Content-Language")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("contact")
    @get:JsonProperty("contact") val contact: kotlin.String? = null
) {

}

