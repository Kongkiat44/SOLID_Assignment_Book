import java.util.List;

public class MainBookReader {
    public static void main(String[] args) {
        BookViewer book = new BookViewer("Tyland", List.of("I", "moved", "here", "recently", "too"));
        book.printToScreen();
    }
}
