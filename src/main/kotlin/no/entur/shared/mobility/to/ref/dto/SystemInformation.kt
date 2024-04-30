package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import java.time.LocalDate

/**
 *
 * @param systemId identifier for this transport system. This should be globally unique (even between different systems)
 * @param language The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header
 * and should then be returned in Content-Language
 * @param name Full name of the system to be displayed to customers, could match Content-Language
 * @param timezone The time zone where the system is located. Time zone names never contain the space character but may contain an
 * underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values
 * @param typeOfSystem Describes the type of system
 * @param shortName Optional abbreviation for a system
 * @param &#x60;operator&#x60; Name of the operator of the system, could match Content-Language
 * @param url The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special
 * characters in the URL must be correctly escaped.
 * @param purchaseUrl A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships
 * @param discoveryUriAndroid Uri to detect if the app is available at the mobile.
 * @param discoveryUriIOS Uri to detect if the app is available at the mobile.
 * @param storeUriAndroid Uri to the app in the store.
 * @param storeUriIOS Uri to the app in the store.
 * @param startDate
 * @param phoneNumber A single voice telephone number for the specified system. This field is a string value that presents the telephone
 * number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.
 * @param email A single contact email address for customers to address questions about the system
 * @param feedContactEmail A single contact email address for consumers of this feed to report technical issues.
 * @param licenseUrl A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other
 * license terms the system would like to define (including the use of corporate trademarks, etc.)
 * @param chamberOfCommerceInfo
 * @param conditions Added to include possibility to communicate general rental conditions like minimum age, max. reservation time
 * etc. [amended]
 * @param productType the type of product offered. SHARING should also be used for public transport.
 * @param assetClasses
 */
data class SystemInformation(
    @Schema(
        example = "XXTO0001",
        required = true,
        description = "identifier for this transport system. This should be globally unique (even between different systems)",
    )
    @get:JsonProperty("systemId", required = true) val systemId: String,
    @Schema(
        example = "null",
        required = true,
        description = """The languages supported by this operator for user-facing text. These can be requested using the Accept-Language 
            |header and should then be returned in Content-Language""",
    )
    @get:JsonProperty("language", required = true) val language: List<String>,
    @Schema(
        example = "FreeBike",
        required = true,
        description = "Full name of the system to be displayed to customers, could match Content-Language",
    )
    @get:JsonProperty("name", required = true) val name: String,
    @Schema(
        example = "IST",
        required = true,
        description = """The time zone where the system is located. Time zone names never contain the space character but may contain an 
            |underscore. Please refer to the "TZ" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of 
            |valid values""",
    )
    @get:JsonProperty("timezone", required = true) val timezone: String,
    @Schema(example = "FREE_FLOATING", required = true, description = "Describes the type of system")
    @get:JsonProperty("typeOfSystem", required = true) val typeOfSystem: TypeOfSystem,
    @Schema(example = "FB", description = "Optional abbreviation for a system")
    val shortName: String? = null,
    @Schema(example = "FreeBike", description = "Name of the operator of the system, could match Content-Language")
    @get:JsonProperty("operator") val `operator`: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com",
        description = """The URL of the transport operator. The value must be a fully qualified URL that includes https:// or https://, 
            |and any special characters in the URL must be correctly escaped.""",
    )
    val url: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/purchase",
        description = "A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships",
    )
    val purchaseUrl: String? = null,
    @Schema(example = "null", description = "Uri to detect if the app is available at the mobile.")
    val discoveryUriAndroid: String? = null,
    @Schema(example = "null", description = "Uri to detect if the app is available at the mobile.")
    val discoveryUriIOS: String? = null,
    @Schema(
        example = "https://play.google.com/store/apps/details?id=com.rentmyfreebike.android",
        description = "Uri to the app in the store.",
    )
    val storeUriAndroid: String? = null,
    @Schema(
        example = "itms-apps://itunes.apple.com/app/idcom.rentmyfreebike.ios",
        description = "Uri to the app in the store.",
    )
    val storeUriIOS: String? = null,
    @field:Valid
    @Schema(example = "null")
    val startDate: LocalDate? = null,
    @Schema(
        example = "555-12345",
        description = """A single voice telephone number for the specified system. This field is a string value that presents the 
            |telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of 
            |the number.""",
    )
    val phoneNumber: String? = null,
    @get:Email
    @Schema(
        example = "rent@freebike.com",
        description = "A single contact email address for customers to address questions about the system",
    )
    val email: String? = null,
    @get:Email
    @Schema(
        example = "null",
        description = "A single contact email address for consumers of this feed to report technical issues.",
    )
    val feedContactEmail: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/license",
        description = """A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any 
            |other license terms the system would like to define (including the use of corporate trademarks, etc)""",
    )
    val licenseUrl: String? = null,
    @field:Valid
    @Schema(example = "null")
    val chamberOfCommerceInfo: ChamberOfCommerceInfo? = null,
    @Schema(
        example = "null",
        description = """Added to include possibility to communicate general rental conditions like minimum age, max. reservation time 
            |etc. [amended]""",
    )
    val conditions: String? = null,
    @Schema(
        example = "null",
        description = "the type of product offered. SHARING should also be used for public transport.",
    )
    val productType: ProductType? = null,
    @field:Valid
    @Schema(example = "null")
    val assetClasses: List<AssetClass>? = null,
) {
    /**
     * Describes the type of system
     */
    enum class TypeOfSystem {
        FREE_FLOATING,
        STATION_BASED,
        VIRTUAL_STATION_BASED,
    }

    /**
     * the type of product offered. SHARING should also be used for public transport.
     */
    enum class ProductType {
        RENTAL,
        SHARING,
        PARKING,
        CHARGING,
    }
}
