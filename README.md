# University Microservices Project

## Overview

This project began as a monolithic application named "University," designed to manage students and their addresses. It has since been refactored into a microservices architecture with the following components:

- **Student Service**: Manages student information.
- **Address Service**: Manages student addresses.

### Features Added

#### 1. Service Communication Improvements
- **WebClient to Feign Client Transition:**  
  Initially, services communicated using WebClient. Feign Client was later introduced to simplify and streamline service-to-service communication, offering a more declarative approach.

- **Eureka Server Integration:**  
  Eureka Server has been added to the project, enabling service discovery and registry, which allows microservices to locate each other dynamically.

#### 2. Fault Tolerance and Monitoring
- **Resilience4j Circuit Breaker:**  
  Resilience4j has been integrated to provide fault tolerance. It handles failures using circuit breakers, preventing cascading failures across services. This includes configurations for sliding window size, thresholds, open state duration, and fallback mechanisms.

- **Actuator for Health Monitoring:**  
  Actuator endpoints have been configured to monitor the health of services. Additionally, the `/actuator/refresh` endpoint allows dynamic configuration updates.

#### 3. Centralized Configuration Management
- **Spring Cloud Config Server Setup:**  
  A Spring Cloud Config Server has been implemented to centralize the management of configuration properties for all microservices. This simplifies configuration changes across different environments (dev, test, prod).

- **Environment Profiles:**  
  The project now supports multiple profiles, enabling environment-specific configurations to be managed efficiently.

- **Dynamic Configuration Refresh with Actuator:**  
  Added the ability to dynamically refresh configuration properties without restarting services, using the `/actuator/refresh` endpoint. This ensures that services pick up new configurations immediately after updates.

## Project Structure

### Monolithic Application

- **University**: A single application combining student and address management functionalities.

### Microservices Architecture

1. **Student Service**: 
   - **Description**: Handles operations related to students.
   - **Endpoints**:
     - `/POST /api/student/create` - Create a new student
     - `/GET /api/student/getById/{id}` - Get student by ID
     - Circuit breaker logic with fallback is implemented for resilient service communication.

2. **Address Service**:
   - **Description**: Manages address information for students.
   - **Endpoints**:
     - `/POST /api/address/create` - Create a new address
     - `/GET /api/address/getById/{id}` - Get address by ID

### Communication

- **Initial**: WebClient was used for communication between services.
- **Updated**: Feign Client is now used for inter-service communication with added fault tolerance using Resilience4j.

### Service Discovery

- **Eureka Server**: Added to provide service registration and discovery.

### Load Balancing

- **Spring Cloud LoadBalancer**: Configured to distribute requests evenly across multiple service instances.

### Resilience4j Configuration

- Circuit breaker settings include:
  - Sliding window size.
  - Failure threshold percentage.
  - Duration for which the circuit remains open.
  - Fallback methods for handling service degradation.
- Actuator endpoints are enabled for monitoring circuit breaker metrics and service health.
  
### Distributed Tracing with Sleuth and Zipkin
- **Spring Cloud Sleuth:** Added for distributed tracing across microservices. It automatically generates trace IDs and spans for each request.
- **Zipkin:** Configured as the tracing backend, enabling tracking of requests across services via the Zipkin UI.
  
### Monitoring and Health Checks
- **Spring Boot Actuator:** Provides endpoints for monitoring the health and status of services.
- **Zipkin UI:** Access the tracing UI to visualize service dependencies and latencies.
  
### Centralized Configuration Management
- **Spring Cloud Config Server Setup:** Centralized configuration management for all microservices, simplifying changes across environments (dev, test, prod).
- **Environment Profiles:** Supports multiple profiles for managing environment-specific configurations efficiently.
- **Dynamic Configuration Refresh:** Enables dynamic property updates without restarting services via the `/actuator/refresh` endpoint.

### Prerequisites

- JDK 8 or later
- Maven

### Running the Application

1. **Eureka Server**:  
   - Navigate to the `eureka-server` directory and run:
     ```bash
     mvn spring-boot:run
     ```

2. **Config Server**:  
   - Navigate to the `config-server` directory and run:
     ```bash
     mvn spring-boot:run
     ```

3. **API Gateway**:  
   - Navigate to the `api-gateway` directory and run:
     ```bash
     mvn spring-boot:run
     ```

4. **Student Service**:  
   - Navigate to the `student-service` directory and run:
     ```bash
     mvn spring-boot:run
     ```

5. **Address Service**:  
   - Navigate to the `address-service` directory and run:
     ```bash
     mvn spring-boot:run
     ```
     
This updated section now includes all the necessary steps for running the Config Server, API Gateway, and Eureka Server along with the other microservices.
### Testing the Application

- Use Postman or any API testing tool to interact with the endpoints listed above.
- Ensure Eureka Server is running before starting the microservices.
- For testing fault tolerance, stop the Address Service and trigger a call to the Student Service using:
  - `http://localhost:9090/student-service/api/student/getById/{id}` (This call will invoke the fallback method).
- Monitor the health status using the actuator endpoint:
  - `http://localhost:9090/student-service/actuator/health`
  - `Visit http://localhost:9411 to open the Zipkin UI.`
- To verify if the `address-service` is loading properties from the `dev` environment, visit:
   ```bash
   http://localhost:8888/address-service/dev
   ```
- To confirm that the microservice is picking up the properties from the `dev` file, visit:
  ```bash
  http://localhost:8082/api/address/test
  ```
- To refresh configurations without restarting the service, send a POST request to:
  ```bash
  http://localhost:8082/actuator/refresh
  ```
  
## Future Enhancements

- Implement additional features such as authentication and authorization.
- Add more detailed logging and monitoring.
- Expand the application to include more services and features.
- Enhance the load balancer with dynamic scaling based on traffic.
- Spring Cloud Sleuth & Zipkin: For distributed tracing.
- Spring Cloud Config Server: For unified management of configuration properties across all microservices.

  You can add the following section to your `README.md` file to acknowledge the course and certification:

### Acknowledgements

To complete this project, I utilized the Udemy course **"Microservices with Java Spring Boot and Spring Cloud"** by **Infybuzz Learnings**. The course provided valuable insights and hands-on experience in building and managing microservices with Spring Boot and Spring Cloud. I hold a certificate for this course.

## Contributing

Feel free to fork the repository and submit pull requests. For any issues or suggestions, please open an issue on GitHub.
