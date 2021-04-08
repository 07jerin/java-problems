package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;

public class BasicSorting {

	private List<A> values = new ArrayList<>();
	private List<Integer> ints;

	@Before
	public void create() {
		this.values.add(new A(1));
		this.values.add(new A(3));
		this.values.add(new A(2));
		int[] intsa = { 1, 3, 2 };

//		this.ints = Arrays.asList(intsa); // Will work only with Integer array
		this.ints = Arrays.stream(intsa).boxed().collect(Collectors.toList()); // for int array we need to do the boxing
	}

	@org.junit.Test
	public void test() {
		List<Integer> ascValue = Arrays.asList(new Integer[] { 1, 2, 3 });
		List<Integer> descValue = Arrays.asList(new Integer[] { 3, 2, 1 });

		List<A> ascValueA = new ArrayList<>();
		Collections.addAll(ascValueA, new A[] { new A(1), new A(2), new A(3) });

		List<A> descValueA = new ArrayList<>();
		Collections.addAll(descValueA, new A[] { new A(3), new A(2), new A(1) });

		Collections.sort(ints);
		assertEquals(ascValue, ints);

		Collections.sort(ints, Comparator.reverseOrder());
		assertEquals(descValue, ints);

		Collections.sort(values);
		assertEquals(ascValueA, values);

		Collections.sort(values, Comparator.reverseOrder()); // Reverse Order flips the compareTo Checks
		assertEquals(descValueA, values);
		
		// Use Comparator
		Collections.sort(values, ((A obj1, A obj2 ) -> obj1.val - obj2.val));
		assertEquals(ascValueA, values);

		Collections.sort(values, ((A obj1, A obj2 ) -> obj2.val - obj1.val));
		assertEquals(descValueA, values);
		

	}

}



class A implements Comparable<A> {
	int val;

	protected A(int value) {
		this.val = value;
	}

	@Override
	public int compareTo(A obj) {
		return  this.val - obj.val ;
	}
	
	@Override
	public boolean equals(Object obj1) {
		return ((A)obj1).val == this.val;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.val);
	}
}
