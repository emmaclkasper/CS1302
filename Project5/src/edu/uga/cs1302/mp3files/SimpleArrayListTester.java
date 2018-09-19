/**
 * 
 */
package edu.uga.cs1302.mp3files;

import org.junit.Assert.*;
import java.util.ListIterator;
import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class SimpleArrayListTester {

	// object to be tested
	SimpleArrayList<String> strings = new SimpleArrayList<String>();

	// setUp method is invoked before EACH test case
	@Before
	public void setUp() {
		strings.add("cat");
		strings.add("dog");
		strings.add("bird");
		strings.add("reptile");
		strings.add("fish");
		strings.add("insect");

	}

	// tearDown method is invoked after EACH test case
	@After
	public void tearDown() {
		strings = null;

	}

	// Test 1: Tests the call to previous method
	@Test
	public void TestPrevious() {
		ListIterator<String> listIter = strings.listIterator(1);
		assertEquals(listIter.previous(), "dog");
	}

	// Test 2: Tests the call to has previous, should return true
	@Test
	public void TestHasPrevious() {
		ListIterator<String> listIter = strings.listIterator(4);
		assertEquals(listIter.hasPrevious(), true);

	}

	// Test 3: Tests previous index method with a legal argument
	@Test
	public void TestHasPreviousIndex() {
		ListIterator<String> listIter = strings.listIterator(3);
		assertEquals(listIter.previousIndex(), 1);

	}

	// Test 4: Tests the previous method with an illegal argument, should return
	// false
	@Test
	public void TestIllegalHasPrevious() {

		ListIterator<String> listIter = strings.listIterator(0);
		assertEquals(listIter.hasPrevious(), false);

	}

	// Test 5: Tests the previous index method with an illegal argument, should
	// return -1
	@Test
	public void TestIllegalHasPreviousIndex() {
		ListIterator<String> listIter = strings.listIterator(0);
		assertEquals(listIter.previousIndex(), -1);

	}

	// Test 6: Tests call to previous with an illegal argument
	@Test(expected = NoSuchElementException.class)
	public void TestIllegalPrevious() {

		ListIterator<String> listIter = strings.listIterator(0);
		listIter.previous();
	}

	// Test 7: Tests the call to next method
	@Test
	public void TestNext() {

		ListIterator<String> listIter = strings.listIterator(1);
		assertEquals(listIter.previous(), "dog");

	}

	// Test 8: Tests the call to has next, should return true
	@Test
	public void TestHasNext() {
		ListIterator<String> listIter = strings.listIterator(0);
		assertEquals(listIter.hasNext(), true);

	}

	// Test 9: Tests next index method with a legal argument
	@Test
	public void TestHasNextIndex() {
		ListIterator<String> listIter = strings.listIterator(3);
		assertEquals(listIter.nextIndex(), 5);

	}

	// Test 10: Tests the next method with an illegal argument, should return
	// false
	@Test
	public void TestIllegalHasNext() {
		ListIterator<String> listIter = strings.listIterator(6);
		assertEquals(listIter.hasNext(), false);

	}

	// Test 11: Tests the next index method with an illegal argument, should
	// return -1
	@Test
	public void TestIllegalHasNextIndex() {
		ListIterator<String> listIter = strings.listIterator(4);
		assertEquals(listIter.nextIndex(), 6);

	}

	// Test 12: Tests call to next with an illegal argument
	@Test(expected = NoSuchElementException.class)
	public void TestIllegalNext() {
		ListIterator<String> listIter = strings.listIterator(6);
		listIter.next();

	}

}
