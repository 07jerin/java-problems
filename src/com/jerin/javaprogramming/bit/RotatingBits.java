package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Consider a positive 32-bit integer, n. Write a snippet of code that rotates k
 * bits to the left or the right. By rotation, we understand that the bits that
 * fall off at one end of the binary representations are sent to the other end.
 * So, in the left rotation, the bits that fall off the left end are sent to the
 * right end, while in the right rotation, the bits that fall off the right end
 * are sent to the left end.
 * 
 * @author jerijose
 *
 */
public class RotatingBits {

	@Test
	public void test() {
		
		assertEquals(rotate(5, 1), rightRotate(5, 1));
		
		for(int i=0; i<2500; i++) {
			Integer ip = (int) ( Math.random() * 1000000);
			assertEquals(rotate(ip, 1), rightRotate(ip, 1));
			assertEquals(rotate(ip, 3), rightRotate(ip, 3));
			assertEquals(rotate(ip, 6), rightRotate(ip, 6));
		}

	}

	public int rotate(int num, int k) {
		// find fall off k bits
//		int fall = num & ((num << k) - 1);

		// append in beginning
		int result = num >> k;
		return result | (num << (32 - k));

	}
	
	public static int rightRotate(int n, int bits) {

		  int fallBits = n >> bits;

		  int fallBitsShiftToLeft = n << (32 - bits);

		  return fallBits | fallBitsShiftToLeft;

		}
}
