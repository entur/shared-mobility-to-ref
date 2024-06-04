# shared-mobility-to-ref

Reference implementation of a backend that implements a [TOMP API](https://github.com/TOMP-WG/TOMP-API) from the TO (Transport Operator) side.
You can find the full Swagger Petstore documentation from the TOMP-team [here](https://app.swaggerhub.com/apis-docs/TOMP-API-WG/transport-operator_maas_provider_api/1.5.0#/).

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
  - **state**: The state of the leg. Model: [LegState](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/LegState.kt)
  - **pricing** The pricing of the booking. Model: [Fare](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Fare.kt)
    - **estimated**: Is this fare an estimation?
    - **parts**: All the priced parts. Model: List of [FarePart](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/FarePart.kt)

departureTime, arrivalTime, actualDepartureTime and actualArrivalTime on the Booking is optional 
since Entur only use the variables from the [Leg](src/main/kotlin/no/entur/shared/mobility/to/ref/dto/Leg.kt).

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