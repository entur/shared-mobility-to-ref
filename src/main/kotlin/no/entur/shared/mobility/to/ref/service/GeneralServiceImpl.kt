package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.controller.GeneralService
import no.entur.shared.mobility.to.ref.dto.Notification
import org.springframework.stereotype.Service

@Service
class GeneralServiceImpl : GeneralService {
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
