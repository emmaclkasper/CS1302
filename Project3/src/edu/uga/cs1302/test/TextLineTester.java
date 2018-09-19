package edu.uga.cs1302.test;

import edu.uga.cs1302.txtbuff.*;
import java.util.Scanner;

/**
 * Class includes main method to test classes in package edu.uga.cs1302.test
 *
 * @author Emma Kasper
 *
 */
public class TextLineTester {

    public static void main(String[] args) {

	// gathering user input
	Scanner input = new Scanner(System.in);
	TextLine tLine = new TextLine("one line of text");
	System.out.print("Please enter a line of text: ");
	System.out.println();

	EditableTextLine eLine = new EditableTextLine(input.nextLine());

	// compares two objects for equality
	System.out.println("Does tLine equal an object of eLine?: ");

	if (tLine.equals(eLine))
	    System.out.println("tLine is the same as eLine");
	else
	    System.out.println("tLine is different than eLine");

	// printing string representation of eLine
	System.out.println();
	System.out.println("eLine: \t\t" + eLine.toString());
	System.out.println("eLine Length: \t" + eLine.length() + "\n" + "eLine Capacity: " + eLine.capacity());

	System.out.println();
	System.out.print("Please enter a string of characters: ");
	System.out.println();

	// gathering more user input
	String str = input.next();
	System.out.println();

	System.out.println("Str: \t\t\t\t\t" + str);
	int occurrence = 0;
	int index = 0;
	int indexOfStr = eLine.indexOf(str);

	// counting how many times str appears in eLine
	if (indexOfStr == -1)
	    System.out.println("Number of occurances of str in eLine:\tnone");
	else {

	    for (int i = 0; i < eLine.length(); i++) {
		int indexOfStrAtIndex = eLine.indexOf(str, i);

		if (eLine.indexOf(str, i) == 0) {
		    occurrence++;
		} else if (index != indexOfStrAtIndex && indexOfStrAtIndex != -1) {
		    occurrence++;
		    index = indexOfStrAtIndex;
		}
	    }
	    System.out.println("Number of occurances of str in eLine: \t" + occurrence);
	}

	// adding str to the end of eLine
	eLine.append(str);
	System.out.println("Fragment Appended to eLine: \t\t" + eLine.toString());

	// inserts str at index 0 of eLine
	eLine.insert(0, str);
	System.out.println("Fragment Inserted to eLine: \t\t" + eLine.toString());

	// inserts str at specified index of eLine
	eLine.insert(str.length(), str);
	System.out.println("Fragment Inserted at Index to eLine: \t" + eLine.toString());

	// finding occurrences of str and replacing them with 'abc'
	int indexCount = 0;
	while (indexCount != -1) {

	    int start = eLine.indexOf(str, indexCount);
	    int end = eLine.indexOf(str, indexCount) + 3;
	    if (start == -1)
		indexCount = -1;
	    else {
		eLine.replace(start, end, "abc");
		indexCount += str.length();
	    }
	}

	System.out.println("Replaced ALL occurences of str w/ abc:  " + eLine.toString());

    }

}