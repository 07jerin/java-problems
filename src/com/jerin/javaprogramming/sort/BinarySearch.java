package com.jerin.javaprogramming.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class BinarySearch {

	@Test
	public void search() {
		int[] input = new Random().ints(100, 0, 1000).toArray();
		Arrays.parallelSort(input);
		System.out.println(Arrays.toString(input));
		for (int i = 0; i < 2500; i++) {
			int k = new Random().nextInt(500);
			int index1 = Arrays.binarySearch(input, k);
			int index2 = find(input, k, 0, input.length - 1);
			if (index1 < 0) {
				System.out.println(k + ":> " + index1 + " : " + index2);
			}
			assertEquals(index1, index2);

		}

	}

	private int find(int[] arr, int k, int from, int to) {

		if (to < from) {
			return -1;
		}

		if (to == from) {

		}

		int index = from + (to - from) / 2;
		if (arr[index] == k) {
			return index;
		} else if (arr[index] < k) {
			if (index == to) {
				return -1 * (index + 2);
			}
			if (arr[index + 1] > k) {
				return -1 * (index + 2);
			}
			return find(arr, k, index + 1, to);
		} else {
			return find(arr, k, from, index - 1);
		}

	}

}
