package com.test.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import static java.util.stream.Collectors.toList;

public class ArrayConversions {

	public static void main(String[] args) {

		// String Array to int []
		int[] vals = Arrays.stream(new String[] { "1", "2", "3" }).mapToInt(str -> Integer.parseInt(str)).toArray();
		System.out.println(vals);

		// int [] to Arraylist
		List<Integer> list = Arrays.stream(vals).boxed().collect(Collectors.toList());
		System.out.println(list);
		
		//create List with default values
		List<Integer> def = Arrays.asList(1,2);

		// List to int []
		int[] vals1 = list.stream().mapToInt(i -> i).toArray();
		System.out.println(vals1);
		
		// int [] to space separated  values
		String strValue = Arrays.stream(vals1).boxed().map(i -> Integer.toString(i)).collect(Collectors.joining(" : "));
		System.out.println(strValue);
		
		
		// Clone primitive array
		int [] clone = vals1.clone();
		
		// copy Array
		
		int [] a1 = {1,2,3,4};
		final int [] copy =  new int [(int)(a1.length*1.5)];
		System.arraycopy(a1, 0,copy, 0, a1.length );
		a1[3] = 5;
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(copy));
		
		List  a = (List) Collections.EMPTY_LIST.stream().map( i -> {return i;}).collect(toList());
		System.out.println(a);
		

	}

}
