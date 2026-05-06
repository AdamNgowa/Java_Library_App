package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    //Create an array list
    private List<Book> books = new ArrayList<>();

    //Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    //Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    //Search by title
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }


}
