package no.entur.shared.mobility.to.ref.controller

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import no.entur.shared.mobility.to.ref.dto.Error
import no.entur.shared.mobility.to.ref.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.dto.JournalCategory
import no.entur.shared.mobility.to.ref.dto.JournalEntry
import no.entur.shared.mobility.to.ref.dto.JournalState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import kotlin.collections.List

@RestController("no.entur.shared.mobility.to.ref.controller.PaymentController")
@Validated
@RequestMapping("\${api.base-path:/bike}")
class PaymentController(
    @Autowired(required = true) val service: PaymentService,
) {
    @Operation(
        summary = "",
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
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ), SecurityRequirement(
                name = "ApiKeyAuth",
            ), SecurityRequirement(
                name = "OpenId",
            ), SecurityRequirement(name = "BearerAuth"), SecurityRequirement(name = "OAuth", scopes = [ ]),
        ],
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/payment/{id}/claim-extra-costs"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun paymentIdClaimExtraCostsPost(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api", required = true) api: kotlin.String,
        @Parameter(
            description = "Version of the API.",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,
        @Parameter(description = "Booking identifier", required = true) @PathVariable("id") id: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(description = "") @Valid @RequestBody(required = false) extraCosts: ExtraCosts?,
    ): ResponseEntity<JournalEntry> =
        ResponseEntity(
            service.paymentIdClaimExtraCostsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, extraCosts),
            HttpStatus.valueOf(200),
        )

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
                description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "401",
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
            ApiResponse(
                responseCode = "403",
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.",
                content = [Content(schema = Schema(implementation = Error::class))],
            ),
        ],
        security = [
            SecurityRequirement(
                name = "BasicAuth",
            ), SecurityRequirement(
                name = "ApiKeyAuth",
            ), SecurityRequirement(
                name = "OpenId",
            ), SecurityRequirement(name = "BearerAuth"), SecurityRequirement(name = "OAuth", scopes = [ ]),
        ],
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/payment/journal-entry"],
        produces = ["application/json"],
    )
    fun paymentJournalEntryGet(
        @Parameter(
            description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api", required = true) api: kotlin.String,
        @Parameter(
            description = "Version of the API.",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "Api-Version", required = true) apiVersion: kotlin.String,
        @Parameter(
            description = "The ID of the sending maas operator",
            `in` = ParameterIn.HEADER,
            required = true,
        ) @RequestHeader(value = "maas-id", required = true) maasId: kotlin.String,
        @Parameter(
            description = "The ID of the maas operator that has to receive this message",
            `in` = ParameterIn.HEADER,
        ) @RequestHeader(value = "addressed-to", required = false) addressedTo: kotlin.String?,
        @Parameter(
            description = "start of the selection",
        ) @Valid @RequestParam(
            value = "from",
            required = false,
        ) @org.springframework.format.annotation.DateTimeFormat(
            iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME,
        ) from: java.time.OffsetDateTime?,
        @Parameter(
            description = "end of the selection",
        ) @Valid @RequestParam(
            value = "to",
            required = false,
        ) @org.springframework.format.annotation.DateTimeFormat(
            iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME,
        ) to: java.time.OffsetDateTime?,
        @Parameter(
            description = "",
            schema = Schema(allowableValues = ["TO_INVOICE", "INVOICED"]),
        ) @Valid @RequestParam(value = "state", required = false) state: JournalState?,
        @Parameter(description = "") @Valid @RequestParam(value = "id", required = false) id: kotlin.String?,
        @Parameter(
            description = "type of booking line (e.g. fare, addition costs, fines, ...)",
            schema =
                Schema(
                    allowableValues = ["ALL", "DAMAGE", "LOSS", "STOLEN", "EXTRA_USAGE", "REFUND", "FINE", "OTHER_ASSET_USED", "CREDIT", "VOUCHER", "DEPOSIT", "OTHER", "FARE"],
                ),
        ) @Valid @RequestParam(value = "category", required = false) category: JournalCategory?,
        @Min(
            0,
        )@Parameter(
            description = "start of the selection",
            schema = Schema(defaultValue = "0"),
        ) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: kotlin.Int,
        @Min(0)@Parameter(description = "count of the selection") @Valid @RequestParam(value = "limit", required = false) limit:
            kotlin.Int?,
    ): ResponseEntity<List<JournalEntry>> =
        ResponseEntity(
            service.paymentJournalEntryGet(
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
            ),
            HttpStatus.valueOf(200),
        )
}
