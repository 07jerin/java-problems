package com.jerin;

import java.util.Stack;

import org.junit.Test;

public class CustomStack extends Stack<Integer> {

	private static final long serialVersionUID = 1L;
	private Stack<Integer> maxValues;
	
	public CustomStack() {
		maxValues = new Stack<>();
	}
	
	@Override
	public Integer push(Integer item) {
		if(!maxValues.isEmpty()) {
			Integer curMax = maxValues.peek();
			if(item >= curMax) maxValues.push(item);
		}else {
			maxValues.push(item);
		}
		
		return super.push(item);
	}
	
	public Integer getCurrentMax() {
		return maxValues.peek();
	}
	
	@Override
	public synchronized Integer pop() {
		Integer popVal = super.pop();
	
		if(popVal == getCurrentMax())
			maxValues.pop();
		
		return popVal ;
	}
	
	
	@Test
	public void testStack() {
		
		CustomStack stack = new CustomStack();
		stack.push(13);
		System.out.println(stack.getCurrentMax());
		stack.push(15);
		System.out.println(stack.getCurrentMax());
		stack.push(8);
		System.out.println(stack.getCurrentMax());
		stack.push(13);
		System.out.println(stack.getCurrentMax());
		stack.push(16);
		System.out.println(stack.getCurrentMax());
		stack.push(14);
		System.out.println(stack.getCurrentMax());
		stack.push(12);
		System.out.println(stack.getCurrentMax());
		
		stack.pop();
		System.out.println(stack.getCurrentMax());
		stack.pop();
		System.out.println(stack.getCurrentMax());
		stack.pop();
		System.out.println(stack.getCurrentMax());
		
	}
}
