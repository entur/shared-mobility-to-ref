package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.SupportService
import no.entur.shared.mobility.to.ref.tomp200.dto.GetSupportTickets200Response
import no.entur.shared.mobility.to.ref.tomp200.dto.RequestSupportRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicket
import no.entur.shared.mobility.to.ref.tomp200.dto.SupportTicketStatus
import org.springframework.stereotype.Service

@Service("SupportServiceImpl200")
class SupportServiceImpl : SupportService {
    /**
     * GET /collections/support-tickets/items : Get for support tickets of a package/leg
     * returns support tickets in their current state, based on the parameters
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param packageId the identifier of a package (required)
     * @param legId leg identifier (required)
     * @param supportTicketStatus  (optional)
     * @return a list of tickets (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun getSupportTickets(
        acceptLanguage: String,
        authorization: String,
        packageId: String,
        legId: String,
        supportTicketStatus: SupportTicketStatus?,
    ): GetSupportTickets200Response {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/request-support/execution : Create a support ticket
     * creates a request for SUPPORT from end user via MP
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param requestSupportRequest  (optional)
     * @return support request acknowledged, the response contains a support ticket with a unique ID. Multiple support tickets can be created on one single leg. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun requestSupport(
        acceptLanguage: String,
        authorization: String,
        requestSupportRequest: RequestSupportRequest?,
    ): SupportTicket {
        TODO("Not yet implemented")
    }
}
