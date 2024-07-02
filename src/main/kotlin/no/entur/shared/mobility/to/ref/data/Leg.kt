package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegState
import java.time.OffsetDateTime

val leg
    get() =
        Leg(
            id = "string",
            from = place,
            departureTime = OffsetDateTime.now(),
            arrivalTime = null,
            actualArrivalTime = null,
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
            id = "string",
            from = place,
            departureTime = OffsetDateTime.now(),
            arrivalTime = null,
            actualArrivalTime = null,
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
            id = "string",
            from = place,
            departureTime = OffsetDateTime.now(),
            arrivalTime = null,
            actualArrivalTime = null,
            actualDepartureTime = OffsetDateTime.now(),
            assetType = assetType,
            asset = asset,
            pricing = fare,
            conditions = conditionsWithHighDepositAmount,
            state = LegState.NOT_STARTED,
        )
