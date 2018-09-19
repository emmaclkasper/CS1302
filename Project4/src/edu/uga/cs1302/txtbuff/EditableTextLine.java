
package edu.uga.cs1302.txtbuff;

/**
 * EditableTextLine is a subclass of the Textline. This class can perform
 * everything that a TextLine object can, but now has the ability to be edited
 * with specified methods.
 * 
 * 
 * @author Emma Kasper
 *
 */
public class EditableTextLine extends TextLine implements Editable {

    /**
     * Constructs an empty EditableTextLine and makes a call to the parent class
     * constructor
     */
    public EditableTextLine() {
	super();
    }

    /**
     * Constructs an EditableTextLine object initialized to contain the same
     * characters as in the argument line string. Makes a call to the parent
     * constructor passing line as the parameter.
     * 
     * @param line
     *            This is the string that is to be placed at the beginning of the
     *            object.
     */
    public EditableTextLine(String line) {
	super(line);
    }

    /**
     * Appends the given string fragment at the end of TextLine
     * 
     * @param fragment
     *            This is the string that is going to be added onto the TextLine
     *            object
     */
    public void append(String fragment) {

	int length = this.length() + fragment.length();
	while (arrayCap < length) {
	    arrayCap += DEFAULT_SIZE;
	}

	char[] newTxtArray = new char[arrayCap];

	for (int i = 0; i < this.length(); i++) {
	    newTxtArray[i] = txtArray[i];
	}

	int position = 0;
	int totalLength = this.length() + fragment.length();

	for (int i = this.length(); i < totalLength; i++) {
	    newTxtArray[i] = fragment.charAt(position);
	    position++;
	}

	txtArray = newTxtArray;
    }

    /**
     * Inserts the given string fragment at the specified index of TextLine. A
     * TextLineOutOfBoundsException exception is thrown if the supplied index is out
     * of bounds of a textLine.
     * 
     * @param index
     *            This parameter is the index in which the string is to be inserted.
     * @param fragment
     *            This is the string that is to be inserted within the object.
     */
    public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException {
	if (index > arrayCap || index < 0)
	    throw new TextLineIndexOutOfBoundsException(index);

	int length = fragment.length() + length();
	while (length > arrayCap) {
	    arrayCap += DEFAULT_SIZE;
	}

	char[] newTxtArray = new char[arrayCap];

	for (int i = 0; i < index; i++) {
	    newTxtArray[i] = txtArray[i];
	}

	int position = 0;
	int totalLength = index + fragment.length();
	for (int i = index; i >= index && i < totalLength; i++) {
	    newTxtArray[i] = fragment.charAt(position);
	    position++;
	}

	position = 0;
	int anotherPosition = index;
	for (int i = totalLength; anotherPosition < this.length(); i++) {
	    newTxtArray[i] = txtArray[anotherPosition];
	    anotherPosition++;
	}

	txtArray = newTxtArray;
    }

    /**
     * Replaces the characters between start(inclusive) and end (exclusive) in this
     * TextLine with characters in the specified string fragment. A
     * TextLineIndexOutOfBoundsException exception is thrown if the supplied start
     * or end index is out of bounds of this TextLine.
     * 
     * @param start
     *            This integer is the start of the block to be replaced.
     * @param end
     *            This is the integer that is to be the end of the block to be
     *            replaced.
     * @param fragment
     *            This is the string value that will fill in the block between start
     *            and finish.
     */
    public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException {
	if (start > arrayCap || end > arrayCap || start < 0 || end < 0 || start > end)
	    throw new TextLineIndexOutOfBoundsException();

	char[] newTxtArray = new char[arrayCap];
	if (start == 0) {

	    for (int i = 0; i < end; i++) {
		newTxtArray[i] = fragment.charAt(i);
	    }

	    for (int i = end + 1; i < this.length(); i++) {
		newTxtArray[i] = txtArray[i];
	    }

	    txtArray = newTxtArray;

	}

	else {

	    for (int i = 0; i < start; i++) {
		newTxtArray[i] = txtArray[i];
	    }

	    int position = 0;
	    for (int i = start; i >= start && i < end; i++) {
		newTxtArray[i] = fragment.charAt(position);
		position++;
	    }

	    for (int i = end + 1; i < this.length(); i++) {
		newTxtArray[i] = txtArray[i];
	    }

	    txtArray = newTxtArray;

	}

    }
}