# cnj-rest-backend-javaee

Cloud native JavaEE backend based on JavaEE Full Profile Application Server using JAX-RS and JSON-B to expose and consume REST endpoints.

## Build this application 

``` 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing an Payara Full Profile application server plus the deployed application.

## Exposed REST endpoints

### /api/v1/tasks

Manages Task entities.

Method
: GET

URI
: /api/v1/tasks

Parameter(s)
: none

Response
: all existing Task entities

Authentication type
: Bearer Token

Role(s) required
: CLOUDTRAIN_USER

Method
: GET

URI
: /api/v1/tasks/{taskId}

Parameter(s)
: task ID as last path component

Response
: (200) Task identified by the given task ID or (404) if no Task with the given task ID can be found

Authentication type
: Bearer Token

Role(s) required
: CLOUDTRAIN_USER

Method
: POST

URI
: /api/v1/tasks

Parameter(s)
: Task as request body

Response
: (201) Location of newly created Task

Authentication type
: Bearer Token

Role(s) required
: CLOUDTRAIN_USER

Method
: PUT

URI
: /api/v1/tasks/{taskId}

Parameter(s)
: task ID of task to save as last path component plus Task to save as request body

Response
: (204) if Task could be saved successfully

Authentication type
: Bearer Token

Role(s) required
: CLOUDTRAIN_USER

Method
: DELETE

URI
: /api/v1/tasks/{taskId}

Parameter(s)
: task ID of Task to delete as last path component

Response
: (204) if Task could be deleted successfully

Authentication type
: Bearer Token

Role(s) required
: CLOUDTRAIN_USER

## Exposed environment variables

| Name | Required | Description |
| --- | --- | --- |
| MP_JWT_VERIFY_PUBLICKEY_LOCATION | x | REST endpoint of an OpenID Connect authentication provider returning the JWT key set |
| MP_JWT_VERIFY_ISSUER | x | ID of the JWT's issuer |

## Exposed Ports

| Port | Protocol | Description |
| --- | --- | --- |
| 8080 | HTTP | HTTP endpoint of this application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 4.0.0 | first release |
