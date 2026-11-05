package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import no.entur.shared.mobility.to.ref.tomp150.service.GeneralService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("GeneralControllerTomp150")
class GeneralController(
    private val service: GeneralService,
) : GeneralApi {
    // Optional endpoint
    override fun bookingsIdNotificationsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        notification: Notification?,
    ): ResponseEntity<Unit> {
        service.bookingsIdNotificationsPost(acceptLanguage, api, apiVersion, maasId, id, addressedTo, notification)
        return ResponseEntity.noContent().build()
    }
}
