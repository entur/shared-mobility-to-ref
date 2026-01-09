package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.CancelPackageOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.ConfirmPaymentEntryRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.GetRedressOptionsDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentCategory
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentState
import no.entur.shared.mobility.to.ref.tomp200.dto.Payments
import no.entur.shared.mobility.to.ref.tomp200.dto.RedressOptionRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.RedressOptions
import no.entur.shared.mobility.to.ref.tomp200.dto.RefundDepositRequestRequest
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.AfterSalesController")
@Validated
@RequestMapping("\${api.base-path:}")
class AfterSalesController(@Autowired(required = true) val service: AfterSalesService) {

    @Operation(
        summary = "Cancel a package in confirmed state for (technical issues).",
        operationId = "cancelPackageOperation",
        description = """Cancel this package. This endpoint is only there to correct (technical) issues.<br> Normally, after purchase, you have to request redress options, claim it and confirm the claim.<br> <br> Before purchase you release a package.<br> During the purchase you rollback a package.<br>""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/cancel-package/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun cancelPackageOperation(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) cancelPackageOperationRequest: CancelPackageOperationRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.cancelPackageOperation(acceptLanguage, authorization, cancelPackageOperationRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Confirm a financial transaction",
        operationId = "confirmPaymentEntry",
        description = """The MP (reseller) confirms a payment""",
        responses = [
            ApiResponse(responseCode = "204", description = "the payment is acknowledged"),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/confirm-payment/execution"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun confirmPaymentEntry(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) confirmPaymentEntryRequest: ConfirmPaymentEntryRequest?): ResponseEntity<Unit> {
        return ResponseEntity(service.confirmPaymentEntry(acceptLanguage, authorization, confirmPaymentEntryRequest), HttpStatus.valueOf(204))
    }

    @Operation(
        summary = "",
        operationId = "confirmRedressOptionRequest",
        description = """confirm the claimed redress option""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/confirm-redress-option/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun confirmRedressOptionRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) redressOptionRequestRequest: RedressOptionRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.confirmRedressOptionRequest(acceptLanguage, authorization, redressOptionRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Retrieve financial details",
        operationId = "getPaymentOverview",
        description = """Returns all the JOURNAL ENTRIES that should be paid""",
        responses = [
            ApiResponse(responseCode = "200", description = "journal entries", content = [Content(schema = Schema(implementation = Payments::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/payments/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun getPaymentOverview(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Min(1) @Max(10000) @Parameter(description = "The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum = 1. Maximum = 10000. Default = 100.", schema = Schema(defaultValue = "100")) @Valid @RequestParam(value = "limit", required = false, defaultValue = "100") limit: kotlin.Int,@Min(0)@Parameter(description = "The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default = 0.", schema = Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: kotlin.Int,@Parameter(description = "start of the selection") @Valid @RequestParam(value = "startTime", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) startTime: java.time.OffsetDateTime?,@Parameter(description = "end of the selection") @Valid @RequestParam(value = "endTime", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) endTime: java.time.OffsetDateTime?,@Parameter(description = "", schema = Schema(allowableValues = ["TO_INVOICE", "INVOICING", "INVOICED"])) @Valid @RequestParam(value = "invoiceState", required = false) invoiceState: PaymentState?,@Size(max=200) @Parameter(description = "") @Valid @RequestParam(value = "package", required = false) `package`: kotlin.String?,@Parameter(description = "type of PAYMENT DETAIL (e.g. fare, addition costs, fines, ...)", schema = Schema(allowableValues = ["ALL", "DAMAGE", "LOSS", "STOLEN", "EXTRA_USAGE", "REFUND", "REBATE", "REIMBURSEMENT", "FINE", "OTHER_ASSET_USED", "CREDIT", "VOUCHER", "DEPOSIT", "OTHER", "FARE"])) @Valid @RequestParam(value = "category", required = false) category: PaymentCategory?,@Parameter(description = "the identity of the reseller. Only to be used in a PSP (externalized payments) setup.", `in` = ParameterIn.HEADER) @RequestHeader(value = "onBehalveOf", required = false) onBehalveOf: kotlin.String?): ResponseEntity<Payments> {
        return ResponseEntity(service.getPaymentOverview(acceptLanguage, authorization, limit, offset, startTime, endTime, invoiceState, `package`, category, onBehalveOf), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Retrieve redress options for a guarantee",
        operationId = "getRedressOptions",
        description = """Returns possible refund or replacement options for a guarantee""",
        responses = [
            ApiResponse(responseCode = "200", description = "a list of redress options", content = [Content(schema = Schema(implementation = RedressOptions::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/redress-options/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun getRedressOptions(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Size(max=200) @Parameter(description = "the id of the package that contains a purchased product", required = true) @Valid @RequestParam(value = "packageId", required = true) packageId: kotlin.String,@Size(max=200) @Parameter(description = "the offer with a guarantee") @Valid @RequestParam(value = "offerId", required = false) offerId: kotlin.String?,@Size(max=200) @Parameter(description = "the offer with a guarantee") @Valid @RequestParam(value = "legId", required = false) legId: kotlin.String?,@Size(max=75) @Parameter(description = "the unfulfilled guarantee") @Valid @RequestParam(value = "guaranteeId", required = false) guaranteeId: kotlin.String?,@Size(max=200) @Parameter(description = "to request redresses for a single traveller") @Valid @RequestParam(value = "travellerId", required = false) travellerId: kotlin.String?,@Size(max=200) @Parameter(description = "to request redresses for a not-used ancillary or ancillary to remove") @Valid @RequestParam(value = "ancillaryId", required = false) ancillaryId: kotlin.String?,@Parameter(description = "reference to support ticket(s) to claim redress options") @Valid @RequestParam(value = "supportTicket", required = false) supportTicket: kotlin.String?): ResponseEntity<RedressOptions> {
        return ResponseEntity(service.getRedressOptions(acceptLanguage, authorization, packageId, offerId, legId, guaranteeId, travellerId, ancillaryId, supportTicket), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "",
        operationId = "redressOptionRequest",
        description = """redress options must be claimed & confirmed""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/claim-redress-option/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun redressOptionRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) redressOptionRequestRequest: RedressOptionRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.redressOptionRequest(acceptLanguage, authorization, redressOptionRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Request to refund a deposit",
        operationId = "refundDepositRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "204", description = "the payment is acknowledged"),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetRedressOptionsDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/refund-deposit/execution"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun refundDepositRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) refundDepositRequestRequest: RefundDepositRequestRequest?): ResponseEntity<Unit> {
        return ResponseEntity(service.refundDepositRequest(acceptLanguage, authorization, refundDepositRequestRequest), HttpStatus.valueOf(204))
    }
}
