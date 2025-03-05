package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.tomp150.controller.GeneralApiService
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.springframework.stereotype.Service

@Service
class GeneralService : GeneralApiService {
    override fun bookingsIdNotificationsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): List<Notification> = throw NotImplementedError()

    override fun bookingsIdNotificationsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        notification: Notification?,
    ): Unit = throw NotImplementedError()
}
