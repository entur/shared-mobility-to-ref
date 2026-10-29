package no.entur.shared.mobility.to.ref.tomp150.controller.required

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import no.entur.shared.mobility.to.ref.tomp150.controller.OperatorInformationService
import no.entur.shared.mobility.to.ref.tomp150.dto.EndpointImplementation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController("no.entur.shared.mobility.to.ref.tomp150.controller.required.OperatorInformationController")
@Validated
@RequestMapping("\${api.base-path:}")
class OperatorInformationController(@Autowired(required = true) val service: OperatorInformationService) {

    @Operation(
        summary = "describes the running implementations",
        operationId = "operatorMetaGet",
        description = """all versions that are implemented on this url, are described in the result of this endpoint. In contains all versions and per version the endpoints, their status and the supported scenarios.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(array = ArraySchema(schema = Schema(implementation = EndpointImplementation::class)))]
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/operator/meta"],
        produces = ["application/json"]
    )
    @Hidden
    fun operatorMetaGet(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: String?
    ): ResponseEntity<List<EndpointImplementation>> {
        return ResponseEntity(service.operatorMetaGet(acceptLanguage, maasId, addressedTo), HttpStatus.valueOf(200))
    }
}
