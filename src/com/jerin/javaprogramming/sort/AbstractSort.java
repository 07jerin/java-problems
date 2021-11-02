package com.jerin.javaprogramming.sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;

public class AbstractSort {
	int[] sorted = new Random().ints(1000).toArray();
	int[] input = Arrays.copyOf(sorted, sorted.length);

	@Before
	public void setUp() {
		Arrays.parallelSort(sorted);
	}

}
