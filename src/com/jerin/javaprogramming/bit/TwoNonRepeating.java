package com.jerin.javaprogramming.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Consider that you're given an array of integers containing 2n+2 elements. The
 * 2n elements are n elements repeated once. So, each element in 2n appears
 * twice in the given array. The remaining two elements appear only once. Write
 * a snippet of code that finds these two elements.
 * 
 * @author jerijose
 *
 */
public class TwoNonRepeating {

	@Test
	public void test() {
		int[] vals = new int[] { 1, 1, 2, 2, 4, 4, 5, 6, 6, 8, 8, 7, 9, 9 };
		List ip1 = Arrays.stream(vals).boxed().collect(Collectors.toList());

		int[] vals2 = new int[] { 10, 10, 24, 24, 434, 434, 569, 612, 612, 8889, 8889, 711, 2239, 2239 };
		List ip2 = Arrays.stream(vals2).boxed().collect(Collectors.toList());

		Collections.shuffle(ip1);
		find(ip1);
		
		Collections.shuffle(ip1);
		find(ip1);

		Collections.shuffle(ip2);
		find(ip2);
	}

	private void find(List<Integer> list) {

		int XOR = 0;
		for (int val : list) {
			XOR = XOR ^ val;
		}

		int setBit = 0;
		boolean found = false;
		while (!found) {
			if (((XOR >> setBit) & 1) == 1) {
				found = true;
				break;
			}
			setBit++;
		}

		List<Integer> setList = new ArrayList<Integer>();
		List<Integer> unsetList = new ArrayList<Integer>();

		for (int val : list) {
			if (((val >> setBit) & 1) == 1) {
				setList.add(val);
			} else {
				unsetList.add(val);
			}
		}

		int val1 = 0;
		for (int val : setList) {
			val1 = val1 ^ val;
		}

		int val2 = 0;
		for (int val : unsetList) {
			val2 = val2 ^ val;

		}
		System.out.println(val1);
		System.out.println(val2);

	}

}
