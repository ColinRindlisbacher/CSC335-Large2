import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyLibrary {

	public static void main(String[] args) {
		Librarian lib = new Librarian();
		Scanner s = new Scanner(System.in);
		String input = "";

		// Welcome
		System.out.println("Welcome to the CroRind Library!");

		// Main loop until user inputs Q or q
		while(!input.equalsIgnoreCase("q")){
			// printing options
			System.out.println("Please choose from one of the below options:");
			System.out.println("1- Search for a book");
			System.out.println("2- Add a book to Library");
			System.out.println("3- Set a book to read");
			System.out.println("4- Rate a book");
			System.out.println("5- Get a list of books");
			System.out.println("6- Get a book suggestion");
			System.out.println("7- Add books file");
			System.out.println("Type 'q' or 'Q' to exit");

			input = s.nextLine();

			switch(input){
				// book search selected
				case "1":
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
					search = s.nextLine();	
					System.out.println("Searching for book by "+ method + "...");
					lib.search(method, search);
					break;

				// add book selected
				case "2":
					// get info about new book
					System.out.println("Please enter title of book to be added:");
					String title = s.nextLine();
					System.out.println("Please enter author of book to be added:");
					String author = s.nextLine();
					System.out.println("Adding book to library...");
					// create new book
					Book newBook = new Book(title, author);
					lib.addBook(newBook);
					break;

				// setToRead selected
				case "3":
					System.out.println("Enter title of book that you read:");
					title = s.nextLine();
					System.out.println("Enter the author of book that you read:");
					author = s.nextLine();
					// can add status message here if we want
					lib.setToRead(title, author);
					break;

				// rate selected
				case "4":
					System.out.println("Enter title for book you want to rate:");
					title = s.nextLine();
					System.out.println("Enter author for book you want to rate:");
					author = s.nextLine();
					int rating = 0;
					boolean isValidRate = false;
			
					// loop to get valid rating(1-5)
					while(!isValidRate){
						System.out.println("Please enter rating for book(1-5):");
						rating = s.nextInt();

						isValidRate = rating >= 1 && rating <= 5;
						if(!isValidRate){
							System.out.println("Invalid input. Please enter an integer 1-5");
						}
					}
					lib.rate(title, author, rating);
					break;

				// getBooks selected
				case "5":
					isValidMethod = false;
					method = "";
					
					while(!isValidMethod){
						System.out.println("Please select what method you would like to sort the books(title,author,rating,unread)");
						method = s.nextLine();
						isValidMethod = method.equalsIgnoreCase("title")  ||
										method.equalsIgnoreCase("author") ||
										method.equalsIgnoreCase("rating") ||
										method.equalsIgnoreCase("unread");

						// print error message if bad input
						if(!isValidMethod){
							System.out.println("Invalid input. Please enter 'title', 'author', 'rating', or 'unread'.");
						}
					}
					lib.getBooks(method);
					break;

				// suggestRead selected
				case "6":
					Book suggestion = lib.suggestRead();
					System.out.println("Here is a book suggestion that you haven't read:");
					System.out.println(suggestion.toString());
					break;

				// addBooks selected
				case "7":
					System.out.println("Please enter file name:");
					String fileName = s.nextLine();

				    try {
						File file = new File(fileName);
						Scanner fiScanner = new Scanner(file);
						
						while(fiScanner.hasNextLine()){
							String line = fiScanner.nextLine();
							String[] bookInfo = line.split(";");
							// make sure line is valid length of 2
							if(bookInfo.length == 2){
								String newTitle = bookInfo[0].trim();
								String newAuthor = bookInfo[1].trim();
								Book fileBook = new Book(newTitle, newAuthor);
								lib.addBook(fileBook);
							}
						}
						fiScanner.close();
					} catch (FileNotFoundException e) {
						System.out.println("File not found: " + fileName);
					}
					break;

				// if no other valid option is selected
				default:
					// makes sure quit not selected
					if(!input.equalsIgnoreCase("q")){
						System.out.println("Error input is not a valid option, try again.");
					}
					break;
			}
		}
		s.close();
		System.out.println("Thank you for vising CroRind Library, have a good day!");
	}

}
