package service;

import model.Book;
import storage.FileStorageService;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class LibraryService implements ILibraryService {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1; //ID Generator
    private FileStorageService storageService;

    public LibraryService() {
        storageService = new FileStorageService();
        books = storageService.loadBooks();

        for (Book book : books) {
            if (book.getId() >= nextId) {
                nextId = book.getId() + 1;
            }
        }
    }

    //Add a book
    @Override
    public void addBook(String title, String author) {
        Book book = new Book(nextId++, title, author);
        books.add(book);
        storageService.saveBooks(books);
    }

    //delete book
    public boolean deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            storageService.saveBooks(books);
        }
        return removed;
    }

    //Get book by id
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }

        }
        return null;
    }

    //Get all books
    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    //Update book
    public boolean updateBook(int id, String newTitle, String newAuthor) {
        Book book = getBookById(id);

        if (book != null) {
            if (!newTitle.isEmpty()) {
                book.setTitle(newTitle);
            }
            if (!newAuthor.isEmpty()) {
                book.setAuthor(newAuthor);
            }
            storageService.saveBooks(books);
            return true;

        }

        return false;
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
