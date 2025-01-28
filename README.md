# Category Service

This project is a microservice developed with Spring Boot that manages categories and their related products for an online store. It provides a RESTful API to perform operations like creating categories, retrieving all categories, and fetching products associated with a specific category.

## Requirements

- Java 17 or higher
- Maven
- Spring Boot
- Database (configure the database connection in the `application.properties` or `application.yml` file)
- Spring Cloud (for service discovery and Feign clients)

## Project Description

This microservice allows interaction with a database to perform the following operations:

- **Create Category**: Allows the creation of a new product category.
- **Get All Categories**: Retrieves a list of all product categories.
- **Get Products and Category by ID**: Fetches products and category details based on a category ID.

## Project Structure

The project follows a layered architecture with the following main components:

- **Controller**: Defines the API endpoints. The `CategoryController` class exposes the endpoints for creating categories, fetching all categories, and getting products by category ID.
- **Model**: Represents the `Category` entity with necessary attributes such as `id_category` and `name`.
- **DTO**: Data Transfer Objects (DTOs) are used for transferring data between layers. `CategoryDTO` contains category details along with the associated products in the category. `ProductDTO` contains product details.
- **Repository**: Provides database access via Spring Data JPA. The `ICategoryRepository` interface defines methods for querying categories from the database.
- **Service**: Contains business logic. The `CategoryService` class implements the `ICategoryService` interface and handles category operations.
- **Feign Client**: The `IProductAPI` interface uses Feign to communicate with the `products-category-service` to retrieve products associated with a category.

## Technology Stack

- **Spring Boot**: Framework used to build the microservice.
- **Spring Data JPA**: For interacting with the database.
- **Feign**: For communication between services (using the products-category-service).
- **Spring Cloud**: For enabling service discovery with `@EnableDiscoveryClient`.

## API Endpoints

### 1. Create a Category

- **Endpoint**: `POST /category/create`
- **Description**: Creates a new category.
- **Request Body**:
    ```json
    {
        "name": "Category Name"
    }
    ```

### 2. Retrieve All Categories

- **Endpoint**: `GET /category/bring_all`
- **Description**: Retrieves a list of all categories.
- **Response**:
  - **Status Code**: 200
  - **Example Response**:
    ```json
    [
      {
        "id_category": 1,
        "name": "Electronics"
      },
      {
        "id_category": 2,
        "name": "Clothing"
      }
    ]
    ```