package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.AppSupport
import no.entur.shared.mobility.to.ref.tomp200.dto.CargoLimits
import no.entur.shared.mobility.to.ref.tomp200.dto.Damage
import no.entur.shared.mobility.to.ref.tomp200.dto.FareStructure
import no.entur.shared.mobility.to.ref.tomp200.dto.Mode
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
 * the asset that can by applied to execute a leg.
 * @param id default string, full names etc (length 0-200)
 * @param type 
 * @param visualId short string, display names (length 0-75)
 * @param product default string, full names etc (length 0-200)
 * @param mode 
 * @param subMode default string, full names etc (length 0-200)
 * @param damages list of damages that are reported for this asset
 * @param cargo 
 * @param appSupport 
 * @param equipment list of external references
 * @param customFields dictionary for extra fields (bilatural agreements)
 * @param fee 
 */
data class Asset(

    @get:Size(max=200)
    @Schema(example = "null", required = true, description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:Pattern(regexp="^(asset)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @get:Size(max=75)
    @Schema(example = "null", description = "short string, display names (length 0-75)")
    @get:JsonProperty("visualId") val visualId: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("product") val product: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("mode") val mode: Mode? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("subMode") val subMode: kotlin.String? = null,

    @field:Valid
    @get:Size(max=100)
    @Schema(example = "null", description = "list of damages that are reported for this asset")
    @get:JsonProperty("damages") val damages: kotlin.collections.List<Damage>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("cargo") val cargo: CargoLimits? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("appSupport") val appSupport: AppSupport? = null,

    @get:Size(max=100)
    @Schema(example = "null", description = "list of external references")
    @get:JsonProperty("equipment") val equipment: kotlin.collections.List<kotlin.String>? = null,

    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("customFields") val customFields: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("fee") val fee: FareStructure? = null
) {

}

