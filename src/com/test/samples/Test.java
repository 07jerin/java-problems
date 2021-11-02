package com.test.samples;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class A {

}

class B extends A {

}

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		String s = "Hello";
		String s1 = "He";
		String s2 = s1 + "llo";
		System.out.println(s1 == s2);

		List<String> ls = new ArrayList<String>();
		if (ls.removeIf((str -> {
			System.out.println(str);
			return false;
		}))) {

		}

		long x = 1;

	}

	public void p() throws IOException {
		throw new IOException();
	}

	public A test(B a) {
//		return new B();
		return new A();

	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals");
		return true;
	}

	public boolean equals(Test obj) {
		System.out.println("Equals Test");
		return true;
	}

}

class TestSub extends Test {
//	@Override
	public B test(B a) {
		return new B();
	}

}
