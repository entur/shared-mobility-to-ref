package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import java.time.LocalDate

/**
 * A MaaS user that wishes to make a booking, only use the fields required by booking conditions
 * @param id The identifier MaaS uses to identify the customer
 * @param isValidated Whether this traveler's identity and properties have been verified by the MaaS provider
 * @param age Age of the traveler, may be approximate
 * @param referenceNumber reference number of the traveler. This number could be used to refer to in the planning result.
 * @param cardTypes The kind of cards this traveler possesses
 * @param licenseTypes The kind of licenses this traveler possesses
 * @param requirements
 * @param knownIdentifier identifier for this traveler in the personal data store. This identifier can be used to get personal information
 * from the provider specified in the \"knownIdentifierProvider\"
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
    @get:JsonProperty("id", required = true) val id: String,
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
    @Schema(example = "null", description = "optional reference field to the travelers in the planning request.")
    val travelerReference: String? = null,
    @Schema(example = "null")
    val initials: String? = null,
    @Schema(example = "John", description = "First name of the customer")
    val firstName: String? = null,
    @Schema(example = "Doe", description = "Last name of the customer")
    val lastName: String? = null,
    @Schema(example = "von", description = "Middle name of the customer")
    val middleName: String? = null,
    @Schema(example = "null", description = "prefix of the customer, like titles")
    val prefix: String? = null,
    @Schema(example = "null", description = "postfix of the customer, like titles")
    val postfix: String? = null,
    @field:Valid
    @Schema(example = "null")
    val phones: List<Phone>? = null,
    @Schema(example = "null", description = "the email address of the customer")
    val email: String? = null,
    @field:Valid
    @Schema(example = "null")
    val birthDate: LocalDate? = null,
    @field:Valid
    @Schema(example = "null")
    val address: Address? = null,
    @Schema(example = "null", description = "base64 encoded")
    val photo: ByteArray? = null,
    @field:Valid
    @Schema(example = "null")
    val cards: List<Card>? = null,
    @field:Valid
    @Schema(example = "null")
    val licenses: List<License>? = null,
    @field:Valid
    @Schema(example = "null", description = "dictionary for extra fields (bilatural agreements)")
    val extraInfo: Map<String, Any>? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Customer) return false

        if (id != other.id) return false
        if (isValidated != other.isValidated) return false
        if (age != other.age) return false
        if (referenceNumber != other.referenceNumber) return false
        if (cardTypes != other.cardTypes) return false
        if (licenseTypes != other.licenseTypes) return false
        if (requirements != other.requirements) return false
        if (knownIdentifier != other.knownIdentifier) return false
        if (knownIdentifierProvider != other.knownIdentifierProvider) return false
        if (travelerReference != other.travelerReference) return false
        if (initials != other.initials) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (middleName != other.middleName) return false
        if (prefix != other.prefix) return false
        if (postfix != other.postfix) return false
        if (phones != other.phones) return false
        if (email != other.email) return false
        if (birthDate != other.birthDate) return false
        if (address != other.address) return false
        if (cards != other.cards) return false
        if (licenses != other.licenses) return false
        if (extraInfo != other.extraInfo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (isValidated?.hashCode() ?: 0)
        result = 31 * result + (age ?: 0)
        result = 31 * result + (referenceNumber?.hashCode() ?: 0)
        result = 31 * result + (cardTypes?.hashCode() ?: 0)
        result = 31 * result + (licenseTypes?.hashCode() ?: 0)
        result = 31 * result + (requirements?.hashCode() ?: 0)
        result = 31 * result + (knownIdentifier?.hashCode() ?: 0)
        result = 31 * result + (knownIdentifierProvider?.hashCode() ?: 0)
        result = 31 * result + (travelerReference?.hashCode() ?: 0)
        result = 31 * result + (initials?.hashCode() ?: 0)
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (middleName?.hashCode() ?: 0)
        result = 31 * result + (prefix?.hashCode() ?: 0)
        result = 31 * result + (postfix?.hashCode() ?: 0)
        result = 31 * result + (phones?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + (birthDate?.hashCode() ?: 0)
        result = 31 * result + (address?.hashCode() ?: 0)
        result = 31 * result + (cards?.hashCode() ?: 0)
        result = 31 * result + (licenses?.hashCode() ?: 0)
        result = 31 * result + (extraInfo?.hashCode() ?: 0)
        return result
    }
}
