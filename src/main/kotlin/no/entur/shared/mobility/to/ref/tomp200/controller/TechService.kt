package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.GetToken200Response

interface TechService {

    /**
     * POST /oauth/token : Token Endpoint
     * This endpoint is used to obtain an access token and optionally an ID token through different OAuth 2.0 grant types, including Client Credentials Flow. Whenever the mTLS flow is taken, the properties will be ignored, and the access token will be generated based on the credentials in the certificate (O or CN).
     *
     * @param grantType The grant type: &#39;client_credentials&#39;, &#39;password&#39;, or &#39;refresh_token&#39;. (optional, default to client_credentials)
     * @param username The username (optional)
     * @param password The password (optional)
     * @param clientId The client ID (Client Credentials Flow) (optional)
     * @param clientSecret The client secret (Client Credentials Flow) (optional)
     * @return Successful token issuance. (status code 200)
     *         or Bad Request: Invalid request or wrong grant type. (status code 400)
     *         or Unauthorized: Invalid client ID or secret. (status code 401)
     *         or Internal Server Error: Something went wrong. (status code 500)
     * @see Tech#getToken
     */
    fun getToken(grantType: kotlin.String, username: kotlin.String?, password: kotlin.String?, clientId: kotlin.String?, clientSecret: kotlin.String?): GetToken200Response

    /**
     * GET /health : is the API up and running?
     * This is a healthcheck ENDPOINT
     *
     * @return successful operation (status code 204)
     *         or successful operation (status code 200)
     * @see Tech#ping
     */
    fun ping(): Map<String, kotlin.Any>
}
