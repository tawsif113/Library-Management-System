package com.librarymanagement.demo.factory;

import com.librarymanagement.demo.model.Book;
import org.springframework.stereotype.Component;


/**
 * Factory component for creating Book objects.
 *
 * This class provides a method to construct instances of the Book class with specified
 * attributes. The BookFactory is designed to encapsulate the creation logic, providing
 * a clean and consistent way of instantiating Book objects across the application.
 */


@Component
public class BookFactory {
    public Book createBook(int id,String title, String author, int publicationYear, String genre){
        return new Book(id,title,author,publicationYear,genre);
    }
}
