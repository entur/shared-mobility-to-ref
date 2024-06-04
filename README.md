# shared-mobility-to-ref

Reference implementation of a backend that implements a [TOMP API](https://github.com/TOMP-WG/TOMP-API) from the TO (Transport Operator) side.

## Guide for transport operators on how to implement TOMP standard

This guide covers all the endpoints needed for supporting the TOMP standard and how to implement them. 
This is a shorten list of all the endpoints supported by the [TOMP standard](https://github.com/TOMP-WG/TOMP-API).

### TOMP API Implementation Guide: GET "/operator/meta"

This guide outlines how transport operator's can implement the `GET "/operator/meta"` endpoint, 
which is used to retrieve information about how the transport operator's API works and which endpoints that are supported. 
The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/OperatorController.kt).

Response model can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/data/EndpointImplementation.kt). 
Note that the response is a list of EndpointImplementation. 
Required variables in the response:

- **version**: The version of the transport operator's implementation of the TOMP API.
- **baseUrl**: The base URL for the transport operator's implementation of the TOMP API.
- **endpoints**: A list of supported endpoints in the transport operator's implementation of the TOMP API.
  - **method**: [ POST, PUT, GET, DELETE, PATCH ]
  - **status**: [ NOT_IMPLEMENTED, DIALECT, IMPLEMENTED ]
  - **paths**: Should be one of the types listed [here](src/main/kotlin/no/entur/shared/mobility/to/ref/data/EndpointType.kt).
- The rest of the "required" fields can be set as an empty list since it's not supported in Entur's implementation yet.

### TOMP API Implementation Guide: POST "/bookings/one-stop"
TODO

### TOMP API Implementation Guide: POST "/legs/{id}/events"
TODO

### TOMP API Implementation Guide: GET "/bookings/{id}"
TODO

### TOMP API Implementation Guide: GET "/payment/journal-entry"
TODO

### TOMP API Implementation Guide: POST "/support"
TODO

### TOMP API Implementation Guide: GET "/support/{id}/status"
TODO