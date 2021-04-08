package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class InsertionSort extends AbstractSort {

	@Test
	public void test() {

		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSort(new int[] { 4, 3, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSort(new int[] { 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(sorted, insertionSort(input))); // Arrays.equals to compare values

		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSortExtraSpace(new int[] { 4, 3, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSortExtraSpace(new int[] { 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(sorted, insertionSortExtraSpace(input))); // Arrays.equals to compare values

	}

	private int[] insertionSortExtraSpace(int[] input) {

		List<Integer> sorted = new LinkedList<Integer>();
		
		int insertionIndex = 0;

		for (int i = 0; i < input.length; i++) {
			// find index
			int value = input[i];
			insertionIndex = 0;
			for (int j = 0; j < sorted.size(); j++) {
				if (value >= sorted.get(j)) {
					insertionIndex++;
				} else {
					break;
				}

			}
			
			

			// set value
			sorted.add(insertionIndex, value);

		}

		return sorted.stream().mapToInt(i -> i).toArray();

	}

	private int[] insertionSort(int[] input) {

		int temp;
		int j = 0;
		for (int i = 1; i < input.length; i++) {
			temp = input[i];
			j = i - 1;
			while (j >= 0) {

				if (input[j] >= temp) {
					input[j + 1] = input[j];
					j--;
					if (j == -1) {
						input[0] = temp;
					}
				} else {
					input[++j] = temp;
					break;
				}

			}
		}

		return input;

	}

}
