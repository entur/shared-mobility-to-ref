package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.CustomerManagementService
import no.entur.shared.mobility.to.ref.tomp200.dto.Customer
import no.entur.shared.mobility.to.ref.tomp200.dto.CustomerAccount
import org.springframework.stereotype.Service

@Service("CustomerManagementServiceImpl200")
class CustomerManagementServiceImpl : CustomerManagementService {
    /**
     * POST /collections/customers/items : Create a TO CUSTOMER ACCOUNT for the customer
     * creates a CUSTOMER ACCOUNT that can be later used for purchase of a trip
     *
     * @param acceptLanguage  (required)
     * @param customer  (optional)
     * @return Customer Account (status code 201)
     *         or Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun createCustomer(
        acceptLanguage: String,
        customer: Customer?,
    ): CustomerAccount {
        TODO("Not yet implemented")
    }

    /**
     * DELETE /collections/customers/items/{customerId} : Delete the CUSTOMER ACCOUNT from the TO system.
     * The timeline of deletion of the customer account depends on the TO processes, it could be instant, weeks or months.
     *
     * @param customerId  (required)
     * @return CUSTOMER ACCOUNT deleted successfully (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun deleteCustomer(customerId: String) {
        TODO("Not yet implemented")
    }

    /**
     * GET /collections/customers/items/{customerId} : Get the customer account from the TO system
     *
     * @param customerId  (required)
     * @return Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun getCustomer(customerId: String): CustomerAccount {
        TODO("Not yet implemented")
    }

    /**
     * PATCH /collections/customers/items/{customerId} : Update the CUSTOMER ACCOUNT on the TO system
     * updates the defined fields of the CUSTOMER ACCOUNT.&lt;br&gt;
     *
     * @param customerId  (required)
     * @param customer  (optional)
     * @return Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun updateCustomer(
        customerId: String,
        customer: Customer?,
    ): CustomerAccount {
        TODO("Not yet implemented")
    }
}
