package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.Address
import no.entur.shared.mobility.to.ref.tomp150.dto.Card
import no.entur.shared.mobility.to.ref.tomp150.dto.CardType
import no.entur.shared.mobility.to.ref.tomp150.dto.License
import no.entur.shared.mobility.to.ref.tomp150.dto.LicenseType
import no.entur.shared.mobility.to.ref.tomp150.dto.Phone
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
    @param:JsonProperty("id", required = true)
    @get:JsonProperty("id", required = true) val id: kotlin.String,

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
    @get:JsonProperty("knownIdentifierProvider") val knownIdentifierProvider: kotlin.String? = null,

    @Schema(description = "optional reference field to the travelers in the planning request.")
    @param:JsonProperty("travelerReference")
    @get:JsonProperty("travelerReference") val travelerReference: kotlin.String? = null,

    @Schema(description = "")
    @param:JsonProperty("initials")
    @get:JsonProperty("initials") val initials: kotlin.String? = null,

    @Schema(example = "John", description = "First name of the customer")
    @param:JsonProperty("firstName")
    @get:JsonProperty("firstName") val firstName: kotlin.String? = null,

    @Schema(example = "Doe", description = "Last name of the customer")
    @param:JsonProperty("lastName")
    @get:JsonProperty("lastName") val lastName: kotlin.String? = null,

    @Schema(example = "von", description = "Middle name of the customer")
    @param:JsonProperty("middleName")
    @get:JsonProperty("middleName") val middleName: kotlin.String? = null,

    @Schema(description = "prefix of the customer, like titles")
    @param:JsonProperty("prefix")
    @get:JsonProperty("prefix") val prefix: kotlin.String? = null,

    @Schema(description = "postfix of the customer, like titles")
    @param:JsonProperty("postfix")
    @get:JsonProperty("postfix") val postfix: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("phones")
    @get:JsonProperty("phones") val phones: kotlin.collections.List<Phone>? = null,

    @Schema(description = "the email address of the customer")
    @param:JsonProperty("email")
    @get:JsonProperty("email") val email: kotlin.String? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("birthDate")
    @get:JsonProperty("birthDate") val birthDate: java.time.LocalDate? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("address")
    @get:JsonProperty("address") val address: Address? = null,

    @Schema(description = "base64 encoded")
    @param:JsonProperty("photo")
    @get:JsonProperty("photo") val photo: kotlin.ByteArray? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("cards")
    @get:JsonProperty("cards") val cards: kotlin.collections.List<Card>? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("licenses")
    @get:JsonProperty("licenses") val licenses: kotlin.collections.List<License>? = null,

    @field:Valid
    @Schema(description = "dictionary for extra fields (bilatural agreements)")
    @param:JsonProperty("extraInfo")
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {

}

