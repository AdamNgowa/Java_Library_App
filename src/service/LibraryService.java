package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class LibraryService implements ILibraryService {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1; //ID Generator

    //Add a book
    @Override
    public void addBook(String title, String author) {
        Book book = new Book(nextId++, title, author);
        books.add(book);
    }

    //Get all books
    @Override
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

    //File Persistence
    //Save method
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file:" + e.getMessage());

        }
    }

    //Load method
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];

                books.add(new Book(id, title, author));
                //Keep ID counter in sync
                if (id >= nextId) {
                    nextId = id + 1;
                }
            }

        } catch (IOException e) {
            System.out.println("No existing file found.Starting fresh");
        }
    }


}
