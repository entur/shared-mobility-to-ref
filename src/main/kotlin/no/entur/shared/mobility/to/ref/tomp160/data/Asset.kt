package no.entur.shared.mobility.to.ref.tomp160.data

import no.entur.shared.mobility.to.ref.tomp160.dto.AssetProperties

val asset
    get() =
        no.entur.shared.mobility.to.ref.tomp160.dto.Asset(
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
