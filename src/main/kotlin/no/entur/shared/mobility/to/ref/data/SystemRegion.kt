package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.GeoJsonLine
import no.entur.shared.mobility.to.ref.dto.GeoJsonPoint
import no.entur.shared.mobility.to.ref.dto.GeoJsonPolygon
import no.entur.shared.mobility.to.ref.dto.SystemRegion
import java.time.OffsetDateTime

val systemRegion
    get() =
        SystemRegion(
            regionId = "BikeRegion",
            name = "BikeTown",
            type = SystemRegion.Type.OPERATING,
            typeUnit = SystemRegion.TypeUnit.KMPH,
            typeValue = 0F,
            areaStartTime = OffsetDateTime.now(),
            areaEndTime = OffsetDateTime.now(),
            serviceArea =
                GeoJsonPolygon(
                    listOf(
                        GeoJsonLine(
                            listOf(
                                GeoJsonPoint(listOf(1F, 1F)),
                                GeoJsonPoint(listOf(0F, 1F)),
                                GeoJsonPoint(listOf(0F, 0F)),
                                GeoJsonPoint(listOf(1F, 0F)),
                                GeoJsonPoint(listOf(1F, 1F)),
                            ),
                        ),
                    ),
                ),
        )
