package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort extends AbstractSort {

	@Test
	public void test() {

		assertTrue(Arrays.equals(new int[] { 1, 2, 2, 3, 4 }, mergeSort(new int[] { 4, 3, 2, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 3, 4 }, mergeSort(new int[] { 1, 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 3, 4 }, mergeSort(new int[] { 1, 3, 4, 1, 2 })));
		assertTrue(Arrays.equals(sorted, mergeSort(input))); // Arrays.equals to compare values

	}

	private int[] mergeSort(int[] input) {

		return sort(input);

	}

	private int[] sort(int[] input) {

		if (input.length <= 1) {
			return input;
		}

		int mid = input.length / 2;
		int[] left = Arrays.copyOfRange(input, 0, mid);
		int[] right = Arrays.copyOfRange(input, mid, input.length);
		int[] sortedLeft = sort(left);
		int[] sortedRight = sort(right);
		int[] sorted = merge(sortedLeft, sortedRight);

		return sorted;
	}

	private int[] merge(int[] left, int[] right) {
		int[] sorted = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = -1;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				sorted[++k] = left[i];
				i++;
			} else {
				sorted[++k] = right[j];
				j++;
			}
		}

		// Fill with left
		while (i < left.length) {
			sorted[++k] = left[i];
			i++;
		}

		// Fill with right
		while (j < right.length) {
			sorted[++k] = right[j];
			j++;
		}

		return sorted;
	}

}
