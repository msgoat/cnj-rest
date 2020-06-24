# cnj-rest

Showcase of a simple cloud native Java application exposing REST endpoints (provider-side) and calling REST endpoints (consumer-side).

The actual implementation of REST endpoints is demonstrated with different Java backend technologies:

* Java EE (see: [cnj-rest-backend-javaee](cnj-rest-backend-javaee/README.md))
* Eclipse MicroProfile (see: [cnj-rest-backend-micro](cnj-rest-backend-micro/README.md))
* Spring Boot + Spring Data (see: [cnj-rest-backend-spring](cnj-rest-backend-spring/README.md))
* Quarkus (see: [cnj-rest-backend-quarkus](cnj-rest-backend-quarkus/README.md))

## Status
![Build status](https://drone.at.automotive.msg.team/api/badges/cloudtrain/cnj-rest/status.svg)

## Build this showcase 

### Prerequisites

In order to run the build, you have to install the following tools locally:
* Docker
* Docker Compose 
* Maven
* Java JDK 11   

### Run Maven

You can build all showcase applications by running Maven:
```
mvn clean install -P pre-commit-stage
```

The Maven build will create Docker images for all showcase applications and run system tests on them.