package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.GeoJsonLine
import no.entur.shared.mobility.to.ref.dto.GeoJsonPoint
import no.entur.shared.mobility.to.ref.dto.Information
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegState
import no.entur.shared.mobility.to.ref.dto.SubOperator
import no.entur.shared.mobility.to.ref.dto.Token
import no.entur.shared.mobility.to.ref.dto.TokenDefault
import java.time.OffsetDateTime

val leg
    get() =
        Leg(
            id = "string",
            from = place,
            to = place,
            departureTime = OffsetDateTime.now(),
            arrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualArrivalTime = OffsetDateTime.now().plusMinutes(12),
            actualDepartureTime = OffsetDateTime.now(),
            travelerReferenceNumbers = listOf("string"),
            assetType = assetType,
            legSequenceNumber = 0,
            asset = asset,
            pricing = fare,
            suboperator =
                SubOperator(
                    name = "string",
                    maasId = "string",
                    description = "string",
                    contact = "string",
                ),
            conditions = conditions,
            state = LegState.NOT_STARTED,
            departureDelay = 11112,
            arrivalDelay = 11112,
            distance = 7250,
            progressGeometry =
                GeoJsonLine(
                    listOf(
                        GeoJsonPoint(listOf(6.169639F, 52.25327F)),
                        GeoJsonPoint(listOf(6.05623F, 52.63473F)),
                    ),
                ),
            ticket =
                Token(
                    validFrom = OffsetDateTime.now(),
                    validUntil = OffsetDateTime.now(),
                    tokenType = Token.TokenType.tokenDefault,
                    tokenData = TokenDefault(tokenType = "TokenDefault", url = "string"),
                ),
            assetAccessData =
                Token(
                    validFrom = OffsetDateTime.now(),
                    validUntil = OffsetDateTime.now(),
                    tokenType = Token.TokenType.tokenDefault,
                    tokenData = TokenDefault(tokenType = "TokenDefault", url = "string"),
                ),
            allAssetAccessData =
                listOf(
                    Token(
                        validFrom = OffsetDateTime.now(),
                        validUntil = OffsetDateTime.now(),
                        tokenType = Token.TokenType.tokenDefault,
                        tokenData = TokenDefault(tokenType = "TokenDefault", url = "string"),
                    ),
                ),
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
        )
