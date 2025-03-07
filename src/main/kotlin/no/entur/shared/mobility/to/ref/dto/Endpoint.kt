package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min

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
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("method", required = true) val method: Endpoint.Method,
    @Schema(example = "/plannings/", required = true, description = "the exact path of the endpoint, starting after the base URL")
    @get:JsonProperty("path", required = true) val path: kotlin.String,
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("status", required = true) val status: Endpoint.Status,
    @Schema(example = "null", description = "in case the path is ending in /events, the event type/operator enum should be added here.")
    @get:JsonProperty("eventType") val eventType: Endpoint.EventType? = null,
    @Schema(
        example = "null",
        description = "does this endpoint support paging? In that case this endpoint can be accessed using query parameters offset=x and limit=y. Only allowed at endpoints that have specified these query parameters.",
    )
    @get:JsonProperty("supportsPaging") val supportsPaging: kotlin.Boolean? = false,
    @get:Min(1)
    @Schema(
        example = "null",
        description = "the maximum size of the pages (only valid when supportsPaging=true). If the limit-parameter of the request is above this amount, a http code 400 will be returned.",
    )
    @get:JsonProperty("maxPageSize") val maxPageSize: kotlin.Int? = null,
    @Schema(
        example = "null",
        description = "this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)",
    )
    @get:JsonProperty("externalType") val externalType: Endpoint.ExternalType? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("useAssetTypes") val useAssetTypes: kotlin.collections.List<kotlin.String>? = null,
    @Schema(example = "null", description = "")
    @get:JsonProperty("useAssets") val useAssets: kotlin.collections.List<kotlin.String>? = null,
) {
    /**
     *
     * Values: POST,PUT,GET,DELETE,PATCH
     */
    enum class Method(
        @get:JsonValue val value: kotlin.String,
    ) {
        POST("POST"),
        PUT("PUT"),
        GET("GET"),
        DELETE("DELETE"),
        PATCH("PATCH"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Method = values().first { it -> it.value == value }
        }
    }

    /**
     *
     * Values: NOT_IMPLEMENTED,DIALECT,IMPLEMENTED
     */
    enum class Status(
        @get:JsonValue val value: kotlin.String,
    ) {
        NOT_IMPLEMENTED("NOT_IMPLEMENTED"),
        DIALECT("DIALECT"),
        IMPLEMENTED("IMPLEMENTED"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Status = values().first { it -> it.value == value }
        }
    }

    /**
     * in case the path is ending in /events, the event type/operator enum should be added here.
     * Values: PREPARE,ASSIGN_ASSET,SET_IN_USE,PAUSE,OPEN_TRUNK,START_FINISHING,FINISH,ISSUE,CANCEL,EXPIRE,DENY,COMMIT
     */
    enum class EventType(
        @get:JsonValue val value: kotlin.String,
    ) {
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
        COMMIT("COMMIT"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): EventType = values().first { it -> it.value == value }
        }
    }

    /**
     * this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)
     * Values: GBFS,GTFS,NE_TEX,OSDM_OFFLINE,IXSI5,APDS
     */
    enum class ExternalType(
        @get:JsonValue val value: kotlin.String,
    ) {
        GBFS("GBFS"),
        GTFS("GTFS"),
        NE_TEX("NeTEx"),
        OSDM_OFFLINE("OSDM_Offline"),
        IXSI5("IXSI5"),
        APDS("APDS"),
        ;

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): ExternalType = values().first { it -> it.value == value }
        }
    }
}
