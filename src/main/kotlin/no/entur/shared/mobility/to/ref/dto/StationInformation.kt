package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 *
 * @param stationId unique identifier of a station
 * @param name public name of the station, could match Content-Language
 * @param coordinates
 * @param contactPhone Contact phone of the station
 * @param physicalAddress
 * @param crossStreet Cross street of where the station is located. This field is intended to be a descriptive field for human consumption.
 * In cities, this would be a cross street, but could also be a description of a location in a park, etc, should match Content-Language
 * @param regionId ID of the region where the station operates (see \"systemRegions\")
 * @param stationArea
 * @param parkingType parking_lot (Off-street parking lot) street_parking (Curbside parking) underground_parking (Parking that is below
 * street level, station may be non-communicating) sidewalk_parking (Park vehicle on sidewalk, out of the pedestrian right of way) other
 * @param isVirtual Is this station a location with or without smart dock technology? true - The station is a location without smart
 * docking infrastructure. the station may be defined by a point (lat/lon) and/or station_area (below). false - The station consists of
 * smart docking infrastructure (docks). This field SHOULD be published by mobility systems that have station locations without standard,
 * internet connected physical docking infrastructure. These may be racks or geofenced areas designated for rental and/or return of
 * vehicles. Locations that fit within this description SHOULD have the is_virtual_station boolean set to true.
 * @param isValetStation Are valet services provided at this station? Valet service is defined as providing unlimited capacity at a
 * station.
 * @param isChargingStation Does the station support charging of electric vehicles?
 * @param parkingHoop Parking hoops are lockable devices that are used to secure a parking space to prevent parking of unauthorized
 * vehicles.
 * @param isInstalled Is the station currently on the street?
 * @param isRenting Is the station currently renting vehicles?
 * @param isReturning Is the station accepting vehicle returns?
 * @param capacity the total capacity of this station
 * @param assetTypeCapacity An object used to describe the docking capacity of a station where each key is a reference to the ID of the
 * assetType, and the value is a number representing the total docking points installed at this station, both available and unavailable for
 * the specified vehicle type.
 * @param assetsAvailable the number of available assets in this station (total)
 * @param assetTypesAvailable An object used to describe the available assets of a station where each key is a reference to the ID of the
 * assetType, and the value is a number representing the total available asset of this type at this station.
 * @param docksAvailable the number of free docks
 * @param assetDocksAvailable An object used to describe the free slots of a station where each key is a reference to the ID of the
 * assetType, and the value is a number representing the total free docks for this assetType at this station.
 * @param rentalMethods Array of enumerables containing the payment methods accepted at this station.
 * @param rentalMethodOther whenever `OTHER` is specified in the field 'rentalMethods', this field contains a free-format definition.
 * @param rentalUrl web uri for renting assets at this station. Only added to be consistent with GBFS 2.0.
 * @param rentalUrlAndroid android uri for renting assets at this station. Only added to be consistent with GBFS 2.0.
 * @param rentalUrlIOS ios uri for renting assets at this station. Only added to be consistent with GBFS 2.0.
 */
data class StationInformation(
    @Schema(example = "XX:Y:12345678", required = true, description = "unique identifier of a station")
    @get:JsonProperty("stationId", required = true) val stationId: String,
    @Schema(
        example = "Island Central",
        required = true,
        description = "public name of the station, could match Content-Language",
    )
    @get:JsonProperty("name", required = true) val name: String,
    @field:Valid
    @Schema(example = "null", required = true)
    @get:JsonProperty("coordinates", required = true) val coordinates: Coordinates,
    @Schema(example = "null", description = "Contact phone of the station")
    val contactPhone: String? = null,
    @field:Valid
    @Schema(example = "null")
    val physicalAddress: Address? = null,
    @Schema(
        example = "on the corner with Secondary Road",
        description =
            "Cross street of where the station is located. This field is intended to be a descriptive field for human " +
                "consumption. In cities, this would be a cross street, but could also be a description of a location in a park, etc, " +
                "should match Content-Language",
    )
    val crossStreet: String? = null,
    @Schema(example = "null", description = "ID of the region where the station operates (see \"systemRegions\")")
    val regionId: String? = null,
    @field:Valid
    @Schema(example = "null")
    val stationArea: GeojsonGeometry? = null,
    @Schema(
        example = "null",
        description =
            "parking_lot (Off-street parking lot) street_parking (Curbside parking) underground_parking (Parking that is " +
                "below street level, station may be non-communicating) sidewalk_parking (Park vehicle on sidewalk, out of the pedestrian " +
                "right of way) other",
    )
    val parkingType: ParkingType? = null,
    @Schema(
        example = "null",
        description =
            "Is this station a location with or without smart dock technology? true - The station is a location without smart " +
                "docking infrastructure. the station may be defined by a point (lat/lon) and/or station_area (below). false - The " +
                "station consists of smart docking infrastructure (docks). This field SHOULD be published by mobility systems that have " +
                "station locations without standard, internet connected physical docking infrastructure. These may be racks or " +
                "geofenced areas designated for rental and/or return of vehicles. Locations that fit within this description SHOULD have" +
                " the is_virtual_station boolean set to true.",
    )
    val isVirtual: Boolean? = null,
    @Schema(
        example = "null",
        description =
            "Are valet services provided at this station? Valet service is defined as providing unlimited capacity at a " +
                "station.",
    )
    val isValetStation: Boolean? = null,
    @Schema(example = "null", description = "Does the station support charging of electric vehicles?")
    val isChargingStation: Boolean? = null,
    @Schema(
        example = "null",
        description =
            "Parking hoops are lockable devices that are used to secure a parking space to prevent parking of unauthorized " +
                "vehicles.",
    )
    val parkingHoop: Boolean? = null,
    @Schema(example = "null", description = "Is the station currently on the street?")
    val isInstalled: Boolean? = null,
    @Schema(example = "null", description = "Is the station currently renting vehicles?")
    val isRenting: Boolean? = null,
    @Schema(example = "null", description = "Is the station accepting vehicle returns?")
    val isReturning: Boolean? = null,
    @Schema(example = "null", description = "the total capacity of this station")
    val capacity: Int? = null,
    @field:Valid
    @Schema(
        example = "{\"child-bike-01\":3,\"general-bike\":18}",
        description =
            "An object used to describe the docking capacity of a station where each key is a reference to the ID of the " +
                "assetType, and the value is a number representing the total docking points installed at this station, both available " +
                "and unavailable for the specified vehicle type.",
    )
    val assetTypeCapacity: Map<String, Any>? = null,
    @Schema(example = "null", description = "the number of available assets in this station (total)")
    val assetsAvailable: Int? = null,
    @field:Valid
    @Schema(
        example = "{\"child-bike-01\":1,\"general-bike\":3}",
        description =
            "An object used to describe the available assets of a station where each key is a reference to the ID of the " +
                "assetType, and the value is a number representing the total available asset of this type at this station.",
    )
    val assetTypesAvailable: Map<String, Any>? = null,
    @Schema(example = "null", description = "the number of free docks")
    val docksAvailable: Int? = null,
    @field:Valid
    @Schema(
        example = "{\"child-bike-01\":1,\"general-bike\":3}",
        description =
            "An object used to describe the free slots of a station where each key is a reference to the ID of the assetType, " +
                "and the value is a number representing the total free docks for this assetType at this station.",
    )
    val assetDocksAvailable: Map<String, Any>? = null,
    @Schema(
        example = "[\"CREDITCARD\",\"PAYPASS\",\"APPLEPAY\"]",
        description = "Array of enumerables containing the payment methods accepted at this station.",
    )
    val rentalMethods: List<RentalMethods>? = null,
    @Schema(
        example = "iDEAL",
        description = "whenever `OTHER` is specified in the field 'rentalMethods', this field contains a free-format definition.",
    )
    val rentalMethodOther: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com",
        description = "web uri for renting assets at this station. Only added to be consistent with GBFS 2.0.",
    )
    @Deprecated(message = "")
    val rentalUrl: String? = null,
    @Schema(
        example = "https://www.rentmyfreebikecom/app?sid=1234567890&platform=android",
        description = "android uri for renting assets at this station. Only added to be consistent with GBFS 2.0.",
    )
    @Deprecated(message = "")
    val rentalUrlAndroid: String? = null,
    @Schema(
        example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios",
        description = "ios uri for renting assets at this station. Only added to be consistent with GBFS 2.0.",
    )
    @Deprecated(message = "")
    val rentalUrlIOS: String? = null,
) {
    /**
     * parking_lot (Off-street parking lot) street_parking (Curbside parking) underground_parking (Parking that is below street level,
     * station may be non-communicating) sidewalk_parking (Park vehicle on sidewalk, out of the pedestrian right of way) other
     * Values: pARKINGLOT,sTREETPARKING,uNDERGROUNDPARKING,sIDEWALKPARKING,oTHER
     */
    enum class ParkingType {
        PARKING_LOT,
        STREET_PARKING,
        UNDERGROUND_PARKING,
        SIDEWALK_PARKING,
        OTHER,
    }

    /**
     * Array of enumerables containing the payment methods accepted at this station.
     */
    enum class RentalMethods {
        KEY,
        CASH,
        BANKCARD,
        CREDITCARD,
        PAYPASS,
        APPLEPAY,
        ANDROIDPAY,
        TRANSITCARD,
        ACCOUNTNUMBER,
        PHONE,
        OTHER,
    }
}
