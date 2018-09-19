package edu.uga.cs1302.mp3files;

import java.io.File;
import java.util.ListIterator;
import java.util.Scanner;
import javazoom.jl.player.*;

/**
 * The Class MyMP3Files
 *
 * @author emmacaroline
 */

public class MyMP3Files {

	/**
	 * Prints a menu of options the user can select.
	 */
	public static void menu() {
		System.out.println("Enter an option from the menu below");
		System.out.println("Press n to move to the next file if it is present.");
		System.out.println("Press b to move to the previous file if it is present.");
		System.out.println("Press i to print the information about the current file including its path.");
		System.out.println("Press p to play the current file.");
		System.out.println("Press h to print a help screen on the commands.");
		System.out.println("Press q to quit the program.");

	}

	/**
	 * Accepts a path or directory from the user
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // initializing the scanner
		String pathname; // variable for the pathname

		boolean validInput = true; // boolean for valid input for the menu
		boolean check = true; // boolean value to evaluate if a file exists and is a directory

		// do while loop that continues if a file does not exist or is not a directory
		do {
			System.out.println("Enter a pathname of a directory");
			pathname = input.nextLine().trim();

			File validFile = new File(pathname);
			if (validFile.exists() && validFile.isDirectory() == true) {
				check = true;
			}

			else {
				check = false;
				System.out.println("Pathname is not valid");
			}

		} while (check = false);

		File dir = new File(pathname); // creating a file object with parameter of pathname

		SimpleArrayList<MP3File> mp3s = new SimpleArrayList<MP3File>(); 
		File[] fileArray = dir.listFiles(); // creating an array file from the pathnames that lists the files

	       

		// for loop evaluates that each file ends with a .mp3 suffix if so it is added
		// to the simple array list
		for (int i = 0; i < fileArray.length; i++) {
		    	String validString = fileArray[i].getAbsolutePath();
		    	int stringLength = validString.length();
		       	if (validString.charAt(stringLength - 4) == '.' && validString.charAt(stringLength - 3) == 'm'
					&& validString.charAt(stringLength - 2) == 'p' && validString.charAt(stringLength - 1) == '3')
			    
		       
			    {
				MP3File newMP3 = new MP3File(fileArray[i].getAbsolutePath());
				mp3s.add(newMP3);
	 
			    }
		}

		// creating an iterator for the list of MP3 files
		ListIterator<MP3File> iterator = mp3s.listIterator(0);

		// printing file information while there is a next file
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
			System.out.println();
		}

		while (iterator.hasPrevious()) {
			iterator.previous();
		}

		// do while loop that controls the switch statement, while true the loop ends,
		// if false the loop continues
		do {

			menu();
			String userCommand = input.next();
			switch (userCommand) {

			// option n moves to the next file if it is there
			case ("n"):
				if (iterator.hasNext()) {
					iterator.next();
					validInput = false;
					break;
				}

				else {
					System.out.println("You have reached the end of the list");
					validInput = false;
					break;
				}

				// option b moves to the previous file if it is there
			case ("b"):
				if (iterator.hasPrevious()) {
					iterator.previous();
					validInput = false;
					break;
				}

				else {
					System.out.println("You have reached the top of the list");
					validInput = false;
					break;
				}

				// choice i prints info about the current file including its path
			case ("i"):
       			        System.out.println(iterator.next().toString());
				iterator.previous();
				validInput = false;
				break;
			// choice p plays the current file
			case ("p"):
				iterator.next().play();
				iterator.previous();
				validInput = false;
				break;
			case ("h"):
			    System.out.println("Please enter a valid command");
			    validInput = false;
			    break;
			// choice q terminates the program
			case ("q"):
				System.out.println("Goodbye!");
				//validInput = true;

				System.exit(0);
				break;

			// default case if none of the above cases are selected
			default:
				System.out.println("Invalid selection, enter a valid command.");
				validInput = false;
			}
		} while (validInput == false); // end of loop
		input.close(); // scanner close

	}// main

}// MyMP3Files class
