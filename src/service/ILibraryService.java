package service;

import model.Book;
import java.util.List;

public interface ILibraryService {
    void addBook(String title,String author);
    List<Book> getAllBooks();
    List<Book> searchByTitle(String title);
}
