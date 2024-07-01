# A Microservice website for farmers to sell their products and buy inputs for their farms

## Main folders and Files

- **diagrams**: contains UML diagrams for the applications
- **resources**: visual representation of the project
- **services**: Contains services and micro-sevices implemented in the project
- **docker-compose.yaml**: Contains services, volumes and networks for different micro-services

## Languages & Technologies used

- Spring & SpingBoot for APIs
- React for Frontend
- Databases(MongoDB & Postgres)
- Docker
- Kafka for Messaging
- ZipKin for Distributed Tracing

### Microservices distributed pattern empoyed

- Api Gateway
- Discovery server(Eureka)
- Asynchronous communication with Kafka
- Synchronous communication with Open Feign and Rest Templates
- Configuration servers
- Distributed Tracing with Zipkin and spring Actuator
- Securing application with Keyclaok
- Setup infrasructure and required tools with Docker and Docker Compose
