/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: ReadBooks.java
 * Purpose: Holds information about books and their read status.
 * The read status can only be updated to read, not un-read.
 */

import java.util.HashMap;

public class ReadBooks {
    private HashMap<Book, Boolean> bookHashMap;

    public ReadBooks() {
        this.bookHashMap = new HashMap<Book, Boolean>();
    }

    public HashMap<Book, Boolean> getBooks() {
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

    public boolean isRead(Book currBook) {
        return bookHashMap.get(currBook);
    }
}
