import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

public class BookFilePublisher implements Book_Publisher{
    private String title;
    private List<String> pages;
    private ListIterator<String> iterator;
    private String currentPage;

    public BookFilePublisher(String title, List<String> pages) {
        this.title = title;
        this.pages = pages;
        iterator = pages.listIterator();
        if (iterator.hasNext()) {
            currentPage = iterator.next();
        } else {
            currentPage = null;
        }
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getCurrentPage(){
        return currentPage;
    }

    @Override
    public boolean turnToNextPage(){
        if (iterator.hasNext()) {
            currentPage = iterator.next();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printToFile(){
        BookFilePublisher bookFilePub = this;
        boolean isEven = false;
        String previousPage = "";
        try {
            FileWriter fileWriter = new FileWriter(bookFilePub.getTitle() + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            do {
                if (isEven) {
                    previousPage = bookFilePub.getCurrentPage();
                    isEven = false;
                } else {
                    printWriter.printf("%-25s : %25s%n", previousPage, bookFilePub.getCurrentPage());
                    isEven = true;
                }
            } while (bookFilePub.turnToNextPage());
            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Cannot print this book due to IOException");
        }
    }
}
