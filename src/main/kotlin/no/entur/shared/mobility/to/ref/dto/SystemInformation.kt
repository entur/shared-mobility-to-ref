package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import no.entur.shared.mobility.to.ref.dto.AssetClass
import no.entur.shared.mobility.to.ref.dto.ChamberOfCommerceInfo

/**
 *
 * @param systemId identifier for this transport system. This should be globally unique (even between different systems)
 * @param language The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header and should then be returned in Content-Language
 * @param name Full name of the system to be displayed to customers, could match Content-Language
 * @param timezone The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values
 * @param typeOfSystem Describes the type of system
 * @param shortName Optional abbreviation for a system
 * @param &#x60;operator&#x60; Name of the operator of the system, could match Content-Language
 * @param url The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.
 * @param purchaseUrl A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships
 * @param discoveryUriAndroid Uri to detect if the app is available at the mobile.
 * @param discoveryUriIOS Uri to detect if the app is available at the mobile.
 * @param storeUriAndroid Uri to the app in the store.
 * @param storeUriIOS Uri to the app in the store.
 * @param startDate
 * @param phoneNumber A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.
 * @param email A single contact email address for customers to address questions about the system
 * @param feedContactEmail A single contact email address for consumers of this feed to report technical issues.
 * @param licenseUrl A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)
 * @param chamberOfCommerceInfo
 * @param conditions Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]
 * @param productType the type of product offered. SHARING should also be used for public transport.
 * @param assetClasses
 */
data class SystemInformation(
    @Schema(
        example = "XXTO0001",
        required = true,
        description = "identifier for this transport system. This should be globally unique (even between different systems)",
    )
    @get:JsonProperty("systemId", required = true) val systemId: kotlin.String,
    @Schema(
        example = "null",
        required = true,
        description = "The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header and should then be returned in Content-Language",
    )
    @get:JsonProperty("language", required = true) val language: kotlin.collections.List<kotlin.String>,
    @Schema(
        example = "FreeBike",
        required = true,
        description = "Full name of the system to be displayed to customers, could match Content-Language",
    )
    @get:JsonProperty("name", required = true) val name: kotlin.String,
    @Schema(
        example = "IST",
        required = true,
        description = "The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values",
    )
    @get:JsonProperty("timezone", required = true) val timezone: kotlin.String,
    @Schema(example = "FREE_FLOATING", required = true, description = "Describes the type of system")
    @get:JsonProperty("typeOfSystem", required = true) val typeOfSystem: SystemInformation.TypeOfSystem,
    @Schema(example = "FB", description = "Optional abbreviation for a system")
    @get:JsonProperty("shortName") val shortName: kotlin.String? = null,
    @Schema(example = "FreeBike", description = "Name of the operator of the system, could match Content-Language")
    @get:JsonProperty("operator") val `operator`: kotlin.String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com",
        description = "The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.",
    )
    @get:JsonProperty("url") val url: kotlin.String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/purchase",
        description = "A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships",
    )
    @get:JsonProperty("purchaseUrl") val purchaseUrl: kotlin.String? = null,
    @Schema(example = "null", description = "Uri to detect if the app is available at the mobile.")
    @get:JsonProperty("discoveryUriAndroid") val discoveryUriAndroid: kotlin.String? = null,
    @Schema(example = "null", description = "Uri to detect if the app is available at the mobile.")
    @get:JsonProperty("discoveryUriIOS") val discoveryUriIOS: kotlin.String? = null,
    @Schema(
        example = "https://play.google.com/store/apps/details?id=com.rentmyfreebike.android",
        description = "Uri to the app in the store.",
    )
    @get:JsonProperty("storeUriAndroid") val storeUriAndroid: kotlin.String? = null,
    @Schema(example = "itms-apps://itunes.apple.com/app/idcom.rentmyfreebike.ios", description = "Uri to the app in the store.")
    @get:JsonProperty("storeUriIOS") val storeUriIOS: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("startDate") val startDate: java.time.LocalDate? = null,
    @Schema(
        example = "555-12345",
        description = "A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.",
    )
    @get:JsonProperty("phoneNumber") val phoneNumber: kotlin.String? = null,
    @get:Email
    @Schema(
        example = "rent@freebike.com",
        description = "A single contact email address for customers to address questions about the system",
    )
    @get:JsonProperty("email") val email: kotlin.String? = null,
    @get:Email
    @Schema(example = "null", description = "A single contact email address for consumers of this feed to report technical issues.")
    @get:JsonProperty("feedContactEmail") val feedContactEmail: kotlin.String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/license",
        description = "A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)",
    )
    @get:JsonProperty("licenseUrl") val licenseUrl: kotlin.String? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("chamberOfCommerceInfo") val chamberOfCommerceInfo: ChamberOfCommerceInfo? = null,
    @Schema(
        example = "null",
        description = "Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]",
    )
    @get:JsonProperty("conditions") val conditions: kotlin.String? = null,
    @Schema(example = "null", description = "the type of product offered. SHARING should also be used for public transport.")
    @get:JsonProperty("productType") val productType: SystemInformation.ProductType? = null,
    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("assetClasses") val assetClasses: kotlin.collections.List<AssetClass>? = null,
) {
    /**
     * Describes the type of system
     * Values: FREE_FLOATING,STATION_BASED,VIRTUAL_STATION_BASED
     */
    enum class TypeOfSystem(
        @get:JsonValue val value: kotlin.String,
    ) {
        FREE_FLOATING("FREE_FLOATING"),
        STATION_BASED("STATION_BASED"),
        VIRTUAL_STATION_BASED("VIRTUAL_STATION_BASED"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): TypeOfSystem = values().first { it -> it.value == value }
        }
    }

    /**
     * the type of product offered. SHARING should also be used for public transport.
     * Values: RENTAL,SHARING,PARKING,CHARGING
     */
    enum class ProductType(
        @get:JsonValue val value: kotlin.String,
    ) {
        RENTAL("RENTAL"),
        SHARING("SHARING"),
        PARKING("PARKING"),
        CHARGING("CHARGING"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ProductType = values().first { it -> it.value == value }
        }
    }
}
