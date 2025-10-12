# SpringDemo - Employee Management Service

A Spring Boot web service prototype, built with Spring Initializr and Gradle-Groovy as the build tool.

## Features

- RESTful API
- Spring Boot framework with MVC architecture
- Service layer pattern implementation
- Custom exception handling
- Static web resources with documentation
- SQL Express Database with production / testing enviroments for safe testing

## Technology Stack

- **Framework**: Spring Boot
- **Build Tool**: Gradle (Groovy)
- **Language**: Java
- **Architecture**: MVC with Service Layer

## Project Structure

```
src/main/java/org/nikadisplay/
├── Controller/
│   └── EmployeeController
├── Exception/
│   └── EmployeeException.java
├── Model/
│   └── Employee
├── Service/
│   └── EmployeeService
└── SpringBootDemoExampleAlenApplication
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Gradle

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Setup local .env file with a connection string for your SQL Express DB, using Windows auth
4. Run the application:
   ```bash
   ./gradlew bootRun
   ```
5. Access the service at `http://localhost:8080`

The homepage serves as documentation for available endpoints.

## Development Status

This project is currently in active development as an internal service tool.

---
