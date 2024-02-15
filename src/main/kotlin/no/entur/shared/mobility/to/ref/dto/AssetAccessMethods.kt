package no.entur.shared.mobility.to.ref.dto

/**
 *
 * Values: DEEPLINK,QR,AZTEC,TOMPMINUSAPI,AXAMINUSEKEYMINUSOTP,PHYSICALMINUSKEY,BARCODE,PDF,HTML,OVC,EMV,NONE
 */
@Suppress("EnumEntryName")
enum class AssetAccessMethods {
    DEEPLINK,
    QR,
    AZTEC,
    `TOMP-API`,
    `AXA-EKEY-OTP`,
    `PHYSICAL-KEY`,
    BARCODE,
    PDF,
    HTML,
    OVC,
    EMV,
    NONE,
}
