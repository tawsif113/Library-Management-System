# Library Management System

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Language](https://img.shields.io/badge/language-Java-green.svg)

A RESTful API for managing a library of books. This system allows users to add, remove, search, and view books. The project uses **Spring Boot** for backend development and offers endpoints for all basic CRUD operations.

## Table of Contents
- [Functional Requirements](#functional-requirements)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Exception Handling](#exception-handling)
- [Design Patterns](#design-patterns)
- [Directory Structure](#directory-structure)
- [License](#license)
- [Contributing](#contributing)
- [Contact](#contact)

## Functional Requirements

### 1. Add a Book
- **Description**: Allow users to add a new book to the library inventory via REST API.
- **Input Details**:
    - **Book ID** (unique identifier, integer)
    - **Title** (string)
    - **Author** (string)
    - **Publication Year** (integer)
    - **Genre** (string)
- **Output**: JSON response confirming successful addition or throwing an error for duplicates.
- **Implementation**: 
    - Used `@RestController` for API endpoints.
    - Used `@Service` for business logic.

### 2. Remove a Book
- **Description**: Allow users to remove a book by its ID or Title via REST API.
- **Input Details**:
    - **Book ID** (integer) or **Title** (string)
- **Output**:
    - If found: JSON response with removed book details.
    - If not found: JSON error message.
- **Exception Handling**:
    - Custom exception `BookNotFoundException` for invalid or missing input.
    - Exception handling with `@ControllerAdvice` and `@ExceptionHandler`.

### 3. Search for a Book
- **Description**: Allow users to search for a book by one or more criteria via REST API.
- **Input Details**:
    - **Title** (string, partial matches allowed)
    - **Author** (string, exact match)
    - **Publication Year** (integer, optional filter)
- **Output**: 
    - List of books matching the criteria (JSON)
    - If none found: JSON error message.
- **Implementation**:
    - Used `Streams` for filtering, mapping, and sorting operations.
    - Used Collections to perform search operations in a List.
    - Used `@RequestParam` for query parameters.

### 4. Display All Books
- **Description**: Provided an endpoint to display all books in the inventory.
- **Output**: JSON response with a list of all books, including:
    - Book ID, Title, Author, Publication Year, Genre.
- **Implementation**:
    - Iterated through the List of books and sorted them using Streams.

### 5. Exception Handling
- **Scenarios Handled**:
    - Adding a book with a duplicate ID.
    - Removing a book that doesn't exist.
    - Searching with invalid criteria (e.g., invalid publication year input).
- **Implementation**:
    - Custom exceptions (`DuplicateBookException`, `BookNotFoundException`).
    - Exception handling using `@ControllerAdvice` and `@ExceptionHandler`.

### 6. Singleton Design Pattern
- **Description**: Ensure the library inventory is managed through a single instance.
- **Implementation**:
    - Used Singleton pattern for `LibraryService` class.

### 7. Factory Design Pattern
- **Description**: Created a factory to handle dynamic creation of Book objects.
- **Implementation**:
    - Used `BookFactory` class to create `Book` objects.
    - Injected the factory into the `LibraryService`.

### 8. Exit the Program
- **Description**: Provided an endpoint to safely terminate the application.
- **Implementation**:
    - Used a REST API (POST `/exit`) that shuts down the Spring Boot application gracefully.
    - Utilized `ApplicationContext` to trigger a shutdown.

## Technologies Used

- **Spring Boot**:
    - REST Controllers (`@RestController`)
    - Dependency Injection (`@Service`, `@Component`)
    - Exception Handling (`@ControllerAdvice`)
- **Java 8+ Features**:
    - Streams API
    - Functional programming for filtering and sorting
- **In-Memory Storage**:
    - Use a `List` to store book data.

## Installation

1. Clone this repository:
    ```bash
    git clone https://github.com/your-username/LibraryManagementSystem.git
    ```

2. Navigate to the project directory:
    ```bash
    cd LibraryManagementSystem
    ```

3. Build and run the project using Maven (or Gradle):
    ```bash
    mvn spring-boot:run
    ```

4. The application will run on `http://localhost:8080`.



