package com.jerin.javaprogramming.commonporblems;

import org.junit.Test;

public class FizzBuzz {

	@Test
	public void test() {
		print(15);
		print(45);
	}

	private void print(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				sb.append("FizzBuzz");
			} else if (i % 5 == 0) {
				sb.append("Buzz");
			} else if (i % 3 == 0) {
				sb.append("Fizz");
			}else {
				sb.append(i);
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
