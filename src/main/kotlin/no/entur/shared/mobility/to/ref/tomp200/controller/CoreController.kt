package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.GetDataSourcesDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.CoreController")
@Validated
@RequestMapping("\${api.base-path:/tomp/v2}")
class CoreController(@Autowired(required = true) val service: CoreService) {

    @Operation(
        summary = "Retrieves all (external) datasources, used in requests and responses",
        operationId = "getDataSources",
        description = """Retrieves all datasources""",
        responses = [
            ApiResponse(responseCode = "200", description = "a list of datasources, the 'rel' contains the prefix to use in data (to create a URN), like 'gps:' for coordinates ('gps' is always allowed). when referring to an external datasource, the 'href' should be used to retrieve the related data.", content = [Content(array = ArraySchema(schema = Schema(implementation = Link::class)))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetDataSourcesDefaultResponse::class))]) ],
        security = [ SecurityRequirement(name = "OpenData") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/datasources/items"],
        produces = ["application/json"]
    )
    fun getDataSources(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String): ResponseEntity<List<Link>> {
        return ResponseEntity(service.getDataSources(acceptLanguage, authorization), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Get package details",
        operationId = "getPackage",
        description = """Retrieves package details""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = GetDataSourcesDefaultResponse::class))]) ],
        security = [ SecurityRequirement(name = "BearerAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/packages/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun getPackage(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Parameter(description = "the identifier of a package", required = true) @Valid @RequestParam(value = "packageId", required = true) packageId: kotlin.String): ResponseEntity<Package> {
        return ResponseEntity(service.getPackage(acceptLanguage, authorization, packageId), HttpStatus.valueOf(200))
    }
}
