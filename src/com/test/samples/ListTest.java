package com.test.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListTest {
	public static void main(String[] args) {
		int aa [] = new int []{1,2,4};
		List<Integer> ls = Arrays.asList(1, 2);
//		List<Integer> ls1 = new ArrayList<Integer>();
		//	ls.add("Jerin");
		for (Object a : ls) { // No need of if check
			System.out.println(a);
		}
		
		List <Integer> aaList = IntStream.of(aa).boxed().collect(Collectors.toList());
		
		List<Integer> ls1 = new ArrayList<Integer>(Arrays.asList(1, 2));
		List<Integer> ls2 = new ArrayList<Integer>(Arrays.asList(1, 2));
		System.out.println(ls1.hashCode());
		System.out.println(ls2.hashCode());
		
		for(Integer a : ls1) {
			ls2.add(a);
		}
		System.out.println(ls2.hashCode());
	}
}
