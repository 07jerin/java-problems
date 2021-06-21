package com.jerin.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author jerijose
 *
 */

public class WordBreak {

	List<String> wordDict = new ArrayList<String>();
	List<String> check = new ArrayList<String>();

	@Test
	public void usingTrie() {

		Trie trie = createTrie(wordDict);
		for (String word : check) {
			findWordUsingTrie(word, trie, new HashMap<String, Boolean>());
		}

	}

	@Test
	public void usingMemo() {
		for (String word : check) {
			findWordUsingMemo(word, wordDict, new HashMap<String, Boolean>());
		}
	}

	public boolean findWordUsingMemo(String s, List<String> wordDict, Map<String, Boolean> memo) {
		if (s.length() == 0) {
			return true;
		}

		if (memo.get(s) != null) {
			return false;
		}

		for (String word : wordDict) {
			if (s.startsWith(word)) {
				boolean present = findWordUsingMemo(s.substring(word.length(), s.length()), wordDict, memo);
				if (present) {
					return true;
				}
			}
		}

		memo.put(s, false);
		return false;

	}

	private boolean findWordUsingTrie(String word, Trie trie, Map<String, Boolean> memo) {

		// System.out.println(word);

		if ("".equals(word)) {
			return true;
		}

		if (memo.get(word) != null) {
			// System.out.println("Return true from memo" + word);
			return memo.get(word);
		}

		int aIndex = 'a';
		Trie current = trie;
		for (int i = 0; i < word.length(); i++) {

			int charIndex = word.charAt(i) - aIndex;
			// System.out.println( "Index : " + charIndex);
			current = current.data[charIndex];
			// System.out.println("Index data" + current);
			if (current == null) {
				break;
			} else if (current.isTerminal) {

				memo.put(word.substring(0, i + 1), true);

				String pendingWord = word.substring(i + 1, word.length());
				boolean found = findWordUsingTrie(pendingWord, trie, memo);
				if (found) {
					return true;
				} else {

				}

			}
		}

		memo.put(word, false);
		// System.out.println("Return fale" + word);

		return false;

	}

	private Trie createTrie(java.util.List<String> words) {
		int aIndex = 'a';
		Trie parent = new Trie();
		for (String word : words) {
			Trie lastChar = parent;
			for (char ch : word.toCharArray()) {
				int charIndex = ch - aIndex;
				if (lastChar.data[charIndex] == null) {
					lastChar = lastChar.data[charIndex] = new Trie();
				} else {
					lastChar = lastChar.data[charIndex];
				}
			}
			lastChar.isTerminal = true;
		}
		return parent;
	}

	@Before
	public void loadDict() {
		wordDict.add("word");
		wordDict.add("world");
		wordDict.add("test");
		wordDict.add("game");
		wordDict.add("gamble");
		wordDict.add("words");
		wordDict.add("worlds");
		wordDict.add("wheather");
		wordDict.add("wheat");
		wordDict.add("her");
		wordDict.add("well");
		wordDict.add("when");
		wordDict.add("rain");
		wordDict.add("go");
		wordDict.add("away");
		wordDict.add("always");
		wordDict.add("addict");
		wordDict.add("mad");
		wordDict.add("man");
		wordDict.add("fury");
		wordDict.add("war");
		wordDict.add("till");
		wordDict.add("west");
		wordDict.add("woot");
		wordDict.add("test");
		wordDict.add("best");
		wordDict.add("call");

		check.add("worldtestgame");
		check.add("wordgamecallbest");
		check.add("madmanwar");
		check.add("wootbest");
		check.add("madmanwar");
		check.add("madtesworldbestcall");
		check.add("madtesworldbestcall");
		check.add("madrainworldgobestcall");
		check.add("awaymadgogorainbestcall");
		check.add("addictgamemangorainbest");
		check.add("madtesworldbestcall");
		check.add("madtesworldbestcall");

	}
}

class Trie {
	boolean isTerminal;
	Trie[] data = new Trie[26];

	public String toString() {
		StringBuilder str = new StringBuilder();
		Queue<Trie> q = new LinkedList<>();
		q.add(this);

		while (!q.isEmpty()) {
			Trie t = q.remove();
			int index = 0;
			for (Trie innerTrie : t.data) {
				if (innerTrie != null) {
					q.add(innerTrie);

					str.append(index);
					str.append(" , ");
				}
				index++;
			}
			str.append(" \n ");
		}

		return "Terminal " + isTerminal + " data : " + str.toString();
	}
}
