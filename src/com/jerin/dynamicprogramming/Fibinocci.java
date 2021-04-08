package com.jerin.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Fibinocci {
	
	@Test
	public void test() {
		assertEquals(simpleFib(1), 1l);
		assertEquals(simpleFib(6), 8l);
		assertEquals(simpleFib(15), 610l);
		assertEquals(simpleFib(20), 6765l);
//		assertEquals(simpleFib(50), 12586269025l); Will take for ever
		
		long ts = System.nanoTime();
		assertEquals(dpFib(1, new HashMap<Integer, Long>()), 1l);
		assertEquals(dpFib(6,new HashMap<Integer, Long>()), 8l);
		assertEquals(dpFib(15,new HashMap<Integer, Long>()), 610l);
		assertEquals(dpFib(20,new HashMap<Integer, Long>()), 6765l);
		assertEquals(dpFib(50,new HashMap<Integer, Long>()), 12586269025l);
		assertEquals(dpFib(70,new HashMap<Integer, Long>()), 190392490709135l); 
		System.out.println("DP time " + (System.nanoTime() - ts));
		
		//Change since this is 1 index
		ts = System.nanoTime();
		assertEquals(classicFib(2), 1l);
		assertEquals(classicFib(7), 8l);
		assertEquals(classicFib(16), 610l);
		assertEquals(classicFib(21), 6765l);
		assertEquals(classicFib(51), 12586269025l);
		assertEquals(classicFib(71), 190392490709135l);
		System.out.println("Classic time time " + (System.nanoTime() - ts));
		
		ts = System.nanoTime();
		System.out.println(dpFib(50000,new HashMap<Integer, Long>()));
		System.out.println("DP time 400 " + (System.nanoTime() - ts));
		// This will fail in DP due to stack overflow
		
		ts = System.nanoTime();
		System.out.println(classicFib(50001));
		System.out.println("classicFib 5000 value " + (System.nanoTime() - ts));
		
		
		
		
	}
	
	private static long simpleFib(int n) {	
		if(n <=2) {
			return 1l;
		}
		long value = simpleFib(n-1) + simpleFib(n-2);
		return value;
	}
	
	private static long dpFib(int n, Map<Integer, Long> memo) {
		if(n <=2) {
			return 1l;
		}
		Long value = memo.get(n);
		if(value != null) {
			return value;
		}
		
		value = dpFib(n-1, memo) + dpFib(n-2, memo);
		memo.put(n, value);
		return value;
	}
	
	
	
	// Classic Fib
	private long classicFib(int n) {
		if (n <= 2) {
			return 1l;
		}
		
//		return FibinocciFrom1ToN.getFibNonRecursion(n).get(n-1);
		return Fibinocci.getFibByIteration(n);
	}
	
	private static long getFibByIteration(int n) {
		int index = -1;
		long prev = 0;
		long cur = 0;
		long temp = 0;

		if (n >= 2) {
			cur = 1;
			index = 2;
		}

		while (index < n - 1) {
			temp = cur;
			cur = prev + cur;
			prev = temp;
			index++;
		}

		return prev + cur;
	}
		
	
	

}
