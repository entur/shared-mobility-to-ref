package no.entur.shared.mobility.to.ref.tomp150.data

import no.entur.shared.mobility.to.ref.config.EndpointType
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint.EventType
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint.Method.DELETE
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint.Method.GET
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint.Method.POST
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint.Method.PUT
import no.entur.shared.mobility.to.ref.tomp150.dto.Endpoint.Status
import no.entur.shared.mobility.to.ref.tomp150.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.tomp150.dto.ProcessIdentifiers
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
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
                        Endpoint(method = GET, path = EndpointType.BOOKINGS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ID_EVENTS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.BOOKINGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.BOOKINGS_ID_NOTIFICATIONS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ID_NOTIFICATIONS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = PUT, path = EndpointType.BOOKINGS_ID_PUT.path, status = Status.IMPLEMENTED),
                        Endpoint(method = DELETE, path = EndpointType.BOOKINGS_ID_SUBSCRIPTION_DELETE.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ID_SUBSCRIPTION_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_ONE_STOP_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.BOOKINGS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(
                            method = DELETE,
                            path = EndpointType.LEGS_ID_ANCILLARIES_CATEGORY_NUMBER_DELETE.path,
                            status = Status.IMPLEMENTED,
                        ),
                        Endpoint(
                            method = POST,
                            path = EndpointType.LEGS_ID_ANCILLARIES_CATEGORY_NUMBER_POST.path,
                            status = Status.IMPLEMENTED,
                        ),
                        Endpoint(method = GET, path = EndpointType.LEGS_ID_AVAILABLE_ASSETS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.LEGS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.LEGS_ID_EVENTS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.LEGS_ID_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.LEGS_ID_PROGRESS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.LEGS_ID_PROGRESS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = PUT, path = EndpointType.LEGS_ID_PUT.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_PING_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_META_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_STATIONS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_AVAILABLE_ASSETS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_ALERTS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_OPERATING_CALENDAR_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_OPERATING_HOURS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_INFORMATION_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_PRICING_PLANS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.OPERATOR_REGIONS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.PAYMENT_ID_CLAIM_EXTRA_COSTS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.PAYMENT_JOURNAL_ENTRY_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.PLANNING_INQUIRIES_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.PLANNING_OFFERS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.PLANNINGS_POST.path, status = Status.IMPLEMENTED),
                        Endpoint(method = GET, path = EndpointType.SUPPORT_ID_STATUS_GET.path, status = Status.IMPLEMENTED),
                        Endpoint(method = POST, path = EndpointType.SUPPORT_POST.path, status = Status.IMPLEMENTED),
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
