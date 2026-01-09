package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp200.dto.Card
import no.entur.shared.mobility.to.ref.tomp200.dto.CardType
import no.entur.shared.mobility.to.ref.tomp200.dto.EntitlementGiven
import no.entur.shared.mobility.to.ref.tomp200.dto.License
import no.entur.shared.mobility.to.ref.tomp200.dto.LicenseType
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
 * @param isValidated Whether this traveller's identity and properties have been verified by the MaaS provider
 * @param name default string, full names etc (length 0-200)
 * @param age a bit short integer (0-100)
 * @param fullName default string, full names etc (length 0-200)
 * @param customerReference default string, full names etc (length 0-200)
 * @param entitlements entitlements or commercial profiles that are applicable to this traveller
 * @param cardTypes card types that are applicable to this traveller
 * @param cards cards that are applicable to this traveller
 * @param licenseTypes license types that are applicable to this traveller
 * @param licenses licenses that are applicable to this traveller
 * @param assets 
 */
data class TravellerCharacteristics(

    @Schema(example = "null", description = "Whether this traveller's identity and properties have been verified by the MaaS provider")
    @get:JsonProperty("isValidated") val isValidated: kotlin.Boolean? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "a bit short integer (0-100)")
    @get:JsonProperty("age") val age: kotlin.Int? = 0,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("fullName") val fullName: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("customerReference") val customerReference: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "entitlements or commercial profiles that are applicable to this traveller")
    @get:JsonProperty("entitlements") val entitlements: kotlin.collections.List<EntitlementGiven>? = null,

    @field:Valid
    @Schema(example = "null", description = "card types that are applicable to this traveller")
    @get:JsonProperty("cardTypes") val cardTypes: kotlin.collections.List<CardType>? = null,

    @field:Valid
    @Schema(example = "null", description = "cards that are applicable to this traveller")
    @get:JsonProperty("cards") val cards: kotlin.collections.List<Card>? = null,

    @field:Valid
    @Schema(example = "null", description = "license types that are applicable to this traveller")
    @get:JsonProperty("licenseTypes") val licenseTypes: kotlin.collections.List<LicenseType>? = null,

    @field:Valid
    @Schema(example = "null", description = "licenses that are applicable to this traveller")
    @get:JsonProperty("licenses") val licenses: kotlin.collections.List<License>? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("assets") val assets: kotlin.collections.List<kotlin.String>? = null
) {

}

