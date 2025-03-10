package no.entur.shared.mobility.to.ref.tomp160.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * the TO can ask permission to do something to the MP, as the MP is financially responsible.
 * @param type 
 * @param assetTypeId reference to the assetType in /operator/available-assets, this property can be set when replacing an asset (for another type). In case of a succesfull replacement, the /legs/{id}/events - ASSIGN_ASSET should be send to the MP to inform a change of asset has been made.
 */
data class ConfirmationRequest(

    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: ConfirmationRequest.Type? = null,

    @Schema(example = "null", description = "reference to the assetType in /operator/available-assets, this property can be set when replacing an asset (for another type). In case of a succesfull replacement, the /legs/{id}/events - ASSIGN_ASSET should be send to the MP to inform a change of asset has been made.")
    @get:JsonProperty("assetTypeId") val assetTypeId: kotlin.String? = null
    ) {

    /**
    * 
    * Values: REPLACE_ASSET,START_LEG
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        REPLACE_ASSET("REPLACE_ASSET"),
        START_LEG("START_LEG");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().first{it -> it.value == value}
            }
        }
    }

}

