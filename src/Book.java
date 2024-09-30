/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: Book.java
 * Purpose: Represents a book that has a title and an author.
 */

public class Book {

    private final String title;
    private final String author;
    
    /**
     * @pre title !=null && author !=null
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
