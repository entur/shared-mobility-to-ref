package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size

/**
 * street address, including number OR PO box number, eventually extended with internal reference like room number,
 * could match Content-Language
 * @param streetAddress
 * @param areaReference city or town, principal subdivision such as province, state or county, could match Content-Language
 * @param street street, consistent with streetAddress
 * @param houseNumber house number, consistent with streetAddress
 * @param houseNumberAddition the additional part of the house number (f.x. 13bis, where 'bis' is the additional part),
 * consistent with streetAddress
 * @param addressAdditionalInfo additional information to find the address (f.x. just around the corner)
 * @param city specified city or town, consistent with areaReference
 * @param province province or region, consistent with areaReference
 * @param state state, consistent with areaReference
 * @param postalCode
 * @param country two-letter country codes according to ISO 3166-1
 */
data class Address(
    @Schema(example = "example street 18, 2nd floor, 18-B33", required = true)
    @get:JsonProperty("streetAddress", required = true) val streetAddress: String,
    @Schema(
        example = "SmallCity, PineTree county",
        required = true,
        description = "city or town, principal subdivision such as province, state or county, could match Content-Language",
    )
    @get:JsonProperty("areaReference", required = true) val areaReference: String,
    @Schema(example = "null", description = "street, consistent with streetAddress")
    val street: String? = null,
    @get:Min(0)
    @Schema(example = "null", description = "house number, consistent with streetAddress")
    val houseNumber: Int? = null,
    @Schema(
        example = "null",
        description = """the additional part of the house number (f.x. 13bis, where 'bis' is the additional part), consistent with 
            |streetAddress""",
    )
    val houseNumberAddition: String? = null,
    @Schema(example = "null", description = "additional information to find the address (f.x. just around the corner)")
    val addressAdditionalInfo: String? = null,
    @Schema(example = "null", description = "specified city or town, consistent with areaReference")
    val city: String? = null,
    @Schema(example = "null", description = "province or region, consistent with areaReference")
    val province: String? = null,
    @Schema(example = "null", description = "state, consistent with areaReference")
    val state: String? = null,
    @Schema(example = "null")
    val postalCode: String? = null,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
    val country: String? = null,
)
