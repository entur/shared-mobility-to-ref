package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.tomp160.dto.Notification
import org.springframework.stereotype.Service

@Service("GeneralServiceTomp160")
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
