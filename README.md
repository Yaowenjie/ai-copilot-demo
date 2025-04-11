# PSP Demo

## Description
A Spring Boot application for managing payment orders with support for Alipay, WeChat, and Stripe.

## Requirements
- Java 17
- Maven

## Build and Run
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd psp-demo
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the H2 console (for testing):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: `password`

## API Endpoints
- `POST /api/orders`: Create a new order.
- `GET /api/orders`: Retrieve all orders.
- `GET /api/orders/{id}`: Retrieve an order by ID.
- `PUT /api/orders/{id}`: Update an order.
- `DELETE /api/orders/{id}`: Delete an order.
