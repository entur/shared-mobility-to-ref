package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
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
* A way to open/access the asset OR a proof of travel rights<br><br> _BARCODE_ a barcode can be retrieved from the links and used to access the purchased service<br> _QRCODE_ a QR code can be retrieved from the links<br> _AZTECCODE_ an Aztec code can be retrieved from the links<br> _REMOTE_ the /processes/start-leg/execution must be used to open the asset<br> _DEEP_LINK_ a deep link into a proprietary app is provided in the links to open the asset (NFC, Bluetooth)<br> _KEY_ a physical key must be obtained (see instructions) to open the asset<br>
* Values: BARCODE,QRCODE,AZTECCODE,REMOTE,DEEP_LINK,KEY,OTHER
*/
enum class TypeOfTravelDocument(@get:JsonValue val value: kotlin.String) {

    BARCODE("BARCODE"),
    QRCODE("QRCODE"),
    AZTECCODE("AZTECCODE"),
    REMOTE("REMOTE"),
    DEEP_LINK("DEEP_LINK"),
    KEY("KEY"),
    OTHER("OTHER");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): TypeOfTravelDocument {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'TypeOfTravelDocument'")
        }
    }
}

