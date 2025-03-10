package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.Error
import no.entur.shared.mobility.to.ref.tomp150.dto.SupportRequest
import no.entur.shared.mobility.to.ref.tomp150.dto.SupportStatus
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

@RestController("no.entur.shared.mobility.to.ref.tomp150.controller.SupportController")
@Validated
@RequestMapping("\${api.base-path:}")
class SupportController(@Autowired(required = true) val service: SupportService) {

    @Operation(
        summary = "",
        operationId = "supportIdStatusGet",
        description = """Gets the status report of the support request. Last status (highest order number) is the current status""",
        responses = [
            ApiResponse(responseCode = "200", description = "support status delivered", content = [Content(array = ArraySchema(schema = Schema(implementation = SupportStatus::class)))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/support/{id}/status"],
        produces = ["application/json"]
    )
    fun supportIdStatusGet(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?): ResponseEntity<List<SupportStatus>> {
        return ResponseEntity(service.supportIdStatusGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "",
        operationId = "supportPost",
        description = """creates a request for support from end user via MP""",
        responses = [
            ApiResponse(responseCode = "200", description = "support request acknowledged", content = [Content(schema = Schema(implementation = SupportStatus::class))]),
            ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") ],
        security = [ SecurityRequirement(name = "BasicAuth"),SecurityRequirement(name = "ApiKeyAuth"),SecurityRequirement(name = "OpenId"),SecurityRequirement(name = "BearerAuth"),SecurityRequirement(name = "OAuth", scopes = [  ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/support/"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun supportPost(@Parameter(description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "API description, can be TOMP or maybe other (specific/derived) API definitions", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api", required = true) api: kotlin.String,@Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,@Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,@Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) supportRequest: SupportRequest?): ResponseEntity<SupportStatus> {
        return ResponseEntity(service.supportPost(acceptLanguage, api, apiVersion, maasId, addressedTo, supportRequest), HttpStatus.valueOf(200))
    }
}
