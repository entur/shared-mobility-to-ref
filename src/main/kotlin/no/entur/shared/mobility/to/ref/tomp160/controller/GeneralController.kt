package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.config.TompEndpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.Notification
import no.entur.shared.mobility.to.ref.tomp160.service.GeneralService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController("GeneralControllerTomp160")
class GeneralController(
    private val service: GeneralService,
) : GeneralApi {
    @TompEndpoint(optional = true)
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
