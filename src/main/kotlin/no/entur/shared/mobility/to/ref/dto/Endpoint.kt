package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min

/**
 * a formal description of an endpoint.
 * @param method
 * @param path the exact path of the endpoint, starting after the base URL
 * @param status
 * @param eventType in case the path is ending in /events, the event type/operator enum should be added here.
 * @param supportsPaging does this endpoint support paging? In that case this endpoint can be accessed using query parameters offset=x and
 * limit=y. Only allowed at endpoints that have specified these query parameters.
 * @param maxPageSize the maximum size of the pages (only valid when supportsPaging=true). If the limit-parameter of the request is above
 * this amount, a http code 400 will be returned.
 * @param externalType this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)
 * @param useAssetTypes
 * @param useAssets
 */
data class Endpoint(
    @Schema(example = "null", required = true)
    @get:JsonProperty("method", required = true) val method: Method,
    @Schema(
        example = "/plannings/",
        required = true,
        description = "the exact path of the endpoint, starting after the base URL",
    )
    @get:JsonProperty("path", required = true) val path: String,
    @Schema(example = "null", required = true)
    @get:JsonProperty("status", required = true) val status: Status,
    @Schema(
        example = "null",
        description = "in case the path is ending in /events, the event type/operator enum should be added here.",
    )
    val eventType: EventType? = null,
    @Schema(
        example = "null",
        description =
            "does this endpoint support paging? In that case this endpoint can be accessed using query parameters offset=x and" +
                " limit=y. Only allowed at endpoints that have specified these query parameters.",
    )
    val supportsPaging: Boolean? = false,
    @get:Min(1)
    @Schema(
        example = "null",
        description =
            "the maximum size of the pages (only valid when supportsPaging=true). If the limit-parameter of the request is" +
                " above this amount, a http code 400 will be returned.",
    )
    val maxPageSize: Int? = null,
    @Schema(
        example = "null",
        description = "this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)",
    )
    val externalType: ExternalType? = null,
    @Schema(example = "null")
    val useAssetTypes: List<String>? = null,
    @Schema(example = "null")
    val useAssets: List<String>? = null,
) {
    /**
     *
     * Values: pOST,pUT,gET,dELETE,pATCH
     */
    enum class Method {
        POST,
        PUT,
        GET,
        DELETE,
        PATCH,
    }

    /**
     *
     * Values: nOTIMPLEMENTED,dIALECT,iMPLEMENTED
     */
    enum class Status {
        NOT_IMPLEMENTED,
        DIALECT,
        IMPLEMENTED,
    }

    /**
     * in case the path is ending in /events, the event type/operator enum should be added here.
     * Values: pREPARE,aSSIGNASSET,sETINUSE,pAUSE,oPENTRUNK,sTARTFINISHING,fINISH,iSSUE,cANCEL,eXPIRE,dENY,cOMMIT
     */
    enum class EventType {
        PREPARE,
        ASSIGN_ASSET,
        SET_IN_USE,
        PAUSE,
        OPEN_TRUNK,
        START_FINISHING,
        FINISH,
        ISSUE,
        CANCEL,
        EXPIRE,
        DENY,
        COMMIT,
    }

    /**
     * this field must be used when adressing other standards for exchanging 'static' data (Level 1 MaaS)
     * Values: gBFS,gTFS,neTEx,oSDMOffline,iXSI5,aPDS
     */
    enum class ExternalType {
        GBFS,
        GTFS,
        NeTEx,

        @Suppress("EnumEntryName")
        OSDM_Offline,
        IXSI5,
        APDS,
    }
}
