public class Librarian {
    
    RatedBooks ratings;
    ReadBooks readStatus;

    public Librarian() {
        this.ratings = new RatedBooks();
        this.readStatus = new ReadBooks();
    }

    public String search(String method) {
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
        readStatus.addNewBook(newBook);
    }

    public void setToRead(Book bookToUpdate) {

    }

    public void rate(Book bookToUpdate, int newRating) {
        ratings.putRating(bookToUpdate, newRating);
    }

    public void getBooks(String method) {

    }

    public Book suggestRead() {
        return new Book("temp", "temp");
    }

    public void addBooks(String fileName) {

    }
}
