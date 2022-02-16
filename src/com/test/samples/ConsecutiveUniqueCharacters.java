package com.test.samples;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConsecutiveUniqueCharacters {

	@Test
	public void test() {
		printConsecutiveCounts("aaaabbbcc");
		

	}

	public void printConsecutiveCounts(String ip) {

		char[] ipArray = ip.toCharArray();
		List<String> op = new ArrayList<String>();
		int count = 1;
		for (int i = 1; i < ipArray.length; i++) {

			if (ipArray[i] == ipArray[i - 1]) {
				count++;
			} else {
				op.add(ipArray[i - 1] + ": " + count);
				count = 1;
			}

		}
		op.add(ipArray[ipArray.length - 1] + ": " + count);

		System.out.println(op);

	}

}
