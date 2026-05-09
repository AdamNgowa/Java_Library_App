package model;

public class Book {
    private final int id;
    private String title;
    private String author;

    //Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    //Display format
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }

}
