package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.AssetAccessMethods
import no.entur.shared.mobility.to.ref.dto.AssetProperties
import no.entur.shared.mobility.to.ref.dto.AssetPropertiesEcoLabelInner
import no.entur.shared.mobility.to.ref.dto.Damage
import no.entur.shared.mobility.to.ref.dto.Requirement
import java.time.OffsetDateTime
import java.util.UUID

val asset
    get() =
        Asset(
            id = UUID.randomUUID().toString(),
            isReserved = true,
            isReservedFrom = OffsetDateTime.now(),
            isReservedTo = OffsetDateTime.now(),
            isDisabled = true,
            availableUntil = OffsetDateTime.now(),
            mileage = 0F,
            stateOfCharge = 100,
            maxRange = 100,
            licensePlate = "string",
            stationId = "string",
            homeStationId = "string",
            damages = listOf(damage),
            overriddenProperties = assetProperties,
        )

val assetProperties
    get() =
        AssetProperties(
            name = "string",
            location = place,
            brand = "string",
            model = "string",
            buildingYear = 0,
            colour = "string",
            maxSpeed = 0,
            wheelCount = 0,
            image = "https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg",
            icon = "string",
            accessMethods = listOf(AssetAccessMethods.DEEPLINK),
            fuel = AssetProperties.Fuel.NONE,
            propulsion = AssetProperties.Propulsion.MUSCLE,
            energyLabel = AssetProperties.EnergyLabel.A,
            ecoLabel =
                listOf(
                    AssetPropertiesEcoLabelInner(
                        countryCode = "NO",
                        ecoSticker = "string",
                    ),
                ),
            co2PerKm = 0F,
            gears = 0,
            gearbox = AssetProperties.Gearbox.MANUAL,
            airConditioning = true,
            cabrio = true,
            towingHook = true,
            winterTires = true,
            nrOfDoors = 0,
            nrOfHelmets = 0,
            navigation = true,
            cruiseControl = true,
            persons = 1,
            infantSeat = true,
            pets = true,
            smoking = true,
            easyAccessibility = AssetProperties.EasyAccessibility.LIFT,
            ancillaries = listOf(requirement),
            regionId = "string",
            cargo = "string",
            cargoVolume = 0,
            cargoLoad = 0,
            travelAbroad = true,
            undergroundParking = true,
            helmetRequired = false,
            defaultReserveTime = 0,
            other = "string",
            meta = mapOf("additionalProp1" to "prop"),
        )

val requirement
    get() =
        Requirement(
            source = "string",
            category = "string",
            number = "st",
            type = "string",
            memo = "string",
            variableNumber = 0,
            applicableDays = listOf(Requirement.ApplicableDays.MO),
        )

val damage
    get() =
        Damage(
            vehicleComponent = Damage.VehicleComponent.FRONT,
            description = "string",
            pictures = listOf("string"),
        )
