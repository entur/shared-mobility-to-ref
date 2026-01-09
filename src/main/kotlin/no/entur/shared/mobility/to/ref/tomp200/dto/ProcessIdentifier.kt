package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
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
 * 
 * @param module 
 * @param identifiers 
 */
data class ProcessIdentifier(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("module", required = true) val module: ProcessIdentifier.Module,

    @get:Size(max=25)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("identifiers", required = true) val identifiers: kotlin.collections.List<kotlin.String>
) {

    /**
    * 
    * Values: OFFERS,PRE_SALES,PURCHASE,EXECUTE,SUPPORT,AFTER_SALES
    */
    enum class Module(@get:JsonValue val value: kotlin.String) {

        OFFERS("offers"),
        PRE_SALES("pre-sales"),
        PURCHASE("purchase"),
        EXECUTE("execute"),
        SUPPORT("support"),
        AFTER_SALES("after-sales");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Module {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ProcessIdentifier'")
            }
        }
    }

}

