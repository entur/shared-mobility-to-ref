package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.Collection
import no.entur.shared.mobility.to.ref.tomp200.dto.Collections
import no.entur.shared.mobility.to.ref.tomp200.dto.Conformance
import no.entur.shared.mobility.to.ref.tomp200.dto.LandingPage
import no.entur.shared.mobility.to.ref.tomp200.dto.LandingPageDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Process
import no.entur.shared.mobility.to.ref.tomp200.dto.ProcessList
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.DiscoveryController")
@Validated
@RequestMapping("\${api.base-path:}")
class DiscoveryController(@Autowired(required = true) val service: DiscoveryService) {

    @Operation(
        summary = "describe the feature collection with id `collectionId`",
        operationId = "describeCollection",
        description = """a (machine or human) readable description of this collection""",
        responses = [
            ApiResponse(responseCode = "200", description = "description of data delivered by this collection", content = [Content(schema = Schema(implementation = Collection::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/{collectionId}"],
        produces = ["application/json", "text/html"]
    )
    fun describeCollection(@Parameter(description = "local identifier of a collection", required = true, schema = Schema(allowableValues = ["packages", "offers", "assets", "ancillaries", "support-tickets", "payments", "refund-options"])) @PathVariable("collectionId") collectionId: kotlin.String): ResponseEntity<Collection> {
        return ResponseEntity(service.describeCollection(collectionId), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "the feature collections in the dataset",
        operationId = "getCollections",
        description = """returns a collection of available collection (like offers, packages, legs, support-requests and payments)""",
        responses = [
            ApiResponse(responseCode = "200", description = "A list of available collections", content = [Content(schema = Schema(implementation = Collections::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections"],
        produces = ["application/json"]
    )
    fun getCollections(): ResponseEntity<Collections> {
        return ResponseEntity(service.getCollections(), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "API conformance definition",
        operationId = "getConformanceDeclaration",
        description = """A list of all conformance classes specified in a standard that the server conforms to.""",
        responses = [
            ApiResponse(responseCode = "200", description = "The URIs of all conformance classes supported by the server.  To support \"generic\" clients that want to access multiple OGC API Features implementations - and not \"just\" a specific API / server, the server declares the conformance classes it implements and conforms to.", content = [Content(schema = Schema(implementation = Conformance::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/conformance"],
        produces = ["application/json", "text/html"]
    )
    fun getConformanceDeclaration(@Parameter(description = "The optional f parameter indicates the output format that the server shall provide as part of the response document.  The default format is JSON.", schema = Schema(allowableValues = ["json", "html"], defaultValue = "json")) @Valid @RequestParam(value = "f", required = false, defaultValue = "json") f: kotlin.String): ResponseEntity<Conformance> {
        return ResponseEntity(service.getConformanceDeclaration(f), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "retrieve a process description",
        operationId = "getProcessDescription",
        description = """The process description contains information about inputs and outputs and a link to the execution-endpoint for the process. The Core does not mandate the use of a specific process description to specify the interface of a process. That said, the Core requirements class makes the following _recommendation_ implementations SHOULD consider supporting the OGC process description. For more information, see <a href="https://docs.ogc.org/is/18-062/18-062.html#sc_process_description">Section 7.10</a>.""",
        responses = [
            ApiResponse(responseCode = "200", description = "A process description.", content = [Content(schema = Schema(implementation = Process::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/processes/{processID}"],
        produces = ["application/json"]
    )
    fun getProcessDescription(@Parameter(description = "", required = true, schema = Schema(allowableValues = ["search-offers", "update-traveller", "update-travel-specification", "remove-offer", "assign-asset", "assign-ancillary", "purchase-offer", "release-package", "purchase-package", "confirm-purchase", "rollback-purchase", "extend-expiry-time", "start-leg", "pause-leg", "resume-leg", "end-leg", "postpone-leg", "extend-leg", "request-support", "cancel-package", "claim-redress-option", "confirm-redress-option", "refund-deposit", "confirm-payment"])) @PathVariable("processID") processID: kotlin.String): ResponseEntity<Process> {
        return ResponseEntity(service.getProcessDescription(processID), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "retrieve the list of available processes",
        operationId = "getProcesses",
        description = """The list of processes contains a summary of each process the OGC API - Processes offers, including the link to a more detailed description of the process. For more information, see <a href="https://docs.ogc.org/is/18-062/18-062.html#sc_process_list">Section 7.9</a>.""",
        responses = [
            ApiResponse(responseCode = "200", description = "Information about the available processes", content = [Content(schema = Schema(implementation = ProcessList::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/processes"],
        produces = ["application/json"]
    )
    fun getProcesses(): ResponseEntity<ProcessList> {
        return ResponseEntity(service.getProcesses(), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Landing page",
        operationId = "landingPage",
        description = """Gives a (technical & human readable) output describing how this API must be used. If the parameter f=html is supplied, a human readable page must be responded.""",
        responses = [
            ApiResponse(responseCode = "200", description = "The reponse containing a landing page", content = [Content(schema = Schema(implementation = LandingPage::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/"],
        produces = ["application/json", "text/html"]
    )
    fun landingPage(@Parameter(description = "The optional f parameter indicates the output format that the server shall provide as part of the response document.  The default format is JSON.", schema = Schema(allowableValues = ["json", "html"], defaultValue = "json")) @Valid @RequestParam(value = "f", required = false, defaultValue = "json") f: kotlin.String): ResponseEntity<LandingPage> {
        return ResponseEntity(service.landingPage(f), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "This document",
        operationId = "openApi",
        description = """This document""",
        responses = [
            ApiResponse(responseCode = "200", description = "General Success response."),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = LandingPageDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/api"],
        produces = ["application/json"]
    )
    fun openApi(@Parameter(description = "The optional f parameter indicates the output format that the server shall provide as part of the response document.  The default format is JSON.", schema = Schema(allowableValues = ["json", "html"], defaultValue = "json")) @Valid @RequestParam(value = "f", required = false, defaultValue = "json") f: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(service.openApi(f), HttpStatus.valueOf(200))
    }
}
