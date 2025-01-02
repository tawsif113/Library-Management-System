# Library Management System

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/language-Java-green.svg)
![Spring Boot](https://img.shields.io/badge/framework-Spring%20Boot-brightgreen.svg)

The Library Management System is a RESTful API built using Spring Boot that provides functionalities to manage a library's book inventory. It supports operations such as adding, removing, searching, and displaying books while implementing design patterns and exception handling for robust and maintainable code.

---

## Functional Requirements

### 1. Add a Book
**Description**: Allows users to add a new book to the library inventory via a REST API.  
- **Input Details**:  
  - `Book ID` (unique identifier, integer) /// ID is auto generated used AtomicInteger  
  - `Title` (string)  
  - `Author` (string)  
  - `Publication Year` (integer)  
  - `Genre` (string)  
- **Output**: JSON response confirming successful addition or throwing an error for duplicates.  
- **Spring Features Used**:  
  - REST controller: `@RestController` for API endpoints.  
  - Services: `@Service` for business logic.  

---

### 2. Remove a Book
**Description**: Allows users to remove a book by its ID or Title via a REST API.  
- **Input Details**:  
  - `Book ID` (integer) or `Title` (string).  
- **Output**:  
  - **If found**: JSON response with removed book details.  
  - **If not found**: JSON error message.  
- **Exception Handling**:  
  - Custom exception: `NotFoundException`.  
  - Handled with `@ControllerAdvice` and `@ExceptionHandler`.  

---

### 3. Search for a Book
**Description**: Allows users to search for a book by one or more criteria via a REST API.  
- **Input Details**:  
  - `Title` (string, partial matches allowed).  
  - `Author` (string, exact match).  
  - `Publication Year` (integer, optional filter).  
- **Output**:  
  - List of books matching the criteria (JSON).  
  - **If none found**: JSON error message.  
- **Features Used**:  
  - Streams: Filtering, mapping, and sorting operations.  
  - Collections: Search operations within a `List`.  
  - Query Parameters: `@RequestParam` in REST APIs.  

---

### 4. Display All Books
**Description**: Provides an endpoint to display all books in the inventory.  
- **Output**: JSON response with a list of all books, each containing:  
  - `Book ID`, `Title`, `Author`, `Publication Year`, and `Genre`.  
- **Features Used**:  
  - Collections: Iterate through the `List` of books.  
  - Streams: Sort books by `Title` or `Publication Year`.  
  - REST Endpoint: `GET /books`.  

---

### 5. Exception Handling
**Scenarios Handled**:  
- Adding a book with a duplicate ID.  
- Removing a book that doesn't exist.  
- Searching with invalid criteria (e.g., invalid publication year).  

**Implementation Details**:  
- Custom Exceptions:  
  - `DuplicateBookException`.  
  - `BookNotFoundException`.  
- Exception Handling:  
  - Using `@ControllerAdvice` and `@ExceptionHandler`.  

---

### 6. Singleton Design Pattern
**Description**: Ensures the library inventory is managed through a single instance.  
**Implementation**:  
- Singleton pattern used in `LibraryService` class.  

---

### 7. Factory Design Pattern
**Description**: Handles dynamic creation of `Book` objects.  
**Implementation**:  
- `BookFactory` class used to create `Book` objects.  
- Factory injected into `LibraryService`.  

---

### 8. Exit the Program
**Description**: Provides an endpoint to safely terminate the application.  
**Implementation**:  
- REST API: `POST /exit` for shutting down the Spring Boot application gracefully.  
- Utilized `ApplicationContext` to trigger shutdown.  

---


## Directory Structure

```plaintext
src/main/java/com/librarymanagement/
├── controller/
│   ├── BookController.java         // REST API endpoints
├── service/
│   ├── LibraryService.java         // Business logic
├── factory/
│   ├── BookFactory.java            // Factory for creating Book objects
├── exception/
│   ├── BookNotFoundException.java  // Custom exceptions
│   ├── DuplicateBookException.java
├── model/
│   ├── Book.java                   // Book class
├── LibraryManagementApplication.java  // Main Spring Boot application
├── ShutdownHook.java              // Clean up before shutdown

---
