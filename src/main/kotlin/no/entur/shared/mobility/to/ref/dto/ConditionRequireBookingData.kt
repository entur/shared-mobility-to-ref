package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 *
 * @param conditionType The specific subclass of condition, should match the schema name exactly
 * @param requiredFields
 * @param id An identifier for this condition that can be used to refer to this condition
 * @param claims when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI
 * page, the known ones are enlisted, but this list isn't finalized yet.
 * https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials
 */
data class ConditionRequireBookingData(
    @Schema(
        example = "null",
        required = true,
        description = "The specific subclass of condition, should match the schema name exactly",
    )
    @get:JsonProperty("conditionType", required = true) override val conditionType: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty(
        "requiredFields",
        required = true,
    ) val requiredFields: List<RequiredFields>,
    @Schema(
        example = "deposit50eu",
        description = "An identifier for this condition that can be used to refer to this condition",
    )
    val id: String? = null,
    @Schema(
        example = "null",
        description =
            "when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. " +
                "On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. " +
                "https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials",
    )
    val claims: List<String>? = null,
): AssetTypeConditionsInner {
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
}
