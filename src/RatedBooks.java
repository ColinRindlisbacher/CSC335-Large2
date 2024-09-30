/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: RatedBooks.java
 * Purpose: Holds information about books and their ratings.
 * These ratings can be updated.
 */

import java.util.HashMap;

public class RatedBooks {
    private HashMap<Book, Rating> bookHashMap;

    public RatedBooks() {
        this.bookHashMap = new HashMap<Book, Rating>();
    }

    public HashMap<Book, Rating> getRatings() {
        return bookHashMap;
    }

    public void putRating(Book currBook, int rating) {
        bookHashMap.put(currBook, new Rating(rating));
    }
}
