package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Address
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingState
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.Customer
import no.entur.shared.mobility.to.ref.dto.Fare
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
            pricing = finalFare,
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
            pricing = finalFare,
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
            pricing = finalFare,
            departureTime = OffsetDateTime.now(),
            arrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualDepartureTime = OffsetDateTime.now(),
            actualArrivalTime = OffsetDateTime.now().plusMinutes(12),
        )

val place
    get() =
        Place(
            name = "string",
            coordinates =
                Coordinates(
                    lng = 6.169639F,
                    lat = 52.25327F,
                    alt = 0F,
                ),
        )

val address
    get() =
        Address(
            streetAddress = "example street 18, 2nd floor, 18-B33",
            street = "string",
            houseNumber = 0,
            houseNumberAddition = "string",
            addressAdditionalInfo = "string",
            areaReference = "Smallcity, Pinetree county",
            city = "string",
            province = "string",
            state = "string",
            postalCode = "string",
            country = "NO",
        )

val fare
    get() =
        Fare(
            estimated = true,
            description = "string",
            propertyClass = "string",
            parts = listOf(farePartFlex),
        )

val finalFare
    get() =
        Fare(
            estimated = true,
            description = "string",
            propertyClass = "string",
            parts = listOf(farePartFixedFinalPart),
        )
