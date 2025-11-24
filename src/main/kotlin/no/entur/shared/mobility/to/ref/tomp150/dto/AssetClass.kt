package no.entur.shared.mobility.to.ref.tomp150.dto

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
* These classes are taken from the NeTeX standard, but ALL and UNKNOWN are removed. On the other hand OTHER and PARKING are added.
* Values: AIR,BUS,TROLLEYBUS,TRAM,COACH,RAIL,INTERCITYRAIL,URBANRAIL,METRO,WATER,CABLEWAY,FUNICULAR,TAXI,SELFDRIVE,FOOT,BICYCLE,MOTORCYCLE,CAR,SHUTTLE,OTHER,PARKING,MOPED,STEP,FERRY
*/
enum class AssetClass(@get:JsonValue val value: kotlin.String) {

    AIR("AIR"),
    BUS("BUS"),
    TROLLEYBUS("TROLLEYBUS"),
    TRAM("TRAM"),
    COACH("COACH"),
    RAIL("RAIL"),
    INTERCITYRAIL("INTERCITYRAIL"),
    URBANRAIL("URBANRAIL"),
    METRO("METRO"),
    WATER("WATER"),
    CABLEWAY("CABLEWAY"),
    FUNICULAR("FUNICULAR"),
    TAXI("TAXI"),
    SELFDRIVE("SELFDRIVE"),
    FOOT("FOOT"),
    BICYCLE("BICYCLE"),
    MOTORCYCLE("MOTORCYCLE"),
    CAR("CAR"),
    SHUTTLE("SHUTTLE"),
    OTHER("OTHER"),
    PARKING("PARKING"),
    MOPED("MOPED"),
    STEP("STEP"),
    FERRY("FERRY");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): AssetClass {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'AssetClass'")
        }
    }
}

