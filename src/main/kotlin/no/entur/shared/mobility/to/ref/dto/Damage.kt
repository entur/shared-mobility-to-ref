package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema

/**
 * A damage of the vehicle.
 * @param vehicleComponent Part/Component of the vehicle affected. If OTHER is specified the description needs to provide more detail as to what part/component is affected.
 * @param description Description of the damage.
 * @param pictures URL where pictures of the damage can be accessed. Any special characters in the URL must be correctly escaped.
 */
data class Damage(
    @Schema(
        example = "null",
        required = true,
        description = "Part/Component of the vehicle affected. If OTHER is specified the description needs to provide more detail as to what part/component is affected.",
    )
    @get:JsonProperty("vehicleComponent", required = true) val vehicleComponent: Damage.VehicleComponent,
    @Schema(example = "null", required = true, description = "Description of the damage.")
    @get:JsonProperty("description", required = true) val description: kotlin.String,
    @Schema(
        example = "null",
        description = "URL where pictures of the damage can be accessed. Any special characters in the URL must be correctly escaped.",
    )
    @get:JsonProperty("pictures") val pictures: kotlin.collections.List<kotlin.String>? = null,
) {
    /**
     * Part/Component of the vehicle affected. If OTHER is specified the description needs to provide more detail as to what part/component is affected.
     * Values: FRONT,REAR,LEFT,RIGHT,TOP,BOTTOM,INTERIOR,TIRE,ANCILLARY,OTHER
     */
    enum class VehicleComponent(
        @get:JsonValue val value: kotlin.String,
    ) {
        FRONT("FRONT"),
        REAR("REAR"),
        LEFT("LEFT"),
        RIGHT("RIGHT"),
        TOP("TOP"),
        BOTTOM("BOTTOM"),
        INTERIOR("INTERIOR"),
        TIRE("TIRE"),
        ANCILLARY("ANCILLARY"),
        OTHER("OTHER"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): VehicleComponent = values().first { it -> it.value == value }
        }
    }
}
