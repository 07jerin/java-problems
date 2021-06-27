package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

/**
 * Consider a 32-bit integer, n. Write a snippet of code that returns the next
 * largest number that contains exactly the same number of 1 bits.
 * 
 * @author jerijose
 *
 */
public class NextAndPrevNumbers {

	@Test
	public void run() {

		assertEquals("1110", Integer.toBinaryString(nextLargest(Integer.parseInt("1101", 2))));
		assertEquals("10111", Integer.toBinaryString(nextLargest(Integer.parseInt("1111", 2))));
		assertEquals("10", Integer.toBinaryString(nextLargest(Integer.parseInt("1", 2))));

		assertEquals("1110", Integer.toBinaryString(next(Integer.parseInt("1101", 2))));
		assertEquals("10111", Integer.toBinaryString(next(Integer.parseInt("1111", 2))));
		assertEquals("10", Integer.toBinaryString(next(Integer.parseInt("1", 2))));

		assertEquals(next(958), nextLargest(958));
		
		
		for(int i=0; i<2500; i++) {
			Integer ip = (int) ( Math.random() * 1000000);
			assertEquals(nextLargest(ip), next(ip));
		}

	}


	public int nextLargest(int ip) {
		int result = 0;
		boolean foundOne = false;
		int num = ip;
		int oneCount = 0;
		int changedIndex = 0;
		for (int i = 0; i < 32; i++) {

			if ((num & 1) == 1) {
				foundOne = true;
				oneCount++;

			} else if (foundOne) {
				// Next 0 -- set as 1
				result = ip | (1 << i);
				// Right 1 as 0
				result = result & ~(1 << i - 1);
				oneCount--;
				changedIndex = i;
				return resetTheOnes(result, changedIndex, oneCount);
			}

			num = num >> 1;
		}

		return -1; // Not possible so send -1

	}

	public int resetTheOnes(int result, int changedIndex, int swapCount) {
		
		int bm = ~(1<<changedIndex);
		bm = bm ^ ( (1 << changedIndex+1) -1);
		int trailingCleared = result & bm;
		
		return trailingCleared | ((1 << swapCount) -1);
		
	}
	
	
	public static int next(int n) {

		int copyn = n;

		int zeros = 0;

		int ones = 0;

		// count trailing 0s

		while ((copyn != 0) && ((copyn & 1) == 0)) {

			zeros++;

			copyn = copyn >> 1;

		}

		// count all 1s until first 0

		while ((copyn & 1) == 1) {

			ones++;

			copyn = copyn >> 1;

		}

		// the 1111...000... is the biggest number

		// without adding more 1

		if (zeros + ones == 0 || zeros + ones == 31) {

			return -1;

		}

		int marker = zeros + ones;

		n = n | (1 << marker);

		n = n & (-1 << marker);

		n = n | (1 << (ones - 1)) - 1;

		return n;

	}
}
