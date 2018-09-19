 package edu.uga.cs1302.txtbuff;

/**
 * 
 * This class is comprised of constructors and methods used to store a line of
 * text as a char array and manipulate it in specified ways.
 * 
 * 
 * @author Emma Kasper
 *
 */
public class TextLine {

    /**
     * A constant that represents the default size of each array. If it needs to
     * widened it is done so by 80 each time.
     * 
     */
    public static final int DEFAULT_SIZE = 80;

    /**
     * This variable represents the size of each array created.
     */
    public int arrayCap;

    /**
     * A variable that represents the length of this TextLine
     */

    public int length;

    /**
     * The array of each TextLine object.
     */
    char[] txtArray;

    /**
     * This constructs an empty TextLine object with the default size constant as
     * the capacity and sets the length to 0.
     */
   
  

    public TextLine() {

	length = 0;
	arrayCap = DEFAULT_SIZE;
	txtArray = new char[arrayCap];
    }

    /**
     * This constructs a TextLine object initialized to contain the same characters
     * as in the argument. The line length is set to the length of the argument, but
     * the capacity of the internal array is set to the smallest multiple of the
     * default constant that can store the line.
     * 
     * @param line
     *            The line parameter is the string that is to be placed in the
     *            TextLine array.
     */
    public TextLine(String line) {
	arrayCap = DEFAULT_SIZE;
	length = line.length();
	if (length > DEFAULT_SIZE) {
	    while (arrayCap < length)
		arrayCap += DEFAULT_SIZE;
	}
	txtArray = new char[arrayCap];

	for (int i = 0; i < length; i++) {
	    txtArray[i] = line.charAt(i);
	}
    }

    /**
     * This method returns the index position of the first occurrence of the
     * fragment in the TextLine or -1 if the fragment isn't found.
     * 
     * @param fragment
     *            This is the string that is searched for within the TextLine \
     * @return This returns the first instance of the fragment within the TextLine.
     *         If the fragment is not found within the TextLine, then a -1 value is
     *         returned.
     */
    public int indexOf(String fragment) {

	int length = fragment.length() - 1;

	for (int i = 0; i < this.length(); i++) {
	    int temp = i;
	    int j = 0;

	    while (fragment.charAt(j) == txtArray[i]) {
		if (j == length)

		    {
			return temp;
		    }

		else {

		    i++;
		    j++;
		}
	    }

	    i = temp;
	    j = 0;
	}

	return -1;
    }

    /**
     * This method returns the index position of the first occurrence of the
     * fragment in the TextLine or -1 if the fragment isn't found.
     * 
     * @param fragment
     *            This is the string that is searched for within the TextLine
     *            object.
     * @param fromIndex
     *            This is the index from which the search for the fragment begins.
     * @return This method returns an integer value of the first occurrence of the
     *         fragment from the starting index. If no match is found, then a -1 is
     *         returned.
     */
    public int indexOf(String fragment, int fromIndex) {

	int length = fragment.length() - 1;
	for (int i = fromIndex; i < this.length(); i++) {
	    int temp = i;
	    int position = 0;

	    while (fragment.charAt(position) == txtArray[i]) {
		if (position == length) {
		    return temp;
		}
		position++;
		i++;
	    }
	    position = 0;
	    i = temp;
	}
	return -1;
    }

    /**
     * This method returns the length of this TextLine, checks for null characters
     * 
     * @return returns the length of the TextLine object.
     */
    public int length() {
	int txtLineLength = 0;
	for (int i = 0; i < arrayCap; i++) {
	    if (txtArray[i] != '\0')
		txtLineLength = i;
	}
	return txtLineLength + 1;
    }

    /**
     * Returns the current capacity of this TextLine
     * 
     * @return This returns the value of the capacity variable of the TextLine
     *         object.
     */
    public int capacity() {
	return arrayCap;
    }

    /**
     * Returns true if this textLine has the same characters as the argument object
     */
    public boolean equals(Object anObject) {
	if (anObject instanceof TextLine) {
	    String argLine = anObject.toString();

	    for (int i = 0; i < argLine.length(); i++) {
		if (argLine.charAt(i) != this.txtArray[i])
		    return false;
	    }
	    return true;
	}

	else
	    return false;
    }

    /**
     * Returns the contents of this TextLine represented as a Java String
     */
    public String toString() {
	String txtLine = "";
	for (int i = 0; i < txtArray.length; i++) {
	    txtLine += txtArray[i];
	}
	return txtLine;
    }

}