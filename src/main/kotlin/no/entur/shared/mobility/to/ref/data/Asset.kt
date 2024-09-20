package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.AssetProperties

val asset
    get() =
        Asset(
            id = "Asset:549",
            stateOfCharge = 100,
            maxRange = 100,
            licensePlate = "EK1234",
            overriddenProperties = assetProperties,
        )

val assetProperties
    get() =
        AssetProperties(
            meta = mapOf("vehicleCode" to "1234ABCD"),
        )
