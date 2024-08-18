# University Microservices Project

## Overview

This project began as a monolithic application named "University," designed to manage students and their addresses. It has since been refactored into a microservices architecture with the following components:

- **Student Service**: Manages student information.
- **Address Service**: Manages student addresses.

Initially, the services communicated using WebClient. Later, Feign Client was introduced to streamline service-to-service communication. Additionally, Eureka Server was integrated to provide service discovery. Resilience4j has also been added to provide fault tolerance through circuit breakers, along with an actuator for monitoring.

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

## Getting Started

### Prerequisites

- JDK 8 or later
- Maven
- Docker (optional for running Eureka Server)

### Running the Application

1. **Eureka Server**: 
   - Navigate to the `eureka-server` directory and run:
     ```
     mvn spring-boot:run
     ```

2. **Student Service**:
   - Navigate to the `student-service` directory and run:
     ```
     mvn spring-boot:run
     ```

3. **Address Service**:
   - Navigate to the `address-service` directory and run:
     ```
     mvn spring-boot:run
     ```

### Testing the Application

- Use Postman or any API testing tool to interact with the endpoints listed above.
- Ensure Eureka Server is running before starting the microservices.
- For testing fault tolerance, stop the Address Service and trigger a call to the Student Service using:
  - `http://localhost:9090/student-service/api/student/getById/{id}` (This call will invoke the fallback method).
- Monitor the health status using the actuator endpoint:
  - `http://localhost:9090/student-service/actuator/health`

## Future Enhancements

- Implement additional features such as authentication and authorization.
- Add more detailed logging and monitoring.
- Expand the application to include more services and features.
- Enhance the load balancer with dynamic scaling based on traffic.

## Contributing

Feel free to fork the repository and submit pull requests. For any issues or suggestions, please open an issue on GitHub.
