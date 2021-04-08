package com.jerin.javaprogramming.sort;

import java.util.Arrays;

import org.junit.Before;

public class AbstractSort {
	int[] sorted = new int[10000000];
	int[] input = new int[10000000];

	@Before
	public void setUp() {
		for (int i = 0; i < 10000000; i++) {
			int value = (int) (Math.random() * 1000000000);
			sorted[i] = value;
			input[i] = value;
		}
		Arrays.parallelSort(sorted);
	}

}
