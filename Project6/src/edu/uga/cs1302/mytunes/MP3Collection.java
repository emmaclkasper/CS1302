package edu.uga.cs1302.mytunes;

import java.util.*;
import java.io.File;
import java.lang.*;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class MP3Collection.
 */
public class MP3Collection {

    /** The collection. */
    List<MP3File> collection;

    /** The file list. */
    //private static String directory;
    private File[] fileList = null;

    /** The Player. */
    private MP3Player Player = new MP3Player();

    /**
     * Instantiates a new MP 3 collection.
     */
    public MP3Collection() {

	collection = new LinkedList<MP3File>();
	Player = new MP3Player();

    }

    /**
     * Instantiates a new MP 3 collection.
     *
     * @param directoryPathname the directory pathname
     */
    public MP3Collection(String directoryPathname) {
	collection = new LinkedList<MP3File>();
	File validFile = new File(directoryPathname);

	String pathname;

	if (validFile.exists() && validFile.isDirectory()) {
	    pathname = directoryPathname;

	}

	else {
	    System.out.println("File is not valid");
	    pathname = "./Music";
	}

	File anotherValidFile = new File(pathname);
	fileList = anotherValidFile.listFiles();

	for (int i = 0; i < fileList.length; i++) {
	    String validMP3 = fileList[i].getAbsolutePath();
	    int stringLength = validMP3.length();

	    if (validMP3.charAt(stringLength - 4) == '.' && validMP3.charAt(stringLength - 3) == 'm'
		&& validMP3.charAt(stringLength - 2) == 'p' && validMP3.charAt(stringLength - 1) == '3')

		collection.add(new MP3File(fileList[i].getAbsolutePath().toString()));

	}
    }

    /**
     * Gets the table data.
     *
     * @return the table data
     */
    public Object[][] getTableData() {

	Object[][] tableData = new Object[collection.size()][4];

	for (int i = 0; i < collection.size(); i++) {
	    tableData[i][0] = collection.get(i).getAuthor();
	    tableData[i][1] = collection.get(i).getTitle();
	    tableData[i][2] = collection.get(i).getAlbum();
	    tableData[i][3] = collection.get(i).getYear();
	}

	return tableData;

    }

    /**
     * Size.
     *
     * @return the int
     */

    public int size() {
	return collection.size();
    }

    /**
     * Gets the file.
     *
     * @param index the index
     * @return the file
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */

    public MP3File getFile(int index) throws IndexOutOfBoundsException {
	if (index >= collection.size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	return collection.get(index);
    }

    /**
     * Start play.
     *
     * @param index the index
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    public void startPlay(int index) throws IndexOutOfBoundsException {

	if (index >= collection.size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	Player.play(collection.get(index).getPath());
    }

    /**
     * Stop play.
     */
    public void stopPlay() {

	Player.stop();
    }

}
