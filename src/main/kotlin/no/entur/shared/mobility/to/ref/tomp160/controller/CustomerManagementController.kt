package no.entur.shared.mobility.to.ref.tomp160.controller

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.tomp160.dto.Customer
import no.entur.shared.mobility.to.ref.tomp160.dto.CustomerAccount
import no.entur.shared.mobility.to.ref.tomp160.dto.CustomersPostDefaultResponse
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

@RestController("no.entur.shared.mobility.to.ref.tomp160.controller.CustomerManagementController")
@Validated
@RequestMapping("\${api.base-path:/tomp160}")
@Hidden
class CustomerManagementController(@Autowired(required = true) val service: CustomerManagementService) {

    @Operation(
        summary = "[MP->TO] delete the CUSTOMER ACCOUNT on the TO system.",
        operationId = "customersIdDelete",
        description = """The timeline of deletion of the customer account depends on the TO processes, it could be instant, weeks or months.""",
        responses = [
            ApiResponse(responseCode = "200", description = "CUSTOMER ACCOUNT deleted successfully"),
            ApiResponse(
                responseCode = "200",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = CustomersPostDefaultResponse::class))]
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/customers/{id}"],
        produces = ["application/json"]
    )
    fun customersIdDelete(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(description = "ID of the customer, on TO side", required = true) @PathVariable("id") id: String,
        @Parameter(
            description = "The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications.",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "notification-url", required = false) notificationUrl: String?
    ): ResponseEntity<Unit> {
        return ResponseEntity(service.customersIdDelete(acceptLanguage, id, notificationUrl), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "[MP->TO] get the customer account on the TO system",
        operationId = "customersIdGet",
        description = """""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Customer Account",
                content = [Content(schema = Schema(implementation = CustomerAccount::class))]
            ),
            ApiResponse(
                responseCode = "200",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = CustomersPostDefaultResponse::class))]
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/customers/{id}"],
        produces = ["application/json"]
    )
    fun customersIdGet(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(description = "ID of the customer, on TO side", required = true) @PathVariable("id") id: String,
        @Parameter(
            description = "The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications.",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "notification-url", required = false) notificationUrl: String?
    ): ResponseEntity<CustomerAccount> {
        return ResponseEntity(service.customersIdGet(acceptLanguage, id, notificationUrl), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "[MP->TO] update the CUSTOMER ACCOUNT on the TO system",
        operationId = "customersIdPatch",
        description = """updates the defined fields of the CUSTOMER ACCOUNT.<br> When during CREATE CUSTOMER ACCOUNT step the customer status is _OTP_REQUIRED_ this request can be used to send the OTP from the customer to the TO by using extraFields.otp in the Customer object.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "updated CUSTOMER ACCOUNT",
                content = [Content(schema = Schema(implementation = CustomerAccount::class))]
            ),
            ApiResponse(
                responseCode = "200",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = CustomersPostDefaultResponse::class))]
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.PATCH],
        value = ["/customers/{id}"],
        produces = ["application/json"],
        consumes = ["application/merge-patch+json"]
    )
    fun customersIdPatch(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(description = "ID of the customer, on TO side", required = true) @PathVariable("id") id: String,
        @Parameter(
            description = "The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications.",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "notification-url", required = false) notificationUrl: String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) body: Any?
    ): ResponseEntity<CustomerAccount> {
        return ResponseEntity(service.customersIdPatch(acceptLanguage, id, notificationUrl, body), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "[MP->TO] create a TO CUSTOMER ACCOUNT for the customer",
        operationId = "customersPost",
        description = """Creates or links a CUSTOMER ACCOUNT that can be later used for purchasing a trip. If the customer is already registered with this TO it's the TO descision whether to link to the existing acount or to create a seperate account.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "created CUSTOMER ACCOUNT",
                content = [Content(schema = Schema(implementation = CustomerAccount::class))]
            ),
            ApiResponse(
                responseCode = "200",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = CustomersPostDefaultResponse::class))]
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/customers"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun customersPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications.",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "notification-url", required = false) notificationUrl: String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) body: Customer?
    ): ResponseEntity<CustomerAccount> {
        return ResponseEntity(service.customersPost(acceptLanguage, notificationUrl, body), HttpStatus.valueOf(200))
    }
}
