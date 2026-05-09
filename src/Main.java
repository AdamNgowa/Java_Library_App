import service.ILibraryService;
import service.LibraryService;
import ui.LibraryUI;

public class Main {
    public static void main(String[] args) {
        ILibraryService service = new LibraryService();


        LibraryUI ui = new LibraryUI(service);
        ui.start();



    }
}
