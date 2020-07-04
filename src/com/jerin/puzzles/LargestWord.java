package com.jerin.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given a dictionary of the words(strings) which contains different words & you are given an input string e.g. “abd”. You need to find the largest word available in the supplied dictionary which can be made using the letters of input string. The returned word can contain only the same no of occurrences of the letters as given in the input string i.e. if a letter is given once then in the output it should be existed only once. Examples:Dictionary {“to”, “banana”, “toe”, “dogs”, “ababcd”, “elephant”} and input string is “eot”. Output should be “toe”
Dictionary is same as specified in example a but the input string is “ogtdes” and the output is “dogs” and “toes”ou need more classes, simply define them inline.
 */

class LargestWord {

	private String largestWord(String[] dictionary, String input) {

		List<Word> words = new ArrayList<>();
		for (String s : dictionary) {
			words.add(new Word(s));
		}

		Map<Character, Integer> inputCounter = new HashMap<>();
		for (char c : input.toCharArray()) {
			Integer count = inputCounter.get(c);
			if (count == null) {
				inputCounter.put(c, 1);
			} else {
				inputCounter.put(c, ++count);
			}
		}

		List<Word> subWords = words.stream().filter(w -> w.isSubWord(inputCounter)).collect(Collectors.toList());
		String longestSubWord = "";
		for (Word word : subWords) {
			longestSubWord = word.word.length() > longestSubWord.length() ? word.word : longestSubWord;
		}
		return longestSubWord;

	}

	public static void main(String[] args) {
		String[] words = { "to", "banana", "toe", "dogs", "ababcd", "elephant" };
		final LargestWord sol = new LargestWord();
		System.out.println(sol.largestWord(words, "ogtdes"));
		System.out.println(sol.largestWord(words, "eot"));
	}

}

class Word {

	public Map<Character, Integer> charCount = new HashMap<>();
	public String word;

	Word(String word) {
		this.word = word;
		constructCharCount();
	}

	public boolean isSubWord(Map<Character, Integer> inputCounter) {
		for (Map.Entry<Character, Integer> wordEntry : charCount.entrySet()) {
			Character letter = wordEntry.getKey();
			Integer wordLetterCount = wordEntry.getValue();
			if (wordLetterCount != inputCounter.get(letter)) {
				return false;
			}

		}
		return true;
	}

	private void constructCharCount() {
		for (char c : this.word.toCharArray()) {
			Integer count = charCount.get(c);
			if (count == null) {
				charCount.put(c, 1);
			} else {
				charCount.put(c, ++count);
			}
		}
	}
}
