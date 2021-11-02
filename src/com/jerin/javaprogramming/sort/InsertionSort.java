package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class InsertionSort extends AbstractSort {

	
	@Test
	public void insertionSortExtraSpace() {
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSortExtraSpace(new int[] { 4, 3, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSortExtraSpace(new int[] { 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(sorted, insertionSortExtraSpace(input))); // Arrays.equals to compare values
	}
	
	@Test
	public void insertionSort() {
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSort(new int[] { 4, 3, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSort(new int[] { 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(sorted, insertionSort(input))); // Arrays.equals to compare values
	}
	
	@Test
	public void insertionSortSimple() {
		
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSortSimple(new int[] { 4, 3, 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, insertionSortSimple(new int[] { 1, 2, 3, 4 })));
		assertTrue(Arrays.equals(sorted, insertionSortSimple(input))); // Arrays.equals to compare values
		
//		for(int i =0; i<25; i++) {
//			int [] ip = new Random().ints(25).toArray();
//			int [] sorted = Arrays.copyOf(ip, ip.length);
//			Arrays.sort(sorted);
//			assertTrue(Arrays.equals(sorted, insertionSortSimple(ip))); // Arrays.equals to compare values
//		}
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

	private int[] insertionSortSimple(int[] a) {
		int i = 0;
		int j = 0;
		int n = a.length;

		while (i < n-1) {
			j = i + 1;
			while (j > 0) {
				if (a[j] < a[j-1]) {
					// swap and decrement move left
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
					j--;
				} else {
					break;
				}
			}
			i++;
		}
		return a;
	}

}
