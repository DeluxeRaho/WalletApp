# WalletApp API

WalletApp API is a robust banking application designed to handle user transactions, including credits and debits, while managing user accounts. It uses Spring Boot, Spring Data JPA, and MySQL to ensure data integrity and provide a scalable solution for financial transaction management.

## Features

- **Transaction Management**: Support for creating and retrieving credit and debit transactions.
- **User Management**: Handling user details, including balance and transaction history.
- **Swagger UI Documentation**: Easily accessible and interactive API documentation using Swagger.
- **MySQL Database Integration**: Reliable and scalable storage for all user and transaction data.

## Technologies Used

- **Spring Boot** - Framework for creating stand-alone, production-grade Spring based Applications.
- **Spring Data JPA** - Module for database interaction using Java Persistence API.
- **MySQL** - Database for storing all application data.
- **Swagger UI** - Visualization and interaction with the API's resources.
- **Lombok** - Java library that automatically plugs into your editor and build tools, spicing up your java.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 11 or newer
- Maven
- MySQL Server

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/DeluxeRaho/WalletApp.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd WalletApp
   ```
3. **Configure the database:**
   - Ensure MySQL is running and accessible.
   - Configure the database settings in `application.properties` to match your setup.

4. **Add Swagger UI configuration:**
   - Ensure the following line is in your `application.properties`:
     ```properties
     springdoc.swagger-ui.path=/swagger-ui.html
     ```
5. **Build the project:**
   ```bash
   mvn clean install
   ```
6. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## Usage

### API Endpoints

- **Create Credit Transaction:** `POST /TRANSACTIONS/CREDIT/{userId}`
- **Create Debit Transaction:** `POST /TRANSACTIONS/DEBIT/{userId}`
- **Get Transactions by User ID:** `GET /TRANSACTIONS/{userId}`

To view and interact with the API, visit:
```
http://localhost:8080/swagger-ui.html
```

## TODO

- **Add Tests**: Implementation of unit and integration tests.
- **Docker Support**: Dockerize the application for easier deployment and setup.

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
