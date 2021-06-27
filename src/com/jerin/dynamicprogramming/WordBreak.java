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
		long n = System.nanoTime();

		Trie trie = createTrie(wordDict);
		for (String word : check) {
			findWordUsingTrie(word, trie, new HashMap<String, Boolean>());
		}
		System.out.println("findWordUsingTrie : " + (System.nanoTime() - n));

	}

	@Test
	public void usingMemo() {
		long n = System.nanoTime();
		for (String word : check) {
			findWordUsingMemo(word, wordDict, new HashMap<String, Boolean>());
		}
		System.out.println("usingMemo : " + (System.nanoTime() - n));
	}

	@Test
	public void trieWithTabulation() {
		long n = System.nanoTime();
		Trie trie = createTrie(wordDict);
		for (String word : check) {
			trieWIthTabulation(word, trie);
		}
		System.out.println("trieWithTabulation : " + (System.nanoTime() - n));
	}

	private boolean trieWIthTabulation(String word, Trie trie) {

		int[] tab = new int[word.length() + 1];
		tab[0] = 1;
		char[] chars = word.toCharArray();
		for (int i = 0; i < tab.length - 1; i++) {
			if (tab[i] == 1) {
				Trie current = trie;
				for (int j = i + 1; j < tab.length; j++) {
					int chIndex = chars[j - 1] - 'a';
					current = current.data[chIndex];

					if (current == null) {
						break;
					} else if (current.isTerminal) {
						tab[j] = 1;
						if (j == tab.length - 1) {
							return true;
						}
					}
				}
			}
		}

		return tab[word.length()] == 1 ? true : false;
	}

	private boolean findWordUsingMemo(String s, List<String> wordDict, Map<String, Boolean> memo) {
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

		if ("".equals(word)) {
			return true;
		}

		if (memo.get(word) != null) {
			return memo.get(word);
		}

		int aIndex = 'a';
		Trie current = trie;
		for (int i = 0; i < word.length(); i++) {

			int charIndex = word.charAt(i) - aIndex;
			current = current.data[charIndex];
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
		wordDict.add("aman");
		wordDict.add("afury");
		wordDict.add("awar");
		wordDict.add("atill");
		wordDict.add("awest");
		wordDict.add("awoot");
		wordDict.add("atest");
		wordDict.add("abest");
		wordDict.add("acall");
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
		wordDict.add("aman");
		wordDict.add("afury");
		wordDict.add("awar");
		wordDict.add("atill");
		wordDict.add("awest");
		wordDict.add("awoot");
		wordDict.add("atest");
		wordDict.add("abest");
		wordDict.add("acall");

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
		check.add("amadtesworldbestcall");
		check.add("amadraicnworldgobestcall");
		check.add("aawaymacdgogorainbestcall");
		check.add("aaddictcgamemangorainbest");
		check.add("amadtesworldbestcall");
		check.add("amadtesworldbestcall");
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
		check.add("amadtesworldbestcall");
		check.add("amadraicnworldgobestcall");
		check.add("aawaymacdgogorainbestcall");
		check.add("aaddictcgamemangorainbest");
		check.add("amadtesworldbestcall");
		check.add("amadtesworldbestcall");
		check.add("worldtestgame");
		check.add("wordgamecallbest");
		check.add("madmanwar");
		check.add("wootbest");
		check.add("madmsadasdasdadasanwar");
		check.add("madtesworldbestcall");
		check.add("madtesworldbestcall");
		check.add("madrainwshghjgftestorldgobestcall");
		check.add("awaymadgshghjgftestogorainbestcall");
		check.add("addictgashghjgftestmemangorainbest");
		check.add("madteswoshghjgftestrldbestcall");
		check.add("madteswoshghjgftestrldbestcall");
		check.add("amadteswshghjgftestorldbestcall");
		check.add("amadraicshghjgftestnworldgobestcall");
		check.add("aawaymacshghjgftestdgogorainbestcall");
		check.add("aaddictcshghjgftestgamemangorainbest");
		check.add("amadteswshghjgftestorldbestcall");
		check.add("amadteswshghjgftestorldbestcall");
		check.add("worldtesshghjgftesttgame");
		check.add("wordgameshghjgftestcallbest");
		check.add("worldtestgame");
		check.add("wordgamecallbest");
		check.add("madmanwar");
		check.add("wootbest");
		check.add("madrainraingomanwar");
		check.add("madrainraingotesworldbestcall");
		check.add("madrainraingotesworldbestcall");
		check.add("madrainraingorainworldgobestcall");
		check.add("awarainraingoymadgogorainbestcall");
		check.add("addrainraingoictgamemangorainbest");
		check.add("madrainraingotesworldbestcall");
		check.add("madrainraingotesworldbestcall");
		check.add("amarainraingodtesworldbestcall");
		check.add("amadraicnworldgobestcall");
		check.add("aawaymacdgogorainbestcall");
		check.add("aaddictcgamemangorainbest");
		check.add("amadtesworldbestcall");
		check.add("amadtesworldbestcall");
		check.add("worldtestgame");
		check.add("wordgamecallbest");
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
		check.add("amadtesworldbestcall");
		check.add("amadraicnworldgobestcall");
		check.add("aawaymacdgogorainbestcall");
		check.add("aaddictcgamemangorainbest");
		check.add("amadtesworldbestcall");
		check.add("amadtesworldbestcall");
		check.add("worldtestgame");
		check.add("wordgamecallbest");

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
