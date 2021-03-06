package edu.uga.cs1302.test;

import static org.junit.Assert.*;

import edu.uga.cs1302.txtbuff.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class EditableTextLineTest {

    // objects to be tested
    private EditableTextLine eLine, eLine2;

    // setup method is invoked before each test case
    @Before
	public void setUp() {
	eLine = new EditableTextLine("hello");

    }

    // tearDown method cleans up after each test case
    @After
	public void tearDown() {
	eLine = null;
    }

    // test case 1: instantiation of an object smaller than the default size
    @Test

	public void TestInstantiateConstructorSmall() {

	int expectedCap = 80;
	int expectedLength = 5;

	assertEquals(expectedCap, eLine.capacity());
	assertEquals(expectedLength, eLine.length());

    }

    // test case 2: instantiation of an object larger than the default size
    @Test

	public void TestInstantiateConstructorBig() {

	eLine2 = new EditableTextLine(
				      "supercalifragilisticexpialidocioussupercalifragilisticexpialidocioussupercalifragilisticexpialidocious");
	int expectedCap = 160;
	int expectedLength = 102;

	assertEquals(expectedCap, eLine2.capacity());
	assertEquals(expectedLength, eLine2.length());

    }

    // test case 3: testing the append method
    @Test
	public void TestAppend() {

	eLine.append("hi");
	assertEquals(eLine.toString().trim(), "hellohi");

    }

    // test case 4: testing the insert method from an index at the beginning

    @Test
	public void TestInsertBeginning() {
	eLine.insert(0, "hi");
	assertEquals(eLine.toString().trim(), "hihello");

    }

    // test case 5: testing the insert method from an index in the middle

    @Test
	public void TestInsertMiddle() {
	eLine.insert(3, "hi");
	assertEquals(eLine.toString().trim(), "helhilo");

    }

    // test case 6: testing the insert method from an index at the end

    @Test
	public void TestInsertEnd() {
	eLine.insert(5, "hi");
	assertEquals(eLine.toString().trim(), "hellohi");

    }

    // test case 7: testing the replace method from an index at the beginning

    @Test
	public void TestReplaceBeginning() {
	eLine.replace(2, 3, "hi");
	assertEquals(eLine.toString().trim(), "heho");

    }
    // test case 8: testing the replace method from an index in the middle

    @Test
	public void TestReplaceMiddle() {
	eLine.replace(3, 4, "hi");
	assertEquals(eLine.toString().trim(), "helh");

    }
    // test case 9: testing the replace method from an index at the end

    @Test
	public void TestReplaceEnd() {
	eLine.replace(4, 5, "hi");
	assertEquals(eLine.toString().trim(), "hellh");

    }
    // test case 10: testing to make sure an exception is thrown when an invalid
    // index is given as a parameter for insert method

    @Test(expected = TextLineIndexOutOfBoundsException.class)
	public void TestIllegalInsert() {
	eLine.insert(-1, "hi");
    }
    // test case 11: testing to make sure an exception is thrown when an invalid
    // index is given as a parameter for replace method

    @Test(expected = TextLineIndexOutOfBoundsException.class)
	public void TestIllegalReplace() {

	eLine.replace(-2, -4, "hi");
    }

}
