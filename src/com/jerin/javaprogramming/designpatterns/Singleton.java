package com.jerin.javaprogramming.designpatterns;

public class Singleton {
	
	public static void main(String[] args) {
		
		DoubleCheck o1 = DoubleCheck.getInstance();
		DoubleCheck o2 = DoubleCheck.getInstance();
		DoubleCheck o3 = DoubleCheck.getInstance();
		o1.print();
		o2.print();
		o3.print();
		
		SingletonEnum.INSTANCE.print();
		SingletonEnum.INSTANCE.print1();
		SingletonEnum.INSTANCE.print2();
		SingletonEnum.INSTANCE.printThis();
		
		SingletonEnum.INSTANCE1.print();
		SingletonEnum.INSTANCE1.print1();
		SingletonEnum.INSTANCE1.print2();
		SingletonEnum.INSTANCE1.printThis();
		
		
	}

}

enum SingletonEnum{
	// 3 singletons
	INSTANCE, 
	INSTANCE1,
	INSTANCE2;
		
	public void print(){
		System.out.println(INSTANCE.hashCode());
	}
	
	public void print1(){
		System.out.println(INSTANCE1.hashCode());
	}
	
	public void print2(){
		System.out.println(INSTANCE2.hashCode());
	}
	
	public void printThis(){
		System.out.println(this.hashCode());
	}
}


class DoubleCheck {
	private static DoubleCheck INSTANCE = null;

	private DoubleCheck() {

	}

	public static DoubleCheck getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheck.class) {
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheck();
				}
			}
		}
		return INSTANCE;

	}
	
	public void print(){
		System.out.println(INSTANCE.hashCode());
	}

}
