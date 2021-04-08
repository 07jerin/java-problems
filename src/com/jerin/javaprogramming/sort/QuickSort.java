package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort extends AbstractSort {

	@Test
	public void test() {

		assertTrue(Arrays.equals(new int[] { 1, 2, 2, 3, 4 }, quickSort(new int[] { 4, 3, 2, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 3, 4 }, quickSort(new int[] { 1, 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 3, 4 }, quickSort(new int[] { 1, 3, 4, 1, 2 })));
		System.out.println(Arrays.toString(input));
		assertTrue(Arrays.equals(sorted, quickSort(input))); // Arrays.equals to compare values

	}

	private int[] quickSort(int[] input) {

		int[] sorted = sort(input, 0, input.length - 1);
		System.out.println("Sorted           " + Arrays.toString(sorted));
		System.out.println("Sorted from this " + Arrays.toString(this.sorted));

		return sorted;
	}

	private int[] sort(int[] input, int fromIndex, int toIndex) {

		if (toIndex - fromIndex <= 0) {
			return input;
		}

		int pivot = input[toIndex];
		int i = fromIndex - 1;
		int j = fromIndex;

		while (j < toIndex) {
			if (input[j] <= pivot) {
				i++;
				// swap i j
				int t = input[j];
				input[j] = input[i];
				input[i] = t;
			}
			j++;
		}

		// swap i j
		++i;
		input[toIndex] = input[i];
		input[i] = pivot;

		sort(input, fromIndex, i - 1);
		sort(input, i + 1, toIndex);

		return input;

	}

}
