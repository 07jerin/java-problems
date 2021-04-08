package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSort extends AbstractSort {

	@Test
	public void test() {

		assertTrue(Arrays.equals(new int[] { 1, 2, 2, 3, 4 }, bubbleSort(new int[] { 4, 3, 2, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 3, 4 }, bubbleSort(new int[] { 1, 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(sorted, bubbleSort(input))); // Arrays.equals to compare values

	}

	private int[] bubbleSort(int[] input) {
		boolean isSwapped = true;
		int j = input.length;

		while (isSwapped) {
			isSwapped = false;
			j--;
			for (int i = 0; i < j; i++) {
				if (input[i] > input[i + 1]) {
					// swap
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
					isSwapped = true;
				}
			}
		}

		return input;

	}

}
