package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * A damage of the vehicle.
 * @param vehicleComponent Part/Component of the vehicle affected. If OTHER is specified the description needs to provide more
 * detail as to what part/component is affected.
 * @param description Description of the damage.
 * @param pictures URL where pictures of the damage can be accessed. Any special characters in the URL must be correctly escaped.
 */
data class Damage(
    @Schema(
        example = "null",
        required = true,
        description =
            "Part/Component of the vehicle affected. If OTHER is specified the description needs to provide more detail " +
                "as to what part/component is affected.",
    )
    @get:JsonProperty("vehicleComponent", required = true) val vehicleComponent: VehicleComponent,
    @Schema(example = "null", required = true, description = "Description of the damage.")
    @get:JsonProperty("description", required = true) val description: String,
    @Schema(
        example = "null",
        description = "URL where pictures of the damage can be accessed. Any special characters in the URL must be correctly escaped.",
    )
    val pictures: List<String>? = null,
) {
    /**
     * Part/Component of the vehicle affected. If OTHER is specified the description needs to provide more detail as to what
     * part/component is affected.
     * Values: fRONT,rEAR,lEFT,rIGHT,tOP,bOTTOM,iNTERIOR,tIRE,aNCILLARY,oTHER
     */
    enum class VehicleComponent {
        FRONT,
        REAR,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        INTERIOR,
        TIRE,
        ANCILLARY,
        OTHER,
    }
}
