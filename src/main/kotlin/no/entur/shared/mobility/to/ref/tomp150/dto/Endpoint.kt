package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.Nulls
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
 * a formal description of an endpoint.
 * @param method 
 * @param path the exact path of the endpoint, starting after the base URL
 * @param status 
 * @param eventType in case the path is ending in /events, the event type/operator enum should be added here.
 * @param supportsPaging does this endpoint support paging? In that case this endpoint can be accessed using query parameters offset=x and limit=y. Only allowed at endpoints that have specified these query parameters.
 * @param maxPageSize the maximum size of the pages (only valid when supportsPaging=true). If the limit-parameter of the request is above this amount, a http code 400 will be returned.
 * @param externalType this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)
 * @param useAssetTypes 
 * @param useAssets 
 */
data class Endpoint(

    @Schema(required = true, description = "")
    @param:JsonProperty("method")
    @get:JsonProperty("method", required = true) val method: Endpoint.Method,

    @Schema(example = "/plannings/", required = true, description = "the exact path of the endpoint, starting after the base URL")
    @param:JsonProperty("path")
    @get:JsonProperty("path", required = true) val path: kotlin.String,

    @Schema(required = true, description = "")
    @param:JsonProperty("status")
    @get:JsonProperty("status", required = true) val status: Endpoint.Status,

    @Schema(description = "in case the path is ending in /events, the event type/operator enum should be added here.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("eventType")
    @get:JsonProperty("eventType") val eventType: Endpoint.EventType? = null,

    @Schema(description = "does this endpoint support paging? In that case this endpoint can be accessed using query parameters offset=x and limit=y. Only allowed at endpoints that have specified these query parameters.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("supportsPaging")
    @get:JsonProperty("supportsPaging") val supportsPaging: kotlin.Boolean? = false,

    @get:Min(value=1)
    @Schema(description = "the maximum size of the pages (only valid when supportsPaging=true). If the limit-parameter of the request is above this amount, a http code 400 will be returned.")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("maxPageSize")
    @get:JsonProperty("maxPageSize") val maxPageSize: kotlin.Int? = null,

    @Schema(description = "this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("externalType")
    @get:JsonProperty("externalType") val externalType: Endpoint.ExternalType? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("useAssetTypes")
    @get:JsonProperty("useAssetTypes") val useAssetTypes: kotlin.collections.List<kotlin.String>? = null,

    @Schema(description = "")
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    @field:JsonSetter(nulls = Nulls.SKIP)
    @param:JsonProperty("useAssets")
    @get:JsonProperty("useAssets") val useAssets: kotlin.collections.List<kotlin.String>? = null
) {

    /**
    * 
    * Values: POST,PUT,GET,DELETE,PATCH
    */
    enum class Method(@get:JsonValue val value: kotlin.String) {

        POST("POST"),
        PUT("PUT"),
        GET("GET"),
        DELETE("DELETE"),
        PATCH("PATCH");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Method {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Method'")
            }
        }
    }

    /**
    * 
    * Values: NOT_IMPLEMENTED,DIALECT,IMPLEMENTED
    */
    enum class Status(@get:JsonValue val value: kotlin.String) {

        NOT_IMPLEMENTED("NOT_IMPLEMENTED"),
        DIALECT("DIALECT"),
        IMPLEMENTED("IMPLEMENTED");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Status {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Status'")
            }
        }
    }

    /**
    * in case the path is ending in /events, the event type/operator enum should be added here.
    * Values: PREPARE,ASSIGN_ASSET,SET_IN_USE,PAUSE,OPEN_TRUNK,START_FINISHING,FINISH,ISSUE,CANCEL,EXPIRE,DENY,COMMIT
    */
    enum class EventType(@get:JsonValue val value: kotlin.String) {

        PREPARE("PREPARE"),
        ASSIGN_ASSET("ASSIGN_ASSET"),
        SET_IN_USE("SET_IN_USE"),
        PAUSE("PAUSE"),
        OPEN_TRUNK("OPEN_TRUNK"),
        START_FINISHING("START_FINISHING"),
        FINISH("FINISH"),
        ISSUE("ISSUE"),
        CANCEL("CANCEL"),
        EXPIRE("EXPIRE"),
        DENY("DENY"),
        COMMIT("COMMIT");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EventType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'EventType'")
            }
        }
    }

    /**
    * this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)
    * Values: GBFS,GTFS,NE_TEX,OSDM_OFFLINE,IXSI5,APDS
    */
    enum class ExternalType(@get:JsonValue val value: kotlin.String) {

        GBFS("GBFS"),
        GTFS("GTFS"),
        NE_TEX("NeTEx"),
        OSDM_OFFLINE("OSDM_Offline"),
        IXSI5("IXSI5"),
        APDS("APDS");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ExternalType {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'ExternalType'")
            }
        }
    }

}

