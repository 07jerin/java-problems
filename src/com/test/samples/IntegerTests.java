package com.test.samples;

public class IntegerTests {
	
	public static void main(String[] args) {
		Integer a = 127;
		Integer b = 127;
		int a1 = 127;
		int b1 = 127;
		
		System.out.println(a == b);
		System.out.println(a1 == b1);
		a = 128;
		b = 128;
		a1 = 128;
		b1 = 128;
		System.out.println(a == b);
		System.out.println(a1 == b1);
		
		System.out.println(a.equals(b));
	}

}
