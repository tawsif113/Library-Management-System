package com.librarymanagement.demo.controller;


import com.librarymanagement.demo.model.Book;
import com.librarymanagement.demo.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController is a REST controller that manages endpoints for book-related operations
 * in the library system. It interacts with the LibraryService to handle requests such as
 * adding, removing, searching, and retrieving books.
 *
 * Key Functionality:
 * - Add a new book to the library's collection using a POST request.
 * - Remove a book from the collection by its ID or title using a DELETE request.
 * - Retrieve all books stored in the library using a GET request.
 * - Search for books in the library by title, author, or publication year using a GET request with query parameters.
 *
 * Endpoints:
 * 1. POST /add:
 *    Adds a new book to the library with details such as title, author, year, and genre.
 *    Delegates the operation to the libraryService's addBook method.
 *
 * 2. DELETE /remove:
 *    Removes a specific book from the library.
 *    Supports removal by ID or title, based on the query parameters provided.
 *    Delegates the operation to the libraryService's removeBookById or removeBookByTitle methods.
 *
 * 3. GET /books:
 *    Retrieves a sorted list of all books in the library.
 *    Delegates the operation to the libraryService's getAllBooks method.
 *
 * 4. GET /search:
 *    Allows searching for books in the library based on title, author, or year.
 *    Delegates the operation to the libraryService's searchBooks method.
 *
 * Dependency:
 * - Requires an instance of LibraryService, injected via the constructor to manage
 *   the business logic for book operations.
 */


@RestController
public class BookController {
    private final LibraryService libraryService;

    @Autowired
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {

        return libraryService.addBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getGenre());

    }

    @DeleteMapping("/remove")
    public String removeBook(@RequestParam(required = false) int id, @RequestParam(required = false) String title) {

        if (title != null) return libraryService.removeBookByTitle(title);
        else return libraryService.removeBookById(id);

    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();

    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) Integer year) {
        return libraryService.searchBooks(title, author, year);
    }


}
