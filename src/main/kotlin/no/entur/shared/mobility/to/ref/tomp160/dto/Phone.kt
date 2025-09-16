package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param preferred only one phone in this array can have a true in this property
 * @param number phone number. In case of international usage, always provide the country code.
 * @param kind 
 * @param type 
 */
data class Phone(

    @Schema(example = "null", description = "only one phone in this array can have a true in this property")
    @get:JsonProperty("preferred") val preferred: kotlin.Boolean? = null,

    @get:Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\.0-9]*$")
    @Schema(example = "+31-48934758 or +(0075)-834923384 or 020 1234 1234", description = "phone number. In case of international usage, always provide the country code.")
    @get:JsonProperty("number") val number: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("kind") val kind: Phone.Kind? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: Phone.Type? = null
    ) {

    /**
    * 
    * Values: LANDLINE,MOBILE
    */
    enum class Kind(@get:JsonValue val value: kotlin.String) {

        LANDLINE("LANDLINE"),
        MOBILE("MOBILE");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Kind {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Phone'")
            }
        }
    }

    /**
    * 
    * Values: PRIVATE,BUSINESS,OTHER
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        PRIVATE("PRIVATE"),
        BUSINESS("BUSINESS"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Phone'")
            }
        }
    }

}

