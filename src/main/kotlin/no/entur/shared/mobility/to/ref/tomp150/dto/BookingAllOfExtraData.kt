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
 * Arbitrary information that a TO can add
 * @param safeWaitTime the predicted time before the asset will arrive, in minutes
 * @param maxWaitTime the maximum time before the asset will arrive, in minutes
 * @param safeTravelTime the predicted time the legs will take, in minutes
 * @param maxTravelTime the maximum time the legs will take, in minutes
 */
data class BookingAllOfExtraData(

    @get:Min(value=0)
    @Schema(description = "the predicted time before the asset will arrive, in minutes")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("safeWaitTime")
    @get:JsonProperty("safeWaitTime") val safeWaitTime: kotlin.Int? = null,

    @get:Min(value=0)
    @Schema(description = "the maximum time before the asset will arrive, in minutes")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("maxWaitTime")
    @get:JsonProperty("maxWaitTime") val maxWaitTime: kotlin.Int? = null,

    @get:Min(value=0)
    @Schema(description = "the predicted time the legs will take, in minutes")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("safeTravelTime")
    @get:JsonProperty("safeTravelTime") val safeTravelTime: kotlin.Int? = null,

    @get:Min(value=0)
    @Schema(description = "the maximum time the legs will take, in minutes")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("maxTravelTime")
    @get:JsonProperty("maxTravelTime") val maxTravelTime: kotlin.Int? = null
) {

}

