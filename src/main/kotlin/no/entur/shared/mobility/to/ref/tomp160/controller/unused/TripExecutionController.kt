package no.entur.shared.mobility.to.ref.tomp160.controller.unused

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import no.entur.shared.mobility.to.ref.tomp160.controller.TripExecutionService
import no.entur.shared.mobility.to.ref.tomp160.dto.Asset
import no.entur.shared.mobility.to.ref.tomp160.dto.ConfirmationRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import no.entur.shared.mobility.to.ref.tomp160.dto.Leg
import no.entur.shared.mobility.to.ref.tomp160.dto.LegProgress
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("no.entur.shared.mobility.to.ref.tomp160.controller.unused.TripExecutionController")
@Validated
@RequestMapping("\${api.base-path:/tomp160}")
class TripExecutionController(@Autowired(required = true) val service: TripExecutionService) {

    @Operation(
        summary = "",
        operationId = "legsIdAncillariesCategoryNumberDelete",
        description = """an ancillary (or amount) is removed to the leg.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "operation successful",
                content = [Content(schema = Schema(implementation = Leg::class))]
            ),
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/legs/{id}/ancillaries/{category}/{number}"],
        produces = ["application/json"]
    )
    @Hidden
    fun legsIdAncillariesCategoryNumberDelete(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "ancillary category", required = true) @PathVariable("category") category: String,
        @Parameter(description = "ancillary number", required = true) @PathVariable("number") number: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?
    ): ResponseEntity<Leg> {
        return ResponseEntity(
            service.legsIdAncillariesCategoryNumberDelete(
                acceptLanguage,
                api,
                apiVersion,
                maasId,
                id,
                category,
                number,
                addressedTo
            ), HttpStatus.valueOf(200)
        )
    }

    @Operation(
        summary = "",
        operationId = "legsIdAncillariesCategoryNumberPost",
        description = """a new ancillary is added to the leg.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "operation successful",
                content = [Content(schema = Schema(implementation = Leg::class))]
            ),
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/legs/{id}/ancillaries/{category}/{number}"],
        produces = ["application/json"]
    )
    @Hidden
    fun legsIdAncillariesCategoryNumberPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "ancillary category", required = true) @PathVariable("category") category: String,
        @Parameter(description = "ancillary number", required = true) @PathVariable("number") number: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?
    ): ResponseEntity<Leg> {
        return ResponseEntity(
            service.legsIdAncillariesCategoryNumberPost(
                acceptLanguage,
                api,
                apiVersion,
                maasId,
                id,
                category,
                number,
                addressedTo
            ), HttpStatus.valueOf(200)
        )
    }

    @Operation(
        summary = "",
        operationId = "legsIdAvailableAssetsGet",
        description = """Returns a list of available assets for the given leg. These assets can be used to POST to /legs/{id}/asset if no specific asset is assigned by the TO. If picking an asset is not allowed for this booking, or one already has been, 403 should be returned. If the booking is unknown, 404 should be returned. See (4.7) in the process flow. - trip execution""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Available assets for the leg. If no suitable assets are found an empty array is to be returned.",
                content = [Content(array = ArraySchema(schema = Schema(implementation = Asset::class)))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/legs/{id}/available-assets"],
        produces = ["application/json"]
    )
    @Hidden
    fun legsIdAvailableAssetsGet(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?,
        @Min(0) @Parameter(
            description = "start of the selection",
            schema = Schema(defaultValue = "0")
        ) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: Int,
        @Min(0) @Parameter(description = "count of the selection") @Valid @RequestParam(
            value = "limit",
            required = false
        ) limit: Int?
    ): ResponseEntity<List<Asset>> {
        return ResponseEntity(
            service.legsIdAvailableAssetsGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo, offset, limit),
            HttpStatus.valueOf(200)
        )
    }

    @Operation(
        summary = "",
        operationId = "legsIdConfirmationPost",
        description = """The TO can request confirmation for certain actions from the MP.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "operation successful",
                content = [Content(schema = Schema(implementation = Boolean::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/legs/{id}/confirmation"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @Hidden
    fun legsIdConfirmationPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "") @Valid @RequestBody(required = false) confirmationRequest: ConfirmationRequest?
    ): ResponseEntity<Boolean> {
        return ResponseEntity(
            service.legsIdConfirmationPost(acceptLanguage, api, apiVersion, id, confirmationRequest),
            HttpStatus.valueOf(200)
        )
    }


    @Operation(
        summary = "",
        operationId = "legsIdProgressGet",
        description = """Monitors the current location of the asset and duration & distance of the leg (see (4.7) in process flow)""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "operation successful",
                content = [Content(schema = Schema(implementation = LegProgress::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/legs/{id}/progress"],
        produces = ["application/json"]
    )
    @Hidden
    fun legsIdProgressGet(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?,
        @Parameter(
            description = "Specifies if only the location should be returned",
            schema = Schema(defaultValue = "false")
        ) @Valid @RequestParam(value = "location-only", required = false, defaultValue = "false") locationOnly: Boolean
    ): ResponseEntity<LegProgress> {
        return ResponseEntity(
            service.legsIdProgressGet(acceptLanguage, api, apiVersion, maasId, id, addressedTo, locationOnly),
            HttpStatus.valueOf(200)
        )
    }

    @Operation(
        summary = "",
        operationId = "legsIdProgressPost",
        description = """Monitors the current location of the asset and duration & distance of the leg""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/legs/{id}/progress"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @Hidden
    fun legsIdProgressPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) legProgress: LegProgress?
    ): ResponseEntity<Unit> {
        return ResponseEntity(
            service.legsIdProgressPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, legProgress),
            HttpStatus.valueOf(204)
        )
    }

    @Operation(
        summary = "",
        operationId = "legsIdPut",
        description = """Updates the leg with new information. Only used for updates about execution to the MP. To request changes as the MP, the booking should be updated and the TO can accept the change and update the leg in turn.""",
        responses = [
            ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),
            ApiResponse(
                responseCode = "400",
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."
            )],
        security = [SecurityRequirement(name = "BasicAuth"), SecurityRequirement(name = "ApiKeyAuth"), SecurityRequirement(name = "OpenId"), SecurityRequirement(
            name = "BearerAuth"
        ), SecurityRequirement(name = "OAuth", scopes = [])]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/legs/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @Hidden
    fun legsIdPut(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "Api", required = true) api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true) @RequestHeader(
            value = "Api-Version",
            required = true
        ) apiVersion: String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true
        ) @RequestHeader(value = "maas-id", required = true) maasId: String,
        @Parameter(description = "Leg identifier", required = true) @PathVariable("id") id: String,
        @Parameter(description = "changed leg (e.g. with different duration or destination)", required = true) @Valid @RequestBody leg: Leg,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER) @RequestHeader(
            value = "addressed-to",
            required = false
        ) addressedTo: String?
    ): ResponseEntity<Unit> {
        return ResponseEntity(service.legsIdPut(acceptLanguage, api, apiVersion, maasId, id, leg, addressedTo), HttpStatus.valueOf(204))
    }
}
