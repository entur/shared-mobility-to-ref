package no.entur.shared.mobility.to.ref.tomp160.dto

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
 * 
 * @param bdAddress physical address
 * @param deviceName how it advertises itself
 */
data class TokenEKeyAllOfLock(

    @Schema(description = "physical address")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("bdAddress")
    @get:JsonProperty("bdAddress") val bdAddress: kotlin.String? = null,

    @Schema(description = "how it advertises itself")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("deviceName")
    @get:JsonProperty("deviceName") val deviceName: kotlin.String? = null
) {

}

