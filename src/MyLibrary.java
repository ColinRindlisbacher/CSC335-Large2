/*
 * Authors: AJ Cronin and Colin Rindlisbacher
 * File: MyLibrary.java
 * Purpose: Serves as the view/UI for our Library.
 * Gets and validates user inputs and calls the 
 * related methods.
 */

import java.util.Scanner;

public class MyLibrary {

	public static void main(String[] args) {
		LibraryController libCon = new LibraryController();
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
					libCon.search();
					break;

				// add book selected
				case "2":
					libCon.addBook();
					break;

				// setToRead selected
				case "3":
					libCon.setToRead();
					break;

				// rate selected
				case "4":
					libCon.rate();
					break;

				// getBooks selected
				case "5":	
					libCon.getBooks();
					break;

				// suggestRead selected
				case "6":
					libCon.suggestRead();
					break;

				// addBooks selected
				case "7":
					libCon.addBooks();
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
		libCon.closeScanner();
		System.out.println("Thank you for visiting CroRind Library, have a good day!");
	}

}
