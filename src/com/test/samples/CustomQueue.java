package com.test.samples;

public class CustomQueue<T> implements Queue <T> {

	
	private Node<T> head;
	private Node<T> tail;
	private long size;
	
	public CustomQueue() {
		
	}
	
	public long getSize() {
		return size;
	}
	
	
	
	private class Node <U>{
		U val;
		Node <U> next;
		
		Node(U val){
			this.val = val;
		}
	}
	
	public T peek() {
		return head.val;
	}
	
	@Override
	public void add(T t) {
		if(head == null) {
			head = new Node<T>(t);
			tail = head;
		}else {
			Node<T> newNode = new Node<T>(t);
			newNode.next = head;
			
			head = newNode;
		}	
		
	}
	



}


interface Queue <T>{
	
	public void add(T t);
	
	public T peek();
}
