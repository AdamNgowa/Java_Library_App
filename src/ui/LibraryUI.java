package ui;

import service.LibraryService;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class LibraryUI {
    private LibraryService service;
    private Scanner scanner = new Scanner(System.in);

    public LibraryUI(LibraryService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();//Consume next line

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    private void addBook() {

        System.out.println("Enter title");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty");
            return;
        }

        System.out.println("Enter Author:");
        String author = scanner.nextLine();

        if (author.isEmpty()) {
            System.out.println("Author cannot be empty");
            return;
        }


        service.addBook(title,author);
        System.out.println("Book added successfully!");
    }

    private void viewBooks() {
        List<Book> books = service.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }

    }

    private void searchBooks() {
        System.out.println("Enter title to search: ");
        String title = scanner.nextLine();

        List<Book> results = service.searchByTitle(title);

        if (results.isEmpty()) {
            System.out.println("No books found");
            return;
        }
        for (Book book : results) {
            System.out.println(book);
        }
    }
}
