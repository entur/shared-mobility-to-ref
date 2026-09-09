package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetProperties
import no.entur.shared.mobility.to.ref.tomp150.dto.Damage
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

    @Schema(required = true, description = "Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).")
    @param:JsonProperty("id", required = true)
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @Schema(description = "true indicates the bike is currently reserved for someone else")
    @param:JsonProperty("isReserved")
    @get:JsonProperty("isReserved") val isReserved: kotlin.Boolean? = null,

    @Schema(description = "optional addition to determine if an asset is reserved in the future")
    @param:JsonProperty("isReservedFrom")
    @get:JsonProperty("isReservedFrom") val isReservedFrom: java.time.OffsetDateTime? = null,

    @Schema(description = "optional addition to determine when asset is available in the future")
    @param:JsonProperty("isReservedTo")
    @get:JsonProperty("isReservedTo") val isReservedTo: java.time.OffsetDateTime? = null,

    @Schema(description = "true indicates the asset is currently disabled (broken)")
    @param:JsonProperty("isDisabled")
    @get:JsonProperty("isDisabled") val isDisabled: kotlin.Boolean? = null,

    @Schema(description = "The date and time when any rental of the vehicle must be completed. The vehicle must be returned and made available for the next user by this time. If this field is empty, it indicates that the vehicle is available indefinitely. This field SHOULD be published by carsharing or other mobility systems where vehicles can be booked in advance for future travel.")
    @param:JsonProperty("availableUntil")
    @get:JsonProperty("availableUntil") val availableUntil: java.time.OffsetDateTime? = null,

    @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890", description = "deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0")
    @Deprecated(message = "")
    @param:JsonProperty("rentalUrl")
    @get:JsonProperty("rentalUrl") val rentalUrl: kotlin.String? = null,

    @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=android", description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0")
    @Deprecated(message = "")
    @param:JsonProperty("rentalUrlAndroid")
    @get:JsonProperty("rentalUrlAndroid") val rentalUrlAndroid: kotlin.String? = null,

    @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios", description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0")
    @Deprecated(message = "")
    @param:JsonProperty("rentalUrlIOS")
    @get:JsonProperty("rentalUrlIOS") val rentalUrlIOS: kotlin.String? = null,

    @get:DecimalMin(value="0")
    @Schema(description = "the current mileage of the asset")
    @param:JsonProperty("mileage")
    @get:JsonProperty("mileage") val mileage: kotlin.Float? = null,

    @get:Min(value=0)
    @get:Max(value=100)
    @Schema(description = "percentage of charge available")
    @param:JsonProperty("stateOfCharge")
    @get:JsonProperty("stateOfCharge") val stateOfCharge: kotlin.Int? = null,

    @get:Min(value=0)
    @get:Max(value=100)
    @Schema(description = "maximum range in meters")
    @param:JsonProperty("maxRange")
    @get:JsonProperty("maxRange") val maxRange: kotlin.Int? = null,

    @Schema(description = "the usage of this field requires a secure environment. When assets are published in available-assets, this field can be used to track assets. Be aware of this.")
    @param:JsonProperty("licensePlate")
    @get:JsonProperty("licensePlate") val licensePlate: kotlin.String? = null,

    @Schema(description = "reference to station_id in /operator/stations, station where it is located")
    @param:JsonProperty("stationId")
    @get:JsonProperty("stationId") val stationId: kotlin.String? = null,

    @Schema(description = "reference to station_id in /operator/stations, station where it is assigned to")
    @param:JsonProperty("homeStationId")
    @get:JsonProperty("homeStationId") val homeStationId: kotlin.String? = null,

    @field:Valid
    @Schema(description = "List of known vehicle damages.")
    @param:JsonProperty("damages")
    @get:JsonProperty("damages") val damages: kotlin.collections.List<Damage>? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("overriddenProperties")
    @get:JsonProperty("overriddenProperties") val overriddenProperties: AssetProperties? = null
) {

}

