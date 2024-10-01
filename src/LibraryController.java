import java.util.Scanner;
import java.util.ArrayList;

public class LibraryController {
    private Librarian lib;
    private Scanner s;
    
    public LibraryController(){
        lib = new Librarian();
        s = new Scanner(System.in);
    }


    public void search(){
        String method = "";
        boolean isValidMethod = false;

        // keep getting user input until they input "title" or "author" or "rating"
        while(!isValidMethod){
            System.out.println("Please enter method of search(title, author, or rating):");
            method = s.nextLine();
            isValidMethod = method.equalsIgnoreCase("title")  ||
                            method.equalsIgnoreCase("author") ||
                            method.equalsIgnoreCase("rating");

            // print error message if bad input
            if(!isValidMethod){
                System.out.println("Invalid input. Please enter 'title', 'author', or 'rating'.");
            }
        }

        String search = "";
        System.out.println("Please enter the " + method + " you would like to search");
        search = s.nextLine();	
        System.out.println("Searching for book by "+ method + "...");
        System.out.println(lib.search(method, search));
    }


    public void addBook(){
        // get info about new book
		System.out.println("Please enter title of book to be added:");
		String title = s.nextLine();
		System.out.println("Please enter author of book to be added:");
		String author = s.nextLine();
		System.out.println("Adding book to library...");

		// create new book
		Book newBook = new Book(title, author);
		lib.addBook(newBook);
    }


    public void setToRead(){
        System.out.println("Enter title of book that you read:");
		String title = s.nextLine();
		System.out.println("Enter the author of book that you read:");
		String author = s.nextLine();
		// can add status message here if we want
		lib.setToRead(title, author);
    }


    public void rate(){
        System.out.println("Enter title for book you want to rate:");
		String title = s.nextLine();
		System.out.println("Enter author for book you want to rate:");
		String author = s.nextLine();
		String  rating = "";
		boolean isValidRate = false;
		ArrayList<String> range = new ArrayList<String>();
		range.add("1");
		range.add("2");
		range.add("3");
		range.add("4");
		range.add("5");

			
		// loop to get valid rating(1-5)
		while(!isValidRate){
			System.out.println("Please enter rating for book(1-5):");
			rating = s.nextLine();
			if(range.contains(rating)){
				isValidRate = true;
            }
			if(!isValidRate){
				System.out.println("Invalid input. Please enter an integer 1-5");
			}
		}
		int r = Integer.parseInt(rating);
		lib.rate(title, author, r);
    }


    public void getBooks(){
        boolean isValidMethod = false;
		String method = "";
		
		while(!isValidMethod){
			System.out.println("Please select what method you would like to sort the books(title,author,read,unread)");
			method = s.nextLine();
			isValidMethod = method.equalsIgnoreCase("title")  ||
							method.equalsIgnoreCase("author") ||
							method.equalsIgnoreCase("read")   ||
							method.equalsIgnoreCase("unread");
			// print error message if bad input
			if(!isValidMethod){
				System.out.println("Invalid input. Please enter 'title', 'author', 'read', or 'unread'.");
			}
		}
		System.out.println(lib.getBooks(method));
    }


    public void suggestRead(){
        Book suggestion = lib.suggestRead();
        System.out.println("Here is a book suggestion that you haven't read:");
        System.out.println(suggestion.toString());
    }


    public void addBooks(){
        System.out.println("Please enter file name:");
        String fileName = s.nextLine();
        lib.addBooks(fileName);
    }


    public void closeScanner(){
        s.close();
    }

}
