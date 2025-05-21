# Coffee Shop Menu Application

A Spring Boot application for managing a coffee shop menu with complete CRUD operations (Create, Read, Update, Delete).

## Project Overview

This application allows coffee shop owners to:
- View the current menu items
- Add new menu items
- Update existing menu items
- Delete menu items

The application is built using Spring Boot and Spring Data JPA for database operations, with Thymeleaf for the view layer.

## Technology Stack

- Java 11+
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

## Project Structure

```
src/main/java/com/coffeeshop/menu/
├── CoffeeShopMenuApplication.java
├── controller/
│   └── ProductController.java
├── model/
│   └── Product.java
├── repository/
│   └── ProductRepository.java
├── service/
│   ├── ProductService.java
│   └── ProductServiceImpl.java
└── resources/
    ├── application.properties
    ├── static/
    │   └── css/
    │       ├── styles.css
    │       └── add-product-styles.css
    └── templates/
        ├── menu.html
        ├── add-new-product.html
        └── update-product.html
```

## Database Configuration

The application is configured to connect to a MySQL database. The configuration is in `application.properties`:

```properties
spring.application.name=CoffeeShopMenu
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

## Key Features Implementation

### 1. Product Entity

The `Product` class represents a menu item with:
- ID (auto-generated)
- Name (with validation)
- Price (with validation)

### 2. Repository Layer

The `ProductRepository` interface extends JpaRepository to enable CRUD operations.

### 3. Service Layer

The service layer includes:
- `ProductService` interface defining operations
- `ProductServiceImpl` class implementing these operations

### 4. Controller Layer

The `ProductController` handles HTTP requests and manages the flow between the service layer and views.

### 5. View Layer (Thymeleaf Templates)

- `menu.html`: Displays all products with Update and Delete buttons
- `add-new-product.html`: Form for adding new products
- `update-product.html`: Form for updating existing products

## Implemented Features

### Product Creation
- Form for adding new products
- Validation of inputs
- Saving to database

### Product Listing
- Display of all products in a table
- Product ID, name, and price information

### Product Update
- Update button for each product
- Pre-populated form with existing product details
- Saving updated information to database

### Product Deletion
- Delete button for each product
- Confirmation and removal from database

## Implementation Details

### Update Feature

The update functionality was implemented by:
1. Adding a getProductById() method to the service layer
2. Creating an update button on the menu page
3. Adding a controller method to handle update requests
4. Creating an update form view pre-populated with product data

### Delete Feature

The delete functionality was implemented by:
1. Adding a deleteProductById() method to the service layer
2. Creating a delete button on the menu page
3. Adding a controller method to handle delete requests

## Running the Application

1. Clone the repository
2. Ensure MySQL is running with the correct database
3. Update database credentials in application.properties if needed
4. Run CoffeeShopMenuApplication.java
5. Access the application at http://localhost:8080

## Next Steps / Future Enhancements

- Add product categories
- Implement user authentication and authorization
- Add product images
- Create a shopping cart functionality
- Implement search and filtering options
