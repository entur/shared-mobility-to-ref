package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
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
 * A damage of the asset.
 * @param assetComponent Part/Component of the asset affected. If OTHER is specified the description needs to provide more detail as to what part/component is affected.<br>
 * @param description long string, memos etc (length 0-10.000)
 * @param pictures URL where pictures of the damage can be accessed. Any special characters in the URL must be correctly escaped.
 */
data class Damage(

    @Schema(example = "null", required = true, description = "Part/Component of the asset affected. If OTHER is specified the description needs to provide more detail as to what part/component is affected.<br>")
    @get:JsonProperty("assetComponent", required = true) val assetComponent: Damage.AssetComponent,

    @get:Size(max=10000)
    @Schema(example = "null", required = true, description = "long string, memos etc (length 0-10.000)")
    @get:JsonProperty("description", required = true) val description: kotlin.String,

    @field:Valid
    @get:Size(max=10)
    @Schema(example = "null", description = "URL where pictures of the damage can be accessed. Any special characters in the URL must be correctly escaped.")
    @get:JsonProperty("pictures") val pictures: kotlin.collections.List<java.net.URI>? = null
) {

    /**
    * Part/Component of the asset affected. If OTHER is specified the description needs to provide more detail as to what part/component is affected.<br>
    * Values: FRONT,REAR,LEFT,RIGHT,TOP,BOTTOM,INTERIOR,TIRE,ANCILLARY,OTHER
    */
    enum class AssetComponent(@get:JsonValue val value: kotlin.String) {

        FRONT("FRONT"),
        REAR("REAR"),
        LEFT("LEFT"),
        RIGHT("RIGHT"),
        TOP("TOP"),
        BOTTOM("BOTTOM"),
        INTERIOR("INTERIOR"),
        TIRE("TIRE"),
        ANCILLARY("ANCILLARY"),
        OTHER("OTHER");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): AssetComponent {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Damage'")
            }
        }
    }

}

