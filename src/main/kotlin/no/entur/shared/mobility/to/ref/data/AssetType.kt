package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.AssetClass
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.ConditionDeposit
import no.entur.shared.mobility.to.ref.dto.ConditionRequireOffboardingSteps
import no.entur.shared.mobility.to.ref.dto.OffBoardingStep
import java.util.UUID

val assetType
    get() =
        AssetType(
            id = UUID.randomUUID().toString(),
            assets = listOf(asset),
            assetClass = AssetClass.MOPED,
            conditions = conditions,
        )

val conditions
    get() =
        listOf(
            ConditionDeposit(
                conditionType = "ConditionDeposit",
                id = UUID.randomUUID().toString(),
                amount = 12.50F,
                amountExVat = 10.00F,
                currencyCode = "NOK",
                vatRate = 25F,
                vatCountryCode = "NO",
            ),
            ConditionRequireOffboardingSteps(
                conditionType = "ConditionRequireOffboardingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        OffBoardingStep(
                            type = OffBoardingStep.Type.PLAIN_TEXT,
                            goal = OffBoardingStep.Goal.INSTRUCTIONS,
                            text = "Take a picture of the parked mobility to finish the trip",
                            showTime = OffBoardingStep.ShowTime.START_FINISHING,
                            action = OffBoardingStep.Action.SEND_EVIDENCE_PARKED,
                        ),
                    ),
            ),
        )

val conditionsNoDeposit
    get() =
        listOf(
            ConditionRequireOffboardingSteps(
                conditionType = "ConditionRequireOffboardingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        OffBoardingStep(
                            type = OffBoardingStep.Type.PLAIN_TEXT,
                            goal = OffBoardingStep.Goal.INSTRUCTIONS,
                            text = "Take a picture of the parked mobility to finish the trip",
                            showTime = OffBoardingStep.ShowTime.START_FINISHING,
                            action = OffBoardingStep.Action.SEND_EVIDENCE_PARKED,
                        ),
                    ),
            ),
        )

val conditionsWithHighDepositAmount
    get() =
        listOf(
            ConditionDeposit(
                conditionType = "ConditionDeposit",
                id = "deposit50eu",
                amount = 125.00F,
                amountExVat = 100.00F,
                currencyCode = "NOK",
                vatRate = 25F,
                vatCountryCode = "NO",
            ),
            ConditionRequireOffboardingSteps(
                conditionType = "ConditionRequireOffboardingSteps",
                id = "deposit50eu",
                steps =
                    listOf(
                        OffBoardingStep(
                            type = OffBoardingStep.Type.PLAIN_TEXT,
                            goal = OffBoardingStep.Goal.INSTRUCTIONS,
                            text = "Take a picture of the parked mobility to finish the trip",
                            showTime = OffBoardingStep.ShowTime.START_FINISHING,
                            action = OffBoardingStep.Action.SEND_EVIDENCE_PARKED,
                        ),
                    ),
            ),
        )
