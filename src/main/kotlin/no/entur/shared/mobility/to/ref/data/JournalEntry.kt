package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.BankAccount
import no.entur.shared.mobility.to.ref.dto.FarePart
import no.entur.shared.mobility.to.ref.dto.JournalCategory
import no.entur.shared.mobility.to.ref.dto.JournalEntry
import no.entur.shared.mobility.to.ref.dto.JournalEntryAllOfDetails
import no.entur.shared.mobility.to.ref.dto.JournalState
import java.time.OffsetDateTime
import java.util.UUID

val journalEntry
    get() =
        JournalEntry(
            amount = 20.00F,
            amountExVat = 20.00F,
            currencyCode = "NOK",
            vatRate = 0F,
            vatCountryCode = "NO",
            category = JournalCategory.FARE,
            journalId = UUID.randomUUID().toString(),
            journalSequenceId = UUID.randomUUID().toString(),
            invoiceId = UUID.randomUUID().toString(),
            invoiceDate = OffsetDateTime.now(),
            state = JournalState.TO_INVOICE,
            expirationDate = OffsetDateTime.now(),
            comment = "string",
            distance = 0F,
            distanceType = JournalEntry.DistanceType.KM,
            usedTime = 0,
            rentalStartMileage = 0F,
            vatNumber = "string",
            bankAccount =
                BankAccount(
                    name = "string",
                    number = "string",
                    country = "NO",
                    bankIdentification = "string",
                ),
            details =
                JournalEntryAllOfDetails(
                    estimated = true,
                    amount = 12.00F,
                    category = JournalCategory.DEPOSIT,
                    description = "string",
                    propertyClass = "string",
                    parts = listOf(farePartFixed, farePartFlex),
                ),
        )

val farePartFixed
    get() =
        FarePart(
            amount = 10.00F,
            amountExVat = 10.0F,
            currencyCode = "NOK",
            vatRate = 0F,
            vatCountryCode = "NO",
            type = FarePart.Type.FIXED,
            kind = FarePart.Kind.DEFAULT,
            name = "Activation cost",
            minimumAmount = 9F,
            maximumAmount = 11F,
            assetState = FarePart.AssetState.IN_USE,
            meta = mapOf("additionalProp1" to "prop"),
        )

val farePartFlex
    get() =
        FarePart(
            amount = 2.50F,
            amountExVat = 2.5F,
            currencyCode = "NOK",
            vatRate = 0F,
            vatCountryCode = "NO",
            type = FarePart.Type.FLEX,
            kind = FarePart.Kind.DEFAULT,
            unitType = FarePart.UnitType.MINUTE,
            units = 1F,
            scaleFrom = 0F,
            scaleType = FarePart.ScaleType.MINUTE,
            name = "string",
            assetState = FarePart.AssetState.IN_USE,
            meta = mapOf("additionalProp1" to "prop"),
        )
