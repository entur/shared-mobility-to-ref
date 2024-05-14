package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.GeoJsonGeometry
import no.entur.shared.mobility.to.ref.dto.StationInformation

val stationInformations
    get() =
        listOf(
            StationInformation(
                stationId = "XX:Y:12345678",
                name = "Island Central",
                contactPhone = "string",
                coordinates =
                    Coordinates(
                        lng = 6.169639F,
                        lat = 52.25327F,
                        alt = 0F,
                    ),
                physicalAddress = address,
                crossStreet = "on the corner with Secondary Road",
                regionId = "string",
                stationArea =
                    GeoJsonGeometry(
                        type = GeoJsonGeometry.Type.Point,
                        coordinates = listOf(4.53432, 55.324523),
                    ),
                parkingType = StationInformation.ParkingType.PARKING_LOT,
                isVirtual = true,
                isValetStation = true,
                isChargingStation = true,
                parkingHoop = true,
                isInstalled = true,
                isRenting = true,
                isReturning = true,
                capacity = 0,
                assetTypeCapacity =
                    mapOf(
                        "childBike-01" to 3,
                        "generalBike" to 18,
                    ),
                assetsAvailable = 0,
                assetTypesAvailable =
                    mapOf(
                        "childBike-01" to 1,
                        "generalBike" to 3,
                    ),
                docksAvailable = 0,
                assetDocksAvailable =
                    mapOf(
                        "childBike-01" to 1,
                        "generalBike" to 3,
                    ),
                rentalMethods =
                    listOf(
                        StationInformation.RentalMethods.CREDITCARD,
                        StationInformation.RentalMethods.PAYPASS,
                        StationInformation.RentalMethods.APPLEPAY,
                    ),
                rentalMethodOther = "iDEAL",
            ),
            StationInformation(
                stationId = "XX:Y:12345678",
                name = "Island Central",
                coordinates =
                    Coordinates(
                        lng = 6.169639F,
                        lat = 52.25327F,
                        alt = 0F,
                    ),
                stationArea =
                    GeoJsonGeometry(
                        type = GeoJsonGeometry.Type.LineString,
                        coordinates =
                            listOf(
                                listOf(4.53432, 55.324523),
                                listOf(4.53432, 55.324523),
                            ),
                    ),
            ),
            StationInformation(
                stationId = "XX:Y:12345678",
                name = "Island Central",
                coordinates =
                    Coordinates(
                        lng = 6.169639F,
                        lat = 52.25327F,
                        alt = 0F,
                    ),
                stationArea =
                    GeoJsonGeometry(
                        type = GeoJsonGeometry.Type.Polygon,
                        coordinates =
                            listOf(
                                listOf(
                                    listOf(4.53432, 55.324523),
                                    listOf(4.53432, 55.324523),
                                ),
                                listOf(
                                    listOf(4.53432, 55.324523),
                                    listOf(4.53432, 55.324523),
                                ),
                            ),
                    ),
            ),
            StationInformation(
                stationId = "XX:Y:12345678",
                name = "Island Central",
                coordinates =
                    Coordinates(
                        lng = 6.169639F,
                        lat = 52.25327F,
                        alt = 0F,
                    ),
                stationArea =
                    GeoJsonGeometry(
                        type = GeoJsonGeometry.Type.MultiPolygon,
                        coordinates =
                            listOf(
                                listOf(
                                    listOf(
                                        listOf(4.53432, 55.324523),
                                        listOf(4.53432, 55.324523),
                                    ),
                                    listOf(
                                        listOf(4.53432, 55.324523),
                                        listOf(4.53432, 55.324523),
                                    ),
                                ),
                                listOf(
                                    listOf(
                                        listOf(4.53432, 55.324523),
                                        listOf(4.53432, 55.324523),
                                    ),
                                    listOf(
                                        listOf(4.53432, 55.324523),
                                        listOf(4.53432, 55.324523),
                                    ),
                                ),
                            ),
                    ),
            ),
        )
