package no.entur.shared.mobility.to.ref.controller

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.dto.Error
import no.entur.shared.mobility.to.ref.dto.SupportRequest
import no.entur.shared.mobility.to.ref.dto.SupportStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("\${api.base-path}")
class SupportController(private val objectMapper: ObjectMapper) {
    @Operation(
        operationId = "supportIdStatusGet",
        description = """Gets the status report of the support request. Last status (highest order number) is the current status""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "support status delivered",
                content = [Content(array = ArraySchema(schema = Schema(implementation = SupportStatus::class)))],
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
    @GetMapping(value = ["/support/{id}/status"], produces = ["application/json"])
    fun supportIdStatusGet(
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
        @Parameter(description = "Booking identifier", required = true)
        @PathVariable("id")
        id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
    ): List<SupportStatus> {
        TODO()
    }

    @Operation(
        operationId = "supportPost",
        description = """creates a request for support from end user via MP""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "support request acknowledged",
                content = [Content(schema = Schema(implementation = SupportStatus::class))],
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
    @PostMapping(value = ["/support/"], produces = ["application/json"], consumes = ["application/json"])
    fun supportPost(
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
        @Valid
        @RequestBody(required = false)
        supportRequest: SupportRequest?,
    ): SupportStatus {
        TODO()
    }
}
