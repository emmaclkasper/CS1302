/**
 * 
 */
package edu.uga.cs1302.txtbuff;

/**
 * A public interface to later be implemented by class EditableTextLine
 * 
 * @author Emma Kasper
 * 
 *
 */

public interface Editable {

    /**
     * Appends the given string fragment at the end of TextLine
     * 
     * @param fragment
     *            This is the string that is going to be added onto the TextLine
     *            object
     */
    void append(String fragment);

    /**
     * Inserts the given string fragment at the specified index of TextLine. A
     * TextLineOutOfBoundsException exception is thrown if the supplied index is out
     * of bounds of a textLine.
     * 
     * @param index
     *            This parameter is the index in which the string is to be inserted.
     * @param fragment
     *            This is the string that is to be inserted within the object.
     * 
     */
    void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException;

    /**
     * Replaces the characters between start(inclusive) and end (exclusive) in this
     * TextLine with characters in the specified string fragment. A
     * TextLineIndexOutOfBoundsException exception is thrown if the supplied start
     * or end index is out of bounds of this TextLine.
     * 
     * @param start
     *            This is the index is the start of the block to be replaced.
     * @param end
     *            This is the index that is to be the end of the block to be
     *            replaced.
     * @param fragment
     *            This is the string value that will fill in the block between start
     *            and finish.
     * 
     */
    void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException;
}
