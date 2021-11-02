package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Consider a positive 32-bit integer, n. Write a snippet of code that swaps the
 * odd and even bits of this integer.
 * 
 * @author jerijose
 *
 */
public class BitSwapping {

	@Test
	public void test() {
		assertEquals(swap(10), bitswap(10));
		
		for(int i=0; i<2500; i++) {
			Integer ip = (int) ( Math.random() * 1000000);
			assertEquals(bitswap(ip), swap(ip));
		}
		
	}
	
	private int bitswap(int n) {
		int evenValues = n & 0b01010101010101010101010101010101; 
		int oddValues = n &  0b10101010101010101010101010101010;
		
		return ( oddValues >> 1 ) | (evenValues << 1);
				
	}
	
	
	public static int swap(int n) {

		  int moveToEvenPositions

		    = (n & 0b10101010101010101010101010101010) >>> 1;

		  int moveToOddPositions

		    = (n & 0b1010101010101010101010101010101) << 1;

		  return moveToEvenPositions | moveToOddPositions;

		}

}
