# shared-mobility-to-ref

Reference implementation of a backend that implements a [TOMP API](https://github.com/TOMP-WG/TOMP-API) from the TO (Transport Operator) side.
You can find the full Swagger Petstore documentation from the TOMP-team 
[here](https://app.swaggerhub.com/apis-docs/TOMP-API-WG/transport-operator_maas_provider_api/1.5.0#/).

## Guide for transport operators on how to implement TOMP standard

This guide covers all the endpoints needed for supporting the TOMP standard and how to implement them. 
This is a shorten list of all the endpoints supported by the [TOMP standard](https://github.com/TOMP-WG/TOMP-API).

You can find the Swagger Petstore documentation for this app [here](https://petstore.swagger.io/?url=https://api.dev.entur.io/api-docs/shared-mobility-to-ref)

| Endpoints                                                                             | Purpose                                             |
|---------------------------------------------------------------------------------------|-----------------------------------------------------|
| [GET /operator/meta](#tomp-api-implementation-guide-get-operatormeta)                 | Describes the running implementations               |
| [POST /bookings/one-stop](#tomp-api-implementation-guide-post-bookingsone-stop)       | Creates a one-stop booking                          |
| [POST /legs/{id}/events](#tomp-api-implementation-guide-post-legsidevents)            | Alters the state of a leg                           |
| [GET /bookings/{id}](#tomp-api-implementation-guide-get-bookingsid)                   | Returns a booking given id                          |
| [GET /payment/journal-entry](#tomp-api-implementation-guide-get-paymentjournal-entry) | Returns all the journal entries that should be paid |
| [POST /support](#tomp-api-implementation-guide-post-support)                          | Creates a request for support from end user         |
| [GET /support/{id}/status](#tomp-api-implementation-guide-get-supportidstatus)        | Gets the status report of the support request       |

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
- The rest of the "required" variables can be set as an empty list since it's not supported in Entur's implementation yet.

### TOMP API Implementation Guide: POST "/bookings/one-stop"
This guide outlines how transport operator's can implement the `POST "/bookings/one-stop"` endpoint,
which is used to create a one-stop booking. This is for travels without a specified final destination.
The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/BookingsController.kt).

The first id in the request.useAssets list will always be the mobility the user wants to book for a trip. 
This id is from the [public GBFS data](https://developer.entur.org/pages-mobility-docs-mobility-v2).

Response model can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Booking.kt).
The model has many optional variables because it is designed to support booking of many different modalities, 
but because Entur currently only supports booking of micromobility, only these variables are required:
- **id**: Unique identifier. Should be the same as "leg.id" for one-stop booking.
- **from**: Where the customer is traveling from. Model: [Place](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Place.kt)
  - **name**: Name of the place.
  - **coordinates**: Coordinates of the place. Model: [Coordinates](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Coordinates.kt)
- **customer**: Information about the traveling customer. Model: [Customer](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Customer.kt)
  - **id**: The identifier Entur uses to identify the customer.
- **state**: The state of the booking. Model: [BookingState](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/BookingState.kt)
- **legs**: A list of all legs in the booking. Since this is a one-stop booking this list should only include one leg. 
    Model: List of [Leg](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Leg.kt)
  - **id**: Unique identifier. Should be the same as "booking.id" for one-stop booking.
  - **from**: Where the customer is traveling from. For one-stop booking this variable should be identical as the "booking.from" variable.
    Model: [Place](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Place.kt)
  - **arrivalTime**: The intended arrival time at the to place. Or, in case of a parking, the end of the usage.
  - **actualArrivalTime**: the 'arrivalTime' can be used as 'plannedArrivalTime' whenever the leg has ended. Use this field to ease 
    searching for discrepancies between planned and actual arrival times.
  - **departureTime**: The departure time of this leg. Or, in case of a parking, the start of the usage.
  - **actualDepartureTime**: the 'departureTime' can be used as 'plannedDepartureTime' whenever the leg has started. Use this field to ease
    searching for discrepancies between planned and actual departure times.
  - **assetType**: Type of asset. Model: [AssetType](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/AssetType.kt)
    - **id** Unique identifier. 
  - **asset**: The booked asset for the trip. Model: [Asset](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Asset.kt)
    - **id** Unique identifier. Should be the same id as given from the useAssets request variable.
  - **pricing**: Same as the "booking.pricing". Model: [Fare](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Fare.kt)
  - **conditions**: The conditions that apply to this leg. 
    Model: List of [AssetTypeConditionsInner](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/AssetTypeConditionsInner.kt)
    - **ConditionDeposit::class**: Gives us information about the preferred deposit amount. 
      Model: [ConditionDeposit](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/ConditionDeposit.kt)
    - **ConditionRequireOffboardingSteps::class**: Used if the transport operator wants a parking picture of the bike/scooter.
      Model: [ConditionRequireOffboardingSteps](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/ConditionRequireOffboardingSteps.kt)
  - **state**: The state of the leg. When creating a one-stop booking this state should be set to ASSIGN_ASSET. Model: [LegState](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/LegState.kt)
  - **pricing** The pricing of the booking. Model: [Fare](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Fare.kt)
    - **estimated**: Is this fare an estimation?
    - **parts**: All the priced parts. Model: List of [FarePart](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/FarePart.kt)

departureTime, arrivalTime, actualDepartureTime and actualArrivalTime on the Booking is optional 
since Entur only use the variables from the [Leg](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Leg.kt).

### TOMP API Implementation Guide: POST "/legs/{id}/events"

This guide outlines how transport operator's can implement the `POST "/legs/{id}/events"` endpoint, which is used to alter the state of a leg. 
The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/LegsController.kt).

Response model can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Leg.kt).

Required fields are described in the [POST /bookings/one-stop](#tomp-api-implementation-guide-post-bookingsone-stop) guide above.




| Event           | Action                                                                                                                                                                                                                                                                           |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| SET_IN_USE      | Set the event on the leg to IN_USE, set the state on the booking to STARTED, set the actualDepartureTime (if this is the first SET_IN_USE event) and let the user start using your mobility.                                                                                     |
| PAUSE           | Set the event on the leg to PAUSED and pause the use of the mobility.                                                                                                                                                                                                            |
| START_FINISHING | Set the event on the leg to FINISHING, create a journal entry and make the mobility available for other users and set the actualArrivalTime. This event is usually used when the transport operator wants the user to do a action like taking av picture of the parked mobility. |
| FINISH          | Check the picture of the parked mobility if needed, set the event on the leg to FINISHED, set the state on the booking to FINISHED.                                                                                                                                              |
| CANCEL          | Set the event on the leg to CANCELLED, set the state of the booking to CANCELLED and make the mobility available for other users.                                                                                                                                                |

### TOMP API Implementation Guide: GET "/bookings/{id}"
This guide outlines how transport operators can implement the `GET "/bookings/{id}"` endpoint, which is used to retrieve booking details by booking ID. The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/BookingsController.kt).

#### Request Headers:
- **Accept-Language**:
  - **Description**: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in `operator/information`.
  - **Required**: Yes
- **Api**:
  - **Description**: API description, can be TOMP or maybe other (specific/derived) API definitions.
  - **Required**: Yes
- **Api-Version**:
  - **Description**: Version of the API.
  - **Required**: Yes
- **maas-id**:
  - **Description**: The ID of the sending MaaS operator.
  - **Required**: Yes
- **addressed-to**:
  - **Description**: The ID of the MaaS operator that has to receive this message.
  - **Required**: No

#### Path Variables:
- **id**:
  - **Description**: Booking identifier.
  - **Required**: Yes

#### Example Request:
```http
GET /bookings/12345 HTTP/1.1
Accept-Language: en
Api: TOMP
Api-Version: 1.0
maas-id: example-maas-id
addressed-to: receiver-maas-id
```

#### Response Model:
The response will be a `Booking` object. The model can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Booking.kt). The model has many optional variables because it is designed to support booking of many different modalities, but because Entur currently only supports booking of micromobility, only these variables are required:

Required fields are the same as described in the POST /bookings/one-stop guide above.

### TOMP API Implementation Guide: GET "/payment/journal-entry"
This guide outlines how transport operators can implement the `GET "/payment/journal-entry"` endpoint, which is used to retrieve all journal entries that should be paid per leg. The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/PaymentController.kt).

#### Request Headers:
- **Accept-Language**: 
  - **Description**: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in `operator/information`.
  - **Required**: Yes
- **Api**: 
  - **Description**: API description, can be TOMP or maybe other (specific/derived) API definitions.
  - **Required**: Yes
- **Api-Version**: 
  - **Description**: Version of the API.
  - **Required**: Yes
- **maas-id**: 
  - **Description**: The ID of the sending MaaS operator.
  - **Required**: Yes
- **addressed-to**: 
  - **Description**: The ID of the MaaS operator that has to receive this message.
  - **Required**: No

#### Request Parameters:
- **id**:
  - **Description**: ID of the journal entry.
  - **Required**: No



#### Example Request:
```http
GET /payment/journal-entry HTTP/1.1
Accept-Language: en
Api: TOMP
Api-Version: 1.0
maas-id: example-maas-id
addressed-to: receiver-maas-id
id: journal-12345
```

#### Response Model:
The response will be a list of `JournalEntry` objects. The model can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/JournalEntry.kt). The key fields in the `JournalEntry` object are:

- **amount**:
  - **Description**: This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol (e.g., if the price is in US Dollars the price would be 9.95). This is inclusive VAT.
  - **Example**: `9.95`

- **amountExVat**:
  - **Example**: `8.95`

- **vatRate**:
  - **Description**: Value added tax rate (percentage of amount).
  - **Example**: `21.0`

#### Example Response:
```json
[
  {
    "amount": 12.50,
    "amountExVat": 10.00,
    "vatRate": 25.00
  }
]
```

### TOMP API Implementation Guide: POST "/support"

This guide outlines how transport operators can implement the `POST "/support/"` endpoint, which is used to submit a support request. The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/SupportController.kt).

#### Request Headers:
- **Accept-Language**: (Required) A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information.
- **Api**: (Required) API description, can be TOMP or maybe other (specific/derived) API definitions.
- **Api-Version**: (Required) Version of the API.
- **maas-id**: (Required) The ID of the sending maas operator.
- **addressed-to**: (Optional) The ID of the maas operator that has to receive this message.

#### Request Body:
- **SupportRequest**: (Optional) The support request object containing details about the issue.

#### Response:
- **SupportStatus**: The response object containing the status of the support request.

### Request Model: SupportRequest
```kotlin
data class SupportRequest(
    val id: String? = null, // the booking id
    val supportType: SupportType? = null,
    val location: Place? = null,
    val time: OffsetDateTime? = null,
    val priority: Priority? = null, // the priority of the support request.
    val contactInformationEndUser: String? = null, // contact information of the end user in case of direct response requests, like phone number
    val comment: String? = null,
    val requestedResponseTime: Double? = null, // time to respond in minutes.
    val urls: List<String>? = null // urls to clarify the support request e.g. pictures showing damage
)
```

- **id**: The booking id.
- **supportType**: The type of support request.
  - **BROKEN_DOWN**
  - **NOT_AT_LOCATION**
  - **MISSING_AFTER_PAUSE**
  - **NOT_CLEAN**
  - **NOT_AVAILABLE**
  - **UNABLE_TO_OPEN**
  - **UNABLE_TO_CLOSE**
  - **API_TECHNICAL**
  - **API_FUNCTIONAL**
  - **ACCIDENT**
  - **OTHER**
- **location**: The location of the issue.
  - **name**: The name of the place.
  - **coordinates**: The coordinates of the place.
    - **longitude**: Longitude of the place.
    - **latitude**: Latitude of the place.
- **time**: The time of the issue (set to current time).
- **priority**: The priority of the support request (set to OTHER).
  - **ERROR_CANNOT_CONTINUE**
  - **ERROR_CAN_CONTINUE**
  - **DISTURBING_ISSUE**
  - **QUESTION**
  - **OTHER**
- **contactInformationEndUser**: Contact information of the end user, like phone number.
- **comment**: Additional comments.
- **requestedResponseTime**: Time to respond in minutes (set to 10.0).
- **urls**: URLs to clarify the support request, e.g., pictures showing damage (base64-encoded image from the user).

#### Example Usage:
```http
POST /support/
Content-Type: application/json
Accept-Language: en
Api: TOMP
Api-Version: 1.0
maas-id: example-maas-id

{
  "id": "booking123",
  "supportType": "BROKEN_DOWN",
  "location": {
    "name": "Example Location",
    "coordinates": {
      "latitude": 59.9139,
      "longitude": 10.7522
    }
  },
  "time": "2024-05-29T08:30:00Z",
  "priority": "ERROR_CANNOT_CONTINUE",
  "contactInformationEndUser": "+4712345678",
  "comment": "The bike is broken down and cannot be used.",
  "requestedResponseTime": 30,
  "urls": "data:image/png;base64,UklGRtA5AQBXRUJQVlA4IPBmAADQ7AGdASoABAAEPjEYiEQiIYj9CBABglnbv"
}
```

### Response Model: SupportStatus

```kotlin
data class SupportStatus(
    val status: String? = null, // current status of the support request
    val timeToResolution: Int? = null // time in minutes to expected resolution of support request
)
```

- **status**: The current status of the support request.
  - **PROCESSING**
  - **UPDATE_REQUESTED**
  - **RESOLVED**
  - **CANCELLED**
- **timeToResolution**: Time in minutes to expected resolution of the support request.

### Example Response:
```json
{
  "status": "PROCESSING",
  "timeToResolution": 9
}
```

### TOMP API Implementation Guide: GET "/support/{id}/status"

This guide outlines how transport operators can implement the `GET "/support/{id}/status"` endpoint, which is used to retrieve the current status of a support request. The controller code can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/controller/SupportController.kt).

Response model can be found [here](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/SupportStatus.kt). The model includes several optional variables, but for this endpoint, only the following variables are used: `status` and `timeToResolution`. These are the same fields used in the response for the POST "/support" endpoint.

### Endpoint: GET "/support/{id}/status"
Retrieve the current status of a support request.

#### Headers
- **Accept-Language** (required): A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the transport operator's side, this list should be kept as short as possible, ideally just one language tag from the list in `operator/information`.
- **Api** (required): API description, can be TOMP or other specific/derived API definitions.
- **Api-Version** (required): Version of the API.
- **maas-id** (required): The ID of the sending Mobility as a Service (MaaS) operator.
- **addressed-to** (optional): The ID of the MaaS operator that has to receive this message.

#### Path Parameters
- **id** (required): Booking identifier.

#### Example Request
```http
GET /support/12345/status HTTP/1.1
Host: api.example.com
Accept-Language: en
Api: TOMP
Api-Version: 1.0
maas-id: maas-operator-1
addressed-to: support-operator-1
```

#### Example Response
For the response details, refer to the example response in the documentation for the POST "/support" endpoint.

### Response Model: SupportStatus

For the response model details, refer to the documentation for the POST "/support" endpoint. This endpoint uses the same `SupportStatus` model, including the fields `status` and `timeToResolution`.