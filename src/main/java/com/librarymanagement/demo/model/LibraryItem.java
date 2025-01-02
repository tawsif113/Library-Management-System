package com.librarymanagement.demo.model;

public interface LibraryItem {
    public int getId();
    public void setId(int id);
    public String getTitle();
    public void setTitle(String title);
    public int getPublicationYear();
    public void setPublicationYear(int publicationYear);
    public String getGenre();
    public void setGenre(String genre);
}
