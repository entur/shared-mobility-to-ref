package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.CreateCustomerDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Customer
import no.entur.shared.mobility.to.ref.tomp200.dto.CustomerAccount

interface CustomerManagementService {

    /**
     * POST /collections/customers/items : Create a TO CUSTOMER ACCOUNT for the customer
     * creates a CUSTOMER ACCOUNT that can be later used for purchase of a trip
     *
     * @param acceptLanguage  (required)
     * @param customer  (optional)
     * @return Customer Account (status code 201)
     *         or Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#createCustomer
     */
    fun createCustomer(acceptLanguage: kotlin.String, customer: Customer?): CustomerAccount

    /**
     * DELETE /collections/customers/items/{customerId} : Delete the CUSTOMER ACCOUNT from the TO system.
     * The timeline of deletion of the customer account depends on the TO processes, it could be instant, weeks or months.
     *
     * @param customerId  (required)
     * @return CUSTOMER ACCOUNT deleted successfully (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#deleteCustomer
     */
    fun deleteCustomer(customerId: kotlin.String): Unit

    /**
     * GET /collections/customers/items/{customerId} : Get the customer account from the TO system
     *
     * @param customerId  (required)
     * @return Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#getCustomer
     */
    fun getCustomer(customerId: kotlin.String): CustomerAccount

    /**
     * PATCH /collections/customers/items/{customerId} : Update the CUSTOMER ACCOUNT on the TO system
     * updates the defined fields of the CUSTOMER ACCOUNT.&lt;br&gt;
     *
     * @param customerId  (required)
     * @param customer  (optional)
     * @return Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#updateCustomer
     */
    fun updateCustomer(customerId: kotlin.String, customer: Customer?): CustomerAccount
}
