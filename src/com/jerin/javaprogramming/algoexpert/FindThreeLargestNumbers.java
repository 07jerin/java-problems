package com.jerin.javaprogramming.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class FindThreeLargestNumbers {
	
	@Test
	public void test(){
		
		List<Integer> ip =  new ArrayList<>();
		
		List ls =  ip.stream().collect(Collectors.toList());
		System.out.println(ls);
		
	   int[] res = topThree(Arrays.asList(1,2,3,4,5,6,7));
	   System.out.println(Arrays.toString(res));
	   
	   res = topThree(Arrays.asList(5,6,3,1,8,9,0,2,7));
	   System.out.println(Arrays.toString(res));
	 
	}
	
	public int[] topThree(List<Integer> ip) {
		int [] result = new int[3];
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		q.addAll(ip);
		result[0] = q.poll();
		result[1] = q.poll();
		result[2] = q.poll();
		
		return result;
	}

}
