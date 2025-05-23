package no.entur.shared.mobility.to.ref.tomp160.controller

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import no.entur.shared.mobility.to.ref.tomp160.dto.Notification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController("no.entur.shared.mobility.to.ref.tomp160.controller.GeneralController")
@Validated
@RequestMapping("\${api.base-path:/tomp160}")
@Hidden
class GeneralController(@Autowired(required = true) val service: GeneralService) {

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsGet",
        description = """retrieves all notifications concerning events related to this booking.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The bookings matching the query",
                content = [Content(array = ArraySchema(schema = Schema(implementation = Notification::class)))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent.")],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"]
    )
    fun bookingsIdNotificationsGet(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?
    ): ResponseEntity<List<Notification>> {
        return ResponseEntity(
            service.bookingsIdNotificationsGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo),
            HttpStatus.valueOf(200)
        )
    }

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsPost",
        description = """notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls.""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent.")],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun bookingsIdNotificationsPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) notification: Notification?
    ): ResponseEntity<Unit> {
        return ResponseEntity(
            service.bookingsIdNotificationsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, notification),
            HttpStatus.valueOf(204)
        )
    }
}
