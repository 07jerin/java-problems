package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Consider a given array of integers, arr. Every element from this array occurs
 * exactly three times, except for one element, which occurs only once. This
 * makes it unique. Write a snippet of code that finds this unique element in
 * O(n) complexity time and O(1) extra space.
 * 
 * @author jerijose
 *
 */
public class UniqueElements {

	@Test
	public void test() {
		assertEquals(3, run(new int[] { 1, 2, 3, 1, 2, 1, 2 }));
		assertEquals(15, run(new int[] { 15, 23, 36, 36, 23, 23, 36 }));
		assertEquals(887, run(new int[] { 359, 175, 359, 359, 445, 887, 445, 175, 445, 175 }));
		assertEquals(999, run(new int[] { 359, 175, 999, 359, 359, 445, 445, 175, 445, 175 }));
		assertEquals(10, run(new int[] { 359, 175, 359, 359, 445, 445, 175, 10, 445, 175 }));
		assertEquals(700, run(new int[] { 700, 359, 175, 359, 359, 445, 445, 175, 445, 175 }));

		for (int i = 0; i < 2500; i++) {
			List<Integer> ip = new ArrayList<Integer>();
			int unique = 0;
			for (int j = 0; j < 50; j++) {
				Integer random = (int) (Math.random() * 1000000);
				if (j == 0) {
					unique = random;
					ip.add(unique);
				} else {
					ip.add(random);
					ip.add(random);
					ip.add(random);
				}

			}

			Collections.shuffle(ip);
			assertEquals(unique, run(ip.stream().mapToInt(val -> val).toArray()));
		}
	}

	public int run(int[] arr) {

		int result = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			boolean valuePresent = false;
			for (int j = 0; j < arr.length; j++) {

				if (arr[j] != 0) {
					valuePresent = true;
					sum += 1 & arr[j];
					arr[j] = arr[j] >> 1;
				}
			}

			int indexBit = sum % 3;
			indexBit = indexBit << i;
			result = indexBit | result;

			if (!valuePresent) {
				break;
			}
		}

		return result;

	}
}
