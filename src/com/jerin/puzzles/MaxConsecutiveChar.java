package com.jerin.puzzles;

public class MaxConsecutiveChar {

	private Character maxConsecutiveChar(String str) {
		Character maxChar = str.charAt(0);
		int lenght = str.length();
		int maxCount = 0;
		int currentSeqCount = 0;
		int i = 1;
		for (; i < lenght; i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				currentSeqCount = currentSeqCount + 1;
			} else if (maxCount < currentSeqCount) {
				maxCount = currentSeqCount;
				maxChar = str.charAt(--i);
				currentSeqCount = 0;
			}
		}
		if (maxCount < currentSeqCount) {
			maxCount = currentSeqCount;
			maxChar = str.charAt(i - 1);
		}
		return maxChar;

	}

	public static void main(String[] args) {

		System.out.println(new MaxConsecutiveChar().maxConsecutiveChar("aabbcd"));
	}

}
