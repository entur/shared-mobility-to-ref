package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.Address
import no.entur.shared.mobility.to.ref.tomp160.dto.Card
import no.entur.shared.mobility.to.ref.tomp160.dto.CardType
import no.entur.shared.mobility.to.ref.tomp160.dto.CustomerAccountStatus
import no.entur.shared.mobility.to.ref.tomp160.dto.License
import no.entur.shared.mobility.to.ref.tomp160.dto.LicenseType
import no.entur.shared.mobility.to.ref.tomp160.dto.Phone
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
 * A registration of the TRANSPORT CUSTOMER with an ACCOUNT PROVIDER to obtain travel services.
 * @param id The identifier that the TO uses to identify this customer.
 * @param isValidated Whether this traveler's identity and properties have been verified by the MaaS provider
 * @param age Age of the traveler, may be approximate
 * @param referenceNumber reference number of the traveler. This number could be used to refer to in the planning result.
 * @param cardTypes The kind of cards this traveler possesses
 * @param licenseTypes The kind of licenses this traveler possesses
 * @param requirements 
 * @param knownIdentifier identifier for this traveler in the personal data store. This identifier can be used to get personal information from the provider specified in the \"knownIdentifierProvider\"
 * @param knownIdentifierProvider provider for personal information. Can be a URI or identifier.
 * @param externalId The identifier that the MP uses to identify this customer. It is not mandatory to store it at the TOs side, since the communication between TO and MP always uses the identifier on TO side.
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
 * @param placeOfBirth 
 * @param countryOfBirth two-letter country codes according to ISO 3166-1
 * @param address 
 * @param photo base64 encoded
 * @param cards 
 * @param licenses 
 * @param extraInfo dictionary for extra fields (bilatural agreements)
 * @param creationDate The date in which the CUSTOMER ACCOUNT has been created
 * @param modificationDate Last modification date of CUSTOMER ACCOUNT.
 * @param status 
 */
data class CustomerAccount(

    @Schema(example = "A0-123456", required = true, description = "The identifier that the TO uses to identify this customer.")
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

    @Schema(example = "A0-123456", description = "The identifier that the MP uses to identify this customer. It is not mandatory to store it at the TOs side, since the communication between TO and MP always uses the identifier on TO side.")
    @param:JsonProperty("externalId")
    @get:JsonProperty("externalId") val externalId: kotlin.String? = null,

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
    @param:JsonProperty("placeOfBirth")
    @get:JsonProperty("placeOfBirth") val placeOfBirth: java.time.LocalDate? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @param:JsonProperty("countryOfBirth")
    @get:JsonProperty("countryOfBirth") val countryOfBirth: kotlin.String? = null,

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
    @get:JsonProperty("extraInfo") val extraInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,

    @get:Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}Z$")
    @Schema(example = "2019-10-12T07:20:50.520Z", description = "The date in which the CUSTOMER ACCOUNT has been created")
    @param:JsonProperty("creationDate")
    @get:JsonProperty("creationDate") val creationDate: java.time.OffsetDateTime? = null,

    @get:Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}Z$")
    @Schema(description = "Last modification date of CUSTOMER ACCOUNT.")
    @param:JsonProperty("modificationDate")
    @get:JsonProperty("modificationDate") val modificationDate: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("status")
    @get:JsonProperty("status") val status: CustomerAccountStatus? = null
) {

}

