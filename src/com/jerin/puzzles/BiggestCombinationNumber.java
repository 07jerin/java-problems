package com.jerin.puzzles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of numbers, arrange them in a way that yields the largest
 * value. For example, if the given numbers are {54, 546, 548, 60}, the
 * arrangement 6054854654 gives the largest value. And if the given numbers are
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the
 * largest value
 * 
 * @author jerijose
 *
 */

public class BiggestCombinationNumber {

	public static void main(String[] args) {
		Integer[] numbers = { 54, 546, 548, 60 };
		System.out.println(BiggestCombinationNumber.getHighestNumber(numbers));
	}

	private static int customCompare(String fStr, String sStr) {
		int val = 0;
		int flen = fStr.length();
		int slen = sStr.length();
		int smallLength = flen < slen ? flen : slen;
		for (int i = 0; i < smallLength; i++) {
			if (fStr.charAt(i) != sStr.charAt(i)) {
				return fStr.charAt(i) > sStr.charAt(i) ? -1 : 1;
			}
		}
		if (flen != slen) {
			String first = flen < slen ? fStr : fStr.substring(slen, flen);
			String second = slen < flen ? sStr : sStr.substring(flen, slen);
			return BiggestCombinationNumber.customCompare(first, second);
		}
		return val;

	}

	public static Double getHighestNumber(Integer[] number) {

		Comparator<Integer> c = (Integer first, Integer second) -> {
			int val = 0;
			if (!first.equals(second)) {
				String fStr = first.toString();
				String sStr = second.toString();
				return BiggestCombinationNumber.customCompare(fStr, sStr);
			}
			return val;

		};

		List<Integer> strs = Arrays.asList(number);
		Collections.sort(strs, c);
		System.out.println(strs.stream().map(Object::toString).collect(Collectors.joining("m")));

		return 0d;

	}
}
