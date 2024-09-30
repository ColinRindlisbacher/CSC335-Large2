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

    public void addBook(Book newBook) {
        allBooks.add(newBook);
        readStatus.addNewBook(newBook);
    }

    public void setToRead(Book bookToUpdate) {
        readStatus.readBook(bookToUpdate);
    }

    public void rate(Book bookToUpdate, int newRating) {
        ratings.putRating(bookToUpdate, newRating);
    }

    public void getBooks(String method) {

    }

    public Book suggestRead() {
        Collections.shuffle(allBooks);
        int i = 0;
        Book currBook = allBooks.get(i);

        while(readStatus.isRead(currBook) && i < allBooks.size()) {
            i++;
            currBook = allBooks.get(i);
        }
        if (i == allBooks.size()) {
            System.out.println("You've read all your books.");
        }
        return currBook;
        
    }

    public void addBooks(String fileName) {

    }
}
