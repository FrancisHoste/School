package algorithms;

/**
 * 
 * Singly linked list implementation
 * 
 * @param <T>
 *            element type
 */
public class List<T> {

	private Node<T> head;
	private int size = 0;

	/**
	 * Empty list constructor
	 */
	public List() {
		this.head = null;
	}

	/**
	 * Construct a list with head as its first element
	 * 
	 * @param head
	 */
	public List(Node<T> head) {
		this.head = head;
		this.size = countNodes_R(head, 0);
	}

	/**
	 * counts the number of nodes in the list
	 * 
	 * @return count
	 */
	private int countNodes() {
		Node<T> cursor = head;
		int count = 0;
		while (cursor != null) {
			count++;
			cursor = cursor.next();
		}
		return count;
	}

	/**
	 * counts the number of nodes in the list recursively
	 * 
	 * @param node
	 *            start with head
	 * @param count
	 *            start with 0
	 * @return count
	 */
	private int countNodes_R(Node<T> node, int count) {
		if (node == null)
			return count;
		else {
			count++;
			return countNodes_R(node.next(), count);
		}
	}

	public String toString() {
		Node<T> cursor = head;
		StringBuilder b = new StringBuilder();

		while (cursor != null) {
			b.append(cursor);
			cursor = cursor.next();
			if (cursor != null)
				b.append(",");
		}
		return b.toString();
	}

	/**
	 * prepends node to the list
	 * 
	 * @param node
	 */
	public void prepend(Node<T> node) {
		node.setNext(this.head);
		this.head = node;
		this.size = countNodes();
	}

	/**
	 * @return the head node
	 */
	public Node<T> head() {
		return head;
	}

	public int size() {
		return size;
	}

	/**
	 * reverses the list
	 * 
	 */
	public void reverse() {
		List<T> reversed = new List<T>();
		Node<T> cursor = head;
		Node<T> temp = head;
		while (cursor != null) {
			cursor = cursor.next();
			reversed.prepend(temp);
			temp = cursor;
		}
		this.head = reversed.head;
	}

	public static void main(String[] args) {
		Node<String> drie = new Node<String>("c", null);
		Node<String> twee = new Node<String>("b", drie);
		Node<String> een = new Node<String>("a", twee);

		List<String> l = new List<String>(een);
		System.out.println(l.toString());

		l.reverse();
		System.out.println(l.toString());
	}
}
