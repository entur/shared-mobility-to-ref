package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.AssetClass
import no.entur.shared.mobility.to.ref.dto.ChamberOfCommerceInfo
import no.entur.shared.mobility.to.ref.dto.SystemInformation
import java.time.LocalDate

val systemInformation
    get() =
        SystemInformation(
            systemId = "XXTO0001",
            language = listOf("fr-FR"),
            name = "FreeBike",
            shortName = "FB",
            operator = "FreeBike",
            url = "https://www.rentmyfreebike.com",
            purchaseUrl = "https://www.rentmyfreebike.com/purchase",
            discoveryUriAndroid = "string",
            discoveryUriIOS = "string",
            storeUriAndroid = "https://play.google.com/store/apps/details?id=com.rentmyfreebike.android",
            storeUriIOS = "itms-apps://itunes.apple.com/app/idcom.rentmyfreebike.ios",
            startDate = LocalDate.parse("2024-02-16"),
            phoneNumber = "555-12345",
            email = "rent@freebike.com",
            feedContactEmail = "user@example.com",
            timezone = "IST",
            licenseUrl = "https://www.rentmyfreebike.com/license",
            typeOfSystem = SystemInformation.TypeOfSystem.FREE_FLOATING,
            chamberOfCommerceInfo =
                ChamberOfCommerceInfo(
                    number = "string",
                    place = "string",
                ),
            conditions = "string",
            productType = SystemInformation.ProductType.RENTAL,
            assetClasses = listOf(AssetClass.AIR),
        )
