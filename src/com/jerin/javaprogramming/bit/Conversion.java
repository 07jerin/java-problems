package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Consider two positive 32-bit integers, q and p. Write a snippet of code that
 * counts the number of bits that we should flip in q in order to convert it
 * into p.
 * 
 * @author jerijose
 *
 */
public class Conversion {

	@Test
	public void run() {
		assertEquals(1, test("10", "11"));
		assertEquals(0, test("11", "11"));
		assertEquals(2, test("10", "01"));
		assertEquals(2, test("1100", "1010"));
	}

	private int test(String a, String b) {
		return count(Integer.parseInt(a, 2), Integer.parseInt(b, 2));
	}

	private int count(int a, int b) {
		int count = 0;
		int XOR = a ^ b;
		while (XOR != 0) {
			if ((XOR & 1) != 0) {
				count++;
			}
			XOR = XOR >> 1;
		}
		return count;
	}

}
