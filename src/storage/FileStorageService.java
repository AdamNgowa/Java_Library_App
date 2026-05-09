package storage;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageService {
    private static final String FILE_NAME = "books.txt";

    public void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
                writer.newLine();
            }


        } catch (IOException e) {
            System.out.println("Error saving books");
        }
    }

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    continue;
                }
                try {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];

                    books.add(new Book(id, title, author));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping corrupted record.");
                }


            }

        } catch (IOException e) {
            System.out.println("No saved books found.");
        }
        return books;
    }
}
