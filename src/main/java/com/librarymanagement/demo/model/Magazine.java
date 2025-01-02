package com.librarymanagement.demo.model;

public class Magazine implements LibraryItem{
    private int id;
    private String title;
    private int publicationYear;
    private String genre;
    private String publisher;
    public Magazine(int id,String title, int publicationYear, String genre, String publisher){
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.publisher = publisher;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public int getPublicationYear() {
        return publicationYear;
    }
    @Override
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    @Override
    public String getGenre() {
        return genre;
    }
    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return "\nMagazine ID: "+id + " Title: "+title+" Publication Year: "+publicationYear+" Genre: "+genre+" Publisher: "+publisher;
    }

}
