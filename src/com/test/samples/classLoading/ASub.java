package com.test.samples.classLoading;

import java.util.ArrayList;
import java.util.List;

public class ASub extends A{
	
	private String name;
	
	BInASub b = new BInASub();
	List<Integer> ls = new ArrayList<Integer>();
	
	static{
		System.out.println("ASub Static");
	}
	public ASub() {
		System.out.println("ASub Constructor");
	}
	
	public void print() {
		System.out.println("Print ASub");
	}
	
//	private void exPrint() {
//		this.name = "Sub Name";
//		System.out.println("EX Print ASub");
//		this.print();
//	}

}
