import service.LibraryService;
import ui.LibraryUI;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        service.loadFromFile(); //Load on startup

        LibraryUI ui = new LibraryUI(service);
        ui.start();

        service.saveToFile();//save on exit

    }
}
