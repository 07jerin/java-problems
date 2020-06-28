package com.jerin.puzzles;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
	public static void main(String[] args) {
		System.out.println(FirstNonRepeatedCharacter.getFirstNonRepeatingCharacter("ABCACDB"));
	}

	public static Character getFirstNonRepeatingCharacter(String str) {

		char[] charArray = str.toCharArray();

		Map<Character, Boolean> repeatedCharMap = new LinkedHashMap<>();
		for (char c : charArray) {
			Boolean isRepeated = repeatedCharMap.get(c);
			if (isRepeated == null) {
				repeatedCharMap.put(c, Boolean.FALSE);
			} else {
				repeatedCharMap.put(c, Boolean.TRUE);
			}
		}

		for (Map.Entry<Character, Boolean> entry : repeatedCharMap.entrySet()) {
			if (!entry.getValue()) {
				return entry.getKey();
			}
		}

		System.out.println("No Non repeated value found");
		return null;

	}
}
