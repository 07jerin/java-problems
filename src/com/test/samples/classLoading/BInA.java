package com.test.samples.classLoading;

public class BInA {
	static {
		System.out.println("BInA Static");
	}

	public BInA() {
		System.out.println("BInA Constructor");
	}

}
