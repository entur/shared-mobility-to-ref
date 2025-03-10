package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * street address, including number OR PO box number, eventually extended with internal reference like room number, could match Content-Language
 * @param streetAddress 
 * @param areaReference city or town, principal subdivision such as province, state or county, could match Content-Language
 * @param street street, consistent with streetAddress
 * @param houseNumber house number, consistent with streetAddress
 * @param houseNumberAddition the additional part of the house number (f.x. 13bis, where 'bis' is the additional part), consistent with streetAddress
 * @param addressAdditionalInfo additional information to find the address (f.x. just around the corner)
 * @param city specified city or town, consistent with areaReference
 * @param province province or region, consistent with areaReference
 * @param state state, consistent with areaReference
 * @param postalCode 
 * @param country two-letter country codes according to ISO 3166-1
 */
data class Address(

    @Schema(example = "example street 18, 2nd floor, 18-B33", required = true, description = "")
    @get:JsonProperty("streetAddress", required = true) val streetAddress: kotlin.String,

    @Schema(example = "Smallcity, Pinetree county", required = true, description = "city or town, principal subdivision such as province, state or county, could match Content-Language")
    @get:JsonProperty("areaReference", required = true) val areaReference: kotlin.String,

    @Schema(example = "null", description = "street, consistent with streetAddress")
    @get:JsonProperty("street") val street: kotlin.String? = null,

    @get:Min(0)
    @Schema(example = "null", description = "house number, consistent with streetAddress")
    @get:JsonProperty("houseNumber") val houseNumber: kotlin.Int? = null,

    @Schema(example = "null", description = "the additional part of the house number (f.x. 13bis, where 'bis' is the additional part), consistent with streetAddress")
    @get:JsonProperty("houseNumberAddition") val houseNumberAddition: kotlin.String? = null,

    @Schema(example = "null", description = "additional information to find the address (f.x. just around the corner)")
    @get:JsonProperty("addressAdditionalInfo") val addressAdditionalInfo: kotlin.String? = null,

    @Schema(example = "null", description = "specified city or town, consistent with areaReference")
    @get:JsonProperty("city") val city: kotlin.String? = null,

    @Schema(example = "null", description = "province or region, consistent with areaReference")
    @get:JsonProperty("province") val province: kotlin.String? = null,

    @Schema(example = "null", description = "state, consistent with areaReference")
    @get:JsonProperty("state") val state: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("postalCode") val postalCode: kotlin.String? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country") val country: kotlin.String? = null
    ) {

}

