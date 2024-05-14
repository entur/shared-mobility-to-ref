package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Address
import no.entur.shared.mobility.to.ref.dto.AssetClass
import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.BookingAllOfExtraData
import no.entur.shared.mobility.to.ref.dto.BookingState
import no.entur.shared.mobility.to.ref.dto.Card
import no.entur.shared.mobility.to.ref.dto.CardType
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.Customer
import no.entur.shared.mobility.to.ref.dto.Fare
import no.entur.shared.mobility.to.ref.dto.Information
import no.entur.shared.mobility.to.ref.dto.License
import no.entur.shared.mobility.to.ref.dto.LicenseType
import no.entur.shared.mobility.to.ref.dto.Phone
import no.entur.shared.mobility.to.ref.dto.Place
import no.entur.shared.mobility.to.ref.dto.Requirements
import no.entur.shared.mobility.to.ref.dto.StopReference
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

val booking
    get() =
        Booking(
            id = UUID.randomUUID().toString(),
            from = place,
            callbackUrl = "string",
            to = place,
            customer = customer,
            extraInfo = mapOf("additionalProp1" to "prop"),
            state = BookingState.CONFIRMED,
            legs = listOf(leg),
            pricing = fare,
            departureTime = OffsetDateTime.now(),
            arrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualDepartureTime = OffsetDateTime.now(),
            actualArrivalTime = OffsetDateTime.now().plusMinutes(12),
            mainAssetType = assetType,
            userCommunication =
                listOf(
                    Information(
                        type = Information.Type.URL,
                        url = "string",
                        goal = Information.Goal.INSTRUCTIONS,
                        text = "string",
                    ),
                ),
            memo = "string",
            extraData =
                BookingAllOfExtraData(
                    safeWaitTime = 0,
                    maxWaitTime = 0,
                    safeTravelTime = 0,
                    maxTravelTime = 0,
                ).apply { put("additionalProp1", "prop") },
        )

val place
    get() =
        Place(
            name = "string",
            stopReference =
                listOf(
                    StopReference(
                        type = StopReference.Type.GTFS_STOP_ID,
                        id = "string",
                        country = "NO",
                    ),
                ),
            stationId = "string",
            coordinates =
                Coordinates(
                    lng = 6.169639F,
                    lat = 52.25327F,
                    alt = 0F,
                ),
            physicalAddress = address,
            extraInfo = mapOf("additionalProp1" to "prop"),
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

val customer
    get() =
        Customer(
            isValidated = true,
            age = 0,
            referenceNumber = "string",
            cardTypes =
                listOf(
                    CardType(
                        type = CardType.Type.ID,
                        subType = "string",
                        assetClass = AssetClass.AIR,
                        acceptors = listOf("string"),
                    ),
                ),
            licenseTypes =
                listOf(
                    LicenseType(
                        assetClass = AssetClass.AIR,
                        issuingCountry = "NO",
                    ),
                ),
            requirements = requirements,
            knownIdentifier = "string",
            knownIdentifierProvider = "string",
            id = "A0-123456",
            travelerReference = "string",
            initials = "string",
            firstName = "John",
            lastName = "Doe",
            middleName = "von",
            prefix = "string",
            postfix = "string",
            phones =
                listOf(
                    Phone(
                        preferred = true,
                        number = "+31-48934758 or +(0075)-834923384 or 020 1234 1234",
                        kind = Phone.Kind.LANDLINE,
                        type = Phone.Type.PRIVATE,
                    ),
                ),
            email = "string",
            birthDate = LocalDate.parse("2024-02-16"),
            address = address,
            photo = null,
            cards =
                listOf(
                    Card(
                        type = Card.Type.ID,
                        subType = "string",
                        assetClass = AssetClass.AIR,
                        acceptors = listOf("string"),
                        cardDescription = "string",
                        cardNumber = "string",
                        cardAdditionalNumber = "string",
                        validUntil = LocalDate.parse("2024-02-16"),
                        country = "NO",
                    ),
                ),
            licenses =
                listOf(
                    License(
                        assetClass = AssetClass.AIR,
                        issuingCountry = "NO",
                        number = "1287948792",
                        licenseCode = "D4",
                        validUntil = LocalDate.parse("2024-02-16"),
                    ),
                ),
            extraInfo = mapOf("additionalProp1" to "prop"),
        )

val fare
    get() =
        Fare(
            estimated = true,
            description = "string",
            propertyClass = "string",
            parts = listOf(farePartFlex),
        )

val requirements
    get() =
        Requirements(
            abilities = listOf(requirement),
            bringAlong = listOf(requirement),
        ).apply { put("additionalProp1", "prop") }
