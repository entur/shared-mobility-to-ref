package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param ultimateResponseTime
 * @param requiredFields
 * @param evidenceTypes
 * @param steps
 * @param id An identifier for this condition that can be used to refer to this condition
 * @param amount This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal
 * places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
 * @param amountExVat
 * @param currencyCode ISO 4217 currency code
 * @param vatRate value added tax rate (percentage of amount)
 * @param vatCountryCode two-letter country codes according to ISO 3166-1
 * @param claims when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified.
 * On the WIKI page, the known ones are enlisted, but this list isn't finalized yet.
 * https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials
 * @param stationId station to which the asset should be returned
 * @param returnArea geojson representation of a polygon. First and last point must be equal.
 * See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4.
 * The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
 * @param coordinates
 * @param returnHours the return hours of the facility (if different from operating-hours)
 */

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "conditionType",
    visible = true,
)
@JsonSubTypes(
    JsonSubTypes.Type(ConditionDeposit::class),
    JsonSubTypes.Type(ConditionPayWhenFinished::class),
    JsonSubTypes.Type(ConditionPostponedCommit::class),
    JsonSubTypes.Type(ConditionRequireBookingData::class),
    JsonSubTypes.Type(ConditionReturnArea::class),
    JsonSubTypes.Type(ConditionUpfrontPayment::class),
    JsonSubTypes.Type(ConditionRequireEvidence::class),
    JsonSubTypes.Type(ConditionRequireOnboardingSteps::class),
    JsonSubTypes.Type(ConditionRequireOffboardingSteps::class),
    JsonSubTypes.Type(ConditionRequirePausingSteps::class),
    JsonSubTypes.Type(ConditionRequireResumingSteps::class),
)
interface AssetTypeConditionsInner {
    @get:Schema(
        example = "null",
        requiredMode = Schema.RequiredMode.REQUIRED,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    val conditionType: String

//    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
//    val ultimateResponseTime: java.time.OffsetDateTime
//
//    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
//    val requiredFields: RequiredFields
//
//    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
//    val evidenceTypes: EvidenceTypes
//
//    @get:Schema(example = "null", requiredMode = Schema.RequiredMode.REQUIRED)
//    val steps: List<ResumingStep>
//
//    @get:Schema(
//        example = "deposit50eu",
//        description = "An identifier for this condition that can be used to refer to this condition",
//    )
//    val id: String?
//
//    @get:Schema(
//        example = "9.95",
//        description =
//        "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of " +
//            "decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. " +
//            "This is inclusive VAT",
//    )
//    val amount: Float?
//
//    @get:Schema(example = "8.95")
//    val amountExVat: Float?
//
//    @get:Schema(example = "null", description = "ISO 4217 currency code")
//    val currencyCode: String?
//
//    @get:Schema(example = "21.0", description = "value added tax rate (percentage of amount)")
//    val vatRate: Float?
//
//    @get:Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
//    val vatCountryCode: String?
//
//    @get:Schema(
//        example = "null",
//        description =
//        "when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. " +
//            "On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. " +
//            "https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials",
//    )
//    val claims: List<String>?
//
//    @get:Schema(example = "null", description = "station to which the asset should be returned")
//    val stationId: String?
//
//    @get:Schema(
//        example = "[[[1.0,1.0],[0.0,1.0],[0.0,0.0],[1.0,0.0],[1.0,1.0]]]",
//        description =
//        "geojson representation of a polygon. First and last point must be equal. See also " +
//            "https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should " +
//            "be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.",
//    )
//    val returnArea: List<List<List<Float>>>?
//
//    @get:Schema(example = "null")
//    val coordinates: Coordinates?
//
//    @get:Schema(example = "null", description = "the return hours of the facility (if different from operating-hours)")
//    val returnHours: List<SystemHours>?

    enum class RequiredFields {
        FROM_ADDRESS,
        TO_ADDRESS,
        BIRTHDATE,
        EMAIL,
        PERSONAL_ADDRESS,
        PHONE_NUMBERS,
        LICENSES,
        BANK_CARDS,
        DISCOUNT_CARDS,
        TRAVEL_CARDS,
        ID_CARDS,
        CREDIT_CARDS,
        NAME,
        AGE,
        BLOCKCHAIN_CLAIMS,
    }

    enum class EvidenceTypes {
        PARKED,
        HELMET_IN_BASKET,
        CHARGING,
    }
}
