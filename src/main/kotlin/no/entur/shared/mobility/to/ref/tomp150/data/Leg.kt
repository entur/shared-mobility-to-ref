package no.entur.shared.mobility.to.ref.tomp150.data

import no.entur.shared.mobility.to.ref.tomp150.dto.Leg
import no.entur.shared.mobility.to.ref.tomp150.dto.LegState
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
            state = LegState.IN_USE,
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
            state = LegState.IN_USE,
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
            state = LegState.IN_USE,
        )
