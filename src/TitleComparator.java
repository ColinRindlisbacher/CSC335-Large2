/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: TitleComparator.java
 * Purpose: Serves as the comparator for the book class to compare
 * by Title which can be helpful when sorting by Title.
 */

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    /**
     * @pre book1 != null && book2 != null
     */    
    public int compare(Book book1, Book book2) {
        return book1.getTitle().compareTo(book2.getTitle());
    }
}