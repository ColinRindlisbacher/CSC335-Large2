import java.util.HashMap;

public class ReadBooks {
    private HashMap<Book, Boolean> bookHashMap;

    public ReadBooks() {
        this.bookHashMap = new HashMap<Book, Boolean>();
    }

    public HashMap<Book, Boolean> getReadBooks() {
        return bookHashMap;
    }

    public void addNewBook(Book currBook) {
        if (bookHashMap.containsKey(currBook)) {
            bookHashMap.put(currBook, bookHashMap.get(currBook));
        }
        bookHashMap.put(currBook, false);
    }

    public void readBook(Book currBook) {
        bookHashMap.put(currBook, true);
    }
}
