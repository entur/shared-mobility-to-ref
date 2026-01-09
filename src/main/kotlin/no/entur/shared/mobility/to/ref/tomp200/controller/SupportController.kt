package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.GetSupportTickets200Response
import no.entur.shared.mobility.to.ref.tomp200.dto.GetSupportTicketsDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.RequestSupportRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicket
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicketStatus
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.SupportController")
@Validated
@RequestMapping("\${api.base-path:}")
class SupportController(@Autowired(required = true) val service: SupportService) {

    @Operation(
        summary = "Get for support tickets of a package/leg",
        operationId = "getSupportTickets",
        description = """returns support tickets in their current state, based on the parameters""",
        responses = [
            ApiResponse(responseCode = "200", description = "a list of tickets", content = [Content(schema = Schema(implementation = GetSupportTickets200Response::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetSupportTicketsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/support-tickets/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun getSupportTickets(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Parameter(description = "the identifier of a package", required = true) @Valid @RequestParam(value = "packageId", required = true) packageId: kotlin.String,@NotNull @Parameter(description = "leg identifier", required = true) @Valid @RequestParam(value = "legId", required = true) legId: kotlin.String,@Parameter(description = "", schema = Schema(allowableValues = ["ISSUE_REQUESTED", "ISSUE_OPEN", "ISSUE_UPDATE_REQUESTED", "ISSUE_RESOLVED", "ISSUE_REVOKED"])) @Valid @RequestParam(value = "supportTicketStatus", required = false) supportTicketStatus: SupportTicketStatus?): ResponseEntity<GetSupportTickets200Response> {
        return ResponseEntity(service.getSupportTickets(acceptLanguage, authorization, packageId, legId, supportTicketStatus), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Create a support ticket",
        operationId = "requestSupport",
        description = """creates a request for SUPPORT from end user via MP""",
        responses = [
            ApiResponse(responseCode = "200", description = "support request acknowledged, the response contains a support ticket with a unique ID. Multiple support tickets can be created on one single leg.", content = [Content(schema = Schema(implementation = SupportTicket::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetSupportTicketsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/request-support/execution"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun requestSupport(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) requestSupportRequest: RequestSupportRequest?): ResponseEntity<SupportTicket> {
        return ResponseEntity(service.requestSupport(acceptLanguage, authorization, requestSupportRequest), HttpStatus.valueOf(200))
    }
}
