package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
*
* Values: DEEPLINK,QR,AZTEC,TOMP_MINUS_API,AXA_MINUS_EKEY_MINUS_OTP,PHYSICAL_MINUS_KEY,BARCODE,PDF,HTML,OVC,EMV,NONE
*/
enum class AssetAccessMethods(
    @get:JsonValue val value: kotlin.String,
) {
    DEEPLINK("DEEPLINK"),
    QR("QR"),
    AZTEC("AZTEC"),
    TOMP_MINUS_API("TOMP-API"),
    AXA_MINUS_EKEY_MINUS_OTP("AXA-EKEY-OTP"),
    PHYSICAL_MINUS_KEY("PHYSICAL-KEY"),
    BARCODE("BARCODE"),
    PDF("PDF"),
    HTML("HTML"),
    OVC("OVC"),
    EMV("EMV"),
    NONE("NONE"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): AssetAccessMethods = values().first { it -> it.value == value }
    }
}
