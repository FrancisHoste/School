package algorithms;

/**
 * 
 * Node of a singly linked list of type T
 *
 * @param <T> type of the element
 */
public class Node<T> {
	private T element;
	private Node<T> next;
	
	public Node(T element, Node<T> next) {
		this.element = element;
		this.next = next;
	}
	
	public T get() {
		return element;
	}
	
	public Node<T> next() {
		return next;
	}
	
	public void set(T element) {
		this.element = element;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public String toString() {
		return "(" + element.toString() + ")";
	}
}
