# University Microservices Project

## Overview

This project started as a monolithic application named "University," which allows for managing students and their addresses. The project has been refactored into a microservices architecture with the following components:

- **Student Service**: Manages student information.
- **Address Service**: Manages student addresses.

Initially, the services communicated using WebClient. Later, Feign Client was introduced to streamline service-to-service communication. Additionally, Eureka Server was integrated to provide service discovery.

## Project Structure

### Monolithic Application

- **University**: A single application that combined student and address management functionalities.

### Microservices Architecture

1. **Student Service**: 
   - **Description**: Handles operations related to students.
   - **Endpoints**:
     - `/POST /api/student/create` - Create a new student
     - `/GET /api/student/getById/{id}` - Get student by ID 
2. **Address Service**:
   - **Description**: Manages address information for students.
   - **Endpoints**:
     - `/POST /api/address/create` - Create a new address
     - `/GET /api/address/getById/{id}` - Get address by ID


### Communication

- **Initial**: WebClient was used for communication between services.
- **Updated**: Feign Client is now used for inter-service communication.

### Service Discovery

- **Eureka Server**: Added to provide service registration and discovery.

## Getting Started

### Prerequisites

- JDK 8 or later
- Maven
- Docker (optional for running Eureka Server)

### Running the Application

1. **Eureka Server**: 
   - Navigate to the `eureka-server` directory and run `mvn spring-boot:run`.

2. **Student Service**:
   - Navigate to the `student-service` directory and run `mvn spring-boot:run`.

3. **Address Service**:
   - Navigate to the `address-service` directory and run `mvn spring-boot:run`.

### Testing the Application

- Use Postman or any API testing tool to interact with the endpoints listed above.
- Ensure Eureka Server is running before starting the microservices.

## Future Enhancements

- Implement additional features such as authentication and authorization.
- Add more detailed logging and monitoring.
- Expand the application to include more services and features.

## Contributing

Feel free to fork the repository and submit pull requests. For any issues or suggestions, please open an issue on GitHub.

