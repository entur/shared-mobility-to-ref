package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.GetToken200Response
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.TechController")
@Validated
@RequestMapping("\${api.base-path:}")
class TechController(@Autowired(required = true) val service: TechService) {

    @Operation(
        summary = "Token Endpoint",
        operationId = "getToken",
        description = """This endpoint is used to obtain an access token and optionally an ID token through different OAuth 2.0 grant types, including Client Credentials Flow. Whenever the mTLS flow is taken, the properties will be ignored, and the access token will be generated based on the credentials in the certificate (O or CN).""",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful token issuance.", content = [Content(schema = Schema(implementation = GetToken200Response::class))]),
            ApiResponse(responseCode = "400", description = "Bad Request: Invalid request or wrong grant type."),
            ApiResponse(responseCode = "401", description = "Unauthorized: Invalid client ID or secret."),
            ApiResponse(responseCode = "500", description = "Internal Server Error: Something went wrong.") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/oauth/token"],
        produces = ["application/json"],
        consumes = ["application/x-www-form-urlencoded"]
    )
    fun getToken(@Parameter(description = "The grant type: 'client_credentials', 'password', or 'refresh_token'.", schema = Schema(allowableValues = ["client_credentials", "password", "refresh_token"], defaultValue = "client_credentials")) @Valid @RequestParam(value = "grant_type", required = false) grantType: kotlin.String ,@Parameter(description = "The username") @Valid @RequestParam(value = "username", required = false) username: kotlin.String? ,@Parameter(description = "The password") @Valid @RequestParam(value = "password", required = false) password: kotlin.String? ,@Parameter(description = "The client ID (Client Credentials Flow)") @Valid @RequestParam(value = "client_id", required = false) clientId: kotlin.String? ,@Parameter(description = "The client secret (Client Credentials Flow)") @Valid @RequestParam(value = "client_secret", required = false) clientSecret: kotlin.String? ): ResponseEntity<GetToken200Response> {
        return ResponseEntity(service.getToken(grantType, username, password, clientId, clientSecret), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "is the API up and running?",
        operationId = "ping",
        description = """This is a healthcheck ENDPOINT""",
        responses = [
            ApiResponse(responseCode = "204", description = "successful operation"),
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/health"],
        produces = ["application/json"]
    )
    fun ping(): ResponseEntity<Map<String, kotlin.Any>> {
        return ResponseEntity(service.ping(), HttpStatus.valueOf(204))
    }
}
