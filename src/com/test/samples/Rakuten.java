package com.test.samples;

import java.util.concurrent.Semaphore;

public class Rakuten{
	
	
	
	public static void main(String[] args) throws InterruptedException {
		printer p = new printer(true);
		
		Runnable print1 =  () -> {
			for(int  i =0; i< 100; i++) {
				p.print1();
				
			}
		};
		Runnable print2 =  () -> {
			for(int  i =0; i< 100; i++) {
					p.print2();
			}
		};
		
		
		Runnable semaPrint1 =  () -> {
			for(int  i =0; i< 100; i++) {
				try {
					p.semaPrint1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		Runnable semaPrint2 =  () -> {
			for(int  i =0; i< 100; i++) {
					try {
						p.semaPrint2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		};
		
		
		
		Thread p1 = new Thread(semaPrint1);
		Thread p2 = new Thread(semaPrint2);
		
		p1.start();
		p2.start();
		
		p1.join();
		p2.join();
	
		System.out.println("Completed");
	}
     
}

class printer{
	volatile boolean isOne;
	Semaphore s1 = new Semaphore(0);
	Semaphore s2 = new Semaphore(1);
	
	printer(boolean isOne){
		this.isOne = isOne;
	}
	
	
	public void semaPrint1() throws InterruptedException {
		s1.acquire();
		System.out.println("Print 1");
		s2.release();
		
	}
	
	public void semaPrint2() throws InterruptedException {
		s2.acquire();
		System.out.println("Print 2");
		s1.release();
//		s1.release();
	}
	
	public synchronized void print1() {
		while(!isOne) {
			
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		System.out.println("Print 1"  + Thread.currentThread().getName());
		isOne = false;
		notify();
		
		
		
	}
	
	public synchronized void print2() {
		while(isOne) {
			
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Print 2"  + Thread.currentThread().getName());
		isOne = true;
		notify();
		
		
	}
	
	
}
