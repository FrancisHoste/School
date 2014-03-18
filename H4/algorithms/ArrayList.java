package algorithms;

public class ArrayList<E> implements IndexList<E> {

	private int size = 0;
	private int capacity;
	private E elements[];
	private int index_of_first = 0;

	/**
	 * Initializes the arraylist with an initial capacity of 2
	 */
	public ArrayList() {
		this(2);
	}

	/**
	 * Initializes the arraylist with an initial capacity
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		capacity = initialCapacity;
		elements = (E[]) new Object[capacity];
	}

	/**
	 * @return number of elements
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @return is the arraylist empty?
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Get the element at index i
	 * 
	 * @param i
	 *            the index of the element
	 * @return the element
	 */
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > (size - 1))
			throw new IndexOutOfBoundsException();
		return elements[getIndex(i)];
	}

	/**
	 * Retrieve & remove the element at index i
	 * 
	 * @param i
	 *            the index of the element
	 * @return the element
	 */
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > (size - 1))
			throw new IndexOutOfBoundsException();
		size--;
		E removed = elements[getIndex(i)];
		if (i == index_of_first)
			index_of_first++;
		else {
			for (int index = i; index < size; index++) {
				elements[getIndex(index)] = elements[getIndex(index) + 1];
			}
		}

		return removed;
	}

	/**
	 * Return the current element at index i and add the element e instead
	 * Precondition: the index is not larger than the current size of the array
	 * 
	 * @param e
	 *            the element to add
	 * @param i
	 *            the index of the element
	 * @return the element
	 */
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size)
			throw new IndexOutOfBoundsException();

		E element = null;

		if (i + 1 > size) {
			size++;
			if (size > capacity)
				growArray();
		} else {
			element = elements[getIndex(i)];
		}

		elements[getIndex(i)] = e;
		return element;
	}

	private void growArray() {
		E large[] = (E[]) new Object[capacity * 2];
		int j = 0;
		for (int i = getIndex(0); i < getIndex(capacity - 1); i++) {
			large[j] = elements[i];
			j++;
		}
		index_of_first = 0;
		capacity = 2 * capacity;
		elements = large;
	}

	private int getIndex(int index) {
		return (index + index_of_first) % capacity;
	}
}
