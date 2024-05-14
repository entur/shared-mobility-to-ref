package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.SystemAlert
import java.time.OffsetDateTime

val systemAlert
    get() =
        SystemAlert(
            alertId = "string",
            alertType = SystemAlert.AlertType.SYSTEM_CLOSURE,
            startAndEndTimes =
                listOf(
                    listOf(
                        OffsetDateTime.now(),
                        OffsetDateTime.now(),
                    ),
                ),
            stationIds = listOf("stationID0001"),
            regionId = listOf("regionID0001"),
            url = "https://www.rentmyfreebike.com/alerts",
            summary = "station closed",
            description = "station closed indefinitely due to vandalism",
            lastUpdated = OffsetDateTime.now(),
        )
