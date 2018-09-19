package edu.uga.cs1302.txtbuff;

/**
 *
 * Contains constructors for the specific exceptions needed by the
 * EdtiableTextLine class It is derived from java.lang.IndexOutofBoundsException
 *
 *
 * @author Emma Kasper
 *
 */
public class TextLineIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
     * Constructs a TextLineIndexOutOfBoundsException object with no detailed
     * message. It simply calls the default constructor of its superclass
     */
    public TextLineIndexOutOfBoundsException() {
	super();
    }

    /**
     * Constructs a TextLineIndexOutOfBoundsException object with the specified
     * message, given as the argument. This constructor calls the one-parameter
     * constructor of the superclass and passes errMsg as the argument.
     *
     * @param errMsg
     *            The error message that is printed when the exception is thrown
     *
     */
    public TextLineIndexOutOfBoundsException(String errMsg) {
	super(errMsg);
    }

    /**
     * Constructs a new TextLineIndexOutofBoundsException object with an argument
     * indicating the illegal index. It calls the one-parameter constructor of its
     * superclass passing "TextLine index out of range: " + index as the argument.
     *
     * @param index
     *            The index that is thrown in the error message when the exception
     *            is thrown.
     *
     */
    public TextLineIndexOutOfBoundsException(int index) {
	super("TextLine index out of range: " + index);
    }
}