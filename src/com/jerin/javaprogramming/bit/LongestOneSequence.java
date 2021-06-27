package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Consider a 32-bit integer, n. A sequence of 101 can be considered 111. Write
 * a snippet of code that computes the length of the longest sequence of 1.
 * 
 * @author jerijose
 *
 */
public class LongestOneSequence {

	@Test
	public void test() {

		assertEquals(1, longestSequence(Integer.parseInt("100", 2)));
		assertEquals(2, longestSequence(Integer.parseInt("110", 2)));
		assertEquals(3, longestSequence(Integer.parseInt("101", 2)));
		assertEquals(3, longestSequence(Integer.parseInt("1010", 2)));
		assertEquals(3, longestSequence(Integer.parseInt("111", 2)));
		assertEquals(1, longestSequence(Integer.parseInt("1001", 2)));
		assertEquals(7, longestSequence(Integer.parseInt("1010101001", 2)));
		assertEquals(9, longestSequence(Integer.parseInt("1010010111101100001", 2)));

	}

	private int longestSequence(int number) {

		int result = 0;
		int count = 0;

		for (int i = 0; i < 32; i++) {
			int left = number >> 1;

			int isOne = number & 1;
			if (isOne == 1) {
				++result;
			} else if (result != 0 // If previous was 0 then result would have reset to 0
					&& ((left & 1) != 0)) { // next is not zero
				// Check if the previous and next are non 0
				++result;

			} else {
				// Reset the counter
				count = Math.max(count, result);
				result = 0;
			}
			number = left;

		}
		return count;
	}

}
