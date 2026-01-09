package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.AssetOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.LegOperationDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.LegOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.ProductOperationRequest
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.ExecutionController")
@Validated
@RequestMapping("\${api.base-path:}")
class ExecutionController(@Autowired(required = true) val service: ExecutionService) {

    @Operation(
        summary = "Perform an operation on a asset",
        operationId = "assetOperation",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "503", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LegOperationDefaultResponse::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LegOperationDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/{assetOperation}-asset/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun assetOperation(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "OPERATION on a specified asset", required = true) @PathVariable("assetOperation") assetOperation: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) assetOperationRequest: AssetOperationRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.assetOperation(acceptLanguage, authorization, assetOperation, assetOperationRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Perform an operation on a leg",
        operationId = "legOperation",
        description = """This endpoint must be used to alter the state of a LEG, using OPERATION requests.""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LegOperationDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/{legOperation}-leg/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun legOperation(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "OPERATION on a specified leg", required = true, schema = Schema(allowableValues = ["start", "pause", "resume", "end", "extend", "postpone"])) @PathVariable("legOperation") legOperation: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) legOperationRequest: LegOperationRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.legOperation(acceptLanguage, authorization, legOperation, legOperationRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Perform an operation on a product",
        operationId = "productOperation",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LegOperationDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/{productOperation}-product/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun productOperation(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "OPERATION on a specified product", required = true, schema = Schema(allowableValues = ["activate", "initiate-leg"])) @PathVariable("productOperation") productOperation: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) productOperationRequest: ProductOperationRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.productOperation(acceptLanguage, authorization, productOperation, productOperationRequest), HttpStatus.valueOf(200))
    }
}
