package com.test.samples.classLoading;

public class A {
	BInA b;
	public String name;
	
	static{
		System.out.println("A Static");
	}
	public A() {
		System.out.println("A Constructor");
		b = new BInA();
	}
	
	private void print() {
		System.out.println("Print A");
	}
	
	public void exPrint() {
		System.out.println("EX Print A");
		this.print();
	}

}
