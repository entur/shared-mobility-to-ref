package no.entur.shared.mobility.to.ref.tomp150.controller

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.tomp150.dto.Error
import no.entur.shared.mobility.to.ref.tomp150.dto.Planning
import no.entur.shared.mobility.to.ref.tomp150.dto.PlanningRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
@RequestMapping("\${api.base-path:/bike}")
class PlanningApiController {
    @Operation(
        summary = "",
        operationId = "planningInquiriesPost",
        description = """Returns informative options for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the process flow - planning.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.",
                content = [Content(schema = Schema(implementation = Planning::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ), SecurityRequirement(
                name = "ApiKeyAuth",
            ), SecurityRequirement(
                name = "OpenId",
            ), SecurityRequirement(name = "BearerAuth"), SecurityRequirement(name = "OAuth", scopes = [ ]),
        ],
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/planning/inquiries"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun planningInquiriesPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api", required = true) api: kotlin.String,
        @Parameter(
            description = "Version of the API.",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?,
    ): ResponseEntity<Planning> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "planningInquiriesPost",
        description = """Returns informative options for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the process flow - planning.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.",
                content = [Content(schema = Schema(implementation = Planning::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ), SecurityRequirement(
                name = "ApiKeyAuth",
            ), SecurityRequirement(
                name = "OpenId",
            ), SecurityRequirement(name = "BearerAuth"), SecurityRequirement(name = "OAuth", scopes = [ ]),
        ],
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/planning/inquiries"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun planningInquiriesPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api", required = true) api: kotlin.String,
        @Parameter(
            description = "Version of the API.",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?,
    ): ResponseEntity<Planning> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "planningOffersPost",
        description = """Returns bookable offers for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the process flow - planning""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.",
                content = [Content(schema = Schema(implementation = Planning::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ), SecurityRequirement(
                name = "ApiKeyAuth",
            ), SecurityRequirement(
                name = "OpenId",
            ), SecurityRequirement(name = "BearerAuth"), SecurityRequirement(name = "OAuth", scopes = [ ]),
        ],
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/planning/offers"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun planningOffersPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api", required = true) api: kotlin.String,
        @Parameter(
            description = "Version of the API.",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?,
    ): ResponseEntity<Planning> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "planningOffersPost",
        description = """Returns bookable offers for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the process flow - planning""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.",
                content = [Content(schema = Schema(implementation = Planning::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ), SecurityRequirement(
                name = "ApiKeyAuth",
            ), SecurityRequirement(
                name = "OpenId",
            ), SecurityRequirement(name = "BearerAuth"), SecurityRequirement(name = "OAuth", scopes = [ ]),
        ],
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/planning/offers"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun planningOffersPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api", required = true) api: kotlin.String,
        @Parameter(
            description = "Version of the API.",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?,
    ): ResponseEntity<Planning> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
}
