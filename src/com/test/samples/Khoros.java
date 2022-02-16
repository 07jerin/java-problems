package com.test.samples;

import java.util.HashSet;
import java.util.Set;

public class Khoros {

	public int getLongestSequenceCount(int[] ip) {
		if (ip.length == 0)
			return 0;

		int max = 1;
		Set<Integer> elements = new HashSet<>();
		for (int ele : ip) {
			elements.add(ele);
		}

		int curMax = 1;
		for (Integer ele : ip) {
			int curEle = ele;
			// move left
			while (elements.contains(--curEle)) {
				curMax++;
				elements.remove(curEle);
			}

			// move right
			curEle = ele;
			while (elements.contains(++curEle)) {
				curMax++;
				elements.remove(curEle);
			}

			max = Math.max(max, curMax);
		}

		return max;
	}
}
