package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.AssetProperties
import no.entur.shared.mobility.to.ref.dto.Damage
import java.util.UUID

val asset
    get() =
        Asset(
            id = UUID.randomUUID().toString(),
            stateOfCharge = 100,
            maxRange = 100,
            licensePlate = "EK1234",
            damages = listOf(damage),
            overriddenProperties = assetProperties,
        )

val assetProperties
    get() =
        AssetProperties(
            name = "string",
            location = place,
            meta = mapOf("vehicleCode" to "1234ABCD"),
        )

val damage
    get() =
        Damage(
            vehicleComponent = Damage.VehicleComponent.FRONT,
            description = "string",
            pictures = listOf("string"),
        )
