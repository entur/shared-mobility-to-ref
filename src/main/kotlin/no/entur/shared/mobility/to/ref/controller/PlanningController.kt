package no.entur.shared.mobility.to.ref.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Error
import no.entur.shared.mobility.to.ref.dto.Planning
import no.entur.shared.mobility.to.ref.dto.PlanningRequest
import no.entur.shared.mobility.to.ref.service.PlanningService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
class PlanningController(
    private val planningService: PlanningService,
) {
    @Operation(
        hidden = true,
        summary = "",
        operationId = "planningInquiriesPost",
        description = """Returns informative options for the given travel plan. <p>Start time can be defined, but is optional. If startTime 
            |is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. 
            |During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the 
            |process flow - planning.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = """Available transport methods matching the given query parameters. If no transport methods are available, 
                    |an empty array is returned.""",
                content = [Content(schema = Schema(implementation = Planning::class))],
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
    )
    @PostMapping(value = ["/planning/inquiries"], produces = ["application/json"], consumes = ["application/json"])
    fun planningInquiriesPost(
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
        @Parameter(description = "")
        @Valid
        @RequestBody(required = false)
        planningRequest: PlanningRequest?,
    ): Planning =
        planningService.planningInquiriesPost(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            planningRequest,
        )

    @Operation(
        operationId = "planningOffersPost",
        description = """Returns bookable offers for the given travel plan. <p>Start time can be defined, but is optional. If startTime is 
            |not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During 
            |the routing phase this service can be used to check availability without any state changes. 
            |<p>see (2.1) in the process flow - planning""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = """Available transport methods matching the given query parameters. If no transport methods are available, an 
                    |empty array is returned.""",
                content = [Content(schema = Schema(implementation = Planning::class))],
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
    )
    @PostMapping(value = ["/planning/offers"], produces = ["application/json"], consumes = ["application/json"])
    fun planningOffersPost(
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
        @Parameter(description = "")
        @Valid
        @RequestBody(required = false)
        planningRequest: PlanningRequest?,
    ): Planning =
        planningService.planningOffersPost(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            planningRequest,
        )
}
