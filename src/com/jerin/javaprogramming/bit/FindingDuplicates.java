package com.jerin.javaprogramming.bit;

import java.util.BitSet;
import java.util.List;

import org.junit.Test;

/**
 * Consider that you're given an array of integers ranging from 1 to n, where n
 * can be, at most, 32,000. The array may contain duplicates and you don't know
 * the value of n. Write a snippet of code that prints all the duplicates from
 * the given array using only 4 kilobytes (KB) of memory.
 * 
 * @author jerijose
 *
 */
public class FindingDuplicates {

	@Test
	public void test() {

		duplicates(new int[] { 1, 2, 320000, 31000, 2, 5, 6, 7, 9, 6 });
	}

	public void duplicates(int[] arr) {
		BitSet b = new BitSet(32000);

		for (int val : arr) {
			if (b.get(val)) {
				System.out.println(val);
			} else {
				b.set(val);
			}
		}
	}

}
