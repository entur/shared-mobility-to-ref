package no.entur.shared.mobility.to.ref.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import no.entur.shared.mobility.to.ref.dto.AssetType
import no.entur.shared.mobility.to.ref.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.dto.Error
import no.entur.shared.mobility.to.ref.dto.StationInformation
import no.entur.shared.mobility.to.ref.dto.SystemAlert
import no.entur.shared.mobility.to.ref.dto.SystemCalendar
import no.entur.shared.mobility.to.ref.dto.SystemHours
import no.entur.shared.mobility.to.ref.dto.SystemInformation
import no.entur.shared.mobility.to.ref.dto.SystemPricingPlan
import no.entur.shared.mobility.to.ref.dto.SystemRegion
import no.entur.shared.mobility.to.ref.service.OperatorService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("\${api.base-path}")
class OperatorController(private val operatorService: OperatorService) {
    @Operation(
        summary = "informs customers about changes to the system outside of normal operations",
        operationId = "operatorAlertsGet",
        description = """This feed is intended to inform customers about changes to the system that do not fall within the normal system 
            |operations. For example, system closures due to weather would be listed here, but a system that only operated for part of the 
            |year would have that schedule listed in the system-calendar.json feed. This file is an array of alert objects defined as below.
            | Obsolete alerts should be removed so the client application can safely present to the end user everything present in the feed.
            |  The consumer could use the start/end information to determine if this is a past, ongoing or future alert and adjust the 
            |  presentation accordingly. [from GBFS]""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "returns currently active system alerts",
                content = [Content(array = ArraySchema(schema = Schema(implementation = SystemAlert::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/alerts"], produces = ["application/json"])
    fun operatorAlertsGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Min(0)
        @Parameter(description = "start of the selection", schema = Schema(defaultValue = "0"))
        @Valid
        @RequestParam(value = "offset", required = false, defaultValue = "0")
        offset: Int,
        @Min(0)
        @Parameter(description = "count of the selection")
        @Valid
        @RequestParam(value = "limit", required = false)
        limit: Int?,
        @Parameter(description = "optional id of the region to use in the filter (/operator/regions)")
        @Valid
        @RequestParam(value = "regionId", required = false)
        regionId: String?,
        @Parameter(description = "optional id of the station to use in the filter (/operator/stations)")
        @Valid
        @RequestParam(value = "stationId", required = false)
        stationId: String?,
    ): List<SystemAlert> {
        return operatorService.operatorAlertsGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            offset,
            limit,
            regionId,
            stationId,
        )
    }

    @Operation(
        operationId = "operatorAvailableAssetsGet",
        description = """Returns a list of available assets.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Available assets or asset-types. In case assets are replied, the realtime location is also available.",
                content = [Content(array = ArraySchema(schema = Schema(implementation = AssetType::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = """The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting 
                    |to give proper response. Unlike 401, the client's identity is known to the server.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/available-assets"], produces = ["application/json"])
    fun operatorAvailableAssetsGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Min(0)
        @Parameter(description = "start of the selection", schema = Schema(defaultValue = "0"))
        @Valid
        @RequestParam(value = "offset", required = false, defaultValue = "0") offset: Int,
        @Min(0)
        @Parameter(description = "count of the selection")
        @Valid
        @RequestParam(value = "limit", required = false)
        limit: Int?,
        @Parameter(description = "optional id of the region to use in the filter (/operator/regions)")
        @Valid
        @RequestParam(value = "regionId", required = false)
        regionId: String?,
        @Parameter(description = "optional id of the station to use in the filter (/operator/stations)")
        @Valid
        @RequestParam(value = "stationId", required = false)
        stationId: String?,
    ): List<AssetType> {
        return operatorService.operatorAvailableAssetsGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            offset,
            limit,
            regionId,
            stationId,
        )
    }

    @Operation(
        summary = "describes the system",
        operationId = "operatorInformationGet",
        description = """Describes the system including System operator, System location, year implemented, URLs, contact info, time zone.
            | [from GBFS]""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(schema = Schema(implementation = SystemInformation::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/information"], produces = ["application/json"])
    fun operatorInformationGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
    ): SystemInformation {
        return operatorService.operatorInformationGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
        )
    }

    @Operation(
        summary = "describes the running implementations",
        operationId = "operatorMetaGet",
        description = """all versions that are implemented on this url, are described in the result of this endpoint. In contains all 
            |versions and per version the endpoints, their status and the supported scenarios.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(array = ArraySchema(schema = Schema(implementation = EndpointImplementation::class)))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/meta"], produces = ["application/json"])
    fun operatorMetaGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
    ): List<EndpointImplementation> {
        return operatorService.operatorMetaGet(
            acceptLanguage,
            maasId,
            addressedTo,
        )
    }

    @Operation(
        summary = """describes the operating calendar for a system. An array of year objects defined as follows (if start/end year are 
            |omitted, then assume the start and end months do not change from year to year). [from GFBS]""",
        operationId = "operatorOperatingCalendarGet",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(array = ArraySchema(schema = Schema(implementation = SystemCalendar::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ),
            SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"),
            SecurityRequirement(
                name = "BearerAuth",
            ),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/operating-calendar"], produces = ["application/json"])
    fun operatorOperatingCalendarGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Parameter(description = "optional id of the region to use in the filter (/operator/regions)")
        @Valid
        @RequestParam(value = "regionId", required = false)
        regionId: String?,
        @Parameter(description = "optional id of the station to use in the filter (/operator/stations)")
        @Valid
        @RequestParam(value = "stationId", required = false)
        stationId: String?,
    ): List<SystemCalendar> {
        return operatorService.operatorOperatingCalendarGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            regionId,
            stationId,
        )
    }

    @Operation(
        summary = "describes the system hours of operation",
        operationId = "operatorOperatingHoursGet",
        description = """Describes the hours of operation of all available systems of the transport operator [from GBFS]""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(array = ArraySchema(schema = Schema(implementation = SystemHours::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/operating-hours"], produces = ["application/json"])
    fun operatorOperatingHoursGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Parameter(description = "optional id of the region to use in the filter (/operator/regions)")
        @Valid
        @RequestParam(value = "regionId", required = false)
        regionId: String?,
        @Parameter(description = "optional id of the station to use in the filter (/operator/stations)")
        @Valid
        @RequestParam(value = "stationId", required = false)
        stationId: String?,
    ): List<SystemHours> {
        return operatorService.operatorOperatingHoursGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            regionId,
            stationId,
        )
    }

    @Operation(
        summary = "Describes the status of the Transport Operator - whether the APIs are running or not",
        operationId = "operatorPingGet",
        description = """This is a healthcheck endpoint to see if the TO is up and running perfectly.""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation"),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(responseCode = "500", description = "not every endpoint functions properly"),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/ping"], produces = ["application/json"])
    fun operatorPingGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
    ) {
        operatorService.operatorPingGet(acceptLanguage)
    }

    @Operation(
        summary = "gives pricing information",
        operationId = "operatorPricingPlansGet",
        description = """Describes pricing of systems or assets [from GBFS]""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "returns standard pricing plans for an operator",
                content = [Content(array = ArraySchema(schema = Schema(implementation = SystemPricingPlan::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = """The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting 
                    |to give proper response. Unlike 401, the client's identity is known to the server.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ),
            SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"),
            SecurityRequirement(
                name = "BearerAuth",
            ),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/pricing-plans"], produces = ["application/json"])
    fun operatorPricingPlansGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Parameter(description = "optional id of the region to use in the filter (/operator/regions)")
        @Valid
        @RequestParam(value = "regionId", required = false)
        regionId: String?,
        @Parameter(description = "optional id of the station to use in the filter (/operator/stations)")
        @Valid
        @RequestParam(value = "stationId", required = false)
        stationId: String?,
    ): List<SystemPricingPlan> {
        return operatorService.operatorPricingPlansGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            regionId,
            stationId,
        )
    }

    @Operation(
        summary = """describes regions for a system that is broken up by geographic or political region. It is defined as a separate feed 
            |to allow for additional region metadata (such as shape definitions). [from GBFS]""",
        operationId = "operatorRegionsGet",
        description = """""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(array = ArraySchema(schema = Schema(implementation = SystemRegion::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/regions"], produces = ["application/json"])
    fun operatorRegionsGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Min(0)
        @Parameter(description = "start of the selection", schema = Schema(defaultValue = "0"))
        @Valid
        @RequestParam(value = "offset", required = false, defaultValue = "0")
        offset: Int,
        @Min(0)
        @Parameter(description = "count of the selection")
        @Valid
        @RequestParam(value = "limit", required = false)
        limit: Int?,
    ): List<SystemRegion> {
        return operatorService.operatorRegionsGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            offset,
            limit,
        )
    }

    @Operation(
        summary = "describes all available stations",
        operationId = "operatorStationsGet",
        description = """All stations contained in this list are considered public (ie, can be shown on a map for public use). If there 
            |are private stations (such as Capital Bikeshare's White House station) these should not be exposed here and their status 
            |should not be included [from GBFS]. This endpoint can be filtered using the regionId OR with the combination lon, lat and 
            |range.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(array = ArraySchema(schema = Schema(implementation = StationInformation::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/operator/stations"], produces = ["application/json"])
    fun operatorStationsGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Min(0)
        @Parameter(description = "start of the selection", schema = Schema(defaultValue = "0"))
        @Valid
        @RequestParam(value = "offset", required = false, defaultValue = "0")
        offset: Int,
        @Min(0)
        @Parameter(description = "count of the selection")
        @Valid
        @RequestParam(value = "limit", required = false)
        limit: Int?,
        @Parameter(description = "optional id of the region to use in the filter (/operator/regions)")
        @Valid
        @RequestParam(value = "regionId", required = false)
        regionId: String?,
        @DecimalMin("0")
        @Parameter(description = "the longitude of the search location (WGS84)")
        @Valid
        @RequestParam(value = "lon", required = false)
        lon: Float?,
        @DecimalMin("0")
        @Parameter(description = "the latitude of the search location (WGS84)")
        @Valid
        @RequestParam(value = "lat", required = false)
        lat: Float?,
        @DecimalMin("0")
        @Parameter(description = "the range in meters from the search location to look for stations")
        @Valid
        @RequestParam(value = "radius", required = false)
        radius: Float?,
    ): List<StationInformation> {
        return operatorService.operatorStationsGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            offset,
            limit,
            regionId,
            lon,
            lat,
            radius,
        )
    }
}
