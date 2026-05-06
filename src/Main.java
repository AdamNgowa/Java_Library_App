import service.LibraryService;
import ui.LibraryUI;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        LibraryUI ui = new LibraryUI(service);

        ui.start();

    }
}
