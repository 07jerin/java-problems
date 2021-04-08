package com.jerin.javaprogramming.commonporblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(anagrams("abcd"));
	}

	private static List<String> anagrams(String ip) {
		List<List<Character>> values = new ArrayList<>();

		char[] subStrings = ip.toCharArray();

		List<Character> newInnerList = new ArrayList<Character>(1);
		newInnerList.add(subStrings[0]);
		values.add(newInnerList);
		long count = 0l;
		for (int s = 1; s < subStrings.length; s++) {
			char ch = subStrings[s];
			List<List<Character>> newValues = new ArrayList<>();
			for (List<Character> innerList : values) {
				for (int i = 0; i <= innerList.size(); i++) {
					newInnerList = new ArrayList<Character>(innerList);
					newInnerList.add(i, ch);
					newValues.add(newInnerList);
					count++;
				}
			}
			values = newValues;
		}

		return values.stream().map(charList -> new String(getCharArray(charList))).collect(Collectors.toList());
	}

	private static char[] getCharArray(List<Character> charList) {
		char[] charArray = new char[charList.size()];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = charList.get(i);
		}
		return charArray;

	}

}
