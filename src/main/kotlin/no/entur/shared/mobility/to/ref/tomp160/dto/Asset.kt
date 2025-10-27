package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetProperties
import no.entur.shared.mobility.to.ref.tomp160.dto.Damage
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
 * @param id Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).
 * @param isReserved true indicates the bike is currently reserved for someone else
 * @param isReservedFrom optional addition to determine if an asset is reserved in the future
 * @param isReservedTo optional addition to determine when asset is available in the future
 * @param isDisabled true indicates the asset is currently disabled (broken)
 * @param availableUntil The date and time when any rental of the vehicle must be completed. The vehicle must be returned and made available for the next user by this time. If this field is empty, it indicates that the vehicle is available indefinitely. This field SHOULD be published by carsharing or other mobility systems where vehicles can be booked in advance for future travel.
 * @param rentalUrl deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0
 * @param rentalUrlAndroid deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0
 * @param rentalUrlIOS deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0
 * @param mileage the current mileage of the asset
 * @param stateOfCharge percentage of charge available
 * @param maxRange maximum range in meters
 * @param licensePlate the usage of this field requires a secure environment. When assets are published in available-assets, this field can be used to track assets. Be aware of this.
 * @param stationId reference to station_id in /operator/stations, station where it is located
 * @param homeStationId reference to station_id in /operator/stations, station where it is assigned to
 * @param damages List of known vehicle damages.
 * @param overriddenProperties 
 */
data class Asset(

    @Schema(example = "null", required = true, description = "Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @Schema(example = "null", description = "true indicates the bike is currently reserved for someone else")
    @get:JsonProperty("isReserved") val isReserved: kotlin.Boolean? = null,

    @Schema(example = "null", description = "optional addition to determine if an asset is reserved in the future")
    @get:JsonProperty("isReservedFrom") val isReservedFrom: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "optional addition to determine when asset is available in the future")
    @get:JsonProperty("isReservedTo") val isReservedTo: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "true indicates the asset is currently disabled (broken)")
    @get:JsonProperty("isDisabled") val isDisabled: kotlin.Boolean? = null,

    @Schema(example = "null", description = "The date and time when any rental of the vehicle must be completed. The vehicle must be returned and made available for the next user by this time. If this field is empty, it indicates that the vehicle is available indefinitely. This field SHOULD be published by carsharing or other mobility systems where vehicles can be booked in advance for future travel.")
    @get:JsonProperty("availableUntil") val availableUntil: java.time.OffsetDateTime? = null,

    @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890", description = "deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0")
    @Deprecated(message = "")
    @get:JsonProperty("rentalUrl") val rentalUrl: kotlin.String? = null,

    @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=android", description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0")
    @Deprecated(message = "")
    @get:JsonProperty("rentalUrlAndroid") val rentalUrlAndroid: kotlin.String? = null,

    @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios", description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0")
    @Deprecated(message = "")
    @get:JsonProperty("rentalUrlIOS") val rentalUrlIOS: kotlin.String? = null,

    @get:DecimalMin("0")
    @Schema(example = "null", description = "the current mileage of the asset")
    @get:JsonProperty("mileage") val mileage: kotlin.Float? = null,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "percentage of charge available")
    @get:JsonProperty("stateOfCharge") val stateOfCharge: kotlin.Int? = null,

    @get:Min(0)
    @get:Max(100)
    @Schema(example = "null", description = "maximum range in meters")
    @get:JsonProperty("maxRange") val maxRange: kotlin.Int? = null,

    @Schema(example = "null", description = "the usage of this field requires a secure environment. When assets are published in available-assets, this field can be used to track assets. Be aware of this.")
    @get:JsonProperty("licensePlate") val licensePlate: kotlin.String? = null,

    @Schema(example = "null", description = "reference to station_id in /operator/stations, station where it is located")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(example = "null", description = "reference to station_id in /operator/stations, station where it is assigned to")
    @get:JsonProperty("homeStationId") val homeStationId: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "List of known vehicle damages.")
    @get:JsonProperty("damages") val damages: kotlin.collections.List<Damage>? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("overriddenProperties") val overriddenProperties: AssetProperties? = null
) {

}

