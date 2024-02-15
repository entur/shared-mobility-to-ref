package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.time.OffsetDateTime

/**
 *
 * @param id Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).
 * @param isReserved true indicates the bike is currently reserved for someone else
 * @param isReservedFrom optional addition to determine if an asset is reserved in the future
 * @param isReservedTo optional addition to determine when asset is available in the future
 * @param isDisabled true indicates the asset is currently disabled (broken)
 * @param availableUntil The date and time when any rental of the vehicle must be completed. The vehicle must be returned and made
 * available for the next user by this time. If this field is empty, it indicates that the vehicle is available indefinitely.
 * This field SHOULD be published by carsharing or other mobility systems where vehicles can be booked in advance for future travel.
 * @param rentalUrl deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0
 * @param rentalUrlAndroid deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0
 * @param rentalUrlIOS deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0
 * @param mileage the current mileage of the asset
 * @param stateOfCharge percentage of charge available
 * @param maxRange maximum range in meters
 * @param licensePlate the usage of this field requires a secure environment. When assets are published in available-assets,
 * this field can be used to track assets. Be aware of this.
 * @param stationId reference to station_id in /operator/stations, station where it is located
 * @param homeStationId reference to station_id in /operator/stations, station where it is assigned to
 * @param damages List of known vehicle damages.
 * @param overriddenProperties
 */
data class Asset(
    @Schema(
        example = "null",
        required = true,
        description = "Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).",
    )
    @get:JsonProperty("id", required = true) val id: String,
    @Schema(example = "null", description = "true indicates the bike is currently reserved for someone else")
    val isReserved: Boolean? = null,
    @Schema(example = "null", description = "optional addition to determine if an asset is reserved in the future")
    val isReservedFrom: OffsetDateTime? = null,
    @Schema(example = "null", description = "optional addition to determine when asset is available in the future")
    val isReservedTo: OffsetDateTime? = null,
    @Schema(example = "null", description = "true indicates the asset is currently disabled (broken)")
    val isDisabled: Boolean? = null,
    @Schema(
        example = "null",
        description =
            "The date and time when any rental of the vehicle must be completed. The vehicle must be returned and made " +
                "available for the next user by this time. If this field is empty, it indicates that the vehicle is available " +
                "indefinitely. This field SHOULD be published by carsharing or other mobility systems where vehicles can be booked in " +
                "advance for future travel.",
    )
    val availableUntil: OffsetDateTime? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/app?sid=1234567890",
        description = "deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0",
    )
    @Deprecated(message = "")
    val rentalUrl: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=android",
        description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0",
    )
    @Deprecated(message = "")
    val rentalUrlAndroid: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios",
        description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0",
    )
    @Deprecated(message = "")
    val rentalUrlIOS: String? = null,
    @get:DecimalMin("0")
    @Schema(example = "null", description = "the current mileage of the asset")
    val mileage: Float? = null,
    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "percentage of charge available")
    val stateOfCharge: Int? = null,
    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "maximum range in meters")
    val maxRange: Int? = null,
    @Schema(
        example = "null",
        description =
            "the usage of this field requires a secure environment. When assets are published in available-assets, this field " +
                "can be used to track assets. Be aware of this.",
    )
    val licensePlate: String? = null,
    @Schema(
        example = "null",
        description = "reference to station_id in /operator/stations, station where it is located",
    )
    val stationId: String? = null,
    @Schema(
        example = "null",
        description = "reference to station_id in /operator/stations, station where it is assigned to",
    )
    val homeStationId: String? = null,
    @field:Valid
    @Schema(example = "null", description = "List of known vehicle damages.")
    val damages: List<Damage>? = null,
    @field:Valid
    @Schema(example = "null")
    val overriddenProperties: AssetProperties? = null,
)
