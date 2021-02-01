package edu.escuelaing.arep.utilities;

import java.util.Iterator;

/**
 * Iterator for the LinkedList
 * @author Angie Daniela Ruiz Alfonso
 * @param <T> Type of elements returned by the iterator object
 */
public class LinkedListIterator<T> implements Iterator<T> {

	//in this moment
    Node<T> current;

    /**
     * Iterator for an linkedList constructor
     * @param linkedList The linkedList which is assigned the iterator
     */
    public LinkedListIterator(LinkedList<T> linkedList) {
        current = linkedList.getHead();
    }

    /**
     * Returns true if the iteration has more elements or false if not
     * @return True if the iteration has more elements or False if not
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Returns the next element in the iteration.
     * @return The next element in the iteration
     */
    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

	//does nothing
    public void remove() {
    }
}