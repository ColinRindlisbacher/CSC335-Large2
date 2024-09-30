/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: AuthorComparator.java
 * Purpose: Serves as the comparator for the book class to compare
 * by Author which can be helpful when sorting by Author.
 */

import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {
    /**
     * @pre book1 != null && book2 != null
     */
    public int compare(Book book1, Book book2) {
        return book1.getAuthor().compareTo(book2.getAuthor());
    }
}