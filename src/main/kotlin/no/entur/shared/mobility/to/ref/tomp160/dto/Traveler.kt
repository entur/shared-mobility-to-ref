package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.CardType
import no.entur.shared.mobility.to.ref.tomp160.dto.LicenseType
import no.entur.shared.mobility.to.ref.tomp160.dto.Requirements
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
 * A generic description of a traveler, not including any identifying information
 * @param isValidated Whether this traveler's identity and properties have been verified by the MaaS provider
 * @param age Age of the traveler, may be approximate
 * @param referenceNumber reference number of the traveler. This number could be used to refer to in the planning result.
 * @param cardTypes The kind of cards this traveler possesses
 * @param licenseTypes The kind of licenses this traveler possesses
 * @param requirements 
 * @param knownIdentifier identifier for this traveler in the personal data store. This identifier can be used to get personal information from the provider specified in the \"knownIdentifierProvider\"
 * @param knownIdentifierProvider provider for personal information. Can be a URI or identifier.
 */
data class Traveler(

    @Schema(example = "null", description = "Whether this traveler's identity and properties have been verified by the MaaS provider")
    @get:JsonProperty("isValidated") val isValidated: kotlin.Boolean? = null,

    @Schema(example = "null", description = "Age of the traveler, may be approximate")
    @get:JsonProperty("age") val age: kotlin.Int? = null,

    @Schema(example = "null", description = "reference number of the traveler. This number could be used to refer to in the planning result.")
    @get:JsonProperty("referenceNumber") val referenceNumber: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "The kind of cards this traveler possesses")
    @get:JsonProperty("cardTypes") val cardTypes: kotlin.collections.List<CardType>? = null,

    @field:Valid
    @Schema(example = "null", description = "The kind of licenses this traveler possesses")
    @get:JsonProperty("licenseTypes") val licenseTypes: kotlin.collections.List<LicenseType>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("requirements") val requirements: Requirements? = null,

    @Schema(example = "null", description = "identifier for this traveler in the personal data store. This identifier can be used to get personal information from the provider specified in the \"knownIdentifierProvider\"")
    @get:JsonProperty("knownIdentifier") val knownIdentifier: kotlin.String? = null,

    @Schema(example = "null", description = "provider for personal information. Can be a URI or identifier.")
    @get:JsonProperty("knownIdentifierProvider") val knownIdentifierProvider: kotlin.String? = null
    ) {

}

