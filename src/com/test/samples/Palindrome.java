package com.test.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Palindrome {

	public static void main(String[] args) {
		int [] vals= new int[] {51, 71, 17, 42};
//		int[] vals = new int[] { 42, 33, 60 };
//		int[] vals = new int[] { 51, 32, 43 };
		Map<Integer, List<Integer>> sameDigitSumMap = new HashMap<Integer, List<Integer>>();

		for (int val : vals) {
			int digitSum = Palindrome.digitSum(val);
			List<Integer> maxValues = sameDigitSumMap.getOrDefault(digitSum, new ArrayList<Integer>(2));
			if (maxValues.size() == 0) {
				maxValues.add(val);
			} else if (maxValues.get(0) < val) {
				maxValues.add(0, val);
			}else if (maxValues.size() ==1) {
				maxValues.add(val);
			
			} else if (maxValues.size() > 1 && maxValues.get(1) < val) {
				maxValues.set(1, val);
			}
			sameDigitSumMap.put(digitSum, maxValues);
		}

		System.out.println(sameDigitSumMap);

		int sum = -1;
		for (List<Integer> numbers : sameDigitSumMap.values()) {
            if(numbers.size() > 1){
                int listSum = numbers.get(0) + numbers.get(1);
			    sum = Math.max(listSum, sum);
            }
		}
	
//    	return sum;
		System.out.println(sum);
//		return sum;

	}

	public static Integer digitSum(Integer value) {
		int sum = 0;
		while (value > 0) {
			sum += value % 10;
			value = value / 10;
		}

		return sum;

	}

}
