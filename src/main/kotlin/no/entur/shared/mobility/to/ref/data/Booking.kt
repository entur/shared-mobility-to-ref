package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingState
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.Customer
import no.entur.shared.mobility.to.ref.dto.Fare
import no.entur.shared.mobility.to.ref.dto.FarePart
import no.entur.shared.mobility.to.ref.dto.Place
import java.time.OffsetDateTime
import java.util.UUID

val booking
    get() =
        Booking(
            id = UUID.randomUUID().toString(),
            from = place,
            customer = Customer(id = "A0-123456"),
            state = BookingState.CONFIRMED,
            legs = listOf(leg),
            pricing = finalFare(),
            departureTime = OffsetDateTime.now(),
            arrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualDepartureTime = OffsetDateTime.now(),
            actualArrivalTime = OffsetDateTime.now().plusMinutes(12),
        )

val bookingWithoutDeposit
    get() =
        Booking(
            id = UUID.randomUUID().toString(),
            from = place,
            customer = Customer(id = "A0-123456"),
            state = BookingState.CONFIRMED,
            legs = listOf(legWithoutDeposit),
            pricing = finalFare(),
            departureTime = OffsetDateTime.now(),
            arrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualDepartureTime = OffsetDateTime.now(),
            actualArrivalTime = OffsetDateTime.now().plusMinutes(12),
        )

val bookingHigherDepositAmountThanTotalAmount
    get() =
        Booking(
            id = UUID.randomUUID().toString(),
            from = place,
            customer = Customer(id = "A0-123456"),
            state = BookingState.CONFIRMED,
            legs = listOf(legWithHighDepositAmount),
            pricing = finalFare(),
            departureTime = OffsetDateTime.now(),
            arrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualDepartureTime = OffsetDateTime.now(),
            actualArrivalTime = OffsetDateTime.now().plusMinutes(12),
        )

val place
    get() =
        Place(
            coordinates =
                Coordinates(
                    lng = 6.169639F,
                    lat = 52.25327F,
                ),
        )

val fare
    get() =
        Fare(
            estimated = false,
            parts =
                listOf(
                    FarePart(
                        amount = 3.125F,
                        amountExVat = 2.5F,
                        currencyCode = "NOK",
                        vatRate = 25.00F,
                        vatCountryCode = "NO",
                        type = FarePart.Type.FLEX,
                        unitType = FarePart.UnitType.MINUTE,
                        units = 1F,
                        scaleFrom = 0F,
                        scaleType = FarePart.ScaleType.MINUTE,
                    ),
                ),
        )

fun finalFare(amount: Float = 50.00F): Fare {
    return Fare(
        estimated = false,
        parts =
            listOf(
                FarePart(
                    amount = amount,
                    amountExVat = amount * 0.8F,
                    currencyCode = "NOK",
                    vatRate = 25.00F,
                    vatCountryCode = "NO",
                    type = FarePart.Type.FIXED,
                ),
            ),
    )
}