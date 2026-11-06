package no.entur.shared.mobility.to.ref.tomp160.data

import no.entur.shared.mobility.to.ref.config.EndpointType
import no.entur.shared.mobility.to.ref.tomp160.dto.Endpoint
import no.entur.shared.mobility.to.ref.tomp160.dto.Endpoint.EventType
import no.entur.shared.mobility.to.ref.tomp160.dto.Endpoint.Method.GET
import no.entur.shared.mobility.to.ref.tomp160.dto.Endpoint.Method.POST
import no.entur.shared.mobility.to.ref.tomp160.dto.Endpoint.Status
import no.entur.shared.mobility.to.ref.tomp160.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.tomp160.dto.ProcessIdentifiers
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component("tomp160MetaProvider")
class MetaProvider(
    @Value("\${baseUrl}")
    val baseUrl: String,
) {
    fun allEndpointImplementations() =
        listOf(
            EndpointImplementation(
                version = "1.5.0",
                baseUrl = baseUrl,
                endpoints =
                    listOf(
                        Endpoint(method = GET, path = EndpointType.OPERATOR_META_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.PLANNING_OFFERS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ONE_STOP_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.LEGS_ID_EVENTS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.BOOKINGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.LEGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.SUPPORT_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.SUPPORT_ID_STATUS_GET.path, status = Status.NOT_IMPLEMENTED),
                    ),
                scenarios = listOf(),
                processIdentifiers = ProcessIdentifiers(listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf()),
            ),
        )

    fun bikeOperatorEndpointImplementations() =
        listOf(
            EndpointImplementation(
                version = "1.5.0",
                baseUrl = baseUrl,
                endpoints =
                    listOf(
                        Endpoint(method = GET, path = EndpointType.BOOKINGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ONE_STOP_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.LEGS_ID_EVENTS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.SET_IN_USE,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.PAUSE,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.START_FINISHING,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.FINISH,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.CANCEL,
                        ),
                        Endpoint(method = GET, path = EndpointType.LEGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_META_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.PAYMENT_JOURNAL_ENTRY_GET.path, status = Status.IMPLEMENTED),
                    ),
                scenarios = listOf(),
                processIdentifiers = ProcessIdentifiers(listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf()),
            ),
        )

    fun scooterOperatorEndpointImplementations() =
        listOf(
            EndpointImplementation(
                version = "1.5.0",
                baseUrl = baseUrl,
                endpoints =
                    listOf(
                        Endpoint(method = GET, path = EndpointType.BOOKINGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ONE_STOP_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.LEGS_ID_EVENTS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.SET_IN_USE,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.PAUSE,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.START_FINISHING,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.FINISH,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_EVENTS_POST.path,
                            status = Status.IMPLEMENTED,
                            eventType = EventType.CANCEL,
                        ),
                        Endpoint(method = GET, path = EndpointType.LEGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_META_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.PAYMENT_JOURNAL_ENTRY_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.SUPPORT_POST.path, status = Status.IMPLEMENTED),
                    ),
                scenarios = listOf(),
                processIdentifiers = ProcessIdentifiers(listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf()),
            ),
        )
}
