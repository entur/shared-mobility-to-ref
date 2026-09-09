package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import no.entur.shared.mobility.to.ref.tomp160.dto.TokenData
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
 * deeplink info
 * @param tokenType 
 * @param url the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.
 * @param knownParameters 
 */
data class TokenDeeplink(

    @Schema(required = true, description = "")
    @param:JsonProperty("tokenType")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String,

    @Schema(example = "mp1.app://something/?auth=sdfkjhrkjsdf003df38=dfsdf", description = "the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("url")
    @get:JsonProperty("url") val url: kotlin.String? = null,

    @Schema(example = "[\"return-url\",\"error-url\",\"error-code\",\"error-description\"]", description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("knownParameters")
    @get:JsonProperty("knownParameters") val knownParameters: kotlin.collections.List<kotlin.String>? = null
) : TokenData {

}

