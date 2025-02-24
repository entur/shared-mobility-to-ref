package no.entur.shared.mobility.to.ref.tomp150.controller

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingOperation
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingRequest
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingState
import no.entur.shared.mobility.to.ref.tomp150.dto.Error
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import no.entur.shared.mobility.to.ref.tomp150.dto.OneStopBookingRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import kotlin.collections.List

@RestController
@Validated
@RequestMapping("\${api.base-path:/bike}")
class BookingsApiController {
    @Operation(
        summary = "",
        operationId = "bookingsGet",
        description = """Optional - Returns bookings that has been created earlier, selected on state.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The bookings matching the query",
                content = [Content(array = ArraySchema(schema = Schema(implementation = Booking::class)))],
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
        method = [RequestMethod.GET],
        value = ["/bookings"],
        produces = ["application/json"],
    )
    fun bookingsGet(
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
        @Parameter(
            description = "",
            schema =
                Schema(
                    allowableValues = ["NEW", "PENDING", "REJECTED", "RELEASED", "EXPIRED", "CONDITIONAL_CONFIRMED", "CONFIRMED", "CANCELLED", "STARTED", "FINISHED"],
                ),
        ) @Valid @RequestParam(value = "state", required = false) state: BookingState?,
        @Parameter(
            description = "start time of the time window of all bookings (partially) overlapping with this time window",
        ) @Valid @RequestParam(
            value = "min-time",
            required = false,
        ) @org.springframework.format.annotation.DateTimeFormat(
            iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME,
        ) minTime: java.time.OffsetDateTime?,
        @Parameter(
            description = "end time of the time window of all bookings (partially) overlapping with this time window",
        ) @Valid @RequestParam(
            value = "max-time",
            required = false,
        ) @org.springframework.format.annotation.DateTimeFormat(
            iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME,
        ) maxTime: java.time.OffsetDateTime?,
        @Parameter(
            description = "minimum search price, for the whole trip",
        ) @Valid @RequestParam(value = "min-price", required = false) minPrice: kotlin.Float?,
        @Parameter(
            description = "maximum search price, for the whole trip",
        ) @Valid @RequestParam(value = "max-price", required = false) maxPrice: kotlin.Float?,
        @Parameter(
            description = "filter the bookings on the ID of the asset type. Should return all complete bookings containing a leg executed with this asset type.",
        ) @Valid @RequestParam(value = "contains-asset-type", required = false) containsAssetType: kotlin.String?,
    ): ResponseEntity<List<Booking>> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsGet",
        description = """Optional - Returns bookings that has been created earlier, selected on state.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The bookings matching the query",
                content = [Content(array = ArraySchema(schema = Schema(implementation = Booking::class)))],
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
        method = [RequestMethod.GET],
        value = ["/bookings"],
        produces = ["application/json"],
    )
    fun bookingsGet(
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
        @Parameter(
            description = "",
            schema =
                Schema(
                    allowableValues = ["NEW", "PENDING", "REJECTED", "RELEASED", "EXPIRED", "CONDITIONAL_CONFIRMED", "CONFIRMED", "CANCELLED", "STARTED", "FINISHED"],
                ),
        ) @Valid @RequestParam(value = "state", required = false) state: BookingState?,
        @Parameter(
            description = "start time of the time window of all bookings (partially) overlapping with this time window",
        ) @Valid @RequestParam(
            value = "min-time",
            required = false,
        ) @org.springframework.format.annotation.DateTimeFormat(
            iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME,
        ) minTime: java.time.OffsetDateTime?,
        @Parameter(
            description = "end time of the time window of all bookings (partially) overlapping with this time window",
        ) @Valid @RequestParam(
            value = "max-time",
            required = false,
        ) @org.springframework.format.annotation.DateTimeFormat(
            iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME,
        ) maxTime: java.time.OffsetDateTime?,
        @Parameter(
            description = "minimum search price, for the whole trip",
        ) @Valid @RequestParam(value = "min-price", required = false) minPrice: kotlin.Float?,
        @Parameter(
            description = "maximum search price, for the whole trip",
        ) @Valid @RequestParam(value = "max-price", required = false) maxPrice: kotlin.Float?,
        @Parameter(
            description = "filter the bookings on the ID of the asset type. Should return all complete bookings containing a leg executed with this asset type.",
        ) @Valid @RequestParam(value = "contains-asset-type", required = false) containsAssetType: kotlin.String?,
    ): ResponseEntity<List<Booking>> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdEventsPost",
        description = """This endpoint **must** be used to alter the state of a booking:<br> `CANCEL` - Cancels a confirmed booking.<br> `EXTEND_EXPIRY_TIME` - the MP request to extend the expiry time of the booking. Only available when the Process Identifier 'ALLOW_EXTEND_BOOKING_EXPIRY_TIME' is used. Whenever the extension is not granted, 410 should be returned.<br> `COMMIT` - Turns the booking in a confirmed state, after all legs are in state pending. If the booking is in state COMMITTED, CANCELLED or EXPIRED, a commit will result a 403. <BR> `DENY` - Used for the 'postponed-commit' scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a 'COMMIT', but the state of the booking object should be 'POSTPONED-COMMIT'. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event).""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The modified booking",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/events"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdEventsPost(
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
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) bookingOperation: BookingOperation?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdEventsPost",
        description = """This endpoint **must** be used to alter the state of a booking:<br> `CANCEL` - Cancels a confirmed booking.<br> `EXTEND_EXPIRY_TIME` - the MP request to extend the expiry time of the booking. Only available when the Process Identifier 'ALLOW_EXTEND_BOOKING_EXPIRY_TIME' is used. Whenever the extension is not granted, 410 should be returned.<br> `COMMIT` - Turns the booking in a confirmed state, after all legs are in state pending. If the booking is in state COMMITTED, CANCELLED or EXPIRED, a commit will result a 403. <BR> `DENY` - Used for the 'postponed-commit' scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a 'COMMIT', but the state of the booking object should be 'POSTPONED-COMMIT'. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event).""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The modified booking",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/events"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdEventsPost(
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
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) bookingOperation: BookingOperation?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdEventsPost",
        description = """This endpoint **must** be used to alter the state of a booking:<br> `CANCEL` - Cancels a confirmed booking.<br> `EXTEND_EXPIRY_TIME` - the MP request to extend the expiry time of the booking. Only available when the Process Identifier 'ALLOW_EXTEND_BOOKING_EXPIRY_TIME' is used. Whenever the extension is not granted, 410 should be returned.<br> `COMMIT` - Turns the booking in a confirmed state, after all legs are in state pending. If the booking is in state COMMITTED, CANCELLED or EXPIRED, a commit will result a 403. <BR> `DENY` - Used for the 'postponed-commit' scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a 'COMMIT', but the state of the booking object should be 'POSTPONED-COMMIT'. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event).""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The modified booking",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/events"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdEventsPost(
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
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) bookingOperation: BookingOperation?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdGet",
        description = """Returns the booking. See (3.5.2) in the process flow - booking. In the 'meta'-field the digital tickes can be returned (see (3.3) in the process flow - booking)""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The booking was found",
                content = [Content(schema = Schema(implementation = Booking::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        method = [RequestMethod.GET],
        value = ["/bookings/{id}"],
        produces = ["application/json"],
    )
    fun bookingsIdGet(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdGet",
        description = """Returns the booking. See (3.5.2) in the process flow - booking. In the 'meta'-field the digital tickes can be returned (see (3.3) in the process flow - booking)""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The booking was found",
                content = [Content(schema = Schema(implementation = Booking::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        method = [RequestMethod.GET],
        value = ["/bookings/{id}"],
        produces = ["application/json"],
    )
    fun bookingsIdGet(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsGet",
        description = """retrieves all notifications concerning events related to this booking.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The bookings matching the query",
                content = [Content(array = ArraySchema(schema = Schema(implementation = Notification::class)))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        method = [RequestMethod.GET],
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"],
    )
    fun bookingsIdNotificationsGet(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<List<Notification>> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsGet",
        description = """retrieves all notifications concerning events related to this booking.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The bookings matching the query",
                content = [Content(array = ArraySchema(schema = Schema(implementation = Notification::class)))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        method = [RequestMethod.GET],
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"],
    )
    fun bookingsIdNotificationsGet(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<List<Notification>> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsPost",
        description = """notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls.""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdNotificationsPost(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) notification: Notification?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsPost",
        description = """notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls.""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdNotificationsPost(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) notification: Notification?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdNotificationsPost",
        description = """notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls.""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/notifications"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdNotificationsPost(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) notification: Notification?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdPut",
        description = """Optional - This endpoint should be used to adjust the parameters of the booking. Changes not acceptable to the TO should return 400. If a booking is started and can no longer be adjusted the TO should return 403. The state of the booking should **never** be adjusted using this method. Use /bookings/{id}/events for that. See also (7.2) in the flow diagram - booking.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The booking was modified",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(
                responseCode = "409",
                description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        method = [RequestMethod.PUT],
        value = ["/bookings/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdPut(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(description = "changed booking", required = true) @Valid @RequestBody booking: Booking,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdPut",
        description = """Optional - This endpoint should be used to adjust the parameters of the booking. Changes not acceptable to the TO should return 400. If a booking is started and can no longer be adjusted the TO should return 403. The state of the booking should **never** be adjusted using this method. Use /bookings/{id}/events for that. See also (7.2) in the flow diagram - booking.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The booking was modified",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(
                responseCode = "409",
                description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        method = [RequestMethod.PUT],
        value = ["/bookings/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsIdPut(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(description = "changed booking", required = true) @Valid @RequestBody booking: Booking,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdSubscriptionDelete",
        description = """Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
            ApiResponse(
                responseCode = "200",
                description = "Unexpected error",
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
        method = [RequestMethod.DELETE],
        value = ["/bookings/{id}/subscription"],
        produces = ["application/json"],
    )
    fun bookingsIdSubscriptionDelete(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdSubscriptionDelete",
        description = """Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
            ApiResponse(
                responseCode = "200",
                description = "Unexpected error",
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
        method = [RequestMethod.DELETE],
        value = ["/bookings/{id}/subscription"],
        produces = ["application/json"],
    )
    fun bookingsIdSubscriptionDelete(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdSubscriptionDelete",
        description = """Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
            ApiResponse(
                responseCode = "200",
                description = "Unexpected error",
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
        method = [RequestMethod.DELETE],
        value = ["/bookings/{id}/subscription"],
        produces = ["application/json"],
    )
    fun bookingsIdSubscriptionDelete(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdSubscriptionPost",
        description = """Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint. This endpoint facilitates notifications in all the phases. (see (7.1) in the flow chart - execution)""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/subscription"],
        produces = ["application/json"],
    )
    fun bookingsIdSubscriptionPost(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdSubscriptionPost",
        description = """Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint. This endpoint facilitates notifications in all the phases. (see (7.1) in the flow chart - execution)""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/subscription"],
        produces = ["application/json"],
    )
    fun bookingsIdSubscriptionPost(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsIdSubscriptionPost",
        description = """Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint. This endpoint facilitates notifications in all the phases. (see (7.1) in the flow chart - execution)""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings/{id}/subscription"],
        produces = ["application/json"],
    )
    fun bookingsIdSubscriptionPost(
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
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Unit> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsOneStopPost",
        description = """Returns a booking for the given travel plan. This endpoint executes POST /planning/offers and POST /booking in one blow, the information provided should lead to only one possible offer, that is booked directly. The returned booking is still in `PENDING` state, you have to commit it. Unless 'AUTO_COMMIT' process identifier is applied. In that case the booking is in state 'CONFIRMED'.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A single booking, or when it's not possible, return a 406.",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(responseCode = "406", description = "this booking cannot be done."),
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
        value = ["/bookings/one-stop"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsOneStopPost(
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
        @Parameter(description = "") @Valid @RequestBody(required = false) oneStopBookingRequest: OneStopBookingRequest?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsOneStopPost",
        description = """Returns a booking for the given travel plan. This endpoint executes POST /planning/offers and POST /booking in one blow, the information provided should lead to only one possible offer, that is booked directly. The returned booking is still in `PENDING` state, you have to commit it. Unless 'AUTO_COMMIT' process identifier is applied. In that case the booking is in state 'CONFIRMED'.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A single booking, or when it's not possible, return a 406.",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(responseCode = "406", description = "this booking cannot be done."),
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
        value = ["/bookings/one-stop"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsOneStopPost(
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
        @Parameter(description = "") @Valid @RequestBody(required = false) oneStopBookingRequest: OneStopBookingRequest?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsPost",
        description = """Creates a new `Booking` for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). <p>The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. <p> see (3.2) in the process flow - booking. <p>The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A new booking was succesfully created, status pending",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(
                responseCode = "409",
                description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsPost(
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
            description = "One of available booking options, returned by /plannings, with an ID.",
            required = true,
        ) @Valid @RequestBody bookingRequest: BookingRequest,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsPost",
        description = """Creates a new `Booking` for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). <p>The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. <p> see (3.2) in the process flow - booking. <p>The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A new booking was succesfully created, status pending",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(
                responseCode = "409",
                description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsPost(
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
            description = "One of available booking options, returned by /plannings, with an ID.",
            required = true,
        ) @Valid @RequestBody bookingRequest: BookingRequest,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    @Operation(
        summary = "",
        operationId = "bookingsPost",
        description = """Creates a new `Booking` for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). <p>The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. <p> see (3.2) in the process flow - booking. <p>The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP.""",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A new booking was succesfully created, status pending",
                content = [Content(schema = Schema(implementation = Booking::class))],
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
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.",
            ),
            ApiResponse(
                responseCode = "409",
                description = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.",
            ),
            ApiResponse(responseCode = "410", description = "The requested resource is no longer available. This is permanent."),
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
        value = ["/bookings"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun bookingsPost(
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
            description = "One of available booking options, returned by /plannings, with an ID.",
            required = true,
        ) @Valid @RequestBody bookingRequest: BookingRequest,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
    ): ResponseEntity<Booking> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
}
