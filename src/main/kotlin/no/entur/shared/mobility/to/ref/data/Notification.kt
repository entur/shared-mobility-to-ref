package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Notification

val notification
    get() =
        Notification(
            type = Notification.Type.VEHICLE_NOT_AVAILABLE,
            minutes = 0,
            asset = asset,
            comment = "string",
            legId = "string",
        )
