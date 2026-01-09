package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.Collection
import no.entur.shared.mobility.to.ref.tomp200.dto.Collections
import no.entur.shared.mobility.to.ref.tomp200.dto.Conformance
import no.entur.shared.mobility.to.ref.tomp200.dto.LandingPage
import no.entur.shared.mobility.to.ref.tomp200.dto.LandingPageDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Process
import no.entur.shared.mobility.to.ref.tomp200.dto.ProcessList

interface DiscoveryService {

    /**
     * GET /collections/{collectionId} : describe the feature collection with id &#x60;collectionId&#x60;
     * a (machine or human) readable description of this collection
     *
     * @param collectionId local identifier of a collection (required)
     * @return description of data delivered by this collection (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Discovery#describeCollection
     */
    fun describeCollection(collectionId: kotlin.String): Collection

    /**
     * GET /collections : the feature collections in the dataset
     * returns a collection of available collection (like offers, packages, legs, support-requests and payments)
     *
     * @return A list of available collections (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Discovery#getCollections
     */
    fun getCollections(): Collections

    /**
     * GET /conformance : API conformance definition
     * A list of all conformance classes specified in a standard that the server conforms to.
     *
     * @param f The optional f parameter indicates the output format that the server shall provide as part of the response document.  The default format is JSON. (optional, default to json)
     * @return The URIs of all conformance classes supported by the server.  To support \&quot;generic\&quot; clients that want to access multiple OGC API Features implementations - and not \&quot;just\&quot; a specific API / server, the server declares the conformance classes it implements and conforms to. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Discovery#getConformanceDeclaration
     */
    fun getConformanceDeclaration(f: kotlin.String): Conformance

    /**
     * GET /processes/{processID} : retrieve a process description
     * The process description contains information about inputs and outputs and a link to the execution-endpoint for the process. The Core does not mandate the use of a specific process description to specify the interface of a process. That said, the Core requirements class makes the following _recommendation_ implementations SHOULD consider supporting the OGC process description. For more information, see &lt;a href&#x3D;\&quot;https://docs.ogc.org/is/18-062/18-062.html#sc_process_description\&quot;&gt;Section 7.10&lt;/a&gt;.
     *
     * @param processID  (required)
     * @return A process description. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Discovery#getProcessDescription
     */
    fun getProcessDescription(processID: kotlin.String): Process

    /**
     * GET /processes : retrieve the list of available processes
     * The list of processes contains a summary of each process the OGC API - Processes offers, including the link to a more detailed description of the process. For more information, see &lt;a href&#x3D;\&quot;https://docs.ogc.org/is/18-062/18-062.html#sc_process_list\&quot;&gt;Section 7.9&lt;/a&gt;.
     *
     * @return Information about the available processes (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Discovery#getProcesses
     */
    fun getProcesses(): ProcessList

    /**
     * GET / : Landing page
     * Gives a (technical &amp; human readable) output describing how this API must be used. If the parameter f&#x3D;html is supplied, a human readable page must be responded.
     *
     * @param f The optional f parameter indicates the output format that the server shall provide as part of the response document.  The default format is JSON. (optional, default to json)
     * @return The reponse containing a landing page (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * 
     * @see <a href="https://app.swaggerhub.com/apis/OGC/ogcapi-features-1-example-1/1.0.1">Landing page Documentation</a>
     * @see Discovery#landingPage
     */
    fun landingPage(f: kotlin.String): LandingPage

    /**
     * GET /api : This document
     * This document
     *
     * @param f The optional f parameter indicates the output format that the server shall provide as part of the response document.  The default format is JSON. (optional, default to json)
     * @return General Success response. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Discovery#openApi
     */
    fun openApi(f: kotlin.String): Unit
}
