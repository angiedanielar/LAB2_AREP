package edu.escuelaing.arep.app;

import java.util.Iterator;

/**
 * Class that represent a LinkedList
 * @author Angie Daniela Ruiz Alfonso
 * @param <T> Type of the elements stored in the LinkedList
 */
public class LinkedList<T> implements Iterable<T> {

	//Initially, head and tail is set to null

	//first node
    Node<T> head = null;
	//latest node
	Node<T> tail = null;
	
	//teacher recommendation for have more efficient program 
	int size;

    /**
     * Empty linkedList constructor
     */
    public LinkedList() {
        this.size = 0;
    }

    /**
     * Return the size of the linkedList
     * @return The size of an linkedList
     */
    public int getSize() {
        return size;
    }


    /**
     * Return the head of the linkedList
     * @return The head of an linkedList
     */
    public Node<T> getHead(){
        return head;
    }

    /**
     * Return the tail of the linkedList
     * @return The tail of an linkedList
     */
    public Node<T> getTail(){
        return tail;
    }

    /**
     * Add a node to the linkedList
     * @param data The value of the node to be added
     */
    public void add(T data) {
	
		//create a new node  
        Node<T> new_node = new Node<T>(data, null, null);
		
		//if list is empty, head and tail points to newNode
        if (head==null) {
            head= tail =new_node;
        } else {
		
			//newNode->previous set to tail
            new_node.setPrior(tail);
			
			//tail's next point to new_node 
            tail.setNext(new_node);
			
			//newNode becomes new tail 
            tail = new_node;
        }
		
		//increment for keep the variable value correct
        size++;

    }

    /**
     * Delete a node with the given value
     * @param value The value of the node to be deleted
     */
    public void delete(double value){    	
        if(head!=null && head.getValue().equals(value)){
            head=head.getNext();
            size--;
        }
        else {
            Node<T> current = head;
            Node<T> next = current.getNext();
            
            while(next != null && !(next.getValue().equals(value))){
            	current=current.getNext();
            	next = current.getNext();
            }
            
            current.setNext(next.getNext());
            next.getNext().setPrior(current);
            size--;
        }
    }

    /**
     * Convert a linkedList to a String representation
     * @return A string form of the linkedList
     */
    @Override
    public String toString() {
        StringBuilder string= new StringBuilder();
        Node<T> current = head;
        Node<T> next = null;
		
		//while it is not empty add the value
        while((next=current.getNext()) != null){
		
			//add spaces
            string.append(current.getValue()).append(" ");
			
			//call for next
            current=current.getNext();
        }
		
		//if it is empty
        string.append(tail.getValue()).append(" ");
		
        return string.toString();
    }

	/**
     * Create a new linkedList iterator 
     * @return A linkedList iterator 
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }
}