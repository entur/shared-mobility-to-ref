package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.LegProgress

val legProgress
    get() =
        LegProgress(
            coordinates =
                Coordinates(
                    lng = 6.169639F,
                    lat = 52.25327F,
                    alt = 0F,
                ),
            duration = 11112,
            distance = 7250,
            asset = asset,
        )
