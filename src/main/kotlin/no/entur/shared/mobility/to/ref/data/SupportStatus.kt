package no.entur.shared.mobility.to.ref.data

import no.entur.shared.mobility.to.ref.dto.SupportStatus
import java.time.OffsetDateTime

val supportStatus
    get() =
        SupportStatus(
            id = "string",
            supportType = SupportStatus.SupportType.BROKEN_DOWN,
            location = place,
            time = OffsetDateTime.now(),
            priority = SupportStatus.Priority.ERROR_CANNOT_CONTINUE,
            contactInformationEndUser = "string",
            comment = "string",
            requestedResponseTime = 0.0,
            urls = listOf("string"),
        )
