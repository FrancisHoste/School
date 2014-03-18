package algorithms;

public interface IndexList<E> {
	public int size();

	public boolean isEmpty();

	public E get(int i) throws IndexOutOfBoundsException;

	public E remove(int i) throws IndexOutOfBoundsException;

	public E set(int i, E e) throws IndexOutOfBoundsException;

}
