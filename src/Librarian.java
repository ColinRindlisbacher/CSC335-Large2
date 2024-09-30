/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: Librarian.java
 * Purpose: Serves as the central controller to the Library Program
 * that performs actions as specified by the MyLibrary class such as
 * rating books, retrieving all books, and searching for books.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Librarian {
    
    RatedBooks ratings;
    ReadBooks readStatus;
    ArrayList<Book> allBooks;

    public Librarian() {
        this.ratings = new RatedBooks();
        this.readStatus = new ReadBooks();
    }

     /**
     * @pre method.equals("title") || method.equals("author") || method.equals("rating")
     */
    public String search(String method, String search) {
        // if (method.equals("title")) {
        //     return searchByTitle;
        // } else if (method.equals("author"){
        //     return searchByAuthor;
        // } else if (method.equals("rating"){
        //     return searchByRating;
        // }
        return "temp";
    }

    /**
     * @param newBook = a book to be added.
     * Purpose: adds books to the full collection and initializes
     * their read status to unread.
     */
    public void addBook(Book newBook) {
        allBooks.add(newBook);
        readStatus.addNewBook(newBook);
    }

    /**
     * @param title = title of book to set to read.
     * @param author = author of book to set to read.
     */
    public void setToRead(String title, String author) {
        Book foundBook = findBook(title, author);
        if (foundBook != null) {
            readStatus.readBook(foundBook);
        }
        
    }

    /**
     * @param title = title of book to be found.
     * @param author = author of book to set to read.
     */

    private Book findBook(String title, String author) {
        for (Book currBook : allBooks) {
            if(title == currBook.getTitle() && author == currBook.getAuthor()) {
                return currBook;
            }
        }
        return null;
    }

    /**
     * @param title = title of book to set to read.
     * @param author = author of book to set to read.
     * @param newRating = the rating that is wanted to be set.
     * @pre newRating int >= 1 and <= 5
     */
    public void rate(String title, String author, int newRating) {
        Book bookToUpdate = findBook(title, author);
        if(bookToUpdate != null){
            ratings.putRating(bookToUpdate, newRating);
        }
        
    }

    /**
     * @param method = the method that you want to list the books by.
     * @pre method.equals("title") || method.equals("author") || method.equals("read")  || method.equals("unread") 
     */
    public String getBooks(String method) {
        // Store all books in a new array as to not mess with the order of the original array.
        ArrayList<Book> booksToPrint = new ArrayList<Book>();
        if (method.equals("title")) {

            booksToPrint = new ArrayList<Book>(allBooks);
            Collections.sort(booksToPrint, new TitleComparator());

        } else if (method.equals("author")){

            booksToPrint = new ArrayList<Book>(allBooks);
            Collections.sort(booksToPrint, new AuthorComparator());

        } else if (method.equals("read")) {

            Collections.sort(allBooks, new TitleComparator());
            for (Book currBook : allBooks) {
                if (readStatus.isRead(currBook)) booksToPrint.add(currBook);
            }

        } else if (method.equals("unread")) {

            Collections.sort(allBooks, new TitleComparator());
            for (Book currBook : allBooks) {
                if (!readStatus.isRead(currBook)) booksToPrint.add(currBook);
            }

        } 

        return arrayToString(booksToPrint, method);
    }

    /**
     * @param booksToPrint = array of books that should be listed in string.
     * @param method = method in which books are being listed by.
     * @return = a random book that has not been read yet.
     */

    private String arrayToString(ArrayList<Book> booksToPrint, String method) {
        String printString = "";
        if (method.equals("author")) {
            for (Book currBook : booksToPrint) {
                printString += String.format("%s : %s\n", currBook.getAuthor(), currBook.getTitle());
            }
        } else {
            for (Book currBook : booksToPrint) {
                printString += String.format("%s : %s\n", currBook.getTitle(), currBook.getAuthor());
            }
        }
        return printString;
    }

    /**
     * @return = a random book that has not been read yet.
     */
    public Book suggestRead() {
        ArrayList<Book> suggestions = new ArrayList<Book>(allBooks);
        Collections.shuffle(suggestions);
        int i = 0;
        Book currBook = suggestions.get(i);

        while(readStatus.isRead(currBook) && i < suggestions.size()) {
            i++;
            currBook = suggestions.get(i);
        }
        if (i == suggestions.size()) {
            System.out.println("You've read all your books.");
        }
        return currBook;
        
    }

    public void addBooks(String fileName) {

    }
}
