package com.jerin.puzzles;

public class Fibinocci {
	public static void main(String[] args) {
		Fibinocci.printFibinocci(3);
	}

	private static void printFibinocci(int count) {
		if(count == 0) {
			 return;	
		}
		if(count == 1) {
			System.out.println("0");
			return;
		}
		if(count == 2) {
			System.out.println("0");
			System.out.println("1");
			return;
		}
		
		System.out.println("0");
		count -= 2;
		int previous = 0;
		int fib = 1;
		printMoreFib(fib, previous, count);
				
	}

	private static boolean printMoreFib(int fib, int previous, int count) {

		
		System.out.println(fib);
		int temp = fib;
		fib = fib + previous;
		previous = temp;
		if (count > 0) {
			return printMoreFib(fib, previous, --count);
		}
		return true;

	}
}
