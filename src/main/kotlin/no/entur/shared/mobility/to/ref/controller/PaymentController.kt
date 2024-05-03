package no.entur.shared.mobility.to.ref.controller

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
import no.entur.shared.mobility.to.ref.dto.Error
import no.entur.shared.mobility.to.ref.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.dto.JournalCategory
import no.entur.shared.mobility.to.ref.dto.JournalEntry
import no.entur.shared.mobility.to.ref.dto.JournalState
import no.entur.shared.mobility.to.ref.service.PaymentService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController
@Validated
@RequestMapping("\${api.base-path}")
class PaymentController(private val paymentService: PaymentService) {
    @Operation(
        operationId = "paymentIdClaimExtraCostsPost",
        description = """extra costs that the TO has to charge to the MP or vice versa.""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "journal entry received, will be processed (state = INVOICED)",
                content = [Content(schema = Schema(implementation = JournalEntry::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = """The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting 
                    |to give proper response. Unlike 401, the client's identity is known to the server.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @PostMapping(value = ["/payment/{id}/claim-extra-costs"], produces = ["application/json"], consumes = ["application/json"])
    fun paymentIdClaimExtraCostsPost(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "Booking identifier", required = true)
        @PathVariable("id")
        id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Parameter(description = "")
        @Valid
        @RequestBody(required = false)
        extraCosts: ExtraCosts?,
    ): JournalEntry {
        return paymentService.paymentIdClaimExtraCostsPost(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            id,
            addressedTo,
            extraCosts,
        )
    }

    @Operation(
        summary = "",
        operationId = "paymentJournalEntryGet",
        description = """Returns all the journal entries that should be paid per leg""",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "journal entries",
                content = [Content(array = ArraySchema(schema = Schema(implementation = JournalEntry::class)))],
            ),
            ApiResponse(
                responseCode = "400",
                description = """Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation 
                    |of error code.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = """Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
                    |That is, the client must authenticate itself to get the requested response.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = """The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting 
                    |to give proper response. Unlike 401, the client's identity is known to the server.""",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(name = "BasicAuth"),
            SecurityRequirement(name = "ApiKeyAuth"),
            SecurityRequirement(name = "OpenId"),
            SecurityRequirement(name = "BearerAuth"),
            SecurityRequirement(name = "OAuth", scopes = []),
        ],
    )
    @GetMapping(value = ["/payment/journal-entry"], produces = ["application/json"])
    fun paymentJournalEntryGet(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of 
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in 
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String,
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String,
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String?,
        @Parameter(description = "start of the selection")
        @Valid
        @RequestParam(value = "from", required = false)
        @DateTimeFormat(iso = ISO.DATE_TIME)
        from: OffsetDateTime?,
        @Parameter(description = "end of the selection")
        @Valid
        @RequestParam(value = "to", required = false)
        @DateTimeFormat(iso = ISO.DATE_TIME)
        to: OffsetDateTime?,
        @Parameter(description = "", schema = Schema(allowableValues = ["TO_INVOICE", "INVOICED"]))
        @Valid
        @RequestParam(value = "state", required = false)
        state: JournalState?,
        @Parameter(description = "")
        @Valid
        @RequestParam(value = "id", required = false)
        id: String?,
        @Parameter(
            description = "type of booking line (e.g. fare, addition costs, fines, ...)",
            schema =
                Schema(
                    allowableValues = [
                        "ALL",
                        "DAMAGE",
                        "LOSS",
                        "STOLEN",
                        "EXTRA_USAGE",
                        "REFUND",
                        "FINE",
                        "OTHER_ASSET_USED",
                        "CREDIT",
                        "VOUCHER",
                        "DEPOSIT",
                        "OTHER",
                        "FARE",
                    ],
                ),
        )
        @Valid
        @RequestParam(value = "category", required = false)
        category: JournalCategory?,
        @Min(0)
        @Parameter(description = "start of the selection", schema = Schema(defaultValue = "0"))
        @Valid
        @RequestParam(value = "offset", required = false, defaultValue = "0")
        offset: Int,
        @Min(0)
        @Parameter(description = "count of the selection")
        @Valid
        @RequestParam(value = "limit", required = false)
        limit: Int?,
    ): List<JournalEntry> {
        return paymentService.paymentJournalEntryGet(
            acceptLanguage,
            api,
            apiVersion,
            maasId,
            addressedTo,
            from,
            to,
            state,
            id,
            category,
            offset,
            limit,
        )
    }
}
