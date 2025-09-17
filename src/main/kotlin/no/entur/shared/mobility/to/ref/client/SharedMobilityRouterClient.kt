package no.entur.shared.mobility.to.ref.client

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import jakarta.validation.Valid
import no.entur.shared.mobility.to.ref.client.interceptor.AuthorizationConfig
import no.entur.shared.mobility.to.ref.tomp160.dto.Leg
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@Component
@FeignClient("router", configuration = [AuthorizationConfig::class])
interface SharedMobilityRouterClient {
    @PostMapping(value = ["tomp/1_5_0/legs/{id}/events"], produces = ["application/json"], consumes = ["application/json"])
    fun legsIdEventsPost150(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String = "No_nb",
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String = "TOMP",
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String = "1.5.0",
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String = "entur:maas:bysykkeloperator",
        @Parameter(description = "Leg identifier", required = true)
        @PathVariable("id")
        id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String,
        @Valid
        @RequestBody(required = false)
        legEvent: no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent?,
    ): no.entur.shared.mobility.to.ref.tomp150.dto.Leg

    @PostMapping(value = ["tomp/1_6_0/legs/{id}/events"], produces = ["application/json"], consumes = ["application/json"])
    fun legsIdEventsPost160(
        @Parameter(
            description = """A list of the languages/localizations the user would like to see the results in. For user privacy and ease of
                |use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in
                |operator/information""",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Accept-Language", required = true)
        acceptLanguage: String = "No_nb",
        @Parameter(
            description = "API description, can be TOMP or maybe other (specific/derived) API definitions",
            `in` = ParameterIn.HEADER,
            required = true,
        )
        @RequestHeader(value = "Api", required = true)
        api: String = "TOMP",
        @Parameter(description = "Version of the API.", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "Api-Version", required = true)
        apiVersion: String = "1.6.0",
        @Parameter(description = "The ID of the sending maas operator", `in` = ParameterIn.HEADER, required = true)
        @RequestHeader(value = "maas-id", required = true)
        maasId: String = "entur:maas:bysykkeloperator",
        @Parameter(description = "Leg identifier", required = true)
        @PathVariable("id")
        id: String,
        @Parameter(description = "The ID of the maas operator that has to receive this message", `in` = ParameterIn.HEADER)
        @RequestHeader(value = "addressed-to", required = false)
        addressedTo: String,
        @Valid
        @RequestBody(required = false)
        legEvent: LegEvent?,
    ): Leg
}
