package algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestArrayList {

	ArrayList<Integer> a;

	@Before
	public void setup() {
		a = new ArrayList<Integer>();
	}

	@Test
	public void testSize() {

		assertEquals(0, a.size());
	}

	@Test
	public void testIsEmpty() {

		assertEquals(true, a.isEmpty());
	}

	@Test
	public void testGet() {
		Integer zero = new Integer(0);
		a.set(0, zero);
		Integer returned = a.get(0);
		assertEquals(zero, returned);
	}

	@Test
	public void testRemove() {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		a.set(0, zero);
		a.set(1, one);
		Integer returned = a.remove(0);
		assertEquals(zero, returned);
		returned = a.get(0);
		assertEquals(one, returned);
	}

	@Test
	public void testSet() {
		Integer returned = a.set(0, new Integer(0));
		assertEquals(null, returned);
		assertEquals(1, a.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveFromEnd() {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		a.set(0, zero);
		a.set(1, one);
		Integer returned = a.remove(1);
		assertEquals(one, returned);
		assertEquals(1, a.size());
		a.get(1); // throws an exception
	}

	@Test
	public void testRemoveFromTheMiddle() {
		ArrayList<Integer> a = new ArrayList<Integer>(3);
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		a.set(0, zero);
		a.set(1, one);
		a.set(2, two);

		Integer returned = a.remove(1);
		assertEquals(one, returned);
		assertEquals(2, a.size());
		assertEquals(two, a.get(1));
	}

	@Test
	public void testExtendingTheArray() {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		a.set(0, zero);
		a.set(1, one);
		a.set(2, two);

		assertEquals(3, a.size());
		assertEquals(two, a.get(2));
	}

	@Test
	public void testSetAnOccupiedPosition() {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		a.set(0, zero);
		Integer returned = a.set(0, one);

		assertEquals(zero, returned);
		assertEquals(one, a.get(0));
	}

	@Test
	public void testCircularBehavior() {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		a.set(0, zero);
		a.set(1, one);
		a.remove(0);
		a.set(1, two);
		assertEquals(one, a.get(0));
		assertEquals(two, a.get(1));
	}
}
