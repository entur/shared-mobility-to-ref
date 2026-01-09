package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.ExtendExpiryTimeRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseOffersRequestDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseOffersRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchasePackageRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseProductRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.TravelDocuments
import no.entur.shared.mobility.to.ref.tomp200.dto.UseAssetRequestRequest
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.PurchaseController")
@Validated
@RequestMapping("\${api.base-path:}")
class PurchaseController(@Autowired(required = true) val service: PurchaseService) {

    @Operation(
        summary = "Confirm the purchase, before the rollbackExpiryTime has ended",
        operationId = "confirmPurchaseRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM).", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/confirm-purchase/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun confirmPurchaseRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) purchasePackageRequestRequest: PurchasePackageRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.confirmPurchaseRequest(acceptLanguage, authorization, purchasePackageRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Request additional time to complete the purchase",
        operationId = "extendExpiryTimeRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/extend-expiry-time/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun extendExpiryTimeRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) extendExpiryTimeRequestRequest: ExtendExpiryTimeRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.extendExpiryTimeRequest(acceptLanguage, authorization, extendExpiryTimeRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Retrieve travel documents",
        operationId = "getTravelDocuments",
        description = """Returns travel documents for a package or leg""",
        responses = [
            ApiResponse(responseCode = "200", description = "a response to obtain travel document (references)", content = [Content(schema = Schema(implementation = TravelDocuments::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/travel-documents/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun getTravelDocuments(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Parameter(description = "the identifier of a package", required = true) @Valid @RequestParam(value = "packageId", required = true) packageId: kotlin.String,@Parameter(description = "leg identifier") @Valid @RequestParam(value = "legId", required = false) legId: kotlin.String?): ResponseEntity<TravelDocuments> {
        return ResponseEntity(service.getTravelDocuments(acceptLanguage, authorization, packageId, legId), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Perform an purchase of offer(s)",
        operationId = "purchaseOffersRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM).", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/purchase-offers/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun purchaseOffersRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "the hash of the body, SHA-256 (\"SHA-256=3q2+7w==:\")", `in` = ParameterIn.HEADER) @RequestHeader(value = "digest", required = false) digest: kotlin.String?,@Parameter(description = "the public key of the sending party, can be used to validate the signed digest (it should deliver the digest)", `in` = ParameterIn.HEADER) @RequestHeader(value = "publicKey", required = false) publicKey: kotlin.String?,@Parameter(description = "the signed hash of complete response, using the private key, SHA-256 base64 encoded", `in` = ParameterIn.HEADER) @RequestHeader(value = "signedDigest", required = false) signedDigest: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) purchaseOffersRequestRequest: PurchaseOffersRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.purchaseOffersRequest(acceptLanguage, authorization, digest, publicKey, signedDigest, purchaseOffersRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Perform an purchase of a package",
        operationId = "purchasePackageRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM).", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/purchase-package/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun purchasePackageRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "the hash of the body, SHA-256 (\"SHA-256=3q2+7w==:\")", `in` = ParameterIn.HEADER) @RequestHeader(value = "digest", required = false) digest: kotlin.String?,@Parameter(description = "the public key of the sending party, can be used to validate the signed digest (it should deliver the digest)", `in` = ParameterIn.HEADER) @RequestHeader(value = "publicKey", required = false) publicKey: kotlin.String?,@Parameter(description = "the signed hash of complete response, using the private key, SHA-256 base64 encoded", `in` = ParameterIn.HEADER) @RequestHeader(value = "signedDigest", required = false) signedDigest: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) purchasePackageRequestRequest: PurchasePackageRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.purchasePackageRequest(acceptLanguage, authorization, digest, publicKey, signedDigest, purchasePackageRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Perform an purchase of a product",
        operationId = "purchaseProductRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM).", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/purchase-product/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun purchaseProductRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) purchaseProductRequestRequest: PurchaseProductRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.purchaseProductRequest(acceptLanguage, authorization, purchaseProductRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Rollback a purchase, before the rollbackExpiryTime has ended",
        operationId = "rollbackPurchaseRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/rollback-purchase/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun rollbackPurchaseRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) purchasePackageRequestRequest: PurchasePackageRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.rollbackPurchaseRequest(acceptLanguage, authorization, purchasePackageRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Request to use an asset",
        operationId = "useAssetRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM).", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = PurchaseOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/use-asset/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun useAssetRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) useAssetRequestRequest: UseAssetRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.useAssetRequest(acceptLanguage, authorization, useAssetRequestRequest), HttpStatus.valueOf(200))
    }
}
