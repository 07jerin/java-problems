package com.test.samples.classLoading;

public class ClassLoading {
		
	public static void main(String[] args) {
//		ASub aSub  = new ASub();
//		System.out.println("---------------------------------");
////		ASub b = new ASub();
//		
//		long i = 4294967295l;
//		i = i+1;
//		int h = 11598077;
//		
//		System.out.println((int)i );
		
		
		A a = new ASub();
		a.exPrint();
		System.out.println( a.name);
	}

}
