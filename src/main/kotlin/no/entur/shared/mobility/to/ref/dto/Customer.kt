package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Address
import no.entur.shared.mobility.to.ref.dto.Card
import no.entur.shared.mobility.to.ref.dto.CardType
import no.entur.shared.mobility.to.ref.dto.License
import no.entur.shared.mobility.to.ref.dto.LicenseType
import no.entur.shared.mobility.to.ref.dto.Phone
import no.entur.shared.mobility.to.ref.dto.Requirements

/**
 * A MaaS user that wishes to make a booking, only use the fields required by booking conditions
 * @param id The identifier MaaS uses to identify the customer
 * @param isValidated Whether this traveler's identity and properties have been verified by the MaaS provider
 * @param age Age of the traveler, may be approximate
 * @param referenceNumber reference number of the traveler. This number could be used to refer to in the planning result.
 * @param cardTypes The kind of cards this traveler possesses
 * @param licenseTypes The kind of licenses this traveler possesses
 * @param requirements
 * @param knownIdentifier identifier for this traveler in the personal data store. This identifier can be used to get personal information from the provider specified in the \"knownIdentifierProvider\"
 * @param knownIdentifierProvider provider for personal information. Can be a URI or identifier.
 * @param travelerReference optional reference field to the travelers in the planning request.
 * @param initials
 * @param firstName First name of the customer
 * @param lastName Last name of the customer
 * @param middleName Middle name of the customer
 * @param prefix prefix of the customer, like titles
 * @param postfix postfix of the customer, like titles
 * @param phones
 * @param email the email address of the customer
 * @param birthDate
 * @param address
 * @param photo base64 encoded
 * @param cards
 * @param licenses
 * @param extraInfo dictionary for extra fields (bilatural agreements)
 */
data class Customer(
    @Schema(example = "A0-123456", required = true, description = "The identifier MaaS uses to identify the customer")
    @get:JsonProperty("id", required = true) val id: kotlin.String,
    @Schema(example = "null", description = "Whether this traveler's identity and properties have been verified by the MaaS provider")
    @get:JsonProperty("isValidated") val isValidated: kotlin.Boolean? = null,
    @Schema(example = "null", description = "Age of the traveler, may be approximate")
    @get:JsonProperty("age") val age: kotlin.Int? = null,
    @Schema(
        example = "null",
        description = "reference number of the traveler. This number could be used to refer to in the planning result.",
    )
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
    @Schema(
        example = "null",
        description = "identifier for this traveler in the personal data store. This identifier can be used to get personal information from the provider specified in the \"knownIdentifierProvider\"",
    )
    @get:JsonProperty("knownIdentifier") val knownIdentifier: kotlin.String? = null,
    @Schema(example = "null", description = "provider for personal information. Can be a URI or identifier.")
    @get:JsonProperty("knownIdentifierProvider") val knownIdentifierProvider: kotlin.String? = null,
    @Schema(example = "null", description = "optional reference field to the travelers in the planning request.")
    @get:JsonProperty("travelerReference") val travelerReference: kotlin.String? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("initials") val initials: kotlin.String? = null,
    @Schema(example = "John", description = "First name of the customer")
    @get:JsonProperty("firstName") val firstName: kotlin.String? = null,
    @Schema(example = "Doe", description = "Last name of the customer")
    @get:JsonProperty("lastName") val lastName: kotlin.String? = null,
    @Schema(example = "von", description = "Middle name of the customer")
    @get:JsonProperty("middleName") val middleName: kotlin.String? = null,
    @Schema(example = "null", description = "prefix of the customer, like titles")
    @get:JsonProperty("prefix") val prefix: kotlin.String? = null,
    @Schema(example = "null", description = "postfix of the customer, like titles")
    @get:JsonProperty("postfix") val postfix: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("phones") val phones: kotlin.collections.List<Phone>? = null,
    @Schema(example = "null", description = "the email address of the customer")
    @get:JsonProperty("email") val email: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("birthDate") val birthDate: java.time.LocalDate? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("address") val address: Address? = null,
    @Schema(example = "null", description = "base64 encoded")
    @get:JsonProperty("photo") val photo: kotlin.ByteArray? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("cards") val cards: kotlin.collections.List<Card>? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("licenses") val licenses: kotlin.collections.List<License>? = null,
    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
)
