package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.Customer
import no.entur.shared.mobility.to.ref.tomp160.dto.CustomerAccount
import no.entur.shared.mobility.to.ref.tomp160.dto.CustomersPostDefaultResponse

interface CustomerManagementService {

    /**
     * DELETE /customers/{id} : [MP-&gt;TO] delete the CUSTOMER ACCOUNT on the TO system.
     * The timeline of deletion of the customer account depends on the TO processes, it could be instant, weeks or months.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param id ID of the customer, on TO side (required)
     * @param notificationUrl The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications. (optional)
     * @return CUSTOMER ACCOUNT deleted successfully (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#customersIdDelete
     */
    fun customersIdDelete(acceptLanguage: kotlin.String, id: kotlin.String, notificationUrl: kotlin.String?): Unit

    /**
     * GET /customers/{id} : [MP-&gt;TO] get the customer account on the TO system
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param id ID of the customer, on TO side (required)
     * @param notificationUrl The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications. (optional)
     * @return Customer Account (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#customersIdGet
     */
    fun customersIdGet(acceptLanguage: kotlin.String, id: kotlin.String, notificationUrl: kotlin.String?): CustomerAccount

    /**
     * PATCH /customers/{id} : [MP-&gt;TO] update the CUSTOMER ACCOUNT on the TO system
     * updates the defined fields of the CUSTOMER ACCOUNT.&lt;br&gt; When during CREATE CUSTOMER ACCOUNT step the customer status is _OTP_REQUIRED_ this request can be used to send the OTP from the customer to the TO by using extraFields.otp in the Customer object.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param id ID of the customer, on TO side (required)
     * @param notificationUrl The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications. (optional)
     * @param body  (optional)
     * @return updated CUSTOMER ACCOUNT (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#customersIdPatch
     */
    fun customersIdPatch(acceptLanguage: kotlin.String, id: kotlin.String, notificationUrl: kotlin.String?, body: kotlin.Any?): CustomerAccount

    /**
     * POST /customers : [MP-&gt;TO] create a TO CUSTOMER ACCOUNT for the customer
     * Creates or links a CUSTOMER ACCOUNT that can be later used for purchasing a trip. If the customer is already registered with this TO it&#39;s the TO descision whether to link to the existing acount or to create a seperate account.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param notificationUrl The URL at the MP side, where notifications will be send to about the purchased packages. Communication towards the TO is always done using notifications. (optional)
     * @param body  (optional)
     * @return created CUSTOMER ACCOUNT (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see CustomerManagement#customersPost
     */
    fun customersPost(acceptLanguage: kotlin.String, notificationUrl: kotlin.String?, body: Customer?): CustomerAccount
}
