package com.jerin.javaprogramming.bit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Consider a given set, S. Write a snippet of code that returns the Power Set
 * of S. A Power Set, P(S), of a set, S, is the set of all possible subsets of
 * S, including the empty set and S itself.
 * 
 * @author jerijose
 *
 */
public class PowerSet {
	
	@Test
	public void solve() {
		System.out.println(powerSet(new char[] {'a', 'b', 'c'}));
		System.out.println(powerSet(new char[] {'a', 'b', 'c', 'd'}));
	}
	
	private List<List<Character>> powerSet(char[] arr) {
		
		List<List<Character>> powerSet = new ArrayList<List<Character>>();
		int totalElements = (int) Math.pow(2d, (double)arr.length);
		for(int i=0; i<totalElements ; i++) {
			
			List<Character> subSet = new ArrayList<Character>();
			int index = 0;
			int j = i;
			while(j !=0) {
				
				if((j & 1) == 1){
					subSet.add(arr[index]);
				}
				j = j >> 1; 
				
				index++;
			}
			powerSet.add(subSet);
		}
		
		return powerSet;
		
	}

}
