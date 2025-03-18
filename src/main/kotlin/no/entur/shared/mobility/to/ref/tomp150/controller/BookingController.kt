package no.entur.shared.mobility.to.ref.tomp150.controller

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingOperation
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingRequest
import no.entur.shared.mobility.to.ref.tomp150.dto.Error
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

@RestController("no.entur.shared.mobility.to.ref.tomp150.controller.BookingController")
@Validated
@RequestMapping("\${api.base-path:}")
class BookingController(@Autowired(required = true) val service: BookingService) {

    @Operation(
        summary = "",
        operationId = "bookingsIdEventsPost",
        description = """This endpoint **must** be used to alter the state of a booking:<br> `CANCEL` - Cancels a confirmed booking.<br> `EXTEND_EXPIRY_TIME` - the MP request to extend the expiry time of the booking. Only available when the Process Identifier 'ALLOW_EXTEND_BOOKING_EXPIRY_TIME' is used. Whenever the extension is not granted, 410 should be returned.<br> `COMMIT` - Turns the booking in a confirmed state, after all legs are in state pending. If the booking is in state COMMITTED, CANCELLED or EXPIRED, a commit will result a 403. <BR> `DENY` - Used for the 'postponed-commit' scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a 'COMMIT', but the state of the booking object should be 'POSTPONED-COMMIT'. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event).""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The modified booking",
                content = [Content(schema = Schema(implementation = Booking::class))]
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
        method = [RequestMethod.POST],
        value = ["/bookings/{id}/events"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @Hidden
    fun bookingsIdEventsPost(
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
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) bookingOperation: BookingOperation?
    ): ResponseEntity<Booking> {
        return ResponseEntity(
            service.bookingsIdEventsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, bookingOperation),
            HttpStatus.valueOf(200)
        )
    }

    @Operation(
        summary = "",
        operationId = "bookingsIdGet",
        description = """Returns the booking. See (3.5.2) in the process flow - booking. In the 'meta'-field the digital tickes can be returned (see (3.3) in the process flow - booking)""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The booking was found",
                content = [Content(schema = Schema(implementation = Booking::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
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
        value = ["/bookings/{id}"],
        produces = ["application/json"]
    )
    @Hidden
    fun bookingsIdGet(
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
    ): ResponseEntity<Booking> {
        return ResponseEntity(service.bookingsIdGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "",
        operationId = "bookingsPost",
        description = """Creates a new `Booking` for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). <p>The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. <p> see (3.2) in the process flow - booking. <p>The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A new booking was succesfully created, status pending",
                content = [Content(schema = Schema(implementation = Booking::class))]
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
            ApiResponse(
                responseCode = "409",
                description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource."
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent.")],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bookings"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @Hidden
    fun bookingsPost(
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
        @Parameter(
            description = "One of available booking options, returned by /plannings, with an ID.",
            required = true
        ) @Valid @RequestBody bookingRequest: BookingRequest,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?
    ): ResponseEntity<Booking> {
        return ResponseEntity(
            service.bookingsPost(acceptLanguage, api, apiVersion, maasId, bookingRequest, addressedTo),
            HttpStatus.valueOf(201)
        )
    }
}
