package com.test.samples;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PairSum {
	
	
	@Test
	public void test() {
		assertTrue(isFound(-2, new int[]{0, -1, 2, -3, 1}));
		assertTrue(!isFound(-5, new int[]{0, -1, 2, -3, -1}));
		
	}
	
	public boolean isFound(int sum, int[] ip) {
		boolean isPresent = false;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int  k : ip) {
			if(set.contains(sum - k)) {
				System.out.println(k + " : " + (sum-k));
				return true;
			}
			set.add(k);
		}
		System.out.println(false);
		return isPresent;
		
	}
	
	

}
