# Car Management System

## Introduction
This project is a Spring Boot-based Car Management System. It provides RESTful APIs to manage cars, including CRUD operations, filtering, and sorting capabilities. The API is documented using Swagger/OpenAPI.

---

## Features

- **Add a Car**: Add a new car to the system.
- **View All Cars**: View a paginated list of all cars.
- **Filter Cars**: Filter cars by name, model, year, color, and fuel type.
- **Sort Cars**: Sort cars based on various fields such as name, price, etc.
- **Update Car**: Update car details partially or fully.
- **Delete Car**: Delete a car by ID.
- **API Documentation**: Interactive API documentation using Swagger UI.

---

## Requirements

- Java 17+
- Maven 3+
- MySQL Server
- IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code)

---

## Setup Instructions

### 1. Clone the Repository
```bash
$ git clone  https://github.com/prataps007/car-management-system.git
$ cd car-management-system
```

### 2. Configure the Database
- Create a MySQL database named `cardb`.
- Update the `application.properties` file with your database credentials:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/cardb
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
  ```

### 3. Build and Run the Application
- Build the project using Maven:
  ```bash
  $ mvn clean install
  ```
- Run the application:
  ```bash
  $ mvn spring-boot:run
  ```

### 4. Access the Application
- Swagger UI: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- API Documentation: [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)

---

## API Endpoints

### Base URL
`http://localhost:8081/api`

### Endpoints

#### **1. Add a Car**
- **POST** `/cars`
- **Request Body:**
  ```json
  {
    "name": "Tesla Model S",
    "model": "Model S",
    "year": 2022,
    "price": 79999.99,
    "color": "Red",
    "fuelType": "Electric"
  }
  ```

#### **2. Get All Cars**
- **GET** `/cars`
- **Query Parameters:**
  - `page` (optional): Page number (default: 0)
  - `size` (optional): Page size (default: 10)
  - `sort` (optional): Field to sort by (e.g., `name,asc` or `price,desc`)
  - Filters:
    - `name` (optional): Filter by car name
    - `model` (optional): Filter by car model
    - `year` (optional): Filter by year
    - `color` (optional): Filter by color
    - `fuelType` (optional): Filter by fuel type

#### **3. Update Car**
- **PUT** `/cars/{id}`
- **Request Body (Partial Update):**
  ```json
  {
    "price": 75999.99
  }
  ```

#### **4. Delete Car**
- **DELETE** `/cars/{id}`

#### **5. Search Cars**
- Use the `/cars` endpoint with appropriate query parameters to search for cars.

---

## Development Notes

- **Technologies Used:**
  - Spring Boot
  - Hibernate (JPA)
  - MySQL
  - Swagger/OpenAPI
  - Maven
  
- **Architecture:**
  - Controller-Service-Repository pattern
  - RESTful API design principles

---

## Future Enhancements

- Add user authentication and authorization.
- Introduce caching for frequently accessed data.
- Implement advanced search functionality.

---

## License
This project is licensed under the MIT License.

