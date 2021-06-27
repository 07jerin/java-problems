package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicBitOperations {

	Integer val = 1526; // 10111110110
	Integer val2 = 69855; // 10001000011011111

	/**
	 * Consider a 32-bit integer, n. Write a snippet of code that returns the bit
	 * value of n at the given position, k.
	 */
	@Test
	public void findBitValue() {

		assertEquals(findBitValue(val, 2), 1);
		assertEquals(findBitValue(val, 3), 0);
		assertEquals(findBitValue(val2, 5), 0);
		assertEquals(findBitValue(val2, 8), 0);
		assertEquals(findBitValue(val2, 12), 1);

	}

	private int findBitValue(Integer value, int index) {

		int bitMap = 1 << index;
		return (value & bitMap) == 0 ? 0 : 1;
	}

	@Test
	/**
	 * Consider a 32-bit integer, n. Write a snippet of code that sets the bit value
	 * of n at the given position, k to 0 or 1.
	 */
	public void setBitValue() {

		Integer ip = Integer.parseInt("1011011", 2);
		assertEquals("1011011", Integer.toBinaryString(setBitValue(ip, 2, true)));
		assertEquals("1011001", Integer.toBinaryString(setBitValue(ip, 1, true)));
		assertEquals("1001011", Integer.toBinaryString(setBitValue(ip, 4, true)));
		assertEquals("1011011", Integer.toBinaryString(setBitValue(ip, 1, false)));
		assertEquals("1011011", Integer.toBinaryString(setBitValue(ip, 1, false)));
		assertEquals("1010011", Integer.toBinaryString(setBitValue(ip, 3, true)));
		assertEquals("1011011", Integer.toBinaryString(setBitValue(ip, 3, false)));
	}

	private Integer setBitValue(Integer value, int index, boolean toZero) {
		int result = 0;
		if (toZero) {
			int bitMap = ~(1 << index);
			result = value & bitMap;
		} else {
			int bitMap = 1 << index;
			result = value | bitMap;
		}
		return result;

	}

	@Test
	/**
	 * Consider a 32-bit integer, n. Write a snippet of code that clears the bits of
	 * n (sets their value to 0) between the MSB and the given k.
	 * 
	 * OR LSB and given k
	 */
	public void clearBit() {
		Integer ip = Integer.parseInt("1011011", 2);
		assertEquals("11", Integer.toBinaryString(clearBits(ip, 2, true)));
		assertEquals("1", Integer.toBinaryString(clearBits(ip, 1, true)));
		assertEquals("1011", Integer.toBinaryString(clearBits(ip, 4, true)));
		
		assertEquals("1011000", Integer.toBinaryString(clearBits(ip, 2, false)));
		assertEquals("1011010", Integer.toBinaryString(clearBits(ip, 1, false)));
		assertEquals("1010000", Integer.toBinaryString(clearBits(ip, 4, false)));
	}
	
	private int clearBits(Integer value, int index, boolean isFromMSB) {
		int bitMap = (1 << index ) -1;
		if(isFromMSB) {
			
			return value & bitMap;
		}
		
		return value & ~bitMap;
	}
	
	@Test
	/**
	 * Multiply 2 bits
	 */
	public void multiply() {
		
		assertEquals(63, multiply(9,7));
		assertEquals(1497*1334, multiply(1497,1334));
		assertEquals(6*1334, multiply(6,1334));
		assertEquals(1497*18, multiply(1497,18));
		assertEquals(147*134, multiply(147,134));
	
	}
	
	private int multiply(int a, int b) {
		
		int result = 0;
		while(a != 0) {
			
			if((a & 1) != 0) // if current LSB is not 0
			{
				result += b;
			}
			a = a >>> 1;
			b = b<<1;
		}
		return result;
	}
		

}
