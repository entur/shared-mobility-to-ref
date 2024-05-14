package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Planning
import java.time.OffsetDateTime

val planning
    get() =
        Planning(
            validUntil = OffsetDateTime.now().plusMinutes(5),
            options = listOf(booking),
        )
