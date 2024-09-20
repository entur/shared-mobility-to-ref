package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegState
import java.time.OffsetDateTime
import java.util.UUID

val leg
    get() =
        Leg(
            id = UUID.randomUUID().toString(),
            from = place,
            departureTime = OffsetDateTime.now(),
            actualDepartureTime = OffsetDateTime.now(),
            assetType = assetType,
            asset = asset,
            pricing = fare,
            conditions = conditions,
            state = LegState.NOT_STARTED,
        )

val legWithoutDeposit
    get() =
        Leg(
            id = UUID.randomUUID().toString(),
            from = place,
            departureTime = OffsetDateTime.now(),
            actualDepartureTime = OffsetDateTime.now(),
            assetType = assetType,
            asset = asset,
            pricing = fare,
            conditions = conditionsNoDeposit,
            state = LegState.NOT_STARTED,
        )

val legWithHighDepositAmount
    get() =
        Leg(
            id = UUID.randomUUID().toString(),
            from = place,
            departureTime = OffsetDateTime.now(),
            actualDepartureTime = OffsetDateTime.now(),
            assetType = assetType,
            asset = asset,
            pricing = fare,
            conditions = conditionsWithHighDepositAmount,
            state = LegState.NOT_STARTED,
        )
