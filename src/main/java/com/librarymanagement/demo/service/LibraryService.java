package com.librarymanagement.demo.service;


import com.librarymanagement.demo.exception.DuplicateBookException;
import com.librarymanagement.demo.exception.NotFoundException;
import com.librarymanagement.demo.factory.BookFactory;
import com.librarymanagement.demo.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * LibraryService provides functionality for managing a collection of books.
 * It offers capabilities for adding, removing, searching, and retrieving books.
 * This service ensures that no duplicate books (having the same title and author) can be added.
 * It maintains an in-memory list of books and assigns unique IDs to each book using an atomic counter.
 *
 * Key Features:
 * 1. Initialization of sample data upon service construction.
 * 2. Adding new books with title, author, publication year, and genre information.
 * 3. Removing books based on ID or title.
 * 4. Searching for books with optional filtering by title, author, and publication year.
 * 5. Retrieving all books sorted alphabetically by title.
 *
 * Throws:
 * - DuplicateBookException when attempting to add a book that already exists based on title and author.
 * - NotFoundException when attempting to remove or search for a book that does not exist in the collection.
 */

@Service
public class LibraryService {

    private final List<Book> bookList = new ArrayList<>();

    private final BookFactory bookFactory;
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public LibraryService(BookFactory bookFactory){
        this.bookFactory = bookFactory;
    }

    @PostConstruct
    public void initSampleData() {
        bookList.add(new Book(idGenerator.getAndIncrement(), "The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction"));
        bookList.add(new Book(idGenerator.getAndIncrement(), "To Kill a Mockingbird", "Harper Lee", 1960, "Fiction"));
        bookList.add(new Book(idGenerator.getAndIncrement(), "1984", "George Orwell", 1949, "Dystopian"));
    }

    private void validateBookInputs(String title, String author, int year, String genre) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be a positive number");
        }
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
    }

    public String addBook(String title, String author, int year, String genre){

        validateBookInputs(title,author,year,genre);

        if(bookList.stream()
                .anyMatch(book->(book.getTitle().equalsIgnoreCase(title)) && (book.getAuthor().equalsIgnoreCase(author)))){
            throw new DuplicateBookException("book with Same title and author exits in database");
        }

        Book newBook = bookFactory.createBook(idGenerator.getAndIncrement(),title,author,year,genre);
        bookList.add(newBook);

        return "New Book added\n"+newBook;
    }

    public String removeBookById(int id){
        Book book = bookList.stream().filter(_book->_book.getId() == id).findFirst()
                .orElseThrow(()->new NotFoundException("Book not found with given ID"));

        bookList.remove(book);

        return "Removed Book : "+book;
    }

    public String removeBookByTitle(String title){

        Book book = bookList.stream().filter(_book->_book.getTitle().equalsIgnoreCase(title)).
                findFirst().orElseThrow(()->new NotFoundException("Book not found with given Title"));

        bookList.remove(book);

        return "Removed Book : "+book;
    }
    public List<Book> searchBooks(String title,String author,Integer publicationYear){

        List<Book> results = bookList.stream().filter(
                book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author)) &&
                        (publicationYear == null || book.getPublicationYear() == publicationYear))
                .collect(Collectors.toList());

        if(results.isEmpty())throw new NotFoundException("No Such Book Found");

        return results;
    }

    public List<Book> getAllBooks(){

        return bookList.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }



}
