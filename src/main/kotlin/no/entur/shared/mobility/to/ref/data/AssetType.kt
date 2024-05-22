package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.AssetClass
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.ConditionDeposit
import no.entur.shared.mobility.to.ref.dto.ConditionPayWhenFinished
import no.entur.shared.mobility.to.ref.dto.ConditionPostponedCommit
import no.entur.shared.mobility.to.ref.dto.ConditionRequireBookingData
import no.entur.shared.mobility.to.ref.dto.ConditionRequireEvidence
import no.entur.shared.mobility.to.ref.dto.ConditionRequireOffboardingSteps
import no.entur.shared.mobility.to.ref.dto.ConditionRequireOnboardingSteps
import no.entur.shared.mobility.to.ref.dto.ConditionRequirePausingSteps
import no.entur.shared.mobility.to.ref.dto.ConditionRequireResumingSteps
import no.entur.shared.mobility.to.ref.dto.ConditionReturnArea
import no.entur.shared.mobility.to.ref.dto.ConditionUpfrontPayment
import no.entur.shared.mobility.to.ref.dto.Coordinates
import no.entur.shared.mobility.to.ref.dto.Day
import no.entur.shared.mobility.to.ref.dto.GeoJsonLine
import no.entur.shared.mobility.to.ref.dto.GeoJsonPoint
import no.entur.shared.mobility.to.ref.dto.GeoJsonPolygon
import no.entur.shared.mobility.to.ref.dto.OffBoardingStep
import no.entur.shared.mobility.to.ref.dto.OnBoardingStep
import no.entur.shared.mobility.to.ref.dto.PausingStep
import no.entur.shared.mobility.to.ref.dto.ResumingStep
import no.entur.shared.mobility.to.ref.dto.SystemHours
import no.entur.shared.mobility.to.ref.dto.SystemPricingPlan
import java.time.OffsetDateTime

val assetType
    get() =
        AssetType(
            id = "string",
            stationId = "string",
            nrAvailable = 0,
            assets = listOf(asset),
            assetClass = AssetClass.MOPED,
            assetSubClass = "string",
            sharedProperties = assetProperties,
            applicablePricings = listOf(systemPricingPlan),
            defaultPricingPlan = systemPricingPlan,
            conditions = conditions,
        )

val systemPricingPlan
    get() =
        SystemPricingPlan(
            planId = "freeplan1",
            url = "https://www.rentmyfreebike.com/freeplan",
            name = "Free Plan",
            stationId = "string",
            regionId = "string",
            fare = fare,
            isTaxable = true,
            surgePricing = true,
            description = "Unlimited plan for free bikes, as long as you don't break them!",
        )

val conditions
    get() =
        listOf(
            ConditionDeposit(
                conditionType = "ConditionDeposit",
                id = "deposit50eu",
                amount = 9.95F,
                amountExVat = 8.95F,
                currencyCode = "NOK",
                vatRate = 21F,
                vatCountryCode = "NO",
            ),
            ConditionPayWhenFinished(
                conditionType = "ConditionPayWhenFinished",
                id = "deposit50eu",
            ),
            ConditionPostponedCommit(
                conditionType = "ConditionPostponedCommit",
                id = "deposit50eu",
                ultimateResponseTime = OffsetDateTime.now(),
            ),
            ConditionRequireBookingData(
                conditionType = "ConditionRequireBookingData",
                id = "deposit50eu",
                requiredFields =
                    listOf(
                        ConditionRequireBookingData.RequiredFields.FROM_ADDRESS,
                    ),
                claims =
                    listOf(
                        "string",
                    ),
            ),
            ConditionReturnArea(
                conditionType = "ConditionReturnArea",
                id = "deposit50eu",
                stationId = "string",
                returnArea =
                    GeoJsonPolygon(
                        listOf(
                            GeoJsonLine(
                                listOf(
                                    GeoJsonPoint(listOf(1F, 1F)),
                                    GeoJsonPoint(listOf(0F, 1F)),
                                    GeoJsonPoint(listOf(0F, 0F)),
                                    GeoJsonPoint(listOf(1F, 0F)),
                                    GeoJsonPoint(listOf(1F, 1F)),
                                ),
                            ),
                        ),
                    ),
                coordinates =
                    Coordinates(
                        lng = 6.169639F,
                        lat = 52.25327F,
                        alt = 0F,
                    ),
                returnHours =
                    listOf(
                        SystemHours(
                            userType = SystemHours.UserType.MEMBER,
                            stationId = "string",
                            regionId = "string",
                            startTime = "string",
                            endTime = "string",
                            days =
                                listOf(
                                    Day.MON,
                                ),
                        ),
                    ),
            ),
            ConditionUpfrontPayment(
                conditionType = "ConditionUpfrontPayment",
                id = "deposit50eu",
            ),
            ConditionRequireEvidence(
                conditionType = "ConditionRequireEvidence",
                id = "deposit50eu",
                evidenceTypes =
                    listOf(
                        ConditionRequireEvidence.EvidenceTypes.PARKED,
                    ),
            ),
            ConditionRequireOnboardingSteps(
                conditionType = "ConditionRequireOnboardingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        OnBoardingStep(
                            type = OnBoardingStep.Type.URL,
                            url = "string",
                            goal = OnBoardingStep.Goal.INSTRUCTIONS,
                            text = "string",
                            action = OnBoardingStep.Action.SEND_PREPARE,
                        ),
                    ),
            ),
            ConditionRequireOffboardingSteps(
                conditionType = "ConditionRequireOffboardingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        OffBoardingStep(
                            type = OffBoardingStep.Type.URL,
                            url = "string",
                            goal = OffBoardingStep.Goal.INSTRUCTIONS,
                            text = "string",
                            action = OffBoardingStep.Action.SEND_START_FINISHING,
                        ),
                    ),
            ),
            ConditionRequirePausingSteps(
                conditionType = "ConditionRequirePausingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        PausingStep(
                            type = PausingStep.Type.URL,
                            url = "string",
                            goal = PausingStep.Goal.INSTRUCTIONS,
                            text = "string",
                            action = PausingStep.Action.SEND_PAUSE,
                        ),
                    ),
            ),
            ConditionRequireResumingSteps(
                conditionType = "ConditionRequireResumingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        ResumingStep(
                            type = ResumingStep.Type.URL,
                            url = "string",
                            goal = ResumingStep.Goal.INSTRUCTIONS,
                            text = "string",
                            action = ResumingStep.Action.UNLOCK_ASSET,
                        ),
                    ),
            ),
        )
