package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Pattern

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
    @get:Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\.0-9]*$")
    @Schema(
        example = "+31-48934758 or +(0075)-834923384 or 020 1234 1234",
        description = "phone number. In case of international usage, always provide the country code.",
    )
    @get:JsonProperty("number") val number: kotlin.String? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("kind") val kind: Phone.Kind? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: Phone.Type? = null,
) {
    /**
     *
     * Values: LANDLINE,MOBILE
     */
    enum class Kind(
        @get:JsonValue val value: kotlin.String,
    ) {
        LANDLINE("LANDLINE"),
        MOBILE("MOBILE"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Kind = values().first { it -> it.value == value }
        }
    }

    /**
     *
     * Values: PRIVATE,BUSINESS,OTHER
     */
    enum class Type(
        @get:JsonValue val value: kotlin.String,
    ) {
        PRIVATE("PRIVATE"),
        BUSINESS("BUSINESS"),
        OTHER("OTHER"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type = values().first { it -> it.value == value }
        }
    }
}
