package no.entur.shared.mobility.to.ref.tomp160.data

import no.entur.shared.mobility.to.ref.tomp160.dto.AssetClass
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetType
import no.entur.shared.mobility.to.ref.tomp160.dto.ConditionDeposit
import no.entur.shared.mobility.to.ref.tomp160.dto.ConditionRequireOffboardingSteps
import no.entur.shared.mobility.to.ref.tomp160.dto.OffBoardingStep

val assetType
    get() =
        AssetType(
            id = "AssetType:587",
            assets = listOf(asset),
            assetClass = AssetClass.MOPED,
            conditions = conditions,
        )

val conditions
    get() =
        listOf(
            ConditionDeposit(
                conditionType = "ConditionDeposit",
                id = "ConditionDeposit:958",
                amount = 12.50F,
                amountExVat = 10.00F,
                currencyCode = "NOK",
                vatRate = 25F,
                vatCountryCode = "NO",
            ),
            ConditionRequireOffboardingSteps(
                conditionType = "ConditionRequireOffboardingSteps",
                id = "ConditionDeposit:386",
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
                id = "ConditionDeposit:745",
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
                id = "ConditionDeposit:183",
                amount = 125.00F,
                amountExVat = 100.00F,
                currencyCode = "NOK",
                vatRate = 25F,
                vatCountryCode = "NO",
            ),
            ConditionRequireOffboardingSteps(
                conditionType = "ConditionRequireOffboardingSteps",
                id = "ConditionDeposit:046",
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
