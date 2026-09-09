package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
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

    @Schema(description = "only one phone in this array can have a true in this property")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("preferred")
    @get:JsonProperty("preferred") val preferred: kotlin.Boolean? = null,

    @get:Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\.0-9]*$")
    @Schema(example = "+31-48934758 or +(0075)-834923384 or 020 1234 1234", description = "phone number. In case of international usage, always provide the country code.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("number")
    @get:JsonProperty("number") val number: kotlin.String? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("kind")
    @get:JsonProperty("kind") val kind: Phone.Kind? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("type")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Kind'")
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
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Type'")
            }
        }
    }

}

