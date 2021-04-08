package com.test.samples.classLoading;

public class BInASub {
	static {
		System.out.println("BInASub Static");
	}

	public BInASub() {
		System.out.println("BInASub Constructor");
	}

}
