package com.jerin.puzzles;

public class AllPermutationsOfAString {
	
	public static void main(String[] args) {
	B b = new B();
	b.sum("Jerin", "SSS");
		
	}
}


class A{
	int a = 10;
	
	void sum(String a, String b) {
		System.out.println("A");
	}
	
	void abc() {
		
	}
}

class B extends A{
	int a = 15;
	
	void sum(String a, Double b) {
		System.out.println("B");
	}
}
