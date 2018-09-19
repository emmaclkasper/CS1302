package edu.uga.cs1302.mp3files;
// very similar to the ArrayList class in OpenJDK

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.Arrays;
import java.util.ListIterator;

/**
 * @author Emma Kasper
 */

/**
 * This class provides a simple generic list implmented as an array. It is
 * similar to the ArrayList class included in the java.util package.
 * 
 * The first element of the list is at position 0 and the last element is at
 * position list.size() - 1.
 * 
 * Except for the method next(), implementation of the SimpleArrayListIterator
 * methods is left as part of your project.
 *
 * @param <E> the element type
 */

public class SimpleArrayList<E> {

	public static final int DEFAULTSZ = 20; // default array size

	private Object[] list; // contents of the list

	private int count; // number of the list elements

	private int modCount = 0; // the total number of modifications (add and remove calls)

	/**
	 * Creates an empty SimpleArrayList with the default capacity.
	 */
	public SimpleArrayList() {
		list = new Object[DEFAULTSZ];
		count = 0;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the size
	 *
	 * @return the count
	 */
	public int size() {
		return count;
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * @param e the element to be added to the list.
	 * @return true always
	 */
	public boolean add(E e) {
		// make sure that the list has sufficient space
		ensureCapacity(count + 1);
		list[count] = e;
		count++;
		modCount++;
		return true;
	}

	/**
	 * Returns the element of the list at the indicated position.
	 * 
	 * @param index the position of the list element to return.
	 * @return the element at position index. throws IndexOutOfBoundsException if
	 *         the index is less than 0 or greaterthan or equal to the size of the list.
	 */
	public E get(int index) {
		// check if the given index is valid
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException("Index value: " + index);

		@SuppressWarnings("unchecked")
		E e = (E) list[index];
		return e;
	}

	/**
	 * Adds an element to the list at the specified position.
	 * 
	 * @param index the position where the element should be added.
	 * @param e     the element to be added to the list.
	 * @return true throws IndexOutOfBoundsException if the index out of range, i.e.
	 *         index less than 0 or index is greater than or equal to the size().
	 */
	public boolean add(int index, E e) {
		// check if the given index is valid
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException("Index value: " + index);

		// make sure that the list has sufficient space
		ensureCapacity(count + 1);

		// shift the contents of the array one spot to the right from index
		System.arraycopy(list, index, list, index + 1, count - index);
		list[index] = e;
		modCount++;
		count++;
		return true;
	}

	/**
	 * Removes the.
	 *
	 * @param index the index
	 * @return the e
	 */
	public E remove(int index) {
		// check if the given index is valid
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException("Index value: " + index);

		// get the element removed
		@SuppressWarnings("unchecked")
		E removed = (E) list[index];

		// shift the contents of the array one cell to the left from index, but only if
		// it is not the last cell
		if (index < count - 1)
			System.arraycopy(list, index + 1, list, index, count - index - 1);

		list[--count] = null;
		modCount++;
		return removed;
	}

	/**
	 * Returns the index of the first occurrence of a given element on the list
	 * equal or -1 if the given element is not on the list. If the argument element
	 * is null, the method returns the index of the first null element on the list,
	 * or -1 if the list has no null elements.
	 * 
	 * @param e the element to be located on the list.
	 * @return the index of the first occurrence of a given element on the list
	 *         equal or -1 if the given element is not on the list.
	 */
	public int indexOf(E e) {
		if (e != null) {
			// look for the first non-null element equal to the argument e
			for (int i = 0; i < count; i++)
				if (list[i] != null && list[i].equals(e))
					return i;
		} else {
			// look for the first null element, since the argument is null
			for (int i = 0; i < count; i++)
				if (list[i] == null)
					return i;
		}
		return -1;
	}

	/**
	 * Returns a ListIterator of the list elements, starting at the given position
	 * in this list.
	 * 
	 * @param index the position of the first element on the list to be returned
	 *              from the iterator.
	 * @return the created ListIterator throws IndexOutOfBoundsException if the
	 *         index is less than 0 or greater than or equal to the size of the list.
	 */
	public ListIterator<E> listIterator(int index) {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException("Index value: " + index);

		return new SimpleArrayListIterator(index);
	}

	/**
	 * Makes sure the capacity of th list is large enough to accommodate the size
	 * number of elements. If it is not, the list array is widened by allocating a
	 * larger array and copying the old content.
	 *
	 * @param sz the number of elements
	 */
	// a larger array and copying the old content.
	private void ensureCapacity(int sz) {
		Object[] newList = null;

		// if the list is large enough, return immediately
		if (list.length >= sz)
			return;

		// compute the next larger size, as a multiple of DEFAULTSZ
		int newSize = (sz / DEFAULTSZ + 1) * DEFAULTSZ;

		// create a new array and copy the old contents into it
		list = Arrays.copyOf(list, newSize);
	}

	/**
	 * This class provides an iterator for the SimpleArrayList. It partially
	 * implements the java.util.ListIterator interface.
	 *
	 * Except for the method next(), implementation of the SimpleArrayListIterator
	 * methods is left as part of your project.
	 */
	private class SimpleArrayListIterator implements ListIterator<E> {

		private int currPos = 0; // index of the element to be returned next
		private int expectedModCount = modCount;

		/**
		 * Instantiates a new simple array list iterator at position index
		 *
		 * @param index the position where the new iterator starts
		 */

		public SimpleArrayListIterator(int index) {
			if (index < 0 || index > count)
				throw new IndexOutOfBoundsException();
			currPos = index;

		}

		/*
		 * Returns true if the list iterator has more elements when traversing the list
		 * forward
		 * 
		 * @see java.util.ListIterator#hasNext()
		 * 
		 * @returns true
		 */

		public boolean hasNext() {

			try {
				next();
				return true;
			} catch (NoSuchElementException nsee) {
				return false;
			}

			catch (Exception e) {

				return false;
			}
		}

		/*
		 * Returns true if the list iterator has more elements when traversing the list
		 * in the reverse direction
		 * 
		 * @see java.util.ListIterator#hasPrevious()
		 */

		public boolean hasPrevious() {

			try {
				previous();
				return true;
			}

			catch (NoSuchElementException nsee) {
				return false;
			}

			catch (Exception e) {
				return false;
			}
		}

		/**
		 * Returns the next element on the list.
		 * 
		 * @return the next element on the list.
		 * @throw NoSuchElementException if the next element does not exist.
		 */
		@SuppressWarnings("unchecked")
		public E next() {
			checkForComodification();
			if (currPos >= count)
				throw new NoSuchElementException();
			// note the use of the "outer" class reference in SimpleArrayList.this
			// to access the outer class
			return (E) SimpleArrayList.this.list[currPos++];
		}

		/*
		 * Returns the index of the element that would be returned by a call to next
		 * 
		 * @see java.util.ListIterator#nextIndex()
		 */

		public int nextIndex() {
			checkForComodification();
			if (hasNext() == true) {
				return currPos + 1;

			}

			else {
				return count;
			}
		}

		/*
		 * Returns the previous element in the list
		 * 
		 * @see java.util.ListIterator#previous()
		 */
		@SuppressWarnings("unchecked")
		public E previous() {
			checkForComodification();
			if (currPos <= 0)
				throw new NoSuchElementException();
			return (E) SimpleArrayList.this.list[currPos--];
		}

		/*
		 * Returns the index of the element that would be returned by a call to previous
		 * 
		 * @see java.util.ListIterator#previousIndex()
		 */
		public int previousIndex() {
			if (hasPrevious() == true) {
				return currPos - 1;

			}

			else
				return -1;

		}

		// the following are optional operations which are not supported in the
		// SimpleArrayList implementation; no modifications/additions are needed here

		/**
		 * Adds a new element
		 *
		 * @param e the e
		 */
		public void add(Object e) {
			throw new UnsupportedOperationException("add is not available");
		}

		/*
		 * Removes from the list the last element that was returned by next or previous
		 * 
		 * @see java.util.ListIterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException("remove is not available");
		}

		/**
		 * Replaces the last element returned by next or previous with the specified
		 * element
		 *
		 * @param e the specified element
		 */
		public void set(Object e) {
			throw new UnsupportedOperationException("set is not available");
		}

		/**
		 * Checks if there was a concurrent modification of the lists contents
		 * 
		 * @throws ConcurrentModificationException if yes
		 */

		private final void checkForComodification() {
			if (expectedModCount != SimpleArrayList.this.modCount)
				throw new ConcurrentModificationException();
		}
	}
}
