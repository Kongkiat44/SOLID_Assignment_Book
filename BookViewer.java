import java.util.List;
import java.util.ListIterator;

public class BookViewer implements Book_Reader{
    private String title;
    private List<String> pages;
    private ListIterator<String> iterator;
    private String currentPage;

    public BookViewer(String title, List<String> pages) {
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
    public void printToScreen(){
        BookViewer bookview = this;
        do {
            System.out.println(bookview.getCurrentPage());
        }while (bookview.turnToNextPage());
    }
}
