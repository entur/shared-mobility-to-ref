package no.entur.shared.mobility.to.ref.dto

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
    val preferred: Boolean? = null,
    @get:Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\.0-9]*$")
    @Schema(
        example = "+31-48934758 or +(0075)-834923384 or 020 1234 1234",
        description = "phone number. In case of international usage, always provide the country code.",
    )
    val number: String? = null,
    @Schema(example = "null")
    val kind: Kind? = null,
    @Schema(example = "null")
    val type: Type? = null,
) {
    enum class Kind {
        LANDLINE,
        MOBILE,
    }

    enum class Type {
        PRIVATE,
        BUSINESS,
        OTHER,
    }
}
