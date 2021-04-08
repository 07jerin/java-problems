package com.jerin.javaprogramming.commonporblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FibinocciFrom1ToN {

	@Test
	public void testFibSeries() {
		long ts = System.nanoTime();
		fib(1);
		fib(2);
		fib(3);
		fib(5);
		fib(100);
		System.out.println(System.nanoTime() - ts);
		
		ts = System.nanoTime();
		System.out.println(getFibNonRecursion(1));
		System.out.println(getFibNonRecursion(2));
		System.out.println(getFibNonRecursion(3));
		System.out.println(getFibNonRecursion(5));
		System.out.println(getFibNonRecursion(100));
		System.out.println(System.nanoTime() - ts);
		
	}

	private void fib(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		List<Long> values = new ArrayList<>(n);
		if (n >= 1) {
			values.add(0l);
		} 
		if (n >= 2) {
			values.add(1l);
		}
		System.out.println(getFibRecursively(n, 2, values).toString());

	}

	public static List<Long> getFibRecursively(int n, int index, List<Long> values) {
		if (index >= n) {
			return values;
		} else {
			values.add(values.get(index - 1) + values.get(index - 2));
			return getFibRecursively(n, ++index, values);
		}
	}
	
	public static List<Long> getFibNonRecursion(int n){
		List<Long> values = new ArrayList<Long>(n);
		int index = -1;
		if(n >= 1) {
			index++;
			values.add(0l);
		}
		if(n >= 2) {
			index++;
			values.add(1l);
		}
		
		while(index < n-1) {
			values.add(values.get(index) + values.get(index-1));
			index++;
		}
		
		return values;
	}
}
