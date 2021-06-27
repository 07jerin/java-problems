package com.jerin.javaprogramming.bit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReplaceBits {

	@Test
	/**
	 * Consider two positive 32-bit integers, q and p, and two bit positions, i and
	 * j. Write a snippet of code that replaces the bits from q between positions i
	 * and j with the bits of p. You can assume that, between i and j, there is
	 * enough space to fit all bits of p
	 */
	public void replaceBits() {
		int _4914 = Integer.parseInt("1001100110010", 2);
		int _63 = Integer.parseInt("111111", 2);
		int _10 = Integer.parseInt("1010", 2);

		assertEquals("1001111110010", Integer.toBinaryString(replaceBits(_4914, _63, 4, 9)));
		assertEquals("1001111111010", Integer.toBinaryString(replaceBits(_4914, _63, 3, 8)));
		assertEquals("1011111110010", Integer.toBinaryString(replaceBits(_4914, _63, 5, 10)));

		assertEquals("1001110100010", Integer.toBinaryString(replaceBits(_4914, _10, 4, 7)));
		assertEquals("1001101010010", Integer.toBinaryString(replaceBits(_4914, _10, 3, 6)));
		assertEquals("1001101010010", Integer.toBinaryString(replaceBits(_4914, _10, 5, 8)));

		assertEquals("1001111110010", Integer.toBinaryString(replaceBits2(_4914, _63, 4, 9)));
		assertEquals("1001111111010", Integer.toBinaryString(replaceBits2(_4914, _63, 3, 8)));
		assertEquals("1011111110010", Integer.toBinaryString(replaceBits2(_4914, _63, 5, 10)));

		assertEquals("1001110100010", Integer.toBinaryString(replaceBits2(_4914, _10, 4, 7)));
		assertEquals("1001101010010", Integer.toBinaryString(replaceBits2(_4914, _10, 3, 6)));
		assertEquals("1001101010010", Integer.toBinaryString(replaceBits2(_4914, _10, 5, 8)));

	}

	private Integer replaceBits(int a, int b, int i, int j) {
		int prefix = a >> j + 1;
		prefix = prefix << j + 1 - i;
		prefix = prefix | b;

		int result = prefix << i;

		int suffixBitMap = (1 << i) - 1;
		int suffix = a & suffixBitMap;
		result = result | suffix;

		return result;

	}

	private Integer replaceBits2(int a, int b, int i, int j) {
		int bitMaskSuffix = (1 << i) - 1;
		int bitMaskPrefix = -1 << j + 1;

		int bitMask = bitMaskPrefix | bitMaskSuffix;
		int result = a & bitMask;
		result = result | (b << i);

		return result;

	}

}
