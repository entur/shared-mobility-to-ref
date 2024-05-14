package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.SystemCalendar

val systemCalendar
    get() =
        SystemCalendar(
            stationId = "string",
            regionId = "string",
            startMonth = 1,
            startDay = 1,
            startYear = 2019,
            endMonth = 12,
            endDay = 31,
            endYear = 2099,
        )
