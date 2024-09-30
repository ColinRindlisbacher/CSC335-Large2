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

			input = s.next();

			switch(input){
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
				case "2":
					System.out.println("Adding book to library...");
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					break;
				case "6":
					break;
				case "7":
					break;
			}
		}
		s.close();
	}

}
