package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import no.entur.shared.mobility.to.ref.tomp160.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.Planning
import no.entur.shared.mobility.to.ref.tomp160.dto.PlanningRequest
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

@RestController("no.entur.shared.mobility.to.ref.tomp160.controller.PlanningController")
@Validated
@RequestMapping("\${api.base-path:/tomp160}")
class PlanningController(@Autowired(required = true) val service: PlanningService) {

    @Operation(
        summary = "",
        operationId = "bookingsOneStopPost",
        description = """Returns a booking for the given travel plan. This endpoint executes POST /planning/offers and POST /booking in one blow, the information provided should lead to only one possible offer, that is booked directly. The returned booking is still in `PENDING` state, you have to commit it. Unless 'AUTO_COMMIT' process identifier is applied. In that case the booking is in state 'CONFIRMED'.""",
        responses = [
            ApiResponse(responseCode = "201", description = "A single booking, or when it's not possible, return a 406.", content = [Content(schema = Schema(implementation = Booking::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "406", description = "this booking cannot be done.") ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bookings/one-stop"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun bookingsOneStopPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) oneStopBookingRequest: OneStopBookingRequest?): ResponseEntity<Booking> {
        return ResponseEntity(service.bookingsOneStopPost(acceptLanguage, api, apiVersion, maasId, addressedTo, oneStopBookingRequest), HttpStatus.valueOf(201))
    }

    @Operation(
        summary = "",
        operationId = "planningInquiriesPost",
        description = """Returns informative options for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the process flow - planning.""",
        responses = [
            ApiResponse(responseCode = "201", description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.", content = [Content(schema = Schema(implementation = Planning::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]) ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/planning/inquiries"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun planningInquiriesPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?): ResponseEntity<Planning> {
        return ResponseEntity(service.planningInquiriesPost(acceptLanguage, api, apiVersion, maasId, addressedTo, planningRequest), HttpStatus.valueOf(201))
    }

    @Operation(
        summary = "",
        operationId = "planningOffersPost",
        description = """Returns bookable offers for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>see (2.1) in the process flow - planning""",
        responses = [
            ApiResponse(responseCode = "201", description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.", content = [Content(schema = Schema(implementation = Planning::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]) ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/planning/offers"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun planningOffersPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?): ResponseEntity<Planning> {
        return ResponseEntity(service.planningOffersPost(acceptLanguage, api, apiVersion, maasId, addressedTo, planningRequest), HttpStatus.valueOf(201))
    }

    @Operation(
        summary = "",
        operationId = "planningsPost",
        description = """Returns plannings for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of "Date.now()" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>In the final check, just before presenting the alternatives to the user, a call should be made using `booking-intent`, requesting the TO to provide booking IDs to reference to during communication with the MP. <p>see (2.1) in the process flow - planning Replaced by /plannings/inquires (booking-intent false) and /planning/offers (booking-intent true)""",
        responses = [
            ApiResponse(responseCode = "201", description = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.", content = [Content(schema = Schema(implementation = Planning::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]) ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/plannings"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun planningsPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,@Parameter(description = "Specifies whether IDs should be returned for the leg options that can be referred to when booking", schema = Schema(defaultValue = "false")) @Valid @RequestParam(value = "booking-intent", required = false, defaultValue = "false") bookingIntent: kotlin.Boolean,@Parameter(description = "") @Valid @RequestBody(required = false) planningRequest: PlanningRequest?): ResponseEntity<Planning> {
        return ResponseEntity(service.planningsPost(acceptLanguage, api, apiVersion, maasId, addressedTo, bookingIntent, planningRequest), HttpStatus.valueOf(201))
    }
}
