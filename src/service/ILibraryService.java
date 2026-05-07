package service;

import model.Book;

import java.util.List;

public interface ILibraryService {
    void addBook(String title, String author);

    boolean deleteBook(int id);

    Book getBookById(int id);

    boolean updateBook(int id, String newTitle, String newAuthor);

    List<Book> getAllBooks();

    List<Book> searchByTitle(String title);
}
