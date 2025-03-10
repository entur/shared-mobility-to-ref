package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingOperation
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController("no.entur.shared.mobility.to.ref.tomp160.controller.BookingController")
@Validated
@RequestMapping("\${api.base-path:/tomp160}")
class BookingController(@Autowired(required = true) val service: BookingService) {

    @Operation(
        summary = "",
        operationId = "bookingsIdEventsPost",
        description = """This endpoint **must** be used to alter the state of a booking:<br> `CANCEL` - Cancels a pending or confirmed booking.<br> `EXTEND_EXPIRY_TIME` - the MP request to extend the expiry time of the booking. Only available when the Process Identifier 'ALLOW_EXTEND_BOOKING_EXPIRY_TIME' is used. Whenever the extension is not granted, 410 should be returned.<br> `COMMIT` - Turns the booking in a confirmed state, after all legs are in state pending. If the booking is in state COMMITTED, CANCELLED or EXPIRED, a commit will result a 403. <BR> `DENY` - Used for the 'postponed-commit' scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a 'COMMIT', but the state of the booking object should be 'POSTPONED-COMMIT'. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event).""",
        responses = [
            ApiResponse(responseCode = "200", description = "The modified booking", content = [Content(schema = Schema(implementation = Booking::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent.") ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bookings/{id}/events"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun bookingsIdEventsPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) bookingOperation: BookingOperation?): ResponseEntity<Booking> {
        return ResponseEntity(service.bookingsIdEventsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, bookingOperation), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "",
        operationId = "bookingsIdGet",
        description = """Returns the booking. See (3.5.2) in the process flow - booking. In the 'meta'-field the digital tickes can be returned (see (3.3) in the process flow - booking)""",
        responses = [
            ApiResponse(responseCode = "200", description = "The booking was found", content = [Content(schema = Schema(implementation = Booking::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent.") ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/bookings/{id}"],
        produces = ["application/json"]
    )
    fun bookingsIdGet(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?): ResponseEntity<Booking> {
        return ResponseEntity(service.bookingsIdGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "",
        operationId = "bookingsPost",
        description = """Creates a new `Booking` for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). <p>The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. <p> see (3.2) in the process flow - booking. <p>The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP.""",
        responses = [
            ApiResponse(responseCode = "201", description = "A new booking was succesfully created, status pending", content = [Content(schema = Schema(implementation = Booking::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
            ApiResponse(responseCode = "409", description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource."),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
            ApiResponse(responseCode = "428", description = "Preconditions are not met in order to access the requested resource. This might happen e.g. if a booking is made but the user has been blocked by the TO. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]) ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bookings"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun bookingsPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "One of available booking options, returned by /plannings, with an ID.", required = true) @Valid @RequestBody bookingRequest: BookingRequest,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?): ResponseEntity<Booking> {
        return ResponseEntity(service.bookingsPost(acceptLanguage, api, apiVersion, maasId, bookingRequest, addressedTo), HttpStatus.valueOf(201))
    }
}
