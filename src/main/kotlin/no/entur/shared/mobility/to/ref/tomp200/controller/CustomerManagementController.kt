package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.CreateCustomerDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Customer
import no.entur.shared.mobility.to.ref.tomp200.dto.CustomerAccount
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.CustomerManagementController")
@Validated
@RequestMapping("\${api.base-path:}")
class CustomerManagementController(@Autowired(required = true) val service: CustomerManagementService) {

    @Operation(
        summary = "Create a TO CUSTOMER ACCOUNT for the customer",
        operationId = "createCustomer",
        description = """creates a CUSTOMER ACCOUNT that can be later used for purchase of a trip""",
        responses = [
            ApiResponse(responseCode = "201", description = "Customer Account", content = [Content(schema = Schema(implementation = CustomerAccount::class))]),
            ApiResponse(responseCode = "200", description = "Customer Account", content = [Content(schema = Schema(implementation = CustomerAccount::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = CreateCustomerDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/collections/customers/items"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createCustomer(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) customer: Customer?): ResponseEntity<CustomerAccount> {
        return ResponseEntity(service.createCustomer(acceptLanguage, customer), HttpStatus.valueOf(201))
    }

    @Operation(
        summary = "Delete the CUSTOMER ACCOUNT from the TO system.",
        operationId = "deleteCustomer",
        description = """The timeline of deletion of the customer account depends on the TO processes, it could be instant, weeks or months.""",
        responses = [
            ApiResponse(responseCode = "200", description = "CUSTOMER ACCOUNT deleted successfully"),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = CreateCustomerDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/collections/customers/items/{customerId}"],
        produces = ["application/json"]
    )
    fun deleteCustomer(@Size(max=200) @Parameter(description = "", required = true) @PathVariable("customerId") customerId: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(service.deleteCustomer(customerId), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Get the customer account from the TO system",
        operationId = "getCustomer",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "Customer Account", content = [Content(schema = Schema(implementation = CustomerAccount::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = CreateCustomerDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/customers/items/{customerId}"],
        produces = ["application/json"]
    )
    fun getCustomer(@Size(max=200) @Parameter(description = "", required = true) @PathVariable("customerId") customerId: kotlin.String): ResponseEntity<CustomerAccount> {
        return ResponseEntity(service.getCustomer(customerId), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Update the CUSTOMER ACCOUNT on the TO system",
        operationId = "updateCustomer",
        description = """updates the defined fields of the CUSTOMER ACCOUNT.<br>""",
        responses = [
            ApiResponse(responseCode = "200", description = "Customer Account", content = [Content(schema = Schema(implementation = CustomerAccount::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = CreateCustomerDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.PATCH],
        value = ["/collections/customers/items/{customerId}"],
        produces = ["application/json"],
        consumes = ["application/merge-patch+json"]
    )
    fun updateCustomer(@Size(max=200) @Parameter(description = "", required = true) @PathVariable("customerId") customerId: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) customer: Customer?): ResponseEntity<CustomerAccount> {
        return ResponseEntity(service.updateCustomer(customerId, customer), HttpStatus.valueOf(200))
    }
}
