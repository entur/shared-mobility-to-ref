package no.entur.shared.mobility.to.ref.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * A generic description of a traveler, not including any identifying information
 * @param isValidated Whether this traveler's identity and properties have been verified by the MaaS provider
 * @param age Age of the traveler, may be approximate
 * @param referenceNumber reference number of the traveler. This number could be used to refer to in the planning result.
 * @param cardTypes The kind of cards this traveler possesses
 * @param licenseTypes The kind of licenses this traveler possesses
 * @param requirements
 * @param knownIdentifier identifier for this traveler in the personal data store. This identifier can be used to get
 * personal information from the provider specified in the \"knownIdentifierProvider\"
 * @param knownIdentifierProvider provider for personal information. Can be a URI or identifier.
 */
data class Traveler(
    @Schema(
        example = "null",
        description = "Whether this traveler's identity and properties have been verified by the MaaS provider",
    )
    val isValidated: Boolean? = null,
    @Schema(example = "null", description = "Age of the traveler, may be approximate")
    val age: Int? = null,
    @Schema(
        example = "null",
        description = "reference number of the traveler. This number could be used to refer to in the planning result.",
    )
    val referenceNumber: String? = null,
    @field:Valid
    @Schema(example = "null", description = "The kind of cards this traveler possesses")
    val cardTypes: List<CardType>? = null,
    @field:Valid
    @Schema(example = "null", description = "The kind of licenses this traveler possesses")
    val licenseTypes: List<LicenseType>? = null,
    @field:Valid
    @Schema(example = "null")
    val requirements: Requirements? = null,
    @Schema(
        example = "null",
        description =
            "identifier for this traveler in the personal data store. This identifier can be used to get personal " +
                "information from the provider specified in the \"knownIdentifierProvider\"",
    )
    val knownIdentifier: String? = null,
    @Schema(example = "null", description = "provider for personal information. Can be a URI or identifier.")
    val knownIdentifierProvider: String? = null,
)
