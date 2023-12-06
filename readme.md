# Kafka Cluster with Java Avro Models


## Overview

This project sets up a Kafka environment for development purposes. It includes multiple Kafka brokers, Zookeeper, a Schema Registry, and Kafka UI for easy management and visualization. This setup is ideal for development and testing of Kafka-based applications.

## Components
- Zookeeper: Manages Kafka broker coordination and state.
- Kafka Brokers: Three Kafka brokers for handling messages.
- Schema Registry: Manages and validates Kafka message schemas.
- Kafka UI: A web-based UI for managing and visualizing Kafka components.

## Prerequisites
- Docker and Docker Compose installed on your machine.
- Basic knowledge of Kafka and Docker.

## Usage

- **Starting the Services:**
  - Run ```docker-compose up kafka-setup --build -d``` to start all the services defined in the Docker Compose file.
  - This command pulls necessary images and starts the services.
- **Accessing Kafka UI:**
  - Once all services are up, access Kafka UI at http://localhost:8080 to manage and monitor your Kafka clusters.
- **Creating Topics:**
  - The service kafka-setup automatically creates a topic named message-topic-example during startup.
- **Stopping the Services:**
  - Run docker-compose down to stop all running services.
    
## Configuration

Each service has its own environment variables and settings as defined in the Docker Compose file.
You can modify these settings as per your requirement.

## Ports

- Kafka Brokers: 9092, 9093, 9094
- Schema Registry: 8081
- Kafka UI: 8080

## Notes

This setup is for development purposes and not recommended for production use.
Ensure adequate resources are allocated to Docker for smooth operation of this environment.
