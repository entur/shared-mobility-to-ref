package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.TokenData
import no.entur.shared.mobility.to.ref.tomp160.dto.TokenEKeyAllOfEkey
import no.entur.shared.mobility.to.ref.tomp160.dto.TokenEKeyAllOfLock
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
 * Axa EKey information
 * @param ekey 
 * @param lock 
 */
data class TokenEKey(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ekey", required = true) val ekey: TokenEKeyAllOfEkey,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("lock", required = true) val lock: TokenEKeyAllOfLock,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String
) : TokenData {

}

