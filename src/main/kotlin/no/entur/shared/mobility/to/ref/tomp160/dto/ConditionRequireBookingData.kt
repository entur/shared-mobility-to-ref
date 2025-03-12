package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp160.dto.Condition
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
 * 
 * @param requiredFields 
 * @param claims when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials
 */
data class ConditionRequireBookingData(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("requiredFields", required = true) val requiredFields: kotlin.collections.List<ConditionRequireBookingData.RequiredFields>,

    @Schema(example = "null", required = true, description = "The specific subclass of condition, should match the schema name exactly")
    @get:JsonProperty("conditionType", required = true) override val conditionType: kotlin.String,

    @Schema(example = "null", description = "when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials")
    @get:JsonProperty("claims") val claims: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "deposit50eu", description = "An identifier for this condition that can be used to refer to this condition")
    @get:JsonProperty("id") override val id: kotlin.String? = null
    ) : Condition{

    /**
    * 
    * Values: FROM_ADDRESS,TO_ADDRESS,BIRTHDATE,EMAIL,FIRST_NAME,LAST_NAME_MIDDLE_NAME,PREFIX,POSTFIX,NAME,AGE,PERSONAL_ADDRESS,PHONE_NUMBERS,KNOWN_IDENTIFIER,KNOWN_IDENTIFIER_PROVIDER,LICENSES,BANK_CARDS,DISCOUNT_CARDS,TRAVEL_CARDS,ID_CARDS,CREDIT_CARDS,BLOCKCHAIN_CLAIMS
    */
    enum class RequiredFields(@get:JsonValue val value: kotlin.String) {

        FROM_ADDRESS("FROM_ADDRESS"),
        TO_ADDRESS("TO_ADDRESS"),
        BIRTHDATE("BIRTHDATE"),
        EMAIL("EMAIL"),
        FIRST_NAME("FIRST_NAME"),
        LAST_NAME_MIDDLE_NAME("LAST_NAME MIDDLE_NAME"),
        PREFIX("PREFIX"),
        POSTFIX("POSTFIX"),
        NAME("NAME"),
        AGE("AGE"),
        PERSONAL_ADDRESS("PERSONAL_ADDRESS"),
        PHONE_NUMBERS("PHONE_NUMBERS"),
        KNOWN_IDENTIFIER("KNOWN_IDENTIFIER"),
        KNOWN_IDENTIFIER_PROVIDER("KNOWN_IDENTIFIER_PROVIDER"),
        LICENSES("LICENSES"),
        BANK_CARDS("BANK_CARDS"),
        DISCOUNT_CARDS("DISCOUNT_CARDS"),
        TRAVEL_CARDS("TRAVEL_CARDS"),
        ID_CARDS("ID_CARDS"),
        CREDIT_CARDS("CREDIT_CARDS"),
        BLOCKCHAIN_CLAIMS("BLOCKCHAIN_CLAIMS");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): RequiredFields {
                return values().first{it -> it.value == value}
            }
        }
    }

}

