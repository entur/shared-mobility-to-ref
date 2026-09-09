package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.TokenData
import no.entur.shared.mobility.to.ref.tomp150.dto.TokenEKeyAllOfEkey
import no.entur.shared.mobility.to.ref.tomp150.dto.TokenEKeyAllOfLock
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
 * @param tokenType 
 */
data class TokenEKey(

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("ekey", required = true)
    @get:JsonProperty("ekey", required = true) val ekey: TokenEKeyAllOfEkey,

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("lock", required = true)
    @get:JsonProperty("lock", required = true) val lock: TokenEKeyAllOfLock,

    @Schema(required = true, description = "")
    @param:JsonProperty("tokenType", required = true)
    @get:JsonProperty("tokenType", required = true) override val tokenType: kotlin.String
) : TokenData {

}

