package ui;

import service.ILibraryService;
import service.LibraryService;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class LibraryUI {
    private ILibraryService service;
    private Scanner scanner = new Scanner(System.in);

    public LibraryUI(ILibraryService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Book");
            System.out.println("6. View Book by Id");
            System.out.println("7. Exit");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid Input.Please Enter a number");
                scanner.nextLine();//Clear bad input
                continue;
            }

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
                    deleteBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    viewBookById();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    //add books
    private void addBook() {

        System.out.println("Enter title");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty");
            return;
        }

        System.out.println("Enter Author:");
        String author = scanner.nextLine().trim();

        if (author.isEmpty()) {
            System.out.println("Author cannot be empty");
            return;
        }


        service.addBook(title, author);
        System.out.println("Book added successfully!");
    }

    //View books
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

    //Search books by title
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

    //Search books by id
    public void viewBookById() {
        System.out.println("Enter the book ID");
        int id = scanner.nextInt();
        scanner.nextLine();


        Book book = service.getBookById(id);
        if (book == null) {
            System.out.println("Book not found");
        } else {
            System.out.println(book);
        }


    }

    //Delete Books
    private void deleteBook() {
        System.out.println("Enter book Id to delete");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = service.deleteBook(id);
        if (deleted) {
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }

    //Update books
    private void updateBook() {
        System.out.println("Enter Book Id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("New Title(Leave it blank,to keep current title)");
        String title = scanner.nextLine();

        System.out.println("new Author(Leave it blank to keep the current author)");
        String author = scanner.nextLine();

        boolean updated = service.updateBook(id, title, author);
        if (updated) {
            System.out.println("Book updated.");
        } else {
            System.out.println("Book not found");
        }
    }
}
