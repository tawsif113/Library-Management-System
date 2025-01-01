package com.librarymanagement.demo.model;

/**
 * Represents a Book with properties such as ID, title, author, publication year, and genre.
 * This class serves as a model for managing book details in a library system.
 * It provides getters and setters for its attributes and includes an override for the toString method for printing objects with ease.
 *
 * Features:
 * - Each book is uniquely identified using an ID.
 * - Stores metadata about the book including title, author, publication year, and genre.
 * - Provides methods to retrieve and modify these attributes.
 * - Used across the library management application for operations like adding, retrieving, searching, or removing books.
 *
 * Typical usage:
 * - This class is instantiated when adding new books to the library.
 * - Serves as a data structure within the library's book collection.
 */

public class Book {

    private int id;

    private String title;
    private String author;
    private int publicationYear;
    private String genre;

    public Book(int id,String title, String author, int publicationYear, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return "\nBook ID: "+id + " Title: "+title+" Author: "+author+" Publication Year: "+publicationYear+" Genre: "+genre;
    }
}
