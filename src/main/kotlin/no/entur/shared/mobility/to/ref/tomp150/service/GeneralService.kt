package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.springframework.stereotype.Service

@Service("GeneralServiceTomp150")
class GeneralService {
    fun bookingsIdNotificationsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        notification: Notification?,
    ): Unit = throw NotImplementedError()
}
