package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.CardType
import no.entur.shared.mobility.to.ref.tomp150.dto.LicenseType
import no.entur.shared.mobility.to.ref.tomp150.dto.Requirements
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

    @Schema(description = "Whether this traveler's identity and properties have been verified by the MaaS provider")
    @param:JsonProperty("isValidated")
    @get:JsonProperty("isValidated") val isValidated: kotlin.Boolean? = null,

    @Schema(description = "Age of the traveler, may be approximate")
    @param:JsonProperty("age")
    @get:JsonProperty("age") val age: kotlin.Int? = null,

    @Schema(description = "reference number of the traveler. This number could be used to refer to in the planning result.")
    @param:JsonProperty("referenceNumber")
    @get:JsonProperty("referenceNumber") val referenceNumber: kotlin.String? = null,

    @field:Valid
    @Schema(description = "The kind of cards this traveler possesses")
    @param:JsonProperty("cardTypes")
    @get:JsonProperty("cardTypes") val cardTypes: kotlin.collections.List<CardType>? = null,

    @field:Valid
    @Schema(description = "The kind of licenses this traveler possesses")
    @param:JsonProperty("licenseTypes")
    @get:JsonProperty("licenseTypes") val licenseTypes: kotlin.collections.List<LicenseType>? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("requirements")
    @get:JsonProperty("requirements") val requirements: Requirements? = null,

    @Schema(description = "identifier for this traveler in the personal data store. This identifier can be used to get personal information from the provider specified in the \"knownIdentifierProvider\"")
    @param:JsonProperty("knownIdentifier")
    @get:JsonProperty("knownIdentifier") val knownIdentifier: kotlin.String? = null,

    @Schema(description = "provider for personal information. Can be a URI or identifier.")
    @param:JsonProperty("knownIdentifierProvider")
    @get:JsonProperty("knownIdentifierProvider") val knownIdentifierProvider: kotlin.String? = null
) {

}

