package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import no.entur.shared.mobility.to.ref.dto.Condition

/**
 *
 * @param requiredFields
 * @param claims when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials
 */
data class ConditionRequireBookingData(
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("requiredFields", required = true) val requiredFields:
        kotlin.collections.List<ConditionRequireBookingData.RequiredFields>,
    @Schema(example = "null", required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,
    @Schema(
        example = "null",
        description = "when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials",
    )
    @get:JsonProperty("claims") val claims: kotlin.collections.List<kotlin.String>? = null,
    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @get:JsonProperty("id") override val id: kotlin.String? = null,
) : Condition {
    /**
     *
     * Values: FROM_ADDRESS,TO_ADDRESS,BIRTHDATE,EMAIL,PERSONAL_ADDRESS,PHONE_NUMBERS,LICENSES,BANK_CARDS,DISCOUNT_CARDS,TRAVEL_CARDS,ID_CARDS,CREDIT_CARDS,NAME,AGE,BLOCKCHAIN_CLAIMS
     */
    enum class RequiredFields(
        @get:JsonValue val value: kotlin.String,
    ) {
        FROM_ADDRESS("FROM_ADDRESS"),
        TO_ADDRESS("TO_ADDRESS"),
        BIRTHDATE("BIRTHDATE"),
        EMAIL("EMAIL"),
        PERSONAL_ADDRESS("PERSONAL_ADDRESS"),
        PHONE_NUMBERS("PHONE_NUMBERS"),
        LICENSES("LICENSES"),
        BANK_CARDS("BANK_CARDS"),
        DISCOUNT_CARDS("DISCOUNT_CARDS"),
        TRAVEL_CARDS("TRAVEL_CARDS"),
        ID_CARDS("ID_CARDS"),
        CREDIT_CARDS("CREDIT_CARDS"),
        NAME("NAME"),
        AGE("AGE"),
        BLOCKCHAIN_CLAIMS("BLOCKCHAIN_CLAIMS"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): RequiredFields = values().first { it -> it.value == value }
        }
    }
}
