package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.AssetClass
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.ConditionDeposit
import no.entur.shared.mobility.to.ref.dto.ConditionRequireOffboardingSteps
import no.entur.shared.mobility.to.ref.dto.OffBoardingStep
import no.entur.shared.mobility.to.ref.dto.SystemPricingPlan

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
