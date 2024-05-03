package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Day
import no.entur.shared.mobility.to.ref.dto.SystemHours

val systemHours
    get() =
        SystemHours(
            userType = SystemHours.UserType.MEMBER,
            stationId = "string",
            regionId = "string",
            startTime = "string",
            endTime = "string",
            days = listOf(Day.MON),
        )
