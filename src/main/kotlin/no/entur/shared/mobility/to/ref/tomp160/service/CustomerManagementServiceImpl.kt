package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.tomp160.controller.CustomerManagementService
import no.entur.shared.mobility.to.ref.tomp160.dto.Customer
import no.entur.shared.mobility.to.ref.tomp160.dto.CustomerAccount
import org.springframework.stereotype.Service

@Service
class CustomerManagementServiceImpl : CustomerManagementService {
    override fun customersIdDelete(
        acceptLanguage: String,
        id: String,
        notificationUrl: String?,
    ) {
        TODO("Not yet implemented")
    }

    override fun customersIdGet(
        acceptLanguage: String,
        id: String,
        notificationUrl: String?,
    ): CustomerAccount {
        TODO("Not yet implemented")
    }

    override fun customersIdPatch(
        acceptLanguage: String,
        id: String,
        notificationUrl: String?,
        body: Any?,
    ): CustomerAccount {
        TODO("Not yet implemented")
    }

    override fun customersPost(
        acceptLanguage: String,
        notificationUrl: String?,
        body: Customer?,
    ): CustomerAccount {
        TODO("Not yet implemented")
    }
}
