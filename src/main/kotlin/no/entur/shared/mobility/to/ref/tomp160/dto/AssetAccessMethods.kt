package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
* 
* Values: DEEPLINK,QR,AZTEC,TOMP_API,AXA_EKEY_OTP,PHYSICAL_KEY,BARCODE,PDF,HTML,OVC,EMV,NONE
*/
enum class AssetAccessMethods(@get:JsonValue val value: kotlin.String) {

    DEEPLINK("DEEPLINK"),
    QR("QR"),
    AZTEC("AZTEC"),
    TOMP_API("TOMP-API"),
    AXA_EKEY_OTP("AXA-EKEY-OTP"),
    PHYSICAL_KEY("PHYSICAL-KEY"),
    BARCODE("BARCODE"),
    PDF("PDF"),
    HTML("HTML"),
    OVC("OVC"),
    EMV("EMV"),
    NONE("NONE");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): AssetAccessMethods {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'AssetAccessMethods'")
        }
    }
}

